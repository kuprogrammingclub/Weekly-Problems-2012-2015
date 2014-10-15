#!/usr/bin/ruby
input = gets.chomp.split(' ')
puts (eval(input[0]) - eval(input[-1])).to_s
