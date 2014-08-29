package trees;

public class AVLTree {
	private AVLNode root;
	private int size;
	
	//PRIVATE CLASS
	private static class AVLNode {
		int data;
		int height;
		AVLNode left;
		AVLNode right;
		
		public AVLNode(int x) {
			this.data = x;
			this.height = 1;
			this.left = null;
			this.right = null;
		}
		
	}
	
	//PRIVATE CLASS ENDS
	public AVLTree(){
		root=null;
		size=0;
	}
	
	//==================================================================
	//          MISC
	//==================================================================
	public int getSize(){//PASS
		return size;
	}
	
	public AVLNode getRoot(){//PASS
		return root;
	}
	
	public int visit(AVLNode node){//PASS
		return node.data;
	}
	
	public boolean isRootNull(){//PASS
		return root == null ? false : true;
	}
	
	public AVLNode findMax (AVLNode node) {//PASS
		if (node.right == null) return node;
		else {
			while (node.right != null) node=node.right;
			return node;
		}
	}
	
	public AVLNode findMin (AVLNode node) {//PASS
		if (node.left == null)	return node;
		else {
			while (node.left != null){
				node=node.left;
			}
			return node;
		}
	}
	
	public static int getHeight (AVLNode node) {
		if(node == null) {
			return 0;
		}
		else return node.height;
	}
	
	/*
	public int getHeight (AVLNode node) {//PASS
		if (root == null || node == null) return 0;
		else return getHeight(node.left) > getHeight(node.right) ? 
				getHeight(node.left)+1 : getHeight(node.right)+1;
	}
	*/
	
	public int heightDiff (AVLNode node) {//NOT PASS. NEED TO REWRITE THE CODE
		if (node == null) return 0;
		else return getHeight(node.left) - getHeight(node.right);
	}
	
	//==================================================================
	//          ROTATE
	//==================================================================
	
	public AVLNode rotateR (AVLNode node) {
		if (node.left == null) {
			return node;
		}
		else {
			AVLNode temp = node.left;
			node.left = temp.right;
			temp.right = node;
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
			return temp;
		}
	}
	
	public AVLNode rotateL (AVLNode node) {
		if (node.right == null) {
			return node;
		}
		else {
			AVLNode temp = node.right;
			node.right = temp.left;
			temp.left = node;
			//do not change the order of the following two lines.
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
			return temp;
		}
	}
	
	//==================================================================
	//          INSERT
	//==================================================================
	
	public void insert2(int x) {//PASS
		root = insert(root, x);
	}
	
	public AVLNode insert(AVLNode node, int x){//PASS
		//size++;
		if(root == null) {
			System.out.println("the root is null");
			AVLNode temp=new AVLNode(x);
			root=temp;
			return root;
		}
		else if(node == null) {
			node = new AVLNode(x);
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			return node;
		}
		else if (x < node.data) {//insert left
			if (node.left == null) {
				node.left=new AVLNode(x);
				node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
				return node;
			}
			else node.left = insert(node.left, x);
			//balance
			if( (getHeight(node.left) - getHeight(node.right)) == 2) {
				System.out.println("LEFT CHILD TOO HIGH");
				if(getHeight(node.left.left) < getHeight(node.left.right)) {
					node.left = rotateR(node.left);
				}
				node = rotateR(node);
			}
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			return node;
		}
		else{
			if (node.right == null) {
				node.right = new AVLNode(x);
				node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
				return node;
			}
			else node.right = insert(node.right, x);
			if( (getHeight(node.right) - getHeight(node.left)) == 2) {
				System.out.println("RIGHT CHILD TOO HIGH");
				System.out.println(node.data);
				if(getHeight(node.right.right) < getHeight(node.right.left)) {
					node.right = rotateL(node.right);
				}
				node = rotateL(node);
			}
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			return node;
		}
	}
	
	//==================================================================
	//         PRINT TREE STRUCTURE
	//==================================================================
	
	public void printTreeStruct(int maxheight) {//PASS
		for (int i=0; i<maxheight; ++i) {
			System.out.println(printCertainLevel(root, i, 1, maxheight) );
		}
	}
	
	public String returnSpace (int n) {//PASS
		String str = "";
		for (int i=0; i<n; ++i) str += " ";
		return str;
	}
	
	public String printCertainLevel(AVLNode node, int depth, int height, int maxheight) {//PASS
		int numofspace = (int)java.lang.Math.pow(2, (maxheight+1-height))-1;
		String spaces = returnSpace(numofspace);
		if (node == null) {
			return spaces + "_" + spaces;
		}
		else if(depth == 0) {
			return spaces + node.data + spaces;
		}
		else if (depth > 0){
			String leftStr = printCertainLevel(node.left, depth-1, height+1, maxheight);
			String rightStr = printCertainLevel(node.right, depth-1, height+1, maxheight);
			return leftStr+" "+rightStr;
		}
		else return "";
	}
	
//==================================================================
//  					TEST SCRIPT
//==================================================================

	public void testAVLTree() {
		AVLTree a = new AVLTree();
		
		a.insert2(13);
		a.printTreeStruct(6);
		a.insert2(12);
		a.printTreeStruct(6);
		a.insert2(14);
		a.printTreeStruct(6);
		a.insert2(15);
		a.printTreeStruct(6);
		a.insert2(16);
		a.printTreeStruct(6);
		a.insert2(17);
		a.printTreeStruct(6);
		a.insert2(18);
		a.printTreeStruct(6);
		a.insert2(20);
		a.printTreeStruct(6);
		a.insert2(43);
		a.printTreeStruct(6);
		a.insert2(44);
		a.printTreeStruct(6);
		a.insert2(56);
		a.printTreeStruct(6);
		a.insert2(67);
		a.printTreeStruct(6);
		a.insert2(68);
		a.printTreeStruct(6);
		a.insert2(69);
		a.printTreeStruct(6);
		a.insert2(78);
		a.printTreeStruct(6);
		a.insert2(90);
		a.printTreeStruct(6);

	}
}
