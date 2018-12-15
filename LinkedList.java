import java.util.*;
class Node{
    int data;
    Node next;
}
public class LinkedList{
    Node head=null;
    Node prev=null;
    Node prev1 = null;
    public void insert(int data){
        Node node =  new Node();
        if(head==null){
            node.data = data;
            node.next = null;
            head = node;
            prev = head;
        }
    }
    public void insertAtEnd(int data){
        Node endNode =  new Node();
        endNode.data = data;
        prev.next = endNode;
        endNode.next = null;
        prev = endNode;
    }
    public void insertAtBegining(int data){
        Node start =  new Node();
        start.data = data;
        start.next = head;
        head = start;
    }
    public void deletePosition(int pos){
        Node position = null;
        Node prev = null;
        Node temp = head;
        int c = 0;
        if(pos<1)
        return;
        while(temp!=null){
            c++;
            if(c==pos){
                position = temp;
                break;
            }
            else{
                prev = temp;
            }
            temp = temp.next;
        }
        if(pos>c)
            return;
        else if(pos == 1){
            head = position.next;
        }
        else{
           prev.next = position.next;
        }
    }
    public void insertAtPosition(int data, int pos){
        Node position = null;
        Node newNode = new Node();
        Node temp = head;
        int c = 0;
        if(pos<1)
        return;
        while(temp!=null){
            c++;
            if(c==pos){
                position = temp;
                break;
            }
            else{
                prev1 = temp;
            }
            temp = temp.next;
        }
        if(pos>c+1)
        return;
        else if(pos == 1){
            newNode.data = data;
            newNode.next = head;
            head = newNode;
        }
        else{
            newNode.data = data;
            newNode.next = position;
            prev1.next = newNode;
        }
    }
    public void disp(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        System.out.println("Enter Data for first Node");
        int data = sc.nextInt();
        linkedList.insert(data);
        while(true){
			System.out.println("1 InsertAtBegining\t2 InsertAtEnd\t3 InsertAtPosition\t4 deleteAtPosition\t5 display\t6 Exit");
			int ch = sc.nextInt();
			switch(ch){
				case 1:
					int newdata = sc.nextInt(); 
					linkedList.insertAtBegining(newdata);
					break;
				case 2:
					int newdata1 = sc.nextInt(); 
					linkedList.insertAtEnd(newdata1);
					break;
				case 3:
					int newdata2 = sc.nextInt();
					int posi = sc.nextInt(); 
					linkedList.insertAtPosition(newdata2,posi);
					break;
				case 4:
					int pos = sc.nextInt(); 
					linkedList.deletePosition(pos);
					break;
				case 5:
					linkedList.disp();
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong choice");
					break;
			}
		}
       /* int data = sc.nextInt();
        linkedList.insert(data);
        linkedList.insertAtEnd(3);
        linkedList.insertAtBegining(5);
        linkedList.insertAtEnd(6);
        linkedList.insertAtBegining(10);
        linkedList.insertAtPosition(0,5);
        linkedList.insertAtPosition(21,4);
        linkedList.deletePosition(1);
        linkedList.disp();
        linkedList.deletePosition(6);
        linkedList.disp();*/
    }
}
