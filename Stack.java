import java.util.*;
class Stack{
	private static final int MAX = 1000; 
    private static int top; 
    private static int stack[] = new int[MAX]; // Maximum size of Stack 
	public void getStack(){
		while(top>0){
			System.out.print(stack[top]+" ");
			top = top-1;
		}
		System.out.println();
	}
	public void setStack(int data){
		if(top>MAX)
			return;
		top = top +1;
		stack[top] = data;
	}
	public static boolean isEmpty(){
		if(top<1){
			return false;
		}
		return true;
	}
	public void peek(){
		if(isEmpty()){
			System.out.println(stack[top]);
		}	
	}
	public void pop(){
		if(top>0){
			System.out.println(stack[top]);
			top = top-1;
		}
		else
		return;
		
		
	}
	public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			Stack obj = new Stack();
			obj.peek();
			obj.setStack(2);
			obj.setStack(3);
			obj.setStack(4);
			obj.peek();
			obj.setStack(5);
			obj.peek();
			obj.pop();
			obj.peek();
			
			obj.getStack();
	}
}
