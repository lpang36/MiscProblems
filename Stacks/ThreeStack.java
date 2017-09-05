import java.util.ArrayList;

public class ThreeStack {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	int[] sizes = new int[3];
	public ThreeStack () {
	}
	public void push(int x, int stack) {
		arr.set(x,sizes[stack]*3+stack);
		sizes[stack]++;
	}
	public void pop(int stack) {
		arr.get(sizes[stack]*3+stack);
		sizes[stack]--;
	}
	public static void main(String[] args) {
		ThreeStack obj = new ThreeStack();
	}
}
