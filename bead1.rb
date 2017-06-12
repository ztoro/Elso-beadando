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

class Data
  def initalize(f,op,num)
    @f, @operation, @numbers = f, op, num
  end

  def getF
    @f
  end

  def getNumbers
    @numbers
  end

  def getOperation
    @operation
  end
end

inFile.each do |line|
  temp = line.split(",")
  puts temp
#=begin
  data = Data.new(temp)
  y = data.getOperation()
  puts y
#=end
end
                 
