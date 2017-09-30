import java.util.Scanner;
import java.util.Hashtable;
import java.util.Comparator;
import java.util.Arrays;
import java.lang.Math;
public class P2 {
	static Scanner sc = new Scanner(System.in);
	public P2(Hashtable vals) {
		int n = sc.nextInt();
		Pair[] p = new Pair[n];
		for (int i = 0; i<n; i++) {
			long v = (long)(vals.get(sc.next()));
			long d = sc.nextLong();
			p[i] = new Pair(v,d);
		}
		Arrays.sort(p);
		System.out.println(find(p,0,0,0,0));
	}
	public class Pair implements Comparable<Pair> {
		long a;
		long b;
		public Pair(long x, long y) {
			a=x;
			b=y;
		}
		public int compareTo(Pair p1) {
			return (int)(this.b-p1.b);
		}
	}
	public long find(Pair[] p, long health, int eaten, int ind, long last) {
		if (ind<p.length&&p[ind].a>=0&&health>=(p[ind].b-last)) {
			//System.out.println("positive"+ind+" "+health+" "+eaten+" "+(health+p[ind].a-p[ind].b+last)+" "+last);
			return find(p,health+p[ind].a-p[ind].b+last,eaten+1,ind+1,p[ind].b);
		}
		else {
			return eaten;
		}
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		Hashtable vals = new Hashtable();
		for (int i = 0; i<f; i++) {
			vals.put(sc.next(),sc.nextLong());
		}
		P2 p2 = new P2(vals);
	}
}
