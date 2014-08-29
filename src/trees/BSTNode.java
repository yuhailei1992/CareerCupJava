package trees;

public class BSTNode {
	public int data;
	protected BSTNode left;
	protected BSTNode right;
	public BSTNode() {
		this.left=null;
		this.right=null;
	}
	
	public BSTNode(int x) {
		this.data=x;
		this.left=null;
		this.right=null;
	}
}
	
