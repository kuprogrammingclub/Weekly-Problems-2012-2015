def listremv( lst1, lst2 )
  new_lst = lst1.split(",") - lst2.split(",")
  puts "\n"
  print new_lst
end

a = gets.chomp
b = gets.chomp

listremv(a, b)
