#!/usr/bin/env ruby
combination_size = gets.chomp.split(' ').first.to_i
puts gets.chomp.split(' ').combination(combination_size).map(&:join)
