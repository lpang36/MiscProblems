import java.util.ArrayList;

public class Tree {
	Node root;
	public Tree () {
		root = new Node();
	}
	//cci 4.1
	public boolean isBalanced() {
		ArrayList<DepthNode> list = new ArrayList<DepthNode>();
		double depth = -1;
		boolean flag = false;
		list.add(new DepthNode(root,0));
		while(!list.isEmpty()) {
			DepthNode n = list.get(0);
			list.remove(0);
			if (n.node.leaves.isEmpty()) {
				if (depth==-1) 
					depth = n.depth;
				else if (n.depth==depth) {}
				else if (n.depth!=depth&&!flag&&Math.abs(n.depth-depth)<=1.01) {
					depth = (depth+n.depth)/2.0;
					flag = true;
				}
				else if (n.depth!=depth&&flag&&Math.abs(n.depth-depth)<=0.51) {}
				else
					return false;
			}
			else {
				for (Node i: n.node.leaves) {
					list.add(new DepthNode(i,n.depth+1));
				}
			}
		}
		return true;
	}
	private class DepthNode {
		Node node;
		int depth;
		DepthNode(Node n, int d) {
			node = n;
			depth = d;
		}
	}
	private class Node {
		int data;
		Node root;
		ArrayList<Node> leaves = new ArrayList<Node>(); 
		Node() {}
		Node(int d) {
			data = d;
		}
		Node add(Node n) {
			leaves.add(n);
			return n;
		}
	}
	private void test() {
		Tree obj = new Tree();
		Tree obj1 = new Tree();
		obj.root.add(new Node()).add(new Node()).add(new Node());
		obj.root.add(new Node());
		obj1.root.add(new Node()).add(new Node());
		obj1.root.add(new Node());
		obj1.root.add(new Node());	
		System.out.println(obj.isBalanced());
		System.out.println(obj1.isBalanced());
	}
	public static void main(String[] args) {
		Tree obj = new Tree();
		obj.test();
	}
}
