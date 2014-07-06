local function split(str, sSeparator)
	sSeparator = sSeparator or " "
	assert(sSeparator ~= "")
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

local function matMult(m1, m2)
	if #m1[1] ~= #m2 then
		error ""
	end
	local ret = {}
	for i=1,#m1 do
		ret[i] = {}
		for j = 1,#m2[1] do
			local sum = 0
			for k = 1,#m2 do
				sum = sum + m1[i][k] * m2[k][j]
			end
			ret[i][j] = sum
		end
	end
	return ret
end

local function printMat(mat)
	for i=1,#mat do
		io.write("[")
		for j=1,#mat[i] do
			io.write(mat[i][j])
			if j < #mat[i] then
				io.write(" ")
			end
		end
		io.write("]")
		print("")
	end
end

local function main()
	print("Enter a matrix, human.")
	io.flush()
	local line = io.read()
	local mat1 = {}
	local mat2 = {}
	local nIt = 1
	while line ~= "" do
		parts = split(line, " ")
		mat1[nIt] = parts
		line = io.read()
		nIt = nIt + 1
	end
	print("I demand another!")
	io.flush()
	nIt = 1
	line = io.read()
	while line ~= "" do
		parts = split(line)
		mat2[nIt] = parts
		line = io.read()
		nIt = nIt + 1
	end
	local bGood, ret = pcall(matMult, mat1, mat2)
	if bGood then
		print("I will now multiply this matrix:")
		printMat(mat1)
		print("\nBy this one:")
		printMat(mat2)
		print("\nBEHOLD, MORTAL!")
		printMat(ret)
	else
		print("Your matrices are incompatible, imbecile.")
	end
	
end
main()