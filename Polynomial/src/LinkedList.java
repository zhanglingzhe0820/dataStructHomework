
public class LinkedList {
	
	private ListNode header;
	
	public LinkedList(){
		header=new ListNode();
	}
	
	public LinkedList(String polynomial){
		header=new ListNode();
		String[] terms=polynomial.split("\\+");
		ListNode p=header;
		for(String term:terms){
			ListNode listNode=new ListNode(Double.parseDouble(term.split("x\\^")[0]),Integer.parseInt(term.split("x\\^")[1]));
			p.next=listNode;
			p=p.next;
		}
	}
	
	public LinkedListItr zeroth(){
		return new LinkedListItr(header);
	}
	
	public LinkedListItr first(){
		return new LinkedListItr(header.next);
	}
	
	public void printList(){
		LinkedListItr itr=new LinkedListItr(header);
		String result="";
		for(itr.advance();!itr.isPastEnd();itr.advance()){
			result+=itr.retrieve()+"+";
		}
		System.out.println(result.substring(0, result.length()-1));
	}
	
	public void insert(ListNode listNode,LinkedListItr itr){
		itr.current.next=listNode;
	}

}
