local VOWS = "aeiouAEIOU"
local function disemvowel(str)
	local cons = ""
	local vowels = ""
	for i=1,#str do
		local char = str:sub(i,i)
		if VOWS:find(char) then
			vowels = vowels..char
		elseif char ~= " " then
			cons = cons..char
		end
	end
	return cons, vowels
end
local function main()
	local input
	while input ~= "" do
		print("Enter a victim for disemvowelment!")
		io.flush()
		input = io.read()
		local c, v = disemvowel(input)
		if c ~= "" or v ~= "" then
			print("Observe the corpse: "..c.."\nAnd here, it's entrails: "..v)
		end
	end
end
main()
