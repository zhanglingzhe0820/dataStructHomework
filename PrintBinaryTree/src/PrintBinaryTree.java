
public class PrintBinaryTree {

	public static void main(String[] args) {
		new PrintBinaryTree().run();
	}

	public void run(){
		BinaryTree<String> binaryTreeA=new BinaryTree<String>();
		BinaryTree<String> binaryTreeB=new BinaryTree<String>();
		BinaryTree<String> binaryTreeC=new BinaryTree<String>();
		BinaryTree<String> binaryTreeD=new BinaryTree<String>();
		BinaryTree<String> binaryTreeE=new BinaryTree<String>();
		BinaryTree<String> binaryTreeF=new BinaryTree<String>();
		BinaryTree<String> binaryTreeG=new BinaryTree<String>();
		BinaryTree<String> binaryTreeH=new BinaryTree<String>();
		BinaryTree<String> binaryTreeI=new BinaryTree<String>();
		BinaryTree<String> binaryTreeEmpty=new BinaryTree<String>();
		
		binaryTreeD.MakeTree("D", binaryTreeEmpty, binaryTreeEmpty);
		binaryTreeG.MakeTree("G", binaryTreeEmpty, binaryTreeEmpty);
		binaryTreeH.MakeTree("H", binaryTreeEmpty, binaryTreeEmpty);
		binaryTreeI.MakeTree("I", binaryTreeEmpty, binaryTreeEmpty);
		
		binaryTreeB.MakeTree("B", binaryTreeD, binaryTreeEmpty);
		binaryTreeE.MakeTree("E", binaryTreeEmpty, binaryTreeG);
		binaryTreeF.MakeTree("F", binaryTreeH, binaryTreeI);
		binaryTreeC.MakeTree("C", binaryTreeE, binaryTreeF);
		binaryTreeA.MakeTree("A", binaryTreeB, binaryTreeC);
		
		binaryTreeA.preOrder();
		System.out.println();
		binaryTreeA.inOrder();
		System.out.println();
		binaryTreeA.postOrder();
	}
}
