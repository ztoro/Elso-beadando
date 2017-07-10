!/usr/bin/env python2

import smtplib
import os
import errno
import shutil
import time

#Basic Configuration
source = '/home/zoli/Dev/source'
destination = '/home/zoli/Dev/destination'

#SMTP Configuration
smtp = 'mail.bhu.flextronics.com'
fromAddress = 'test_file_copier@flextronics.com'
toAddress = 'zoltanakos.torok@flex.com'


def getSourceList():
	sourceList = []
	for path, subdirs, files in os.walk(source):
		for name in files:
			sourceList.append(os.path.join(path, name))
	return sourceList

def getDestinationList():
	destList = []
	for path, subdirs, files in os.walk(destination):
		for name in files:
			destList.append(os.path.join(path, name))
	return destList

def getImaginaryList():
	imagList = []
	for files in getSourceList():
		imagList.append(files.replace(source, destination))
	return imagList

def getFolderPath(path):
	folderPath = '/'.join(path.split('/')[:-1])
	return folderPath

def makeFolderPath(path):
	try:
		os.makedirs(path)
	except OSError as exception:
		if exception.errno != errno.EEXIST:
			raise

def getLastModified(path):
	time = os.path.getmtime(path)
	return time

def main():
	exceptionfile = open('exceptions.txt','r')
	exceptions = exceptionfile.read()

	log = open('log.txt','a')

	for imaginaryFile, sourceFile in zip(getImaginaryList(), getSourceList()):
		if imaginaryFile not in getDestinationList() and imaginaryFile not in exceptions:
			try:
				makeFolderPath(getFolderPath(imaginaryFile))
				shutil.copyfile(sourceFile,imaginaryFile)
				log.write(time.ctime() + "  " +  sourceFile + ' copied to ' + imaginaryFile + '\n')
			except:
				log.write(time.ctime() + ' !!!!!!ERROR:' + sourceFile + ' cannot be copied to ' + imaginaryFile + '\n')
		elif getLastModified(sourceFile) > getLastModified(imaginaryFile):
			try:
				shutil.copyfile(sourceFile,imaginaryFile)
				log.write(time.ctime() + " " + sourceFile + ' has overwritten ' + imaginaryFile + '\n')
			except:
				log.write(time.ctime() + ' !!!!!!ERROR:' + sourceFile + ' cannot overwrite ' + imaginaryFile + '\n') 

main()
