import java.util.Hashtable;

import trees.BST;

public class CC17 {

	public static void CC17_7 () {//PASS
		Integer n = 564543555;
		String str = "";
		if (n<0) {
			str += "Negative ";
			n = -n;
		}
		if (n/1000000000 != 0) {
			str += below1000(n/1000000000);// += "Billion";
			str += " Billion, ";
			n %= 1000000000;
		}
		if (n/1000000 != 0) {
			str += below1000(n/1000000);
			str += " Million, ";
			n %= 1000000;
		}
		if (n/1000 != 0) {
			str += below1000(n/1000);
			str += " Thousand, ";
			n %= 1000;
		}
		str += below1000(n);
		System.out.println(str);
	}

	public static String below1000 (int n) {
		String str = "";
		if (n > 999) {
			System.out.println ("out of range");
		}
		else if (n==0) {
			str += "Zero";
		}
		else {
			if (n/100 != 0) {//n > 100
				str += int2Ones(n/100);// += "Hundred";
				str += " Hundred and ";
				n = n-n/100*100;
			}
			if (n/10 != 0) {//n > 10
				if (n >= 20) {//20-99
					str += int2Tens(n/10);
					n = n-n/10*10;
					if (n != 0) {
						str += int2Ones(n);
					}
				}
				else {//10-19
					str += intBelow20(n);
				}
			}
			else {
				str += int2Ones(n);
			}
		}
		return str;
	}
	
	public static String int2Ones (int n) {
		String str = "";
		switch (n) {
			case 0: str = "";
			break;
			case 1: str = "One";
			break;
			case 2: str = "Two";
			break;
			case 3: str = "Three";
			break;
			case 4: str = "Four";
			break;
			case 5: str = "Five";
			break;
			case 6: str = "Six";
			break;
			case 7: str = "Seven";
			break;
			case 8: str = "Eight";
			break;
			case 9: str = "Nine";
			break;
		}
		return str;
	}
	
	public static String int2Tens (int n) {
		String str = "";
		switch (n) {
			case 2: str = "Twenty";
			break;
			case 3: str = "Thirty";
			break;
			case 4: str = "Fourty";
			break;
			case 5: str = "Fifty";
			break;
			case 6: str = "Sixty";
			break;
			case 7: str = "Seventy";
			break;
			case 8: str = "Eighty";
			break;
			case 9: str = "Ninty";
			break;
		}
		return str;
	}
	
	public static String intBelow20 (int n) {
		String str = "";
		switch (n) {
			case 10: str = "Ten";
			break;
			case 11: str = "Eleven";
			break;
			case 12: str = "Twelve";
			break;
			case 13: str = "Thirteen";
			break;
			case 14: str = "Fourteen";
			break;
			case 15: str = "Fifteen";
			break;
			case 16: str = "Sixteen";
			break;
			case 17: str = "Seventeen";
			break;
			case 18: str = "Eighteen";
			break;
			case 19: str = "Nineteen";
			break;
		}
		return str;
	}
	//return 0 if x is negative. Otherwise, return 1. 
	public static int getSign (int x) {
		return (x >> 31) + 1;
	}
	
	public static void CC17_4 () {//PASS
		int a = 0x7fffffff;
		int b = 0xffffffff;
		int s_a = getSign(a);
		int s_b = getSign(b);
		int s_c = getSign(a - b);
		int ifOverflow = (s_a ^ s_c) & (s_a ^ s_b);
		int retval = s_c ^ ifOverflow;
		System.out.println(s_a);
		System.out.println(s_b);
		System.out.println(s_c);
		System.out.println(ifOverflow);
		if (retval == 1) {
			System.out.println("Bigger or equal");
		}
		else {
			System.out.println("Smaller");
		}
	}
		
	public static void CC17_9 () {//PASS. 
		String[] book = {"hello", "world", "descipline", "hello", "dear", 
				"think", "world", "world", "WORLD", "FOOD"};
		String target = "WoRld";
		String temp = target.toLowerCase().trim();
		int count = 0;
		for (int i=0; i<book.length; ++i) {
			//System.out.println(book[i].toLowerCase());
			if (book[i].toLowerCase().trim().equals(temp)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void CC17_9_2 () {//PASS
		//use hashtable
		String[] book = {"hello", "world", "descipline", "hello", "dear", 
				"think", "world", "world", "WORLD", "FOOD"};
		String target = "hello";
		target = target.toLowerCase().trim();
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		for (int i=0; i<book.length; ++i) {
			String curr = book[i].toLowerCase().trim();
			if ( !table.containsKey(curr) ) {
				table.put(curr, 1);
			}
			else {
				table.put(curr, table.get(curr)+1);
			}
		}
		//then, getFrequency
		if (table == null || target.equals("")) {
			System.out.println("NULL TABLE OR NULL TARGET");
		}
		else {
			if (table.containsKey(target)) {
				System.out.println(table.get(target));
			}
			else {
				System.out.println(0);
			}
		}
	}
	
	public static int rand7 () {//naive
		int a = rand5() + rand5() + rand5() + rand5() + rand5() + rand5() + rand5();
		return a % 7;
	}
	
	public static int rand7_2 () {//PASS
		int a = rand5()*2;
		while (true) {
			int b = rand5();
			if (b != 4) {
				int c = b%2 + a;//range: 0-9
				if (c < 7) {
					return c;
				}
			}
		}
	}
	
	public static int rand5 () {
		return (int)(Math.random()*5);
	}
//rand7 testScript: 	
//	int arr[] = {0, 0, 0, 0, 0, 0, 0};
//	for (int i=0; i<1000000; ++i) {
//		arr[CC17.rand7()]++;
//	}
//	for (int i=0; i<7; ++i) {
//		System.out.println(arr[i]);
//	}
	
	public static void CC1712(){//Hash. PASS
		int n=10;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		int arr[]={2, 4, 6, 1, 3, 2, 5, 9, 3, 5};
		for (int i=0; i<10; ++i){
			table.put(arr[i], true);
		}
		for (int i=0; i<10; ++i){
			if (table.containsKey(n-arr[i])){
				System.out.println("There is a pair " + i + " and " + (n-i));
			}
		}
	}
	
	public static void CC1713() {//PASS
		//see BST class, tree2CDLL
	}
	
	public static void CC1714() {
		
	}
}
