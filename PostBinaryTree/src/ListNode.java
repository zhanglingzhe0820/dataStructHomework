
public class ListNode<T> {
	
	T t;
	ListNode<T> next;
	
	public ListNode(T t,ListNode<T> next){
		this.t=t;
		this.next=next;
	}
	
	public ListNode(){
		this(null,null);
	}
	
}
