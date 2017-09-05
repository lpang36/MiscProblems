public class Stack {
	Node first;
	int size;
	public Stack () {
	}
	public void push(int n) {
		if (size==0) 
			first = new Node(n);
		else 
			first = new Node(n,first);
		size++;
	}
	public int pop() {
		int out = first.data;
		size--;
		first = first.next;
		return out;
	}
	public int peek() {
		return first.data;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public String toString() {
		String s = "";
		Node current = first;
		for (int i = 0; i<size; i++) {
			s+=current.data+" ";
			current = current.next;
		}
		return s;
	}
	private class Node {
		int data;
		Node next;
		Node(int x) {
			data = x;
		}
		Node(int x, Node n) {
			data = x;
			next = n;
		}
	}
	public static int getMin(Stack s) {
		int min = Integer.MAX_VALUE;
		Stack aux = new Stack();
		while(!s.isEmpty()) {
			int x = s.pop();
			aux.push(x);
			if (x<min)
				min = x;
		}
		while(!aux.isEmpty()) {
			s.push(aux.pop());
		}
		return min;
	}
	public static void popNum(Stack s, int x) {
		Stack aux = new Stack();
		while(!s.isEmpty()) {
			int y = s.pop();
			if (y==x) {
				break;
			}
			else
				aux.push(y);
		}
		while(!aux.isEmpty()) {
			s.push(aux.pop());
		}
	}
	//cci 3.6
	public static Stack sort(Stack s) {
		Stack out = new Stack();
		while(!s.isEmpty()) {
			int x = getMin(s);
			out.push(x);
			popNum(s,x);
		}
		return out;
	}
	public static void main(String[] args) {
		Stack obj = new Stack();
		obj.push(1);
		obj.push(5);
		obj.push(2);
		obj.push(4);
		obj.push(3);
		System.out.println(Stack.sort(obj));
	}
}
