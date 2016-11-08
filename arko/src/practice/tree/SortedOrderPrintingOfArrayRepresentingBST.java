package practice.tree;

public class SortedOrderPrintingOfArrayRepresentingBST {

	public static void main(String[] args) {
		int arr[] = {5,6};
		  int arr_size = arr.length;
		  printSorted(arr, 0, arr_size-1);
	}
	static void printSorted(int arr[], int start, int end)
	{     
	  if(start > end)
	    return;
	 
	  printSorted(arr, start*2 + 1, end);
	 
	  System.out.print(arr[start] + " ");
	 
	  printSorted(arr, start*2 + 2, end);  
	}
}
