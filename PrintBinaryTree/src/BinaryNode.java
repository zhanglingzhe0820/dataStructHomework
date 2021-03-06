
public class BinaryNode<T> {
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	public T data;
	
	public BinaryNode(){
		left=null;
		right=null;
		data=null;
	}
	
	public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
	
	public BinaryNode(T data){
		this.data=data;
	}
	
	public void inOrder(){
		if(left!=null){
			printInOrder(left);
		}
		if(!data.equals("NULL")){
			System.out.print(data);
			System.out.print(" ");
		}
		if(right!=null){
			printInOrder(right);
		}
	}
	
	public void postOrder(){
		if(left!=null){
			printPostOrder(left);
		}
		if(right!=null){
			printPostOrder(right);
		}
		if(!data.equals("NULL")){
			System.out.print(data);
			System.out.print(" ");
		}
	}
	
	public void preOrder(){
		if(!data.equals("NULL")){
			System.out.print(data);
			System.out.print(" ");
		}
		if(left!=null){
			printPreOrder(left);
		}
		if(right!=null){
			printPreOrder(right);
		}
	}
	
	public void printInOrder(BinaryNode<T> node){
		if(node.left!=null){
			printInOrder(node.left);
		}
		if(!node.data.equals("NULL")){
			System.out.print(node.data);
			System.out.print(" ");
		}
		if(node.right!=null){
			printInOrder(node.right);
		}
	}
	
	public void printPostOrder(BinaryNode<T> node){
		if(node.left!=null){
			printPostOrder(node.left);
		}
		if(node.right!=null){
			printPostOrder(node.right);
		}
		if(!node.data.equals("NULL")){
			System.out.print(node.data);
			System.out.print(" ");
		}
	}
	
	public void printPreOrder(BinaryNode<T> node){
		if(!node.data.equals("NULL")){
			System.out.print(node.data);
			System.out.print(" ");
		}
		if(node.left!=null){
			printPreOrder(node.left);
		}
		if(node.right!=null){
			printPreOrder(node.right);
		}
	}
}
