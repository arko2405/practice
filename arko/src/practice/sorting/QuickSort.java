package practice.sorting;

public class QuickSort {
	static int arr[]={4,3,6,8,7,1,9,5};
	public static void main(String[] args) {
		quicksort(0,arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	private static void quicksort(int lower, int upper) {
		if(lower<upper){
			int q = partition(lower,upper);
			quicksort(lower, q-1);
			quicksort(q+1, upper);
		}
		
	}
	private static int partition(int lower, int upper) {
		int x= arr[upper];
		int i=lower-1;
		for (int j = lower; j < upper; j++) {
			if(arr[j]<=x)
			{
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		arr[upper]=arr[i+1];
		arr[i+1]=x;
		return i+1;
	}

}
