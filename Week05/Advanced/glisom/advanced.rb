puts "Door 1  Door 2  Door 3
One of these hides a car. Which do you choose?"

dr1 = 0, dr2 = 0, dr3 = 0
door = (1..3).to_a.sample
case door
when 1
  dr1 = 1
when 2
  dr2 = 1
when 3
  dr3 = 1
end

s = (1..3).to_a.sample

if (usr_choice == 1) && dr1 != 1
  puts"Ah! It looks like Door 2 hides a goat! What to do now? \n Stay with Door 1? Or switch to Door 3?"
