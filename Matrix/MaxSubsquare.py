#cci 20.11
def maxSubsquare(mat):
	return findMaxSubsquare(mat,0,0,len(mat),-1,-1);

def findMaxSubsquare(mat,x1,y1,size,edge1,edge2):
	if size<1:
		return 0
	arr = [None]*8
	arr[0] = mat[x1][y1]
	flag = True
	if edge1 is 0 or edge2 is 0:
		for i in range(1,size-1):
			if not mat[x1][y1+i]:
				flag = False
				break
	arr[1] = flag
	arr[2] = mat[x1+size-1][y1]
	flag = True
	if edge1 is 1 or edge2 is 1:
		for i in range(1,size-1):
			if not mat[x1+size-1][y1+i]:
				flag = False
				break
	arr[3] = flag
	arr[4] = mat[x1+size-1][y1+size-1]
	flag = True
	if edge1 is 2 or edge2 is 2:
		for i in range(1,size-1):
			if not mat[x1+i][y1+size-1]:
				flag = False
				break
	arr[5] = flag
	arr[6] = mat[x1][y1+size-1]
	flag = True
	if edge1 is 3 or edge2 is 3:
		for i in range(1,size-1):
			if not mat[x1+i][y1]:
				flag = False
				break
	arr[7] = flag
	flag = True
	for i in range(0,8):
		if not arr[i]:
			flag = False
	if flag:
		return size
	else:
		ind = [-1]*8
		if arr[7] and arr[0] and arr[1]:
			ind[0] = 3
			ind[1] = 0
		if arr[1] and arr[2] and arr[3]:
			ind[2] = 0
			ind[3] = 1
		if arr[3] and arr[4] and arr[5]:
			ind[4] = 1
			ind[5] = 2
		if arr[5] and arr[6] and arr[7]:
			ind[6] = 2
			ind[7] = 3
		#for even more optimization, put all these calls in a max heap by size, so it does a breadth first rather than depth first search
		return max(findMaxSubsquare(mat,x1,y1,size-1,ind[0],ind[1]),findMaxSubsquare(mat,x1,y1-1,size-1,ind[2],ind[3]),findMaxSubsquare(mat,x1-1,y1,size-1,ind[4],ind[5]),findMaxSubsquare(mat,x1-1,y1-1,size-1,ind[6],ind[7]))

mat = [[True,True,True,False,False],[True,True,True,False,False],[False,True,False,True,False],[False,False,True,False,True],[False,False,False,True,False]]
print(maxSubsquare(mat))