package practice.arrays;

public class ElementsThatAppearMoreThanNByKTimes {

	public static void main(String[] args) {
		int arr1[] = {4, 5, 6, 7, 8, 4, 4};
	    int size = arr1.length;
	    int k = 3;
	    moreThanNdK(arr1, size, k);
	    System.out.println();
	 
	    int arr2[] = {4, 2, 2, 7};
	    size = arr2.length;
	    k = 3;
	    moreThanNdK(arr2, size, k);
	    System.out.println();
	 
	    int arr3[] = {2, 7, 2};
	    size = arr3.length;
	    k = 2;
	    moreThanNdK(arr3, size, k);
	    System.out.println();
	 
	    int arr4[] = {2, 3, 3, 2};
	    size = arr4.length;
	    k = 3;
	    moreThanNdK(arr4, size, k);
	}

	private static void moreThanNdK(int[] arr, int size, int k) {
		if(k<2)
			return;
		TempNode temp[] = new TempNode[k-1];
		for (int i = 0; i < k-1; i++) {
			temp[i] = new TempNode(-1, 0);
		}
		for (int i = 0; i < size; i++) {
			int j=0;
			for ( j = 0; j < k-1; j++) {
				if(temp[j].element == arr[i]){
					temp[j].count++;
					break;
				}
			}
			if(j==(k-1)){
				int l=0;
				for ( l = 0; l < k-1; l++) {
					if(temp[l].count==0){
						temp[l].element = arr[i];
						temp[l].count=1;
						break;
					}
				}
				if(l == k-1){
					for (int l2 = 0; l2 < k-1; l2++) {
						temp[l2].count -=1;
					}
				}
			}
		}
		
		for (int i = 0; i < k-1; i++) {
			int t = 0;
			for (int j = 0; j < size; j++) {
				if(temp[i].element == arr[j])
					t++;
			}
			if(t > (size/k))
				System.out.print(temp[i].element + " " + t + " ");
		}
		
	}
	public static class TempNode{
		Integer element;
		int count;
		public TempNode(Integer element, int count) {
			super();
			this.element = element;
			this.count = count;
		}
		
	}
}
