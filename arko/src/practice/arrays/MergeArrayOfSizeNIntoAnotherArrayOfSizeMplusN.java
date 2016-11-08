package practice.arrays;

public class MergeArrayOfSizeNIntoAnotherArrayOfSizeMplusN {

	public static void main(String[] args) {
		int mPlusN[] = { 2, 8, 0, 0, 0, 13, 0, 15, 20 };
		int N[] = { 5, 7, 9, 25 };
		int m = mPlusN.length, n = N.length;
		merge(mPlusN, N, m, n);

	}

	private static void print(int[] mPlusN, int m) {
		for (int i = 0; i < m; i++) {
			System.out.print(mPlusN[i] + " ");
		}
	}

	private static void merge(int[] mPlusN, int[] n, int m, int n2) {
		mPlusN = moveToEnd(mPlusN,m);
		int j=0;
		int i=n2;
		int x,y;
		for (int k = 0; k < m; k++) {
			if(i >= m)
				x = 9999;
			else
				x = mPlusN[i];
			if(j >= n2)
				y=9999;
			else
				y = n[j];
			
			if(x<y){
				mPlusN[k]=x;
				i++;
			}
			else{
				mPlusN[k]=y;
				j++;
			}
		}
		print(mPlusN, m);
	}

	private static int[] moveToEnd(int[] mPlusN, int m) {
		int j = m - 1;
		for (int i = m - 1; i >= 0; i--) {
			if (mPlusN[i] != 0) {
				mPlusN[j] = mPlusN[i];
				j--;
			}
		}
		return mPlusN;
	}
}
