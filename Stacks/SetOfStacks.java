public class SetOfStacks {
	Stack first;
	int size;
	int limit = 3;
	public SetOfStacks () {
	}
	public void push (int x) {
		if (size==0) {
			first = new Stack();
			size++;
		}
		if (first.size>=limit) {
			first = new Stack(first);
			size++;
		}
		first.push(x);
	}
	public void pop () {
		if (first.size==0) {
			first = first.next;
			size--;
		}
		first.pop();
	}
	public void popFrom (int x) { //0 indexed from most recent stack
		Stack current = first;
		for (int i = 0; i<x-1; i++) {
			current = current.next;
		}
		current.next.pop();
		current.last.next = current.next.first;
	}
	public String toString () {
		String s = "";
		Stack current = first;
		for (int i = 0; i<size; i++) {
			s+=current.toString()+'\n';
			current = current.next;
		}
		return s;
	}
	private class Stack {
		Node first;
		Node last;
		Stack next;
		int size;
		public Stack () {
		}
		public Stack (Stack n) {
			next = n;
		}
		public void push(int n) {
			if (size==0) {
				first = new Node(n);
				last = first;
				if (next!=null) 
					first.next = next.first;
			}
			else 
				first = new Node(n,first);
			size++;
		}
		public int pop() {
			int out = first.data;
			first = first.next;
			size--;
			return out;
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
	}
	public static void main(String[] args) {
		SetOfStacks obj = new SetOfStacks();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.push(8);
		obj.push(9);
		obj.pop();
		obj.pop();
		obj.popFrom(1);
		System.out.println(obj);
	}
}
