package Util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHelper {
	
	public static BinaryNode<String> makeTree(String input){
		String[] elements=input.split(" ");
		Queue<BinaryNode<String>> q=new LinkedList<BinaryNode<String>>();
		BinaryNode<String> result=new BinaryNode<String>(elements[0]);
		q.add(result);
		BinaryNode<String> head,node1,node2;
		for(int i=1;i<elements.length;i+=2){
			node1=new BinaryNode<String>(elements[i]);
			node2=new BinaryNode<String>(elements[i+1]);
			q.add(node1);
			q.add(node2);
			head=q.poll();
			
			if(!(head.data.equals("NULL")&&!node1.data.equals("NULL"))){
				head.left=node1;
				head.right=node2;
			}
			else{
				i-=2;
			}
		}
		return result;
	}
}