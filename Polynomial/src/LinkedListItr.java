
public class LinkedListItr {
	
	ListNode current;
	
	public LinkedListItr(ListNode listNode){
		current=listNode;
	}
	
	public boolean isPastEnd(){
		return current==null;
	}
	
	public String retrieve(){
		return isPastEnd()?null:(current.coef+"x^"+current.exp);
	}
	
	public void advance(){
		if(!isPastEnd()){
			current=current.next;
		}
	}

}
