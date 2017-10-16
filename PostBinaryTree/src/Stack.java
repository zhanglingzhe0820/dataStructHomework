
public class Stack<T> {
	private ListNode<T> topOfStack;
	
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
	
	public void push(T t){
		topOfStack=new ListNode<T>(t,topOfStack);
	}
	
	public T top(){
		return topOfStack.t;
	}
	
	public void pop(){
		topOfStack=topOfStack.next;
	}
	
	public T topAndPop(){
		T result=topOfStack.t;
		topOfStack=topOfStack.next;
		return result;
	}
}
