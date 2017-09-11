import java.util.Comparator;
import java.util.Arrays;

//cci 9.7
public class Circus {
	Person[] people;
	int length;
	public Circus (int[] ht, int[] wt) {
		assert ht.length==wt.length;
		people = new Person[ht.length];
		for (int i = 0; i<ht.length; i++) {
			people[i] = new Person(ht[i],wt[i]);
			people[i].index = i;
		}
		Person[] clone = people.clone();
		Arrays.sort(people,new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.h-p2.h;
			}
		});
		Arrays.sort(clone,new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.w-p2.w;
			}
		});
		//dynamic programming solution to longest common subseq problem
		int[][] memo = new int[ht.length+1][ht.length+1];
		for (int i = 0; i<ht.length; i++) {
			for (int j = 0; j<ht.length; j++) {
				if (people[i].index==clone[j].index)
					memo[i+1][j+1] = memo[i][j]+1;
				else
					memo[i+1][j+1] = Math.max(memo[i][j+1],memo[i+1][j]);
			}
		}
		length = memo[ht.length][ht.length];
	}
	private class Person {
		int h;
		int w;
		int index;
		Person(int ht, int wt) {
			h = ht;
			w = wt;
		}
	}
	public static void main(String[] args) {
		Circus obj = new Circus(new int[] {65,70,56,75,60,68,100}, new int[] {100,150,90,190,95,110,20});
		System.out.println(obj.length);
	}
}
