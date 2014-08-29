package lists;

import java.util.Hashtable;

//featuring http://stackoverflow.com/questions/5374077/what-is-linkedlistnode-in-java
public class LinkedList<T> {

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    }

    public void deleteNode(LinkedListNode<T> node) {
        if(node == null);//return null;
        else if(node.next == null) {
        	LinkedListNode<T> p = head;
        	while (p.next != node) p = p.next;
        	tail = p;
        }

        LinkedListNode<T> next = node.next;
        node.data = next.data;
        node.next = next.next;
    }

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    
    public LinkedListNode<T> getHead() {
    	return head;
    }
    
    public LinkedList() {
        this.head = new LinkedListNode<T>();
        this.tail = new LinkedListNode<T>();
        head.next = tail;
    }

    public void addLast(T e) {
        LinkedListNode<T> node = new LinkedListNode<T>(); // e and next are null
        tail.data = e;
        tail.next = node;
        tail = node;
    }

    public void addFirst(T e) {
        LinkedListNode<T> node = new LinkedListNode<T>(); // e and next are null;
        node.next = head.next;
        node.data = e;//additional head pointer
        head.next = node;
    }

    public T deleteFirst() {
        LinkedListNode<T> first = head.next;
        head.next = first.next;
        return first.data;
    }

    public T deleteLast() {
        throw new UnsupportedOperationException();
    }

    public LinkedListNode<T> findFirst(T e) {
        LinkedListNode<T> curr = head.next;
        while(curr != null) {
            if(curr.data != null && curr.data.equals(e)) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void print() {
        LinkedListNode<T> curr = head.next;
        while(curr.next != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println("");
    }
    
    public void removeDup() {//for CC2_1,PASS
    	Hashtable<T, Boolean> table = new Hashtable<T, Boolean>();
        LinkedListNode<T> prev = head;
    	LinkedListNode<T> curr = prev.next;
    	while (curr.next != null) {
    		if(table.containsKey(curr.data)) {
    			System.out.println("dup" + prev.data + curr.data);
    			deleteNode(curr);
    			System.out.println("dup" + prev.data + curr.data);
    			curr = prev.next;
    		}
    		else {
    			table.put(curr.data, true);
    			prev = prev.next;
        		curr = prev.next;
    		}
    		
    		System.out.println("Position:" + prev.data + curr.data);
    	}
    }
    
    public static void testLinkedList () {//PASS
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	ll.addLast(3);
    	ll.addLast(5);
    	ll.addLast(6);
    	ll.addLast(6);
    	ll.addLast(6);
    	ll.addLast(5);
    	ll.addLast(8);
    	ll.print();
    	ll.removeDup();
    	ll.print();	
    }

}

