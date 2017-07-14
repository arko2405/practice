package practice.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//question at the bottom
public class NoOfChangesToMakeAnagram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			String s = sc.next();
			System.out.println(noOfChangesRequiredToMakeAnagram(s));
		}
	}

	private static Integer noOfChangesRequiredToMakeAnagram(String s) {
		if(s.length()%2==0){
			String first = s.substring(0, (s.length()/2));
			String second = s.substring(s.length()/2);
			Map<Character, Integer> temp = new HashMap<Character, Integer>();
			int count =0;
			for (int i = 0; i < first.length(); i++) {
				Character c = first.charAt(i);
				if(temp.containsKey(c)){
					temp.replace(c, temp.get(c)+1);
					count++;
				}
				else{
					temp.put(c, 1);
					count++;
					}
			}
			for (int i = 0; i < second.length(); i++) {
				Character c = second.charAt(i);
				if(temp.containsKey(c)){
					temp.replace(c, temp.get(c)-1);
					count--;
					if(temp.get(c)==0)
						temp.remove(c);
					}
				else{
					count++;
				}
			}
			return count/2;
		}
		
		return -1;
	}

}

/*
 https://www.hackerrank.com/challenges/anagram
 
Sid is obsessed with reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books. He chooses strings  and  in such a way that .
 
Your task is to help him find the minimum number of characters of the first string he needs to change to enable him to make it an anagram of the second string.
Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.
Input Format 
The first line will contain an integer, , representing the number of test cases. Each test case will contain a string having length , which will be concatenation of both the strings described above in the problem.The given string will contain only characters from  to .
Output Format 
An integer corresponding to each test case is printed in a different line, i.e. the number of changes required for each test case. Print  if it is not possible.
Constraints
Sample Input
6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx

Sample Output
3
1
-1
2
0
1
Explanation 
Test Case #01: We have to replace all three characters from the first string to make both of strings anagram. Here,  = "aaa" and  = "bbb". So the solution is to replace all character 'a' in string a with character 'b'. 

Test Case #02: You have to replace 'a' with 'b', which will generate "bb". 

Test Case #03: It is not possible for two strings of unequal length to be anagram for each other. 

Test Case #04: We have to replace both the characters of first string ("mn") to make it anagram of other one. 

Test Case #05:  and  are already anagram to each other. 

Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". He had to replace 'a' from S1 with 'b' so that S1 = "xbxb" and we can rearrange its letter to "bbxx" in order to get S2.*/