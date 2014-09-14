class Integer
  def factors()
    (1..self).select { |n| (self % n).zero? }
  end
end

puts 64000000.factors.map {|n| n ** 2}.reduce(:+)
