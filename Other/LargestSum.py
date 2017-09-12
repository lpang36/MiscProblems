#cci 19.7
arr = [2,-8,3,-2,4,-10]
def findLargestSum(arr):
	if len(arr)==1:
		return arr[0]
	sum = 0
	prev = findLargestSum(arr[0:(len(arr)-1)])
	max = prev
	for i in range(len(arr)-1,0,-1):
		sum = sum+arr[i]
		if sum>max:
			max = sum
	return max
print(findLargestSum(arr))
			
		