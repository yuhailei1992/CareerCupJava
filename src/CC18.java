import trees.*;

public class CC18 {
	
	public static void CC18_1() {//PASS
		int a = 23454;
		int b = 9949;
		int sum = a+b;
		System.out.println(sum);
		System.out.println(add(a,b));
		
	}
	public static int add(int a, int b){//PASS
		if (b == 0){
			return a;
		}
		else {
			int temp1 = a ^ b;
			int temp2 = (a & b)<<1;
			return add(temp1, temp2);
		}
	}
	
	public static void CC18_2() {//PASS
		//fisher-yates shuffle algorithm
		int N = 10;
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) arr[i]=i;
		for (int i = 0; i < N; ++i) {
			int idx = i + (int) (Math.random() * (N-i));//(int) will round the number
			System.out.println("index is: " + idx);
			int temp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = temp;
		}
		for (int i = 0; i < N; ++i) System.out.print(arr[i]+"_");
	}
	
	public static void CC18_3() {//do not know why
		int N = 10;
		int M = 4;
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) arr[i]=i;
		for (int i = 0; i < M; ++i) {
			int idx = i + (int)(Math.random() * (N-i));
			int temp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void CC18_4(int n) {//PASS
		//check parameter
		if(n<0) {
			System.out.println ("invalid input number");
			return;
		}
		//allocate the array to store digits.
		int temp = n;
		int num_of_digits = 0;
		while(temp != 0) {
			temp = temp/10;
			num_of_digits++;
		}
		int[] arr = new int[num_of_digits];
		int[] sum_temp = new int[num_of_digits];
		System.out.println("The number of digits is: " + num_of_digits);
		//convert the integer to array
		temp = n;
		int sum = 0;
		for (int i=0; i<num_of_digits; ++i) {
			arr[i] = temp%10;
			temp = temp/10;
		}
		
		for (int i=0; i<num_of_digits; ++i) {
			int pow10 = (int)Math.pow(10, i);//the liangji
			sum_temp[i] = n/(10*pow10)*pow10;
			if (arr[i] == 2) {
				sum_temp[i] += (n+1-n/pow10*pow10);
			}
			else if (arr[i] > 2) sum_temp[i] += pow10;
			sum += sum_temp[i];
		}
		System.out.println (sum);

	}
	
	public static void CC18_4_brute_force(int n) {//PASS
		if (n <= 0) {
			System.out.println ("Wrong number");
			return;
		}
		else {
			int sum=0;
			for (int i=1; i<=n; ++i) {
				int sum_temp = 0;
				int iter = i;
				while(iter != 0) {
					if ((iter%10) == 2) sum_temp++;
					iter = iter/10;
				}
				sum += sum_temp;
			}
			System.out.println ("The number of 2s is: " + sum);
		}
	}
	
	
//	public static void CC18_9 () {
//		BST a = new BST();
//		int cnt = 0;
//		int balance = 0;
//		BSTNode ptr = new BSTNode();
//		ptr = a.getRoot();
//		
//		for (int i=0; i<10; ++i) {
//			int rnd = (int)Math.random()*100;
//			a.insert2(rnd);
//			cnt ++;
//			if (rnd >= ptr.data) {
//				balance ++;
//				if (balance ==2) {
//					//move right;
//					balance = 0;
//				}
//			}
//			else {
//				balance --;
//				if (balance == -2) {
//					//move left
//					balance = 0;
//				}
//			}
//		}
//		if (cnt == 0) {
//			
//		}
//		
//	}
	
	//18_4 test case
	/*int n = 212894;
	CC18.CC18_4_brute_force(n);
	CC18.CC18_4(n);*/

}
