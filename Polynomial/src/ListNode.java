
public class ListNode {

	public double coef;
	public int exp;
	public ListNode next;
	
	public ListNode(){
		coef=0;
		exp=0;
		next=null;
	}
	
	public ListNode(double coef,int exp){
		this.coef=coef;
		this.exp=exp;
		this.next=null;
	}
}
