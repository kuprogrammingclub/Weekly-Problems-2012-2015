puts "Enter a time"

timeString = gets.chomp

#need to split string into usable int components

array = timeString.split(":")

#extract the A or P to indicate time of day. This is saying var = third character of index 2 of array
amorpm = array[2][2]

#get rid of am/pm at the end of the string using range
array[2] = array[2][0..1]

#this if indicates we have a time like 12:45:03AM which is 00:45:03
if(amorpm == 'A' && array[0].to_i == 12)
        array[0] = '00'
#indicates we have a time like 11:45:54PM which is 23:45:54
elsif(amorpm == 'P' && array[0].to_i != 12)
        array[0] = array[0].to_i + 12
end

puts "Converted time is " + array[0].to_s+":"+array[1]+":"+array[2]
