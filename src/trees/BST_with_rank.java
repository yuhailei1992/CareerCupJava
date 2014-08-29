package trees;

public class BST_with_rank extends BST {
	
	int size;
	BSTNode_with_rank root;
	
	//nested class BSTNode_with_rank with rank
	class BSTNode_with_rank{//nested class
		int data;
		int rank;
		BSTNode_with_rank left;
		BSTNode_with_rank right;
		
		public BSTNode_with_rank() {
			this.left = null;
			this.right = null;
			this.rank = 0;
		}
		
		public BSTNode_with_rank(int x) {
			this.data = x;
			this.rank = 0;
			this.left = null;
			this.right = null;
		}
	}
	//nested class ends here
	
	public BST_with_rank(){
		this.root = null;
		this.size = 0;
	}
	
	public void insert (BSTNode_with_rank node, int x){//OVERLOAD
		if(root == null) {
			System.out.println("the root is null");
			BSTNode_with_rank temp = new BSTNode_with_rank(x);
			root=temp;
			size++;
		}
		else if(node == null) {
			System.out.println("the node is null");
			BSTNode_with_rank temp = new BSTNode_with_rank(x);
			node = temp;
			size++;
		}
		else if (x < node.data) {
			node.rank++;
			if (node.left == null) {
				node.left=new BSTNode_with_rank(x);
				size++;
			}
			else insert(node.left, x);
		}
		else{
			if (node.right == null) {
				node.right = new BSTNode_with_rank(x);
				size++;
			}
			else insert(node.right, x);
		}
	}
	
	
	public int getRank (BSTNode_with_rank node, int x){//PASS
		
		if (node == null) return 0;//
		
		else if (node.data == x) {
			System.out.println ("reached the bottom");
			return node.rank + 1;//hit
		}
		else {
			if (x < node.data) return getRank (node.left, x);
			else {
				return node.rank + getRank (node.right, x) + 1;
			}
		}
	}
	
	//==================================================================
	//         PRINT TREE STRUCTURE
	//==================================================================
	
	public void printTreeStruct_rank(int maxheight) {//PASS
		for (int i=0; i<maxheight; ++i) {
			System.out.println( printCertainLevel(root, i, 1, maxheight) );
		}
	}
	
	public String printCertainLevel (BSTNode_with_rank node, int depth, int height, int maxheight) {//PASS
		int numofspace = (int)java.lang.Math.pow(2, (maxheight+1-height))-1;
		String spaces = returnSpace(numofspace);
		if (node == null) {
			return spaces + "_" + spaces;
		}
		else if (depth == 0) {
			return spaces + node.data + "(" + node.rank + ")" + spaces;
		}
		else if (depth > 0){
			String leftStr = printCertainLevel(node.left, depth-1, height+1, maxheight);//the depth decres
			String rightStr = printCertainLevel(node.right, depth-1, height+1, maxheight);
			return leftStr+" "+rightStr;
		}
		else return "";
	}
	
	//==================================================================
	//         TEST SCRIPT
	//==================================================================
	
	public void test_BST_with_rank () {
		BST_with_rank a = new BST_with_rank();
		a.insert(a.root, 20);
		a.insert(a.root, 15);
		a.insert(a.root, 10);
		a.insert(a.root, 5);
		a.insert(a.root, 13);
		a.insert(a.root, 25);
		a.insert(a.root, 23);
		a.insert(a.root, 24);
		
		//testing using iterator
		int arr[] = {20, 15, 10, 5, 13, 25, 23, 24};
		for (int i = 0; i < 8; ++i) {
			System.out.println (a.getRank(a.root, arr[i]));
		}
		a.printTreeStruct_rank(4);
	}
}




