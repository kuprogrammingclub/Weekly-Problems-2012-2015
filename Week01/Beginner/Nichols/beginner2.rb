puts "Palindrome Checker \n"

continue = true

while continue == true

    puts "Enter a word: "

    word = gets.chomp

    charArray = word.split("")

    isPalindrone = true

    for i in 0..(word.length/2)
        if charArray[i] != charArray[(word.length - i - 1)]
            isPalindrone = false
        end
    end

    if isPalindrone == true
        puts "Palindrome"
    else
        puts "Not a Palindrome"
    end

    puts "Check another word? (Y/N)"

    choice = gets.chomp.downcase

    if choice == 'y'
        continue = true
    else
        continue = false
    end

end # end while
