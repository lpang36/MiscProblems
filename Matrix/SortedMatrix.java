//cci 9.6
public class SortedMatrix {
	int[][] nums;
	public SortedMatrix (int[][] n) {
		nums = n;
	}
	public int[] search(int n) {
		int[] out = new int[2];
		int[] dim2 = nums[0];
		int[] dim1 = new int[nums.length];
		for (int i = 0; i<nums.length; i++) {
			dim1[i] = nums[i][0];
		}
		out[0] = searchDim(n,dim1,0,dim1.length-1);
		out[1] = searchDim(n,dim2,0,dim2.length-1);
		if ((out[0]>=0&&out[0]<nums.length)&&(out[1]>=0&&out[1]<nums[0].length)&&nums[out[0]][out[1]]==n)
			return out;
		else
			return new int[] {-1,-1};
	}
	public int searchDim(int n, int[] dim, int l, int r) {
		if (l==r&&dim[l]<=n) 
			return l;
		else if (l==r)
			return -1;
		int mid = (l+r)/2+1;
		if (dim[mid]>n)
			return searchDim(n,dim,l,mid-1);
		return searchDim(n,dim,mid,r);
	}
	public static void main(String[] args) {
		int[][] n = new int[][] {{1,2,3,4},{5,6,7,8},{10,11,12,13}};
		SortedMatrix obj = new SortedMatrix(n);
		System.out.println(obj.search(4)[0]+" "+obj.search(4)[1]);
		System.out.println(obj.search(9)[0]+" "+obj.search(9)[1]);
		System.out.println(obj.search(-1)[0]+" "+obj.search(-1)[1]);
	}
}
