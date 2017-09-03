import java.util.Arrays;
import java.lang.Math;

public class UniqueCharacters {
	public UniqueCharacters () {
	}
	public void shuffleArray (char[] arr) {
		for (int i = 0; i<arr.length; i++) {
			int ind = (int)(Math.random()*(i+1));
			char temp = arr[ind];
			arr[ind] = arr[i];
			arr[i] = temp;
		}
	}
	//cci 1.1.1
	public boolean determineUniqueCharacters (String s) {
		//does this count as using an additional data structure?
		char[] arr = s.toCharArray();
		shuffleArray(arr);
		//do quicksort
		for (int i = 0; i<arr.length-1; i++) {
			if (arr[i]==arr[i+1]) {
				return true;
			}
		}
		return false;
	}
	//cci 1.1.3
	public String removeDuplicates (String s) {
		char[] arr = s.toCharArray();
		int count = 0;
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<i; j++) {
				if (arr[i]==arr[j]) {
					count--;
					break;
				}
			}
			arr[count] = arr[i];
			count++;
		}
		String t = "";
		for (int i = 0; i<count; i++) {
			t+=arr[i];
		}
		return t;
	}
	public static void main(String[] args) {
		UniqueCharacters UC = new UniqueCharacters();
		System.out.println(UC.determineUniqueCharacters("asdfdjkl;"));
		System.out.println(UC.removeDuplicates("aaabbb"));
	}
}