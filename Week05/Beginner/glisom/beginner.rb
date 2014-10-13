puts "Begin Equation \n"
eq_array = gets.chomp
eq_array.split(" ")
a = nil

for i in 0..(eq_array.length - 1)
  if eq_array[i] == (0..9)
    a << eq_array[i]
  elsif (a != nil) && (eq_array[i] != (0..9))
    for j in 0..(a.length -1)
      if eq_array[i] == "+"

      end
end
