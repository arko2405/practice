package practice.interviewquestions;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String mainString = in.nextLine();
			String substring = in.nextLine();
			int i = 0;
			while(mainString.contains(substring)){
				i++;
				int x = mainString.indexOf(substring);
				mainString = mainString.substring(x+1);
			}
			if(i==0)
				System.out.println("no");
			else
				System.out.println("yes : "+i);
		}

	}

}
