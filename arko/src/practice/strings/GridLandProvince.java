package practice.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GridLandProvince {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//while(sc.hasNext()){
			int p = sc.nextInt();
			while(p-->0){
				Integer n = sc.nextInt();
				String s1 = sc.next();
				String s2 = sc.next();
				int l = s1.length();
				Map<String, Boolean> temp = new HashMap<>();
				for (int i = 0; i < l; i++) {
					int arr[][]=new int[2][l];
					int count = 0;
					String ans = "";
					getCombinations(arr,0,i,count,l,temp,s1,s2,ans);
				}
				for (int i = 0; i < l; i++) {
					int arr[][]=new int[2][l];
					int count = 0;
					String ans = "";
					getCombinations(arr,1,i,count,l,temp,s1,s2,ans);
				}
				
				System.out.println(temp.size());
				
			}
		//}

	}

	

	private static void getCombinations(int[][] arr, int i, int i2, int count, int l, Map<String, Boolean> temp,
			String s1, String s2, String ans) {
		count++;
		if(i==0)
			ans=ans+s1.charAt(i2);
		else
			ans=ans+s2.charAt(i2);
		arr[i][i2]=1;
		if(count==2*l){
			temp.put(ans, true);
			//System.out.println(ans);
		}
		else{
			if(i2!=l-1){
				if(arr[i][i2+1]==0){
					//System.out.print(i+","+i2+">>"+i+","+(i2+1)+"--count : "+count + " :::  ");
					getCombinations(arr, i, i2+1, count, l, temp, s1, s2, ans);
					//System.out.println(i+","+i2 + ">>");
				}
			}
			if(i2!=0){
				if(arr[i][i2-1]==0){
					//System.out.print(i+","+i2+">>"+i+","+(i2-1)+"--count : "+count + " :::  ");
					getCombinations(arr, i, i2-1, count, l, temp, s1, s2, ans);
					//System.out.println(i+","+i2 + ">>");
				}
			}
			if((i2==0 || i2==l-1) || count!=1){
			if(i==0){
				if(arr[i+1][i2]==0){
					//System.out.print(i+","+i2+">>"+(i+1)+","+i2+"--count = "+count + " :::  ");
					getCombinations(arr, i+1, i2, count, l, temp, s1, s2, ans);
					//System.out.println(i+","+i2 + ">>");
				}
			}
			else{
				if(arr[i-1][i2]==0){
					//System.out.print(i+","+i2+">>"+(i-1)+","+i2+"--count : "+count + " :::  ");
					getCombinations(arr, i-1, i2, count, l, temp, s1, s2, ans);
					//System.out.println(i+","+i2 + ">>");
				}
			}
			}
		}
		arr[i][i2]=0;
	}
}
/*
 The Kingdom of Gridland contains  provinces. Each province is defined as a  grid where each cell in the grid represents a city. Every cell in the grid contains a single lowercase character denoting the first character of the city name corresponding to that cell.

From a city with the coordinates , it is possible to move to any of the following cells in  unit of time (provided that the destination cell is within the confines of the grid):





A knight wants to visit all the cities in Gridland. He can start his journey in any city and immediately stops his journey after having visited each city at least once. Moreover, he always plans his journey in such a way that the total time required to complete it is minimum.

After completing his tour of each province, the knight forms a string by concatenating the characters of all the cells in his path. How many distinct strings can he form in each province?

Input Format

The first line contains a single integer, , denoting the number of provinces. The  subsequent lines describe each province over the following three lines: 
The first line contains an integer, , denoting the number of columns in the province. 
Each of the next two lines contains a string, , of length  denoting the characters for the first and second row of the province.

Constraints




Output Format

For each province, print the number of distinct strings the knight can form on a new line.

Sample Input

3
1
a
a
3
dab
abd
5
ababa
babab
Sample Output

1
8
2
Explanation

Province 0: 
query 0

The knight can only form one string (aa), so we print  on a new line.

Province 1: 
query 1

The knight can form eight different strings (abdbad, adabdb, badabd, bdbada, dababd, dabdba, dbabad, and dbadab), so we print  on a new line.

Province 2: 
query 2

The knight can form two different strings (ababababab and bababababa), so we print  on a new line.
*/