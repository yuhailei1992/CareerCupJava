package lists;

public class DLL {//DoublyLinkedList
	int size;//size of the list
	int balance;//
	DLLNode median;//stores the median value;
	DLLNode head;//additional head node
	DLLNode tail;//point to the last node of the list
	
    static class DLLNode {
        int data;//data
        DLLNode pre;//point to previous node
        DLLNode post;//point to the next node
        
        public DLLNode () {
        	pre = null;
        	post = null;
        }
        
        public DLLNode (int x) {
        	data = x;
        	pre = null;
        	post = null;
        }
    }
    
    public DLL () {
    	size = 0;
    	balance = 0;
    	//median = new DLLNode();
    	head = new DLLNode();
    	tail = head;
    	median = head;
    	//tail = new DLLNode();
//    	head.post = tail;
//    	tail.pre = head;
    }
    
    public boolean isEmpty () {
    	return size == 0;
    }
    
    public int getSize () {
    	return size;
    }
    
    public void linkTwoNodes (DLLNode node1, DLLNode node2) {
    	node1.post = node2;
    	node2.pre = node1;
    }
    
    public void insert (int x) {
    	DLLNode node = new DLLNode(x);
    	size ++;
    	
    	if (isEmpty()) {
    		linkTwoNodes(head, node);
    		tail = node;
    	}
    	else {
    		linkTwoNodes(tail, node);
    		tail = node;
    	}
    }
    
    public void insertPost (DLLNode node, int x) {
    	DLLNode temp = new DLLNode(x);
    	size ++;
    	if (node == tail) {
    		linkTwoNodes(node, temp);
    		tail = temp;
    		
    	}
    	else {//node is tail
    		if (node.post != tail){
    			linkTwoNodes(temp, node.post);
    			linkTwoNodes(node, temp);
    		}
    		else {
    			linkTwoNodes(temp, node.post);
    			linkTwoNodes(node, temp);
    			tail = temp.post;
    		}
    	}
    	
    }
    
    public void deletePost (DLLNode node) {
    	if (node == tail) {
    		System.out.println("Tail, cannot delete next");
    	}
    	else if (node.post == tail) {
    		tail = node;
    	}
    	else {
    		DLLNode temp = node.post.post;
    		linkTwoNodes(node, temp);
    		tail = node;
    	}
    }
//    
    public void showDLL () {
    	if (isEmpty()) {
    		System.out.println("empty list...");
    		return;
    	}
    	DLLNode curr = head.post;
    	while (curr != tail) {
    		System.out.print(Integer.toString(curr.data) + "->");
    		curr = curr.post;
    	}
    	System.out.println(Integer.toString(curr.data));
    }
    
    public void insertAscend (int x) {
    	
    	if (isEmpty()) {
    		insert(x);
    		median = head.post;
    		balance = 0;
    	}
    	else {
    		if (x >= median.data) balance ++;
    		else balance--;
    		System.out.println("BALANCE=" +Integer.toString(balance));
    		if (balance == 2 || balance == -2) {
    			updateMedian();
    		}
    		
    		DLLNode temp = head.post;
    		while (x >= temp.data) {
    			if (temp != tail) {
    				temp = temp.post;
    			}
    			else {
    				insertPost (temp, x);
    				return;
    			}
    		}
    		//seems that temp has not reached the tail, and got stuck!
    		temp = temp.pre;
    		insertPost(temp, x);
    		return;
    	}
    }
    
    public void updateMedian () {
    	if (balance == 2){
    		median = median.post;
    	}
    	else {
    		median = median.pre;
    	}
    	balance = 0;
    }
    
    public static void testDLL () {
    	DLL a = new DLL();
    	for (int i=0; i<20; ++i) {
    		int x = (int)(Math.random()*100);
    		a.insertAscend(x);
    		a.showDLL();
    		System.out.println("Median = " +Integer.toString(a.median.data));
    	}
    }
    
}