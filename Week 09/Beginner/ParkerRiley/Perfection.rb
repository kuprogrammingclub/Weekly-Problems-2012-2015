ARGV.each do|fname|
  file = File.new(fname)
  begin
    while val = Integer(file.readline)
      sum = 0
      for i in 1..(val/2)
        if val % i == 0
          sum += i
        end
      end
      print "#{val} "
      if sum == val
        puts 'Perfect'
      else if sum < val
        puts 'Deficient'
      else
        puts 'Abundant'
      end
    end
  end
rescue EOFError => e
  puts 'End of file reached.'
end

end
