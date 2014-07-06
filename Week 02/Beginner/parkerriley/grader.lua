local function split(str, sSeparator)
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

local function round(num, places)
	local shift = 10 ^ places
	return math.floor(num*shift + 0.5) / shift
end

local function sepCar (t)
	if (#t < 1) then
		return nil, nil
	end
	local car = t[1]
	local cdr = {}
	for i=2,#t do
		cdr[i-1] = t[i]
	end
	return car, cdr
end

local function average(t, places)
	local accum = 0
	for i=1,#t do
		accum = accum + t[i]
	end
	return round(accum / #t, places)
end

local function main()
	local data = { averages={}, students={}, key={} }
	local numStudents = sepCar(split(io.read(), ' '))
	for i=1,numStudents do
		local name, grades = sepCar(split(io.read(), ' '))
		data.students[name] = grades
		data.key[i] = name
		data.averages[i] = average(grades, 2)
	end
	print(average(data.averages, 2))
	for i=1,#data.key do
		print(data.key[i]..': '..data.averages[i])
	end
end
main()
