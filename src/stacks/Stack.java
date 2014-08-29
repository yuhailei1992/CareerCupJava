package stacks;

public class Stack {
	private int[] data;
	private int size;
	protected static final int MAX_SIZE = 5;
	
	public Stack () {
		data = new int[MAX_SIZE];
		size = 0;
	}
	
	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}
	
	public boolean isFull() {
		if (size == MAX_SIZE) return true;
		else return false;
	}
	
	public void setEmpty() {
		size = 0;
	}
	
	public void push (int x) {
		if (size < MAX_SIZE) {
			data[size] = x;
			size ++;
		}
		else {
			System.out.println("Stack Full!");
		}
	}
	
	public void pop () {
		if (size == 0) {
			System.out.println ("EMPTY STACK, CANNOT POP");
		}
		else {
			size--;
		}
	}
	
	public int pop_int () {
		if (size == 0) {
			System.out.println ("EMPTY STACK, CANNOT POP");
			return -1;
		}
		else {
			size--;
			return data[size];
		}
	}
	
	public void showStack () {
		System.out.println("====TOP====");
		for (int i=size-1; i>=0; --i) {
			System.out.println(data[i]);
		}
		System.out.println("====BOTTOM====");
	}
	
	public static void testStack () {
		Stack stk = new Stack();
		stk.push(3);
		stk.push(2);
		stk.push(1);
		stk.push(5);
		stk.push(2);
		if(stk.isFull()){
			System.out.println("full");
		}
		stk.push(1);
		stk.showStack();
	}
}






