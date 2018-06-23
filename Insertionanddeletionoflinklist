import java.util.*;
class Node
{
	int data;
	Node next;
}
class linklist
{
	Node root=null;
	public void insert(int data)
	{
		Node ptr=new Node();
		ptr.data=data;
		if(root==null)
		ptr.next=null;
		else
		ptr.next=root;
		root=ptr;
	}
	public void disp()
	{
	    Node temp=root;
	    while(temp!=null)
	    {
	        System.out.println(temp.data);
	        temp=temp.next;
	    }
	}
	public void del(int n)
	{
	    Node temp=root;
	    Node next=null,pre=null;
	    if(root==null)
	    return;
	    if(temp.next==null && temp.data==n)
	    root=null;
	    if(temp.next!=null && temp.data==n)
	    root=temp.next;
	    while(temp!=null)
	    {
	        
	        
	        if(temp.data==n)
	        {
	            next=temp.next;
	            break;
	        }
	        else
	        pre=temp;
	        temp=temp.next;
	    }
	    pre.next=next;
	}
	public static void main(String[] args)
	{
		int data;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		linklist obj=new linklist();
		for(int i=0;i<n;i++)
		{
			data=sc.nextInt();
			obj.insert(data);
		}
		obj.disp();
		obj.del(1);
		obj.disp();
	}
}
