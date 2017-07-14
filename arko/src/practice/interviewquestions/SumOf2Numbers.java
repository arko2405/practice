package practice.interviewquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOf2Numbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int n = in.nextInt();
		int m = in.nextInt();
		boolean p =false;
		for(int i = 0 ; i < m ; i++){
			int temp= in.nextInt();
			if (hashMap.get(n-temp) !=null){
				p = true;
			} else {
				hashMap.put(temp, n-temp);
			}
		}
		if (p)
			System.out.println("1");
		else
			System.out.println("0");
 	}

}
