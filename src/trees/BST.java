package trees;

public class BST {
	BSTNode root;//use protected for inheritance
	int size;

	//nested class BSTNode
	
//	public class BSTNode {
//		protected int data;
//		protected BSTNode left;
//		protected BSTNode right;
//		public BSTNode() {
//			this.left=null;
//			this.right=null;
//		}
//		
//		public BSTNode(int x) {
//			this.data=x;
//			this.left=null;
//			this.right=null;
//		}
//	}
//	
	public BST(){
		root=null;
		size=0;
	}
	
	//==================================================================
	//          MISC
	//==================================================================
	public int getSize(){//PASS
		return size;
	}
	
	public BSTNode getRoot(){//PASS
		return root;
	}
	
	public int visit(BSTNode node){//PASS
		return node.data;
	}
	
	public boolean isRootNull(){//PASS
		return root == null ? false : true;
	}
	
	public BSTNode findMax (BSTNode node) {//PASS
		if (node.right == null) return node;
		else {
			while (node.right != null) node=node.right;
			return node;
		}
	}
	
	public BSTNode findMin (BSTNode node) {//PASS
		if (node.left == null)	return node;
		else {
			while (node.left != null){
				node=node.left;
			}
			return node;
		}
	}
	
	public int getHeight (BSTNode node) {//PASS
		if (root == null || node == null) return 0;
		else return getHeight(node.left) > getHeight(node.right) ? 
				getHeight(node.left)+1 : getHeight(node.right)+1;
	}
	
	//==================================================================
	//          INSERT
	//==================================================================
	
	public void insert(BSTNode node, int x){//PASS
		if(root == null) {
			System.out.println("the root is null");
			BSTNode temp=new BSTNode(x);
			root=temp;
			size++;
		}
		else if(node == null) {
			System.out.println("the node is null");
			BSTNode temp=new BSTNode(x);
			node=temp;
			size++;
		}
		else if (x < node.data) {
			if (node.left == null) {
				node.left=new BSTNode(x);
				size++;
			}
			else insert(node.left, x);
		}
		else{
			if (node.right == null) {
				node.right = new BSTNode(x);
				size++;
			}
			else insert(node.right, x);
		}
	}
	
	public void insert2(int x) {
		insert(root, x);
	}
	
	//==================================================================
	//          TRAVERSE
	//==================================================================
	
	public void inOrder(BSTNode node){//PASS
		if(node == null);
		else{
			inOrder (node.left);
			System.out.println(node.data);
			inOrder (node.right);
		}
	}
	
	public void preOrder(BSTNode node){//PASS
		if(node == null);
		else{
			System.out.println(node.data);
			inOrder (node.left);
			inOrder (node.right);
		}
	}
	
	public void postOrder(BSTNode node){//PASS
		if(node == null);
		else{
			inOrder (node.left);
			inOrder (node.right);
			System.out.println(node.data);
		}
	}

	//==================================================================
	//          SEARCH
	//==================================================================
	
	public boolean search(BSTNode node, int x){//PASS
		if(node == null)return false;//
		else if (node.data == x) return true;//hit
		else {
			if(x < node.data) return search(node.left, x);
			else return search(node.right, x);
		}
	}
	
	//==================================================================
	//          DELETE
	//==================================================================
	
	/*how to delete a node in a BST?
	First, if the tree is empty, then we don't need to delete any node;
	Or if the tree is not empty, we need to divide to three cases:
	1, x == node.data;
	Current node is the to-delete node, we just delete it. However, we have to 
	decide which node to replace the current one. 
	If the left and right child are null, then delete the current node;
	If the left is null and the right child is not null, then replace the current
	node with the right child;
	If the right is null and left not null, vice versa.
	If the left and right are not null, we need to find a node, which has a value
	closest to current node, to replace it. 
	
	2, x < node.data;
	recursively delete.
	
	3, x > node.data
	recursively delete. 
	
	*/

	public void delete (int x) { //PASS
		root = delete (root, x);
	}
	
	private BSTNode delete(BSTNode node, int x){ //PASS
		if(node == null) return null; 
		else if(x < node.data) node.left = delete(node.left, x);
		else if(x > node.data) node.right = delete(node.right, x);
		else {
			if (node.right == null && node.left == null) {
				node = null;
				return null;
			}
			else if (node.right == null) return node.left;
			else if (node.left == null) return node.right;
			else {// x == node.data
				int temp = findMax(node.left).data;
				node.data = temp;
				node.left = delete(node.left, temp);
			}
		}
		return node;
	}
	
