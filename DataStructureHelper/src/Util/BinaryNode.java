package Util;

public class BinaryNode<T> {
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	public T data;
	
	private String result;//��������
	
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
	
	public String inOrder(){
		result="";
		if(left!=null){
			printInOrder(left);
		}
		if(!data.equals("NULL")){
			result+=data+" ";
		}
		if(right!=null){
			printInOrder(right);
		}
		return result;
	}
	
	public String postOrder(){
		result="";
		if(left!=null){
			printPostOrder(left);
		}
		if(right!=null){
			printPostOrder(right);
		}
		if(!data.equals("NULL")){
			result+=data+" ";
		}
		return result;
	}
	
	public String preOrder(){
		result="";
		if(!data.equals("NULL")){
			result+=data+" ";
		}
		if(left!=null){
			printPreOrder(left);
		}
		if(right!=null){
			printPreOrder(right);
		}
		return result;
	}
	
	public void printInOrder(BinaryNode<T> node){
		if(node.left!=null){
			printInOrder(node.left);
		}
		if(!node.data.equals("NULL")){
			result+=node.data+" ";
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
			result+=node.data+" ";
		}
	}
	
	public void printPreOrder(BinaryNode<T> node){
		if(!node.data.equals("NULL")){
			result+=node.data+" ";
		}
		if(node.left!=null){
			printPreOrder(node.left);
		}
		if(node.right!=null){
			printPreOrder(node.right);
		}
	}
}
