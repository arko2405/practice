package practice.heapproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RunningMedian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			List<Integer> minHeap = new ArrayList<>();
			List<Integer> maxHeap = new ArrayList<>();
			minHeap.add(Integer.MIN_VALUE);
			maxHeap.add(Integer.MAX_VALUE);
			int minPosition = 0;
			int maxPosition = 0;
			for (int i = 1; i <= n; i++) {
				Integer y = sc.nextInt();
				minHeap.add(y);
				minPosition++;
				bubbleUpMin(minPosition, minHeap);
				if(maxHeap.size()>1 && minHeap.get(1)<maxHeap.get(1)){
					int z= minHeap.get(1);
					minHeap.set(1, maxHeap.get(1));
					maxHeap.set(1, z);
					sinkDownMin(1, minHeap);
					sinkDownMax(1, maxHeap);
				}
				if (minHeap.size() - maxHeap.size() > 1) {
					int x = minHeap.get(1);
					minHeap.set(1, minHeap.get(minPosition));
					minHeap.remove(minPosition--);
					sinkDownMin(1, minHeap);
					maxHeap.add(x);
					maxPosition++;
					bubbleUpMax(maxPosition, maxHeap);
				}
				double median = minHeap.size() > maxHeap.size()?minHeap.get(1):(((double)(minHeap.get(1)+maxHeap.get(1)))/2);
				System.out.println(median);
			}
		}
	}

	private static void bubbleUpMax(int position, List<Integer> maxHeap) {
		while (position > 0 && maxHeap.get(position / 2) < maxHeap.get(position)) {
			swap(position, position / 2, maxHeap);
			position = position / 2;
		}
		
	}

	public static void bubbleUpMin(int position, List<Integer> minHeap) {
		while (position > 0 && minHeap.get(position / 2) > minHeap.get(position)) {
			swap(position, position / 2, minHeap);
			position = position / 2;
		}
	}

	public static void sinkDownMin(int position, List<Integer> minHeap) {
		int a = minHeap.get(position);
		int smallest = position;
		if (2 * position < minHeap.size() && minHeap.get(position) > minHeap.get(2 * position)) {
			smallest = 2 * position;
		}
		if (2 * position + 1 < minHeap.size() && minHeap.get(smallest) > minHeap.get(2 * position + 1)) {
			smallest = 2 * position + 1;
		}
		if (smallest != position) {
			swap(position, smallest, minHeap);
			sinkDownMin(smallest, minHeap);
		}
	}
	public static void sinkDownMax(int position, List<Integer> maxHeap) {
		int a = maxHeap.get(position);
		int largest = position;
		if (2 * position < maxHeap.size() && maxHeap.get(position) < maxHeap.get(2 * position)) {
			largest = 2 * position;
		}
		if (2 * position + 1 < maxHeap.size() && maxHeap.get(largest) < maxHeap.get(2 * position + 1)) {
			largest = 2 * position + 1;
		}
		if (largest != position) {
			swap(position, largest, maxHeap);
			sinkDownMax(largest, maxHeap);
		}
	}

	public static void swap(int a, int b, List<Integer> minHeap) {
		int temp = minHeap.get(a);
		minHeap.set(a, minHeap.get(b));
		minHeap.set(b, temp);
	}
}