	/*DO NOT DELETE THIS BLOCK
	public void delete(BSTNode node, int x) {
		if(node == null);
		else if(node.left == null && node.right == null){
			node=null;
		}
		else if(node.data == x){
			//delete node
			if(node.left == null){
				node=node.right;
				node.right=null;
			}
			else if(node.right == null){
				node=node.left;
				node.left=null;
			}
			else {
				node.data=findBiggest(node.left);
				delete(node.left, node.data);
			}
		}
		else if(x < node.data){
			delete(node.left, x);
		}
		else if(x > node.data){
			delete(node.right, x);
		}
		else {//default case
			System.out.println("Something unexpected happened.");
		}
	}*/
	
	
	//==================================================================
	//          BFS
	//==================================================================
	/*How to print every level of a binary tree?
	 * Recursively traverse, use i as an indicator of the depth. 
	 */
	
	public void printLevelOrder(int depth) {//PASS
		if (root == null) {
			System.out.println ("NULL TREE");
		}
		else {
			for (int i=0; i < depth; ++i){
				System.out.println ( printLevel(root, i) );
			}
		}
	}
	
	public String printLevel(BSTNode node, int depth) {//PASS
		if (node == null) {
			return "";
		}
		else if(depth == 0) {
			String str = ""+node.data;
			return str;
		}
		else if (depth > 0){
			String leftStr = printLevel(node.left, depth-1);//the depth decres
			String rightStr = printLevel(node.right, depth-1);
			return leftStr+"_"+rightStr;
		}
		else return "";//default case
	}
	
	//==================================================================
	//         DESTROY TREE
	//==================================================================
	
	public BSTNode destroyTree(BSTNode node) {
		if (root == null) {
			return null;
		}
		else if (node == null) {
			return null;
		}
		else {
			node.left = destroyTree(node.left);
			node.right = destroyTree(node.right);
			return node;
		}
	}

	//==================================================================
	//         PRINT TREE STRUCTURE
	//==================================================================
	
	public void printTreeStruct(int maxheight) {//PASS
		for (int i=0; i<maxheight; ++i) {
			System.out.println(printCertainLevel(root, i, 1, maxheight) );
			/*int numofspace = (int)java.lang.Math.pow(2, (maxheight-i))-1;
			for (int j=0; j<maxheight+4-i; ++j) {
				System.out.println (returnSpace(numofspace-j) + "/" + 
				returnSpace(2*j) + "\\" + returnSpace(numofspace-j));
			}*/
		}
	}
	
	public String returnSpace (int n) {//PASS
		String str = "";
		for (int i=0; i<n; ++i) str += " ";
		return str;
	}
	
	public String printCertainLevel(BSTNode node, int depth, int height, int maxheight) {//PASS
		int numofspace = (int)java.lang.Math.pow(2, (maxheight+1-height))-1;
		String spaces = returnSpace(numofspace);
		if (node == null) {
			return spaces + "_" + spaces;
		}
		else if(depth == 0) {
			return spaces + node.data + spaces;
		}
		else if (depth > 0){
			String leftStr = printCertainLevel(node.left, depth-1, height+1, maxheight);//the depth decres
			String rightStr = printCertainLevel(node.right, depth-1, height+1, maxheight);
			return leftStr+" "+rightStr;
		}
		else return "";
	}
	
	//==================================================================
	//         SELF BALANCE
	//==================================================================
	public BSTNode rotateR (BSTNode node) {//PASS
		if (node.left == null) {
			return node;
		}
		else {
			BSTNode temp = node.left;
			node.left = temp.right;
			temp.right = node;
			System.out.println(temp.data);
			return temp;
		}
	}
	
	public BSTNode rotateL (BSTNode node) {//PASS
		if (node.right == null) {
			return node;
		}
		else {
			BSTNode temp = node.right;
			node.right = temp.left;
			temp.left = node;
			return temp;
		}
	}
	
	//==================================================================
	//         DEGENERATE
	//==================================================================
	
	public void degenerate() {//PASS
		while(root.left != null) {
			root = rotateR(root);
		}
		if (root.right != null) {
			BSTNode temp = root;
			BSTNode temp_r = root.right;
			while (temp_r.right != null) {
				while (temp_r.left != null) {
					temp.right = rotateR(temp_r);
					temp_r = temp.right;//IMPORTANT! If not, temp.right will skip
					//temp's son and link to grandson instead. 
				}
				temp = temp.right;
				temp_r = temp.right;
			}
		}
	}
    
	//==================================================================
	//         REBUILD
	//==================================================================
	
