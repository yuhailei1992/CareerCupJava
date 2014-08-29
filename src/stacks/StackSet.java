package stacks;

public class StackSet {
//includes 5 stacks, each with a capacity of 3;
//stk[4] is used for popping, and the rest 4 are used for pushing
//use two pointers. One points to the current stack top, 
//the other points to the purged one. 
	int stk_top;
	int stk_btm;
	public Stack[] stk;
	
	public StackSet () {
		stk_top = 0;
		stk_btm = 0;
		stk = new Stack[5];
		for (int i=0; i<5; ++i) {
			stk[i] = new Stack();
		}
	}
	
	private int incStkPtr () {
		if (stk_top == 3) stk_top = 0;
		else stk_top ++;
		return stk_top;
	}
	
	public void push (int x) {
		if (!stk[stk_top].isFull()) {//current stack available. just push
			//System.out.println ("simple push");
			stk[stk_top].push(x);
		}
		else if (stk[incStkPtr()].isEmpty()) {//is not totally full;
			//System.out.println ("the next stack ");
			stk[stk_top].push(x);
		}
		else {//the stack is totally full
			System.out.println("Stack is totally full!");
		}
	}
	
	public void shiftStack () {
		if (stk_btm == -1) {//initialization
			stk_btm = 0;
		}
		if (stk[4].isEmpty()) {//if stk4 is empty, shift stk_pos to stk4
			while (!stk[stk_btm].isEmpty()) {
				stk[4].push(stk[stk_btm].pop_int());
			}
			stk[stk_btm].setEmpty();
			if (stk_btm == 3) {
				stk_btm = 0;
			}
			else stk_btm ++;
		}
	}
	
	public void pop () {
		if (stk[4].isEmpty()) {
			shiftStack ();
		}
		stk[4].pop();
	}
	
	public void showStackSet () {
		for (int i=0; i<5; ++i) {
			System.out.println("#" + Integer.toString(i));
			stk[i].showStack();
		}
	}
	
	public static void testStackSet () {
		StackSet stkset = new StackSet();
		System.out.println ("*********************begin test...");
		System.out.println ("*********************firstly, test push...");
		//stkset.stk[0].push(1);
		for (int i=0; i<20; ++i) {
			stkset.push(i);
		}
		stkset.pop();
		stkset.pop();
		stkset.pop();
		stkset.pop();
		stkset.showStackSet();
		for (int i=0; i<2; ++i) {
			stkset.push(i+200);
		}
		stkset.showStackSet();
		System.out.println ("*********************then, begin testing pop()");
		for (int j=0; j<5; ++j) {
			stkset.pop();
		}
		stkset.showStackSet();
		for (int i=0; i<4; ++i) {
			stkset.push(i+300);
		}
		stkset.showStackSet();
	}
}
