class Integer
  def factors()
    (1..self).select { |n| (self % n).zero? }.map {|n| n ** 2}.reduce(:+)
  end
end

puts 64000000.factors
