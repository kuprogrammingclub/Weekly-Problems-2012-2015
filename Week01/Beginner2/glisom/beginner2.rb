def palindrome(wd)
  wd == wd.reverse
end
wd = gets.chomp
if palindrome(wd) == true
puts  "Palindrome"
else
puts  "Not a palindrome"
end
