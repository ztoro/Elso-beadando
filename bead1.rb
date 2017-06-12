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


fValue = Array.new
index=1
inFile.each do |line|
  temp = line.split(",")
  f = temp[0]
  operator = temp[1].strip
  numbers = temp[2][10..-1]
  numberBox = numbers.split(" ")

  if operator == "sum"
    sum = 0
    numberBox.each do |number|
      i=1
      while i <= index do
        if number[0].eql?("f")
          fSzam=number[1..-1].to_i
          number = fValue[fSzam].to_i      
        end
        i=i+1
      end
      sum = sum + number.to_i
    end
    outFile.write f
    fValue[index]=sum
    index=index+1
    outFile.write " = "
    outFile.write sum
    outFile.write "\n"
  end
  

  if operator == "max"
    max = 0
    numberBox.each do |number|
      i=1
      while i <= index do
        if number[0].eql?("f")
          fSzam=number[1..-1].to_i
          number = fValue[fSzam]
        end
        i=i+1
      end
      if number.to_i > max
        max = number.to_i
      end
    end
    outFile.write f
    fValue[index]=max
    index=index+1
    outFile.write " = "
    outFile.write max
    outFile.write "\n"
  end
  if operator == "prod"
    prod = 1
    numberBox.each do |number|
      i=1
      while i <= index do
        if number[0].eql?("f")
          fSzam=number[1..-1].to_i
          number = fValue[fSzam]
        end
        i=i+1
      end
      prod = prod * number.to_i
    end
    outFile.write f
    fValue[index]=prod
    index=index+1
    outFile.write " = "
    outFile.write prod
    outFile.write "\n"
  end
end
