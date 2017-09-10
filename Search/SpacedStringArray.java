//cci 9.5
public class SpacedStringArray {
	String[] words;
	public SpacedStringArray (String[] n) {
		words = n;
	}
	public int search(String s) {
		return search(s,0,words.length-1);
	}
	public int search(String s, int l, int r) {
		if (l==r&&words[l].equals(s))
			return l;
		else if (l>=r&&!words[l].equals(s))
			return -1;
		int lmid = (l+r)/2;
		int rmid = lmid;
		boolean lflag = true;
		boolean rflag = true;
		if (words[lmid].equals(s))
			return lmid;
		while(lmid>=l||rmid<=r) {
			if (lmid>=0&&lflag) {
				if (words[lmid].equals(s))
					return lmid;
				else if (!words[lmid].equals("")) {
					if (words[lmid].compareTo(s)>0)
						return search(s,l,lmid);
					else
						lflag = false;
				}
			}
			if (rmid<words.length&&rflag) {
				if (words[rmid].equals(s))
					return rmid;
				else if (!words[rmid].equals("")) {
					if (words[rmid].compareTo(s)<0)
						return search(s,rmid,r);
					else
						rflag = false;
				}
			}
			lmid--;
			rmid++;
		}
		return -1;
	}
	public static void main(String[] args) {
		SpacedStringArray obj = new SpacedStringArray(new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""});
		System.out.println(obj.search("at"));
		System.out.println(obj.search("hello"));
	}
}
