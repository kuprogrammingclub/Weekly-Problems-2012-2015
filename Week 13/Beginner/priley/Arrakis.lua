local function readGrid()
	local num = tonumber(io.read())
	local grid = {}
	for i=1,num do
		io.write("|")
		io.flush()
		local line = io.read()
		grid[i] = {}
		for j=1,#line do
			grid[i][j] = line:sub(j,j)
		end
	end
	return grid
end
local function timeWarp(grid)
	for i=#grid,1,-1 do
			for j=1,#grid[i] do
				if grid[i][j] == "." then
					for k=i+1,#grid do
						if grid[k][j] == " " then
							if k == #grid or grid[k+1][j] == "." or grid[k+1][j] == "#" then
								grid[i][j] = " "
								grid[k][j] = "."
							end
						elseif grid[k][j] == "#" then
							break
						end
					end
				end
			end
		end
		return grid
end
local function printResult(grid)
	io.write("Result:\n")
	for i=1,#grid do
		io.write("|")
		for j=1,#grid[i] do
			io.write(grid[i][j])
		end
		io.write("\n")
	end
end
local function main()
	local grid = readGrid()
	timeWarp(grid)
	printResult(grid)
end
main()
