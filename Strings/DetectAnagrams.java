public class DetectAnagrams {
	public DetectAnagrams () {
	}
	public void shuffleArray (char[] arr) {
		for (int i = 0; i<arr.length; i++) {
			int ind = (int)(Math.random()*(i+1));
			char temp = arr[ind];
			arr[ind] = arr[i];
			arr[i] = temp;
		}
	}
	//cci 1.1.4
	public boolean detectAnagrams (String s1, String s2) {
		if (s1.length()!=s2.length()) {
			return false;
		}
		//does this count as using an additional data structure?
		char[] arr1 = s1.toCharArray();
		shuffleArray(arr1);
		char[] arr2 = s2.toCharArray();
		shuffleArray(arr2);
		//do quicksort
		for (int i = 0; i<arr1.length; i++) {
			if (arr1[i]==arr2[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		DetectAnagrams obj = new DetectAnagrams();
		System.out.println(obj.detectAnagrams("anagram  ","nag a ram"))
	}
}