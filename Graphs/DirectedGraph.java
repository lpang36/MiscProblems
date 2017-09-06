import java.util.Hashtable;
import java.util.ArrayList;

public class DirectedGraph {
	Node root;
	public DirectedGraph () {
		root = new Node();
	}
	//cci 4.2  
	public boolean pathExists(Node a, Node b) {
		ArrayList<Node> list = new ArrayList<Node>();
		Hashtable table = new Hashtable();
		list.add(a);
		table.put(a,true);
		while(!list.isEmpty()) {
			Node n = list.get(0);
			if (n==b)
				return true;
			list.remove(0);
			for (Node i: n.conns) {
				if (!table.containsKey(i)) {
					list.add(i);
					table.put(i,true);
				}
			}
		}
		return false;
	}
	private class Node {
		int data;
		ArrayList<Node> conns = new ArrayList<Node>(); 
		Node() {}
		Node(int d) {
			data = d;
		}
		Node add(Node n) {
			conns.add(n);
			return n;
		}
	}
	public void test() {
		DirectedGraph obj = new DirectedGraph();
		DirectedGraph obj1 = new DirectedGraph();
		obj.root.add(new Node()).add(new Node()).add(obj.root);
		Node n = obj.root.add(new Node()).add(new Node());
		System.out.println(pathExists(obj.root,n));
		System.out.println(pathExists(n,obj.root));
		System.out.println(pathExists(obj.root,new Node()));
	}
	public static void main(String[] args) {
		DirectedGraph obj = new DirectedGraph();
		obj.test();
	}
}