	public void rebuild() {
		BSTNode temp = root;
		int num_of_nodes = 1;
		while (temp.right != null) {
			temp = temp.right;
			++ num_of_nodes;
		}
		System.out.println (num_of_nodes);
		
		for (int i = num_of_nodes/2; i > 0; i--) {
			root = rotateL(root);
		}
		
	}
	
	//==================================================================
	//         BUILD PERFECT BST FROM DEGENERATED BST, COPIED FROM OTHERS
	//==================================================================
	
	//featuring http://www.geekviewpoint.com/java/bst/dsw_algorithm

	public void createPerfectBST() {//PASS. COPIED
		int n = 0;
		for (BSTNode tmp = root; null != tmp; tmp = tmp.right) {
			n++;
		}
		System.out.println("num of nodes" + n);

		int m = greatestPowerOf2LessThanN(n + 1) - 1;
		System.out.println("num of rotations" + Integer.toString(n-m));
		makeRotations(n - m);
		while (m > 1) {
			System.out.println("num of rotations below" + Integer.toString(m/2));
			makeRotations(m /= 2);
			
		}
	}

	private void rotateLeft(BSTNode grandParent, BSTNode parent, BSTNode child) {//PASS COPIED
		if (null != grandParent) {
		    grandParent.right = child;
		} else {
			root = child;//good
		}
		parent.right = child.left;
		child.left = parent;
	}
	
	public void makeRotations(int bound) {//PASS COPIED
		BSTNode grandParent = null;
		BSTNode parent = root;
		BSTNode child = root.right;
		
		for ( ; bound > 0; bound--) {
			if (null != child) {
				printTreeStruct(5);
				rotateLeft (grandParent, parent, child);
				grandParent = child;
				parent = grandParent.right;
				child = parent.right;
			}
			else break;
		}
		System.out.println("done some rotation");
	}
	
	
	/**
	 * Time complexity: log(n)
	 */
	private int greatestPowerOf2LessThanN(int n) { //PASS. COPIED
		int ndx = 0;
		while (1 < n) {
			n = (n >> 1);
			ndx++;
		}//get the MSB of n in binary representation. 
		//For instance, 9 = 1001, and return 8;
		return (1 << ndx);//2^x
	}
	
	//==================================================================
	//          BST to DLL
	//==================================================================
	//convert a binary search tree to a circular doubly linked list
	
	public BSTNode joinTwoCDLL(BSTNode a, BSTNode b) {//PASS
		if (b == null) return a;
		else if(a == null) return b;
		else {
			BSTNode a_tail = a.left;
			BSTNode b_tail = b.left;
			a_tail.right = b;
			b.left = a_tail;
			b_tail.right = a;
			a.left = b_tail;
			return a;//return head of the first CDLL to keep order
		}
	}
	
	public BSTNode tree2CDLL (BSTNode node) {//PASS
		if (node == null) return null;
		//recursively convert left and right child
		BSTNode alist = tree2CDLL(node.left);
		BSTNode blist = tree2CDLL(node.right);
		
		//convert node to a CDLL
		node.left = node;
		node.right = node;
		
		//combine left child and node
		alist = joinTwoCDLL(alist, node);
		//combine node and right child
		node = joinTwoCDLL(alist, blist);
		
		return node;
	}
	
	public static void printList(BSTNode head) { //PASS
    	//print all the elements in DLL
        BSTNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
            if (current == head) break;//circular list
        }
        
        System.out.println();
    }
	
	//==================================================================
	//         NON-RECURSIVE OPERATIONS OF BINARY TREE
	//==================================================================
	
	public void nr_search() {
		
	}
	
	//==================================================================
	//          TEST SCRIPT
	//==================================================================
	
	public void testBST(){
		BST a = new BST();
		a.insert(a.root, 13);
		a.insert(a.root, 12);
		a.insert(a.root, 22);
		a.insert(a.root, 32);
		a.insert(a.root, 4);
		a.insert(a.root, 6);
		a.insert(a.root, 2);
		a.insert(a.root, 7);
		a.insert(a.root, 42);
		a.printTreeStruct(5);
		a.degenerate();
		a.printTreeStruct(9);
		BSTNode head = a.tree2CDLL(a.root);
		//a.printTreeStruct(4);
		//BSTNode head = treeToList(a.root);
        printList(head);   // 1 2 3 4 5   yay!
		/*test degenerate
		a.printTreeStruct(5);
		a.degenerate();
		System.out.println("degenerate done");
		a.printTreeStruct(5);
		*/
		System.out.println("================================================");
	}
}
