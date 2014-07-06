--[[
	Splits the given string str using sSeparator as a delimiter
	(defaults to space), and returns the result as an
	array-like table
]]--
function split(str, sSeparator)
	sSeparator = sSeparator or ' '
	assert(sSeparator ~= '')
	local aRecord = {}
	if str:len() > 0 then
		local nField=1 
		local nStart=1
		local nFirst = string.find(str, sSeparator, nStart, true)
		while nFirst ~= nil do
			aRecord[nField] = string.sub(str, nStart, nFirst-1)
			nField = nField+1
			nStart = nFirst+1
			nFirst = string.find(str, sSeparator, nStart, true)
		end
		aRecord[nField] = string.sub(str, nStart)
	end
	return aRecord
end

--[[
	Returns the numerical value of the character in str at position i. If i is out of bounds,
	0 is returned. Otherwise, the byte value is manipulated such that 'A' will return 1.
]]--
local function chNum(str,i)
	if (str:len() < i) then
		return 0
	else
		return string.byte(str:sub(i,i)) - 64
	end
	
end
--[[
	Treats given string as a number, where the base is radix (usually 27), and each
	character is a digit. While the actual string is not changed, the maxLen variable is
	used to effectively append 0-valued characters to the end of the string until the
	effective length is maxLen.
]]--
local function strToNumber(str, maxLen, radix)
	local val = 0
	for i=1,str:len() do
		val = val + chNum(str,i)*(radix ^ (maxLen - i))
	end
	return val
end

--[[
	Opens file, splits into array of names, and converts all names to a number
	(see documentation of strToNumber for details).
]]--
local function compress(filestr, radix)
	local nameF = assert(io.open(filestr,"r"))
	local names = split(nameF:read("*all"), ",")
	local maxLen = 0
	for i=1,#names do --find longest name
		names[i] = names[i]:sub(2,#names[i]-1) --remove quotation marks
		if names[i]:len()>maxLen then
			maxLen = names[i]:len()
		end
	end
	for i=1,#names do --convert to numbers
		names[i] = strToNumber(names[i], maxLen, radix)
	end
	return names, maxLen
end

--[[
	Used to queue elem into table t. t is treated as an array, with
	elem appended (position 1 is the "front" of the queue).
]]--
local function q(t, elem)
	t[#t+1] = elem
end

--[[
	Returns an iterator over the numerical indices of t,
	starting from 1.
]]--
local function elems(t)
	local i = 1
	return function()
		if i > #t then
			return nil
		else
			i = i+1
			return t[i-1]
	 	end
	end
end

--[[
	Interprets n as a base-radix number, and returns
	the digit at position i (with the least significant digit
	being at position 1).
]]--
local function getDig(n, i, radix)
	return math.floor((n % (radix ^ i)) / (radix ^ (i-1)))
end

--[[
	Generic radix sort implementation.
	Interprets an array of numbers as an array of
	base-radix numbers, and uses the corresponding
	digits to sort into ascending order.
	Complexity is O(digits*#arr).
]]--
local function radixSort(arr, radix, digits)
	local qs = {}
	for i=1,digits do
		for b=1,radix do
			qs[b] = {}
		end
		for j=1,#arr do
			local dig = getDig(arr[j], i, radix)
			q(qs[dig+1],arr[j])
		end
		arr = {}
		for queue in elems(qs) do
			for val in elems(queue) do
				q(arr,val)
			end
		end
	end
	return arr
	
end

--[[
	Interprets n as a base-radix number of length len
	and returns the sum of its digits.
]]--
local function nameVal(n, len, radix)
	local sum = 0
	for i=1, len do
		sum = sum + getDig(n, i, radix)
	end
	return sum
end

--[[
	Interprets the file at the location specified by
	filestr as a list of (comma-delimited, quote-
	surrounded) names, converts those names into
	numbers (see documentation of compress for details),
	sorts the list, associates each name with a different
	number determined by the sum of the values of its
	characters (see documentation of nameVal for details),
	multiplies those numbers by their respective indices
	in the sorted list, and returns the sum of those 
	products.
]]--
local function nameValSum(filestr)
	local arr, len = compress(filestr, 27)
	local r = radixSort(arr, 27, len)
	local sum = 0
	for i=1,#r do
		sum = sum + (nameVal(r[i], len, 27) * i)
	end
	return sum
end

local function main()
	local directoryPath = ""
	print("The name value sum is: "..nameValSum(directoryPath.."names.txt"))
end
main()
