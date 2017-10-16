
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
}
