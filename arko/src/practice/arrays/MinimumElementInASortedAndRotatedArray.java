package practice.arrays;

public class MinimumElementInASortedAndRotatedArray {
	
	public static void main(String[] args) {
		int arr1[] =  {5, 6, 1, 2, 3, 4};
	    System.out.println("1 \t"+findMin(arr1, 0, arr1.length-1));
	 
	    int arr2[] =  {1, 2, 3, 4};
	    System.out.println("2 \t"+findMin(arr2, 0, arr2.length-1));
	 
	    int arr3[] =  {1};
	    System.out.println("3 \t"+findMin(arr3, 0, arr3.length-1));
	 
	    int arr4[] =  {1, 2};
	    System.out.println("4 \t"+findMin(arr4, 0, arr4.length-1));
	 
	    int arr5[] =  {2, 1};
	    System.out.println("5 \t"+findMin(arr5, 0, arr5.length-1));
	 
	    int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
	    System.out.println("6 \t"+findMin(arr6, 0, arr6.length-1));
	 
	    int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
	    System.out.println("7 \t"+findMin(arr7, 0, arr7.length-1));
	 
	    int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
	    System.out.println("8 \t"+findMin(arr8, 0, arr8.length-1));
	 
	    int arr9[] =  {3, 4, 5, 1, 2};
	    System.out.println("9 \t"+findMin(arr9, 0, arr9.length-1));
	}

	private static int findMin(int[] arr, int i, int j) {
		if(i==j)
			return arr[i];
		int mid = (i + j)/2;
		if(mid==i)
			return Math.min(arr[i], arr[j]);
		if(arr[mid]<arr[mid-1])
			return arr[mid];
		else
		{
			if(arr[j]>arr[mid])
				return findMin(arr, i, mid-1);
			else
				return findMin(arr, mid+1, j);
		}
	}
}
