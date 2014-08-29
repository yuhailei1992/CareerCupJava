package stacks;

public class Stack3{
	int[] stackPointer;
	int[] size;
	int[] data;
	protected static final int MAX_SIZE = 100;
	
	public Stack3 () {
		data = new int[3*MAX_SIZE];
		size = new int[3];
	}
	
	public void push (int x, int numStack) {
		if (numStack < 0 || numStack >2) {
			System.out.println ("Please input a valid numPointer");
		}
		else {
			if (size[numStack] < MAX_SIZE) {
				data[numStack*MAX_SIZE + size[numStack]] = x;
				size[numStack] ++;
			}
		}
	}
	
	public void pop (int numStack) {
		if (numStack < 0 || numStack >2) {
			System.out.println ("Please input a valid numPointer");
		}
		if (size[numStack] == 0) {
			System.out.println ("EMPTY STACK, CANNOT POP");
		}
		else {
			size[numStack]--;
		}
	}
	
	public void showStack3 () {
		System.out.println ("STACK 0");
		System.out.println ("====bottom====");
		for (int i=0; i<size[0]; ++i) {
			System.out.println (data[i]);
		}
		System.out.println ("====top====");
		
		System.out.println ("STACK 1");
		System.out.println ("====bottom====");
		for (int i=0; i<size[1]; ++i) {
			System.out.println (data[MAX_SIZE + i]);
		}
		System.out.println ("====top====");
		
		System.out.println ("STACK 2");
		System.out.println ("====bottom====");
		for (int i=0; i<size[2]; ++i) {
			System.out.println (data[MAX_SIZE*2 + i]);
		}
		System.out.println ("====top====");
		
	}
	
	public static void testStack3 () {
		Stack3 stk = new Stack3();
		stk.push(1, 0);
		stk.push(3, 1);
		stk.push(4, 2);
		stk.push(1, 1);
		stk.push(5, 2);
		stk.push(6, 0);
		stk.push(2, 2);
		stk.push(8, 0);
		stk.push(43, 1);
		stk.push(66, 0);
		stk.push(32, 2);
		stk.push(56, 0);
		stk.showStack3();
	}
}


