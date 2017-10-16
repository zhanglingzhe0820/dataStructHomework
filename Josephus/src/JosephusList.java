
public class JosephusList {

	public static void main(String[] args) {
		
		System.out.println(josephus(8,3));
		
	}
	
	public static int josephus(int m,int n){
		ListNode rear=new ListNode(m,null);
		ListNode head=new ListNode(1,initList(2,m-1,rear));
		rear.next=head;
		ListNode p=head;
		int value=0;
		while(m>1){
			value++;
			if(value+1==n){
				p.next=p.next.next;
				m--;
				value=0;
			}
			p=p.next;
		}
		return p.n;
	}
	
	public static ListNode initList(int init,int last,ListNode rear){
		if(init==last){
			return new ListNode(last,rear);
		}
		else{
			return new ListNode(init,initList(init+1,last,rear));
		}
	}

}
