local function wordIt(textStr)
	local i = 1
	return function()
		local nBeg, nEnd = textStr:find('[A-Za-z]+',i)
		if not nBeg then
			return nil
		end
		i = nEnd + 1
		return textStr:sub(nBeg,nEnd):lower()
	end
end

local function main()
	local text = (io.open("book.txt","r")):read("*a")
	local wTbl = {}
	for str in wordIt(text) do
		if (wTbl[str]) then
			wTbl[str] = wTbl[str] + 1
		else
			wTbl[str] = 1
		end
	end
	local sortArr = {}
	for k in pairs(wTbl) do
		table.insert(sortArr,k)
	end
	table.sort(sortArr) --uses quicksort
	for i=1,#sortArr do
		print(sortArr[i]..": "..wTbl[sortArr[i]])
	end
	
end
main()
