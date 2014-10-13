def sierpinski(n)
  (0...n).inject(["*"]) {|triangle, i|
    space = " " * (2**i)
    triangle.map {|x| space + x + space} + triangle.map {|x| x + " " + x}
  }
end

puts sierpinski(4)
