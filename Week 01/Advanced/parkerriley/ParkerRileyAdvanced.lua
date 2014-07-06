function split(str, sSeparator) --Utility; splits line by separator (space by default)
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

local function gcd(a, b) --Implements Euclidean algorithm
	if ((tonumber(a) == nil) or (tonumber(b) == nil)) then
		return("Invalid input.")
	end
	if (b==0) then
		return a
	else
		return gcd(b, a % b)
	end
end


local function main() --Gets user input, puts through Euclidean algorithm
	while true do
		print("Enter two numbers separated by a space, please.")
		io.flush()
		local input = split(io.read())
		print(gcd(input[1], input[2]))
	end
end
main()
