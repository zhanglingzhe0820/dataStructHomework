
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
	
	public void inOrder(){
		if(root.left!=null){
			printInOrder(root.left);
		}
		System.out.print(root.data);
		if(root.right!=null){
			printInOrder(root.right);
		}
	}
	
	public void postOrder(){
		if(root.left!=null){
			printPostOrder(root.left);
		}
		if(root.right!=null){
			printPostOrder(root.right);
		}
		System.out.print(root.data);
	}
	
	public void preOrder(){
		System.out.print(root.data);
		if(root.left!=null){
			printPreOrder(root.left);
		}
		if(root.right!=null){
			printPreOrder(root.right);
		}
	}
	
	public void printInOrder(BinaryNode<T> node){
		if(node.left!=null){
			printInOrder(node.left);
		}
		System.out.print(node.data);
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
		System.out.print(node.data);
	}
	
	public void printPreOrder(BinaryNode<T> node){
		System.out.print(node.data);
		if(node.left!=null){
			printPreOrder(node.left);
		}
		if(node.right!=null){
			printPreOrder(node.right);
		}
	}

}
