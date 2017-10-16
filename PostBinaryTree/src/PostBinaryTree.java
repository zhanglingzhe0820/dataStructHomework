import java.util.ArrayList;

public class PostBinaryTree {
	
	private final static String ONERESOPER="-";
	private final static String TWORESOPER="+*//";

	public static void main(String[] args) {
		makeTree("da-b+c*+");
	}

	public static void makeTree(String postOrder){
		Stack<BinaryTree<String>> stack=new Stack<BinaryTree<String>>();
		postOrder=postOrder.toLowerCase();
		
		for(int i=0;i<postOrder.length();i++){
			arrangeStack(stack,postOrder.substring(i, i+1));
		}
		
		printBinaryTree(stack.topAndPop().root);
	}
	
	public static void arrangeStack(Stack<BinaryTree<String>> stack,String input){
		if(!input.equals(ONERESOPER)&&!(TWORESOPER.contains(input))){
			BinaryTree<String> binaryTree=new BinaryTree<String>();
			BinaryTree<String> binaryTreeEmpty1=new BinaryTree<String>();
			BinaryTree<String> binaryTreeEmpty2=new BinaryTree<String>();
			binaryTree.MakeTree(input, binaryTreeEmpty1, binaryTreeEmpty2);
			stack.push(binaryTree);
		}
		else{
			if(input.equals(ONERESOPER)){
				stack.top().root.data="-"+stack.top().root.data;
			}else{
				BinaryTree<String> result=new BinaryTree<String>();
				BinaryTree<String> binaryTreeOperand2=stack.topAndPop();
				BinaryTree<String> binaryTreeOperand1=stack.topAndPop();
				result.MakeTree(input, binaryTreeOperand1, binaryTreeOperand2);
				stack.push(result);
			}
		}
	}
	
	public static void printBinaryTree(BinaryNode<String> root){
		if(root.left!=null){
			printBinaryTree(root.left);
		}
		System.out.print(root.data);
		if(root.right!=null){
			printBinaryTree(root.right);
		}
	}
}
