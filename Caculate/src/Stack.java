
public class Stack {
	
	private ListNode topOfStack;
	
	public Stack(){
		topOfStack=null;
	}
	
	public boolean isFull(){
		return false;
	}
	
	public boolean isEmpty(){
		return topOfStack==null;
	}
	
	public void makeEmpty(){
		topOfStack=null;
	}
	
	public void push(String str){
		topOfStack=new ListNode(str,topOfStack);
	}
	
	public String top(){
		return topOfStack.str;
	}
	
	public void pop(){
		topOfStack=topOfStack.next;
	}
	
	public String topAndPop(){
		String result=topOfStack.str;
		topOfStack=topOfStack.next;
		return result;
	}
}
