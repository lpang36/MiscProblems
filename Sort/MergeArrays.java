public class MergeArrays {
	int[] list;
	public MergeArrays (int[] a, int[] b, int n) {
		int j = n-1; 
		int k = b.length-1; 
		for (int i = a.length-1; i>-1; i--) {
			if (k<0||a[j]>b[k]) {
				a[i] = a[j];
				j--;
			}
			else {
				a[i] = b[k];
				k--;
			}
		}
		list = a;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i<list.length; i++) {
			s+=list[i]+" ";
		}
		return s;
	}
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i<5; i++) {
			a[i] = 2*i;
		}
		int[] b = {1,3,5,7,9};
		MergeArrays obj = new MergeArrays(a,b,5);
		System.out.println(obj);
	}
}
