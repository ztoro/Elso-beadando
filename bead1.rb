#!/usr/bin/ruby -w
# encoding: UTF-8

begin
  inFile = File.new(ARGV[0], "r")
rescue TypeError
  puts "Adj meg egy file-t!"
  exit
rescue Errno::ENOENT
  puts "Nincs ilyen file!"
  exit
end

outFile = open("eredmeny.txt", 'w')

  
=begin
inFile.each do |line|
  outFile.puts line
end
=end


inFile.each do |line|
  temp = line.split(",")
  f = temp[0]
  operator = temp[1].strip
  numbers = temp[2][10..-1]
  if operator == "sum"
    sum = 0
    puts sum
    numberBox = numbers.split(" ").join.to_i
    numberBox.each do |number|
      sum = sum + number
    end
   
  end
  
                 
