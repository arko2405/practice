package practice.arrays;

public class MajorityElement {

	public static void main(String[] args) {
		int arr1[] =  {3, 3 ,4 ,2 ,4 ,4, 2, 4};
	   printMajority(arr1,arr1.length);
	}

	private static void printMajority(int[] arr1, int length) {
		int m=0,count=1;
		for (int i = 1; i < length; i++) {
			if(arr1[m] == arr1[i])
				count++;
			else
				count--;
			if(count == 0){
				m=i;
				count=1;
			}
		}
		int ans = arr1[m];
		if(isMajority(ans,arr1))
			System.out.println(ans);
		else
			System.out.println("None");
	}

	private static boolean isMajority(int ans, int[] arr1) {
		int count = 0;
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i] == ans)
				count++;
		}
		return count>(arr1.length/2);
	}
}
