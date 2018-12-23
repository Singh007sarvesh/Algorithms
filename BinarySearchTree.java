import java.util.*;
class NodeTree{
	int data;
	NodeTree left;
	NodeTree right;
	public NodeTree(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
public class BinarySearchTree {
	NodeTree root;
	public BinarySearchTree() {
		root = null;
	}
	public NodeTree insertRec(NodeTree root, int data) {
		if (root == null) {
			root = new NodeTree(data);
			return root;
		}
		if(data<root.data) {
			root.left = insertRec(root.left,data);
		}
		else if(data>root.data)
			root.right = insertRec(root.right,data);
		return root;
	}
	public void inOrder(NodeTree root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	public void insert(int data) {
		root = insertRec(root,data);
	}
	public boolean isBST() {
		return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public boolean checkBST(NodeTree root, int min, int max) {
		if(root == null)
			return true;
		if(root.data<min || root.data>max)
			return false;
		return (checkBST(root.left,min,root.data-1) && checkBST(root.right, root.data+1,max));
	}
	public void order() {
		inOrder(root);
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BinarySearchTree binaruSearchTree = new BinarySearchTree();
		for(int i = 0;i<n;i++) {
			int data = sc.nextInt();
			binaruSearchTree.insert(data);
		}
		binaruSearchTree.order();
		if(binaruSearchTree.isBST())
			System.out.println("BST");
		else
			System.out.println("NOT BST");
		sc.close();
	}
}
