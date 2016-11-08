package practice.heapproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class QHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int q = sc.nextInt();
			List<Integer> minHeap = new ArrayList<Integer>();
			minHeap.add(Integer.MIN_VALUE);
			int position = 0;
			while (q-- > 0) {
				Integer x = sc.nextInt();
				if (x == 1) {
					Integer y = sc.nextInt();
					minHeap.add(y);
					position++;
					bubbleUp(position,minHeap);
				} else if (x == 2) {
					Integer y = sc.nextInt();
					int p = search(1, y,minHeap);
					if(p>-1){
					minHeap.set(p, minHeap.get(position));
					minHeap.remove(position--);
					if(p<=position)
					sinkDown(p,minHeap);
					}
				} else if (x == 3) {
					System.out.println(minHeap.get(1));
				}
			}
		}

	}

	private static int search(int index, Integer y, List<Integer> minHeap) {
		
		if(minHeap.get(index).intValue()==y){
			return index;
		}
		int ans=-1;
		if (2 * index < minHeap.size() && y >= minHeap.get(2*index)) {
			ans=Math.max(ans, search(2*index, y, minHeap));
		}
		if (2 * index + 1 < minHeap.size() && y >= minHeap.get(2*index+1)) {
			if(ans==-1)
			ans=Math.max(ans, search(2*index+1, y, minHeap));
		}
		return ans;
	}

	
	public static void bubbleUp(int position, List<Integer> minHeap) {
		while (position > 0 && minHeap.get(position/2) > minHeap.get(position)) {
			swap(position, position/2, minHeap);
			position = position / 2;
		}
	}
	
	public static void sinkDown(int position, List<Integer> minHeap) {
		int a = minHeap.get(position);
		int smallest = position;
		if (2 * position < minHeap.size() && minHeap.get(position) > minHeap.get(2*position)) {
			smallest = 2 * position;
		}
		if (2 * position + 1 < minHeap.size() && minHeap.get(smallest) > minHeap.get(2*position+1)) {
			smallest = 2 * position + 1;
		}
		if (smallest != position) {
			swap(position, smallest,minHeap);
			sinkDown(smallest, minHeap);
		}
	}

	public static void swap(int a, int b, List<Integer> minHeap) {
		int temp = minHeap.get(a);
		minHeap.set(a, minHeap.get(b));
		minHeap.set(b, temp);
	}
}
/*
 * This question is designed to help you get a better understanding of basic
 * heap operations. You will be given queries of types:
 * 
 * " " - Add an element to the heap. " " - Delete the element from the heap. ""
 * - Print the minimum of all the elements in the heap. NOTE: It is guaranteed
 * that the element to be deleted will be there in the heap. Also, at any
 * instant, only distinct elements will be in the heap.
 * 
 * Input Format
 * 
 * The first line contains the number of queries, . Each of the next lines
 * contains a single query of any one of the above mentioned types.
 * 
 * Constraints
 * 
 * 
 * 
 * Output Format
 * 
 * For each query of type , print the minimum value on a single line.
 * 
 * Sample Input
 * 
 * 5 1 4 1 9 3 2 4 3 Sample Output
 * 
 * 4 9 Explanation
 * 
 * After the first queries, the heap contains {}. Printing the minimum gives as
 * the output. Then, the query deletes from the heap, and the query gives as the
 * output.
 */