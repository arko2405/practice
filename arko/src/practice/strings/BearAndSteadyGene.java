package practice.strings;

import java.util.Scanner;

// quest :https://www.hackerrank.com/challenges/bear-and-steady-gene
public class BearAndSteadyGene {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int freqOfEach = n/4;
			String s = sc.next();
			int count[] = new int[91];
			boolean[] str2 = new boolean[256];
			boolean allCharsEquallyOccuring = true;
			for (int i = 0; i < s.length(); i++) {
				count[s.charAt(i)]++;
			}
			int len = 0;
			for (int i = 65; i < count.length; i++) {
				if(count[i]>freqOfEach){
					count[i] = count[i] - freqOfEach;
					len += count[i];
					str2[i] = true;
					allCharsEquallyOccuring = false;
				}
				else
					count[i] = 0;
			}
			if(!allCharsEquallyOccuring)
			 System.out.println(smlSubStr(s, count,str2,len));
			else
				System.out.println(0);
		}

	}
	
	static int smlSubStr(String s, int[] count1,boolean[] str, int len) {

		int count[] = new int[91];
		int[] substr = new int[91];
		boolean[] str2 = new boolean[91];
		int i = 0, j = 0, m = 0, sum = len;
		for (int k = 65; k < count1.length; k++) {
			count[k] = count1[k];
			str2[k] = str[k];
		}
		i = 0;
		while (str2[s.charAt(i)] != true) {
			i++;
		}
		j = i;
		while (sum != 0 && j < s.length()) {
			if (count[s.charAt(j)] != 0) {
				sum--;
				count[s.charAt(j)]--;
			}
			if (str2[s.charAt(j)]) {
				substr[s.charAt(j)]++;
			}
			if (sum == 0) {
				break;
			}
			j++;

		}
		if (j == s.length()) {
			return 0;
		}
		m = j - i + 1;
		// again update array count[] and str2[]
		for (int k = 65; k < count1.length; k++) {
			count[k] = count1[k];
			str2[k] = str[k];
		}
		// System.out.println(s.substring(i,m+i));
		j++;
		// loop for checking minimum length
		while (j < s.length()) {

			if (str2[s.charAt(j)]) {
				substr[s.charAt(j)]++;
			}
			if (s.charAt(j) == s.charAt(i)) {
				substr[s.charAt(i)]--;
				i++;
				while (str2[s.charAt(i)] != true || substr[s.charAt(i)] > count[s.charAt(i)]) {

					if (str2[s.charAt(i)]) {
						substr[s.charAt(i)]--;
					}
					i++;
				}

			}
			if (j - i + 1 < m) {
				m = j - i + 1;
			}
			j++;

		}

		//System.out.println(s.substring(i,m+i));
		return m;
	}

}
/*

A gene is represented as a string of length  (where  is divisible by ), composed of the letters , , , and . It is considered to be steady if each of the four letters occurs exactly  times. For example,  and  are both steady genes.

Bear Limak is a famous biotechnology scientist who specializes in modifying bear DNA to make it steady. Right now, he is examining a gene represented as a string . It is not necessarily steady. Fortunately, Limak can choose one (maybe empty) substring of  and replace it with any substring of the same length.

Modifying a large substring of bear genes can be dangerous. Given a string , can you help Limak find the length of the smallest possible substring that he can replace to make  a steady gene?

Note: A substring of a string  is a subsequence made up of zero or more consecutive characters of .

Input Format

The first line contains an interger  divisible by , denoting the length of a string . 
The second line contains a string  of length . Each character is one of the four: , , , .

Constraints


 is divisible by 
Subtask

 in tests worth  points.
Output Format

On a new line, print the minimum length of the substring replaced to make  stable.

Sample Input

8  
GAAATAAA
Sample Output

5
Explanation

One optimal solution is to replace a substring  with , resulting in . The replaced substring has length , so we print  on a new line.

*/