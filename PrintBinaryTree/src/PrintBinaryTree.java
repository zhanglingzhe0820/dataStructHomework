import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTree {

	public static void main(String[] args) {
		new PrintBinaryTree().run();
	}
	
	public static BinaryNode<String> makeTreeByPreOrder(String input){
		input=input.charAt(input.length()-1)==' ' ? input.substring(0,input.length()-1):input;
		
		//�ݹ鷵������
		if(!input.contains(" ")){
			return new BinaryNode<String>(input);
		}
		
		String[] elements=input.split(" ");
		BinaryNode<String> result=new BinaryNode<String>(elements[0]);
		StringBuilder leftPart=new StringBuilder();
		StringBuilder rightPart=new StringBuilder();
		int length=elements.length;
		int middle=length/2;
		for(int i=1;i<middle+1;i++){
			leftPart.append(elements[i]+" ");
		}
		for(int i=middle+1;i<length;i++){
			rightPart.append(elements[i]+" ");
		}
		result.left=makeTreeByPreOrder(new String(leftPart));
		result.right=makeTreeByPreOrder(new String(rightPart));
		return result;
	}
	
	public static BinaryNode<String> makeTree(String input){
		String[] elements=input.split(" |\n");
		Queue<BinaryNode<String>> q=new LinkedList<BinaryNode<String>>();
		BinaryNode<String> result=new BinaryNode<String>(elements[0]);
		q.add(result);
		BinaryNode<String> head,node1,node2;
		for(int i=1;i<elements.length;i+=2){
			if(i+1==elements.length){
				node1=new BinaryNode<String>(elements[i]);
				q.add(node1);
				head=q.poll();
				
				if(!(head.data.equals("NULL")&&!node1.data.equals("NULL"))){
					head.left=node1;
				}
				else{
					i-=1;
				}
			}
			else{
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
		}
		return result;
	}

	public void run(){
		BinaryNode<String> header=makeTreeByPreOrder("aa bb dd NULL cc ee ff");
		header.preOrder();
		System.out.println();
		header.inOrder();
		System.out.println();
		header.postOrder();
	}
}
