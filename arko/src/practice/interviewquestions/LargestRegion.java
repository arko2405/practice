package practice.interviewquestions;

import java.util.Scanner;

public class LargestRegion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int mat[][]= new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int maxRegion = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(mat[i][j]==1)
					maxRegion = Math.max(maxRegion, calculateRegionSize(i,j,mat,m,n));
			}
		}
		System.out.println(maxRegion);
		
	}

	private static int calculateRegionSize(int i, int j, int[][] mat, int m, int n) {
		if(i>=0 && i<m && j<n && j>=0 && mat[i][j]==1){
			int res = 1 ;
			mat[i][j]=0;
			res = res + calculateRegionSize(i, j+1, mat, m, n); 
			res = res + calculateRegionSize(i, j-1, mat, m, n);
			res = res + calculateRegionSize(i-1, j, mat, m, n);
			res = res + calculateRegionSize(i+1, j, mat, m, n);
			res = res + calculateRegionSize(i+1, j+1, mat, m, n);
			res = res + calculateRegionSize(i-1, j-1, mat, m, n);
			res = res + calculateRegionSize(i-1, j+1, mat, m, n);
			res = res + calculateRegionSize(i+1, j-1, mat, m, n);
			return res;
		}
		return 0;
	}

}
/*

You are given a matrix with m rows and n columns of cells, each of which contains either 1 or 0. 
Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. 
The connected and filled (i.e. cells that contain a 1) cells form a region. 
There may be several regions in the matrix. Find the number of cells in the largest region in the matrix.
Input Format 
There will be three parts of the input: The first line will contain m, the number of rows in the matrix.
 The second line will contain n, the number of columns in the matrix. 
 This will be followed by the matrix grid: the list of numbers that make up the matrix.
 
Output Format 
Print the length of the largest region in the given matrix.

4 
4 
1 1 0 0 
0 1 1 0 
0 0 1 0 
1 0 0 0


5

*/