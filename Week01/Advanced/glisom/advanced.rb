puts "Enter integer: \n"
integer = gets.chomp
puts "Enter exponent: \n"
exp = gets.chomp
val = integer.to_i**exp.to_i
val = val.to_s.chars.map(&:to_i).reduce(:+)

puts val
