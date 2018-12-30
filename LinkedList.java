import java.util.Scanner;
class LinkedListNode{
	int data;
	LinkedListNode next;
}
public class LinkedList{
	LinkedListNode root;
	LinkedListNode prev;
	public void insert(int data) {
		LinkedListNode node  = new LinkedListNode();
		node.data = data;
		node.next = null;
		if(root == null) {
			root  = node;
			prev = node;
		}
		else {
			prev.next = node;
			prev = node;
		}
	}
	public void swapNode(int x, int y) {
		if (x == y) return; 
        LinkedListNode a = null, temp1 = root; 
        while (temp1 != null && temp1.data != x) 
        { 
            a = temp1; 
            temp1 = temp1.next; 
        }
        LinkedListNode b = null, temp2 = root; 
        while (temp2 != null && temp2.data != y) 
        { 
            b = temp2;
            temp2 = temp2.next; 
        } 
        if (temp1 == null || temp2 == null) 
            return; 
        if (temp1 != null) 
            a.next = temp2; 
        else 
            root = temp2; 
        if (temp2 != null) 
            b.next = temp1; 
        else 
            root = temp1; 
        LinkedListNode temp = temp1.next; 
        temp1.next = temp2.next; 
        temp2.next = temp; 
	}
	public void disp() {
		LinkedListNode cur = root;
		while(cur!=null) {
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		LinkedList linkedList  = new LinkedList();
		for(int i =0;i<n;i++) {
			int data  = sc.nextInt();
			linkedList.insert(data);
		}
		linkedList.disp();
		linkedList.swapNode(2,4);
		linkedList.disp();
		sc.close();
	}
}
