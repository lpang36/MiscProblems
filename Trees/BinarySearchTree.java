import java.util.LinkedList;
import java.lang.Math;

public class BinarySearchTree {
	Node root;
	int size;
	//cci 4.3
	public BinarySearchTree (int[] x) {
		Node[] nodes = new Node[x];
		size = x.length;
		for (int i = 0; i<x.length; i++) {
			Node n = new Node(x[i]);
			nodes[i] = n;
			if (i%2==0)
				nodes[i/2].left = n;
			else
				nodes[i/2].right = n;
			n.parent = nodes[i/2];
		}
		root = nodes[0];
	}
	//cci 4.4
	public LinkedList<Node>[] makeLists() {
		LinkedList<Node>[] listOfLists = new LinkedList<Node>[(int)(Math.log(size)/Math.log(2.0))+1];
		Node[] current = new Node[] {root};
		for (int i = 0; i<listOfLists.length; i++) {
			LinkedList<Node> list = new LinkedList<Node>();
			int count = 0;
			newCurrent = new Node[current.length*2];
			for (int i = 0; i<current.length; i++) {
				list.add(current[i]);
				newCurrent[count] = current[i].left;
				count++;
				newCurrent[count] = current[i].right;
				count++;
			}
			current = newCurrent;
			listOfLists[i] = list;
		}
		return listOfLists;
	}
	//cci 4.5
	public Node findSuccessor(Node n) {
		if (n.right!=null) {
			Node r = n.right;
			while(r.left!=null) {
				r = r.left;
			}
			return r;
		}
		if (n.parent!=null)
			return n.parent;
		return null;
	}
	//cci 4.6
	public Node findCommonAncestor(Node a, Node b) { //also works for non search trees
		if (existsInSubtree(a,b))
			return a;
		Node p = a;
		while(p!=null) {
			if (p==b)
				return p;
			else {
				pParent = p.parent;
				boolean leftFlag = pParent.left==p;
				if (leftFlag&&existsInSubtree(pParent.right,b))
					return pParent;
				else if (!leftFlag&&existsInSubtree(pParent.left,b))
					return pParent;
			}
			p = pParent;
		}
		return null;
	}
	//cci 4.7
	public boolean existsInSubtree(Node a, Node b) {
		if (a!=null&&a==b)
			return true;
		boolean left, right;
		if (a.left!=null)
			left = existsInSubtree(a.left,b);
		if (a.right!=null)
			right = existsInSubtree(a.right,b);
		return left||right;
	}
	public String toString() {
		String s;
		Node[] current = new Node[] {root};
		for (int i = 0; i<(int)(Math.log(size)/Math.log(2.0))+1; i++) {
			int count = 0;
			newCurrent = new Node[current.length*2];
			for (int i = 0; i<current.length; i++) {
				s+=current[i].data+' ';
				newCurrent[count] = current[i].left;
				count++;
				newCurrent[count] = current[i].right;
				count++;
			}
			current = newCurrent;
		}
		return s;
	}
	private class Node {
		int data;
		Node left;
		Node right;
		Node parent;
		Node() {}
		Node(int d) {
			data = d;
		}
	}
	public static void main(String[] args) {
		BinarySearchTree obj = new BinarySearchTree();
	}
}
