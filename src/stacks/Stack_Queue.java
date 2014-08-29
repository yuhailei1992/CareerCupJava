package stacks;

public class Stack_Queue {//PASS
	Stack stk1;
	Stack stk2;
	
	public Stack_Queue () {
		stk1 = new Stack();
		stk2 = new Stack();
	}
	
	public void enQueue (int x) {
		stk1.push(x);
	}
	
	public void deQueue () {
		while (!stk1.isEmpty()) {
			stk2.push ( stk1.pop_int() );
		}
		stk2.pop();
		while (!stk2.isEmpty()) {
			stk1.push ( stk2.pop_int() );
		}
	}
	
	////METHOD 2
	public void enQueue2 (int x) {
		//stk1 stores new values
		//stk2 stores old values
		stk1.push(x);
	}
	
	private void shiftStack () {
		if(stk2.isEmpty()) {//very important premise
			while (!stk1.isEmpty()) {
				stk2.push(stk1.pop_int());
			}
		}
	}
	
	public void deQueue2 () {
		shiftStack ();
		stk2.pop();
	}
	
	public void showQueue () {
		stk1.showStack();
		stk2.showStack();
	}
	
	public static void testStack_Queue () {
		Stack_Queue stkque = new Stack_Queue();
		stkque.enQueue2(4);
		stkque.enQueue2(2);
		stkque.enQueue2(1);
		stkque.enQueue2(5);
		stkque.deQueue2();
		stkque.enQueue2(1);
		stkque.enQueue2(3);
		stkque.showQueue();
		stkque.deQueue2();
		stkque.showQueue();
		stkque.deQueue2();
		stkque.showQueue();
		stkque.deQueue2();
		stkque.showQueue();
		stkque.deQueue2();
		stkque.showQueue();
	}
}
