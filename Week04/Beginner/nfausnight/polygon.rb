#!/usr/bin/env ruby
# Nick Fausnight
# Usage: ./polygon.rb $NUMBER_OF_SIDES $CIRCUMRADIUS
sides = ARGV[0].to_i
circumradius = ARGV[1].to_f
puts 2 * sides * circumradius * Math.sin(Math::PI / sides)