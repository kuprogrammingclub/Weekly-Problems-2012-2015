def combinator(k, arr)
  (k..k).flat_map{|n| arr.to_a.combination(n).map(&:join)}
end

vars = gets.chomp

vars = vars.split(" ")

arr = gets.chomp

k = arr[0].to_i

n = arr[1].to_i

arr = arr.split(" ")

puts combinator(k, arr)
