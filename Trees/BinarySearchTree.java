import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.Math;

public class BinarySearchTree {
	Node root;
	int size;
	//cci 4.3
	public BinarySearchTree (int[] x) {
		Node[] nodes = new Node[x.length];
		size = x.length;
		for (int i = 0; i<x.length; i++) {
			Node n = new Node(x[i]);
			nodes[i] = n;
			if (i==0) {}
			else {
				if (i%2==0)
					nodes[(i+1)/2-1].left = n;
				else
					nodes[(i+1)/2-1].right = n;
				n.parent = nodes[(i+1)/2-1];
			}
		}
		root = nodes[0];
	}
	//cci 4.4
	public ArrayList<LinkedList<Node>> makeLists() {
		ArrayList<LinkedList<Node>> listOfLists = new ArrayList<LinkedList<Node>>();
		Node[] current = new Node[] {root};
		for (int i = 0; i<(int)(Math.log(size)/Math.log(2.0))+1; i++) {
			LinkedList<Node> list = new LinkedList<Node>();
			int count = 0;
			Node[] newCurrent = new Node[current.length*2];
			for (int j = 0; j<current.length; j++) {
				if (current[j]!=null) {
					list.add(current[j]);
					newCurrent[count] = current[j].left;
					count++;
					newCurrent[count] = current[j].right;
					count++;
				}
			}
			current = newCurrent;
			listOfLists.add(list);
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
		while(p.parent!=null) {
			Node pParent = p.parent;
			if (p==b)
				return p;
			else {
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
	public boolean existsInSubtree(Node a, Node b) {
		if (a!=null&&a==b)
			return true;
		boolean left = false, right = false;
		if (a.left!=null)
			left = existsInSubtree(a.left,b);
		if (a.right!=null)
			right = existsInSubtree(a.right,b);
		return left||right;
	}
	public String toString() {
		String s = "";
		Node[] current = new Node[] {root};
		for (int i = 0; i<(int)(Math.log(size)/Math.log(2.0))+1; i++) {
			int count = 0;
			Node[] newCurrent = new Node[current.length*2];
			for (int j = 0; j<current.length; j++) {
				if (current[j]!=null) {
					s+=current[j].data+" ";
					newCurrent[count] = current[j].left;
					count++;
					newCurrent[count] = current[j].right;
					count++;
				}
			}
			current = newCurrent;
		}
		return s;
	}
	public void test() {
		BinarySearchTree bst = new BinarySearchTree(new int[] {1,2,3,4,5,6,7,8,9,10});
		System.out.println(bst);
		ArrayList<LinkedList<Node>> lists = bst.makeLists();
		for (int i = 0; i<lists.size(); i++) {
			System.out.println(lists.get(i));
		}
		Node a = bst.root.right.right.left;
		Node b = bst.root.left.left;
		System.out.println(bst.findCommonAncestor(a,b).data);
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
		BinarySearchTree obj = new BinarySearchTree(new int[] {1,2,3,4,5,6,7,8,9,10});
		obj.test();
	}
}
