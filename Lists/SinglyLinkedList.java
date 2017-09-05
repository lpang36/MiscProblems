import java.util.Hashtable;

public class SinglyLinkedList {
	public Node first;
	public int size;
	public SinglyLinkedList() {
		size = 0;
	}
	public SinglyLinkedList(Node f) {
		first = f;
		size = 1;
	}
	public SinglyLinkedList(char c) {
		first = new Node(c);
		size = 1;
	}
	public SinglyLinkedList(char[] c) {
		first = new Node(c[0]);
		Node current = first;
		for (int i = 1; i<c.length; i++) {
			current.add(new Node(c[i]));
			current = current.next();
		}
		size = c.length;
	}
	public void addNode(Node n) {
		Node current = first;
		for (int i = 0; i<size-1; i++) {
			current = current.next();
		}
		current.add(n);
		size++;
	}
	public void deleteNode(int n) { //0 indexed
		if (n==0) 
			first = first.next();
		else {
			Node current = first;
			for (int i = 0; i<n-1; i++) {
				current = current.next();
			}
			current.add(current.next().next());
		}
		size--;
	}
	public void removeDuplicatesHashTable() {
		Hashtable table = new Hashtable();
		Node current = first;
		for (int i = 0; i<size-1; i++) {
			if (table.containsKey(current.get()))
				deleteNode(i);
			else
				table.put(current.get(),true);
			current = current.next();
		}
	}
	public void removeDuplicatesNoBuffer() {
		Node current1 = first;
		for (int i = 0; i<size-1; i++) {
			Node current2 = first;
			for (int j = 0; j<i; j++) {
				if (current2.get()==current1.get()) {
					deleteNode(i);
					break;
				}
				else
					current2 = current2.next();
			}
			current1 = current1.next();
		}
	}
	public String toString() {
		Node current = first;
		String out = "";
		for (int i = 0; i<size; i++) {
			out += current.get()+" ";
			current = current.next();
		}
		return out;
	}
	public Node get(int n) {
		Node current = first;
		for (int i = 0; i<n; i++) {
			current = current.next();
		}
		return current;
	}
	public char getFromEnd(int n) { //last element indexed as 0
		Node current = first;
		for (int i = 0; i<size-2-n; i++) {
			current = current.next();
		}
		return current.content;
	}
	public void deleteNodeAccessOnly(int n) {
		Node current = first;
		for (int i = 0; i<n-1; i++) {
			current = current.next();
		}
		current.makeRedirect();
		size--;
	}
	public int listToInt() {
		Node current = first;
		int out = 0;
		for (int i = 0; i<size; i++) {
			out = out*10+Character.getNumericValue(current.get());
			current = current.next();
		}
		return out;
	}
	public SinglyLinkedList intToList(int x) {
		char[] list = Integer.toString(x).toCharArray();
		return new SinglyLinkedList(list);
	}
	public SinglyLinkedList add(SinglyLinkedList a) {
		int x = a.listToInt();
		int y = this.listToInt();
		return intToList(x+y);
	}
	public int makeCircular() {
		int ind1 = (int)(Math.random()*size);
		Node n1 = get(ind1);
		Node n2 = get(size-1);
		n2.add(n1);
		return ind1;
	}
	public Node findBeginning() { //don't use size. that's cheating
		Hashtable table = new Hashtable();
		Node current = first;
		while(true) {
			if (table.containsKey(System.identityHashCode(current)))
				return current;
			else
				table.put(System.identityHashCode(current),true);
			current = current.next();
		}
	}
	private class Node {
		Node next;
		char content;
		boolean redirect = false;
		Node(char c) {
			content = c;
		}
		Node(char c, Node n) {
			content = c;
			next = n;
		}
		void makeRedirect() {
			redirect = true;
		}
		void add(Node n) {
			next = n;
		}
		Node next() {
			if (redirect)
				return next.next;
			return next;
		}
		char get() {
			if (redirect)
				return next.content;
			return content;
		}
	}
	public static void main(String[] args) {
		SinglyLinkedList obj = new SinglyLinkedList(new char[] {'a','b','c','a','d'});
		SinglyLinkedList obj2 = new SinglyLinkedList(new char[] {'a','b','c','a','d'});
		obj.removeDuplicatesHashTable();
		System.out.println(obj);
		obj2.removeDuplicatesNoBuffer();
		System.out.println(obj2);
		System.out.println(obj.getFromEnd(2));
		obj2.deleteNodeAccessOnly(0);
		System.out.println(obj2);
		SinglyLinkedList obj3 = new SinglyLinkedList(new char[] {'4','0','0'});
		SinglyLinkedList obj4 = new SinglyLinkedList(new char[] {'9','8','4'});
		System.out.println(obj3.add(obj4));
		System.out.println(obj.makeCircular());
		System.out.println(obj.findBeginning().get());
	}
}
