package practice.interviewquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()){
		     String s = in.nextLine();
		     System.out.println(reverse(s));
		}

	}

	private static String reverse(String s) {
		char[] array = s.toCharArray();
		List<Character> temp = new ArrayList();
		for (int i = 0; i < array.length; i++) {
			if(!(array[i]=='(') && !(array[i]==')')){
				temp.add(array[i]);
			}
		}
		int x = temp.size()-1;
		String s1 = "";
		for (int i = 0; i < array.length; i++) {
			if(!(array[i]=='(') && !(array[i]==')')){
				array[i]=temp.get(x);
				x--;
			}
			s1+=array[i];
		}
		return s1;
	}

}
