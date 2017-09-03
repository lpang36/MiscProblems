//no c strings in java, so i will approximate this with a space
//lol nvm
import java.lang.StringBuffer;

public class ReverseCString {
	public ReverseCString () {
	}
	//cci 1.1.2
	public String reverseCString (String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = s.length()-2; i>-1; i--) {
			sb.append(s.charAt(i));
		}
		sb.append(' ');
		return sb.toString();
	}
	public static void main(String[] args) {
		ReverseCString obj = new ReverseCString();
		System.out.println(obj.reverseCString("me too thanks "));
	}
}