#cci 20.10

from Queue import *

dict = {
	'damp': True,
	'lamp': True,
	'limp': True,
	'lime': True,
	'like': True,
}

def dist(word1, word2):
	assert len(word1)==len(word2)
	sum = 0
	for i in range(0,len(word1)):
		if word1[i] is not word2[i]:
			sum = sum+1
	return sum

def mapChar(word1, word2, x):
	return word1[:x]+word2[x]+word1[(x+1):]

def modifyWords(word1, word2):	
		h1 = PriorityQueue()
		h2 = PriorityQueue()
		words1 = {}
		words2 = {}
		h1.put((dist(word1,word2),word1))
		h2.put((dist(word1,word2),word2))
		words1[word1] = True
		words2[word2] = True
		while True:
			temp1 = h1.get();
			temp2 = h2.get();
			words1[temp1[1]] = True
			words2[temp2[1]] = True
			if temp1[1] in words2:
				return dist(word1,word2)
			if temp2[1] in words1:
				return dist(word1,word2)
			for i in range(0,len(temp1[1])):
				newWord = mapChar(temp1[1],word2,i)
				if newWord in dict and newWord not in words1:
					h1.put((dist(newWord,word2),newWord))
			for i in range(0,len(temp2[1])):
				newWord = mapChar(temp2[1],word1,i)
				if newWord in dict and newWord not in words2:
					h2.put((dist(newWord,word1),newWord))
			if h1.empty() or h2.empty():
				return -1

print(modifyWords('damp','like'))