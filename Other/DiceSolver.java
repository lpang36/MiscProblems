/* generalized solution to a problem i found on reddit, using three different methods to determine the expected minimum of rolling n dice:
https://www.reddit.com/r/AskReddit/comments/6uh94p/what_is_a_math_question_that_looks_easy_but_is/dlsq2af/ */

import java.util.Random;

public class DiceSolver {
    public DiceSolver () {
    }
	public int recursiveCombinations (int n, int[] dice, int max) {
		if (n==max) {
			int min = 7;
			for (int i = 0; i<n; i++) {
				if (dice[i]<min) {
					min = dice[i];
				}
			}
			return min;
		}
		else {
			int sum = 0;
			for (int i = 0; i<6; i++) {
				int[] diceCopy = dice.clone();
				diceCopy[n] = i+1;
				sum+=recursiveCombinations(n+1,diceCopy,max);
			}
			return sum;
		}
	}
	//approximate expected min with random rolls
    public double findExpectedMinRandomTrials (int n, int trials) {
		Random r = new Random();
		int sum = 0;
		for (int i = 0; i<trials; i++) {
			int min = 7;
			for (int j = 0; j<n; j++) {
				int temp = r.nextInt(6)+1;
				if (temp<min) {
					min = temp;
				}
			}
			sum+=min;
		}
		return sum/(trials+0.0);
    }
	public double findExpectedMinRandomTrials (int n) {
		return findExpectedMinRandomTrials(n,10000);
	}
	//find exact min by iterating through all combinations (slow for n>10)
    public double findExpectedMinRecursiveAverage (int n) {
		int[] dice = new int[n];
		return recursiveCombinations(0,dice,n)/Math.pow(6,n);
    }
	//approximate mathematical solution i found as outlined here: https://pastebin.com/Mg1Gfw6Z 
	//testing seems to indicate this doesn't work very well
    public double findExpectedMinIterativeSolution (int n) {
		if (n==1) {
			return 3.5;
		}
		else {
			double x = findExpectedMinIterativeSolution(n-1);
			return ((x-1)/5)*x+((6-x)/5)*(1+x)/2;
		}
    }
    public static void main(String[] args) {
		DiceSolver DS = new DiceSolver();
		for (int n = 1; n<10; n++) {
			System.out.println(DS.findExpectedMinRandomTrials(n)+" "+DS.findExpectedMinRecursiveAverage(n)+" "+DS.findExpectedMinIterativeSolution(n));
		}
    }
}