import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
}
 public class BinaryTree{
	Node root;
	public void insert(int data) {
		Node node;
		if(root == null) {
			node = new Node();
			node.data = data;
			node.left = null;
			node.right = null;
			root = node;
		}
		else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node temp = queue.peek();
				queue.poll();
				if(temp.left == null) {
					node = new Node();
					node.data = data;
					node.left = null;
					node.right = null;
					temp.left = node;
					break;
				}
				else if(temp.right == null) {
					node = new Node();
					node.data = data;
					node.left = null;
					node.right = null;
					temp.right = node;
					break;
				}
				else {
					if(queue.isEmpty()) {
						queue.add(temp.left);
						queue.add(temp.right);
					}
				}
			}
		}
	}
	public void preOrder(Node itr) {
		if(itr == null)
			return;
		System.out.print(itr.data+" ");
		preOrder(itr.left);
		preOrder(itr.right);
	}
	public void inOrder(Node itr) {
		if(itr == null)
			return;
		inOrder(itr.left);
		System.out.print(itr.data+" ");
		inOrder(itr.right);
	}
	public void postOrder(Node itr) {
		if(itr == null)
			return;
		postOrder(itr.left);
		postOrder(itr.right);
		System.out.print(itr.data+" ");
	}
	public int height(Node itr) {
		if( itr == null)
			return 0;
		else {
			int lh = height(itr.left);
			int rh = height(itr.right);
			if(lh>rh)
				return lh+1;
			else
			return rh+1;
		}
	}
	public int levelHeight(Node itr) {
		if(itr == null)
			return 0;
		else {
			int lh = levelHeight(itr.left);
			int rh = levelHeight(itr.right);
			if(lh>rh)
				return lh+1;
			else
				return rh+1;
		}
	}
	public void printGivenLevel(Node itr,int i) {
		if(itr == null)
			return;
		if(i == 1)
			System.out.print(itr.data+" ");
		else if(i>1) {
			printGivenLevel(itr.left,i-1);
			printGivenLevel(itr.right,i-1);
		}
	}
	public void levelOrder(Node itr) {
		if(itr == null)
			return;
		int h = levelHeight(itr);
		for(int i = 1;i<=h;i++)
			printGivenLevel(itr,i);
	}
	public int max(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}
	public int diameter(Node itr) {
		if(itr == null)
			return 0;
		int lh = height(itr.left);
		int rh = height(itr.right);
		int ld = diameter(itr.left);
		int rd = diameter(itr.right);
		return max((lh+rh+1), (max(ld,rd)));
	}
	public void disp() {
		Node itr = root;
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.preOrder(itr);
		System.out.println();
		binaryTree.inOrder(itr);
		System.out.println();
		binaryTree.postOrder(itr);
		System.out.println();
		levelOrder(itr);
		System.out.println();
		System.out.println("Diameter of Tree "+diameter(itr));
		System.out.println("Height Of Tree "+binaryTree.height(itr));
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BinaryTree binaryTree = new BinaryTree();
		for(int i = 0; i<n; i++) {
			int data = sc.nextInt();
			binaryTree.insert(data);
		}
		binaryTree.disp();
		sc.close();
	}
}
