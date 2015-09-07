# Advanced Ruby Solution

puts "Enter a number: "

val = gets.chomp

#split val into integer array
valArray = val.split('').map { |x| x.to_i }

sumVal = 0

for i in 0..(valArray.length - 1)
    sumVal += valArray[i]
end

puts "Sum of the digits of " + val.to_s + " are " + sumVal.to_s
