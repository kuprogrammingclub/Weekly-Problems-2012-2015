#!/usr/bin/env ruby
# Reverse Polish Notation Calculator
# Nick Fausnight
def numeric?(string)
  !!(string =~ /\A\d+\Z/)
end
def evaluate(input)
  buffer = []
  while(input.size > 0)
    argument = input.shift
    if numeric?(argument)
      buffer << argument.to_i
    else
      buffer = [buffer.inject(argument.to_sym)]
    end
  end
  buffer[0]
end
puts "RPN Calculator\nInput:"
puts evaluate(gets.chomp.split(' '))

