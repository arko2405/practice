package practice.arrays;

public class SearchElementInSortedPivotedArray {

	public static void main(String[] args) {
		int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		   int no = 3;
		   int arr_size = arr1.length;
		   System.out.println("Index of the element is " + pivotedBinarySearch(arr1, arr_size, no));
		 
		   int arr2[] = {3, 4, 5, 1, 2};
		    arr_size = arr2.length;
		   System.out.println("Index of the element is " + pivotedBinarySearch(arr2, arr_size, no));
		 
		   no = 4;
		   arr_size = arr2.length;
		   System.out.println("Index of the element is " +  pivotedBinarySearch(arr2, arr_size, no));
		 
		   int arr3[] = {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
		   no = 0;
		    arr_size = arr3.length;
		   System.out.println("Index of the element is " + pivotedBinarySearch(arr3, arr_size, no));
		 
		   int arr4[] = {2, 3, 0, 2, 2, 2, 2, 2, 2, 2};
		   no = 3;
		   arr_size = arr4.length;
		   System.out.println("Index of the element is " +  pivotedBinarySearch(arr4, arr_size, no));
		 
		   no = 2;
		 arr_size = arr4.length;
		   System.out.println("Index of the element is " + pivotedBinarySearch(arr4, arr_size, no));
		 
		   int arr5[] = {1, 2, 3, 4};
		   no = 3;
		    arr_size = arr5.length;
		   System.out.println("Index of the element is " + pivotedBinarySearch(arr5, arr_size, no));
	}

	private static int pivotedBinarySearch(int[] arr, int arr_size, int no) {
		int pivot = findPivot(arr, 0, arr_size-1);
		if(pivot == 0)
			return binarySearch(arr, 0, arr_size-1, no);
		if(no >= arr[0])
			return binarySearch(arr, 0 , pivot-1, no);
		else
			return binarySearch(arr, pivot, arr_size-1, no);
	
	}
	private static int binarySearch(int arr[], int low, int high, int no)
	{
	   if (high < low)
	       return -1;
	   int mid = (low + high)/2;
	   if (no == arr[mid])
	     return mid;
	   if (no > arr[mid])
	     return binarySearch(arr, (mid + 1), high, no);
	   else
	     return binarySearch(arr, low, (mid -1), no);
	}
	private static int findPivot(int[] arr, int i, int j) {
		if(i==j)
			return i;
		int mid = (i + j)/2;
		if(mid==i)
		{
			if(arr[i] < arr[j])
				return i;
			else
				return j;
		}
		if(arr[mid]<arr[mid-1])
			return mid;
		else
		{
			if(arr[j] > arr[mid])
				return findPivot(arr, i, mid-1);
			else if(arr[j] == arr[mid]){
				int x = findPivot(arr, i, mid - 1);
				int y = findPivot(arr, mid+1, j);
				if(arr[x] < arr[y])
					return x;
				else 
					return y;
			}
			else
				return findPivot(arr, mid+1, j);
		} 
	}
}
