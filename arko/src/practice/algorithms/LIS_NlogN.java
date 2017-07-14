package practice.algorithms;

import java.util.Scanner;

public class LIS_NlogN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Integer n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int tail[] = new int[n];
			tail[0]=arr[0];
			int len = 1;
			for (int i = 1; i < arr.length; i++) {
				if(arr[i]<tail[0])
					tail[0]=arr[i];
				else if(arr[i]>tail[len-1])
					tail[len++]=arr[i];
				else
					tail[findPosition(tail,-1,len-1,arr[i])]=arr[i];
			}
			System.out.println(len);
			
		}

	}

	private static int findPosition(int A[], int l, int r, int key)
	{
		while (r - l > 1)
		{
			int m = l + (r - l)/2;
			if (A[m]>=key)
				r = m;
			else
				l = m;
		}

		return r;
	}

}
