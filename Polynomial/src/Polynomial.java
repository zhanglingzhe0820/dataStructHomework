public class Polynomial {

	public static void main(String[] args) {
		
		LinkedList listA=new LinkedList("3x^9+3x^6+2x^6+1x^3");
		LinkedList listB=new LinkedList("4x^9+3x^8+12x^6+1x^3");
		polynomial(listA,listB).printList();
	}
	
	public static LinkedList polynomial(LinkedList listA,LinkedList listB){
		
		LinkedListItr AItr=listA.first();
		LinkedListItr BItr=listB.first();
		double Acoef;
		int Aexp;
		double Bcoef;
		int Bexp;
		LinkedList list=new LinkedList();
		LinkedListItr point=list.zeroth();
		
		while(!AItr.isPastEnd()&&!BItr.isPastEnd()){
			Acoef=Double.parseDouble(AItr.retrieve().split("x\\^")[0]);
			Aexp=Integer.parseInt(AItr.retrieve().split("x\\^")[1]);
			Bcoef=Double.parseDouble(BItr.retrieve().split("x\\^")[0]);
			Bexp=Integer.parseInt(BItr.retrieve().split("x\\^")[1]);
			
			if(Aexp==Bexp){
				ListNode listNode=new ListNode(Acoef+Bcoef,Aexp);
				list.insert(listNode, point);
				AItr.advance();
				BItr.advance();
				point.advance();
			}
			else if(Aexp>Bexp){
				ListNode listNode=new ListNode(Acoef,Aexp);
				list.insert(listNode, point);
				AItr.advance();
				point.advance();
			}
			else{
				ListNode listNode=new ListNode(Bcoef,Bexp);
				list.insert(listNode, point);
				BItr.advance();
				point.advance();
			}
		}
		
		if(!AItr.isPastEnd()){
			while(!AItr.isPastEnd()){
				Acoef=Integer.parseInt(AItr.retrieve().split("x\\^")[0]);
				Aexp=Integer.parseInt(AItr.retrieve().split("x\\^")[1]);
				ListNode listNode=new ListNode(Acoef,Aexp);
				list.insert(listNode, point);
				AItr.advance();
				point.advance();
			}
		}
		
		if(!BItr.isPastEnd()){
			while(!AItr.isPastEnd()){
				Bcoef=Integer.parseInt(BItr.retrieve().split("x^")[0]);
				Bexp=Integer.parseInt(BItr.retrieve().split("x^")[1]);
				ListNode listNode=new ListNode(Bcoef,Bexp);
				list.insert(listNode, point);
				BItr.advance();
				point.advance();
			}
		}
		
		return list;
		
	}

}
