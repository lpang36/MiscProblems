import java.lang.Integer;

public class MinStack {
	Node first;
	int size;
	public MinStack () {
	}
	public void enqueue(int n) {
		if (size==0)
			first = new Node(n);
		else 
			first = new Node(n,first);
		size++;
	}
	public int dequeue() {
		int out = first.data;
		first = first.next;
		size--;
		return out;
	}
	public int getMin() {
		return first.min;
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
		int min;
		Node next;
		Node(int x) {
			data = x;
			min = x;
		}
		Node(int x, Node n) {
			data = x;
			next = n;
			if (x<n.min)
				min = x;
			else
				min = n.min;
		}
	}
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.enqueue(-1);
		obj.enqueue(1);
		obj.enqueue(6);
		obj.enqueue(5);
		obj.dequeue();
		obj.dequeue();
		System.out.println(obj);
		System.out.println(obj.getMin());
	}
}
