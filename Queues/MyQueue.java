//cci 3.5
public class MyQueue {
	Stack a = new Stack();
	Stack b = new Stack();
	boolean aEmpty = false;
	int size = 0;
	public MyQueue () {
	}
	public void enqueue(int x) {
		if (aEmpty) {
			for (int i = 0; i<size; i++) {
				try {
					a.push(b.pop());
				} catch (NullPointerException e) {
					break;
				}
			}
			aEmpty = !aEmpty;
		}
		a.push(x);
		size++;
	}
	public int dequeue() {
		if (!aEmpty) {
			for (int i = 0; i<size; i++) {
				try {
					b.push(a.pop());
				} catch (NullPointerException e) {
					break;
				}
			}
			aEmpty = !aEmpty;
		}
		size--;
		return b.pop();
	}
	private class Stack {
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
		MyQueue obj = new MyQueue();
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
	}
}
