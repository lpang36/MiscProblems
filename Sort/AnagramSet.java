import java.util.Arrays;
import java.util.Comparator;

//cci 9.2
public class AnagramSet {
	String[] words;
	public AnagramSet (String[] list) {
		String[] temp = new String[list.length];
		words = new String[list.length];
		for (int i = 0; i<list.length; i++) {
			char[] chars = list[i].toCharArray();
			Arrays.sort(chars);
			temp[i] = new String(chars);
		}
		ArrayIndexComparator comp = new ArrayIndexComparator(temp);
		Integer[] indexes = comp.createIndexArray();
		Arrays.sort(indexes,comp);
		for (int i = 0; i<list.length; i++) {
			words[i] = list[indexes[i]];
		}
 	}
	public String toString() {
		String s = "";
		for (int i = 0; i<words.length; i++) {
			s+=words[i]+" ";
		}
		return s;
	}
	public class ArrayIndexComparator implements Comparator<Integer>
	{
		private final String[] array;

		public ArrayIndexComparator(String[] array)
		{
			this.array = array;
		}

		public Integer[] createIndexArray()
		{
			Integer[] indexes = new Integer[array.length];
			for (int i = 0; i < array.length; i++)
			{
				indexes[i] = i; // Autoboxing
			}
			return indexes;
		}

		public int compare(Integer index1, Integer index2)
		{
			 // Autounbox from Integer to int to use as array indexes
			return array[index1].compareTo(array[index2]);
		}
	}
	public static void main(String[] args) {
		AnagramSet obj = new AnagramSet(new String[] {"hello","anagram","olleh","nagaram","maragan","what","ehlol"});
		System.out.println(obj);
	}
}
