//cci 9.3
public class RotatedArray {
	int[] list;
	public RotatedArray (int[] n, int k) {
		list = new int[n.length];
		for (int i = 0; i<n.length; i++) {
			list[(i+k)%n.length] = n[i];
		}
	}
	public int search (int n) {
		int x = list.length-1-findMax(0,list.length-1);
		return search(n,x,(x-1)%list.length);
	}
	public int search(int n, int adjl, int adjr) {
		if (adjl==adjr&&list[adjl]==n)
			return adjl;
		else if (adjl==adjr)
			return -1;
		int mid;
		if (adjl<adjr)
			mid = (adjl+adjr)/2;
		else
			mid = ((adjl+adjr)/2+list.length/2)%list.length;
		if (list[mid]<n)
			return search(n,mid+1,adjr);
		else if (list[mid]==n)
			return mid;
		return search(n,adjl,mid+1);
	}
 	public int findMax(int l, int r) {
		if (list[l]<=list[r])
			return r;
		int a = findMax(l,(l+r)/2);
		int b = findMax((l+r)/2+1,r);
		if (list[a]>list[b])
			return a;
		return b;
	}
	public static void main(String[] args) {
		RotatedArray obj = new RotatedArray(new int[] {1,2,3,4,5,6,7,8,9,10}, 7);
		System.out.println(obj.search(5));
		System.out.println(obj.search(11));
	}
}
