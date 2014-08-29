import java.util.*;

public class ExtraProblems {
	
	public void DP1() {
		//coins
		
	}
	
	public static void LAS () {//PASS
		//longest ascending subsequence
		int max_length = 1;
		//int arr[] = {5,3,4,7,6};
		int arr[] = {5,3,4,7,2,3,5,8,2,14,6};
		String LAS_index = "";
		int arrlen = arr.length;
		int[] d = new int[arrlen];
		String[] al = new String[arrlen];
        
		for (int i = 0; i < arrlen; ++i) {
			d[i] = 1;
			al[i] = Integer.toString(i);
			for (int j = 0; j < i; ++j) {
				if (arr[j] < arr[i] && d[j]+1 >= d[i]) {
					d[i] = d[j] + 1;
					al[i] = al[j] + "-" + Integer.toString(i);
				}
				if (d[i] > max_length) {
					max_length = d[i];
					LAS_index = al[i];
				}
			}
		}
		System.out.println (max_length);
		System.out.println(LAS_index);
		for (int i = 0; i < arrlen; ++i) {
			System.out.println (Integer.toString(i) + ":Path:" + al[i]);
		}
	}
}
