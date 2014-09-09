def number_sum(num)
  num.to_s.chars.map(&:to_i).reduce(:+)
end
puts number_sum(2 ** 1000)
puts number_sum(2 ** 10000)
puts number_sum(2 ** 100000)
