package practice.tree;

public class IdenticalBSTs {

	public static void main(String[] args) {
		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13,15};
		   int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13,15};
		   int n=a.length;
		   System.out.println(isSameBST(a, b, n,0,0,-99999,99999)?
		             "BSTs are same":"BSTs not same");
	}

	private static boolean isSameBST(int[] a, int[] b, int n, int a1, int b1,
			int min, int max) {
		int i,j;
		for ( i =a1; i < n; i++) {
			if(a[i] > min && a[i]<max)
				break;
		}
		for ( j = b1; j < n; j++) {
			if(b[j] > min && b[j]<max)
				break;
		}
		if(i==n && j==n) return true;
		if((i==n ^ j==n)||(a[i] != b[j])){
			return false;
		}
		
		return isSameBST(a, b, n, i+1, j+1, min, a[i]) && isSameBST(a, b, n, i+1, j+1, a[i],max);
	}
}