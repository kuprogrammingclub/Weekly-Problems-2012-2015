#!/usr/bin/env ruby
puts "Enter first equation (y = mx + b):"
equation_1 = gets.chomp.scan(/\d+/).map(&:to_i)
puts "Enter second equation (y = mx + b):"
equation_2 = gets.chomp.scan(/\d+/).map(&:to_i)

x = (equation_2[1] - equation_1[1]) / (equation_1[0] - equation_2[0])
y = equation_1[0] * x + equation_1[1]
puts "(#{x}, #{y})"

