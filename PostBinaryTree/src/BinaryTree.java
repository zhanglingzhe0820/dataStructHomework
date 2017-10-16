
public class BinaryTree<T> {
	
	BinaryNode<T> root;
	BinaryNode<T> current;
	
	public BinaryTree(){
		root=null;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public void MakeTree(T data,BinaryTree<T> left,BinaryTree<T> right){
		root=new BinaryNode<T>(data,left.root,right.root);
		left.root=null;
		right.root=null;
	}

}
