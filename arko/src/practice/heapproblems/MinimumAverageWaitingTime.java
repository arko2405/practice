package practice.heapproblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumAverageWaitingTime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			List<Integer> a = new ArrayList<>();
			List<Integer> b = new ArrayList<>();
			a.add(Integer.MIN_VALUE);
			b.add(Integer.MIN_VALUE);
			for (int i = 1; i <= n; i++) {
				a.add(sc.nextInt());
				b.add(sc.nextInt());
			}
			quicksort(1, a.size()-1,a,b);
			
			List<Integer> minHeap = new ArrayList<>();
			List<Integer> time = new ArrayList<>();
			minHeap.add(Integer.MIN_VALUE);
			time.add(Integer.MIN_VALUE);
			int minPosition = 0;
			long t = a.get(1);
			long waitTime = 0;
			for (int i = 1; i <= n; i++) {
				Integer y = a.get(i);
				Integer x = b.get(i);
				if (y <= t) {
					minHeap.add(x);
					time.add(y);
					minPosition++;
					bubbleUpMin(minPosition, minHeap, time);
				} else {
					while (minHeap.size()>1 && y > t) {
						int min = minHeap.get(1);
						int j = time.get(1);
						waitTime = waitTime + (t - j) + min;
						minHeap.set(1, minHeap.get(minPosition));
						time.set(1, time.get(minPosition));
						minHeap.remove(minPosition);
						time.remove(minPosition--);
						sinkDownMin(1, minHeap, time);
						t = t + min;
					}
					minHeap.add(x);
					time.add(y);
					minPosition++;
					bubbleUpMin(minPosition, minHeap, time);
					t=Math.max(y, t);
				}
			}
			while (minHeap.size()>1) {
				int min = minHeap.get(1);
				int j = time.get(1);
				waitTime = waitTime + (t - j) + min;
				minHeap.set(1, minHeap.get(minPosition));
				time.set(1, time.get(minPosition));
				minHeap.remove(minPosition);
				time.remove(minPosition--);
				sinkDownMin(1, minHeap, time);
				t = t + min;
			}
			System.out.println(waitTime/n);
		}
	}

	public static void bubbleUpMin(int position, List<Integer> minHeap, List<Integer> time) {
		while (position > 0 && minHeap.get(position / 2) > minHeap.get(position)) {
			swap(position, position / 2, minHeap);
			swap(position, position / 2, time);
			position = position / 2;
		}
	}

	public static void sinkDownMin(int position, List<Integer> minHeap, List<Integer> time) {
		int smallest = position;
		if (2 * position < minHeap.size() && minHeap.get(position) > minHeap.get(2 * position)) {
			smallest = 2 * position;
		}
		if (2 * position + 1 < minHeap.size() && minHeap.get(smallest) > minHeap.get(2 * position + 1)) {
			smallest = 2 * position + 1;
		}
		if (smallest != position) {
			swap(position, smallest, minHeap);
			swap(position, smallest, time);
			sinkDownMin(smallest, minHeap, time);
		}
	}

	public static void swap(int a, int b, List<Integer> minHeap) {
		int temp = minHeap.get(a);
		minHeap.set(a, minHeap.get(b));
		minHeap.set(b, temp);
	}
	
	private static void quicksort(int lower, int upper, List<Integer> a, List<Integer> b) {
		if(lower<upper){
			int q = partition(lower,upper,a,b);
			quicksort(lower, q-1,a,b);
			quicksort(q+1, upper,a,b);
		}
		
	}
	private static int partition(int lower, int upper, List<Integer> a, List<Integer> b) {
		int x= a.get(upper);
		int i=lower-1;
		for (int j = lower; j < upper; j++) {
			if(a.get(j)<=x)
			{
				i++;
				swap(i, j, a);
				swap(i, j, b);
			}
		}
		swap(i+1, upper, a);
		swap(i+1, upper, b);
		return i+1;
	}

}
/*

Tieu owns a pizza restaurant and he manages it in his own way. While in a normal restaurant, a customer is served by following the first-come, first-served rule, Tieu simply minimizes the average waiting time of his customers. So he gets to decide who is served first, regardless of how sooner or later a person comes.

Different kinds of pizzas take different amounts of time to cook. Also, once he starts cooking a pizza, he cannot cook another pizza until the first pizza is completely cooked. Let's say we have three customers who come at time t=0, t=1, & t=2 respectively, and the time needed to cook their pizzas is 3, 9, & 6 respectively. If Tieu applies first-come, first-served rule, then the waiting time of three customers is 3, 11, & 16 respectively. The average waiting time in this case is (3 + 11 + 16) / 3 = 10. This is not an optimized solution. After serving the first customer at time t=3, Tieu can choose to serve the third customer. In that case, the waiting time will be 3, 7, & 17 respectively. Hence the average waiting time is (3 + 7 + 17) / 3 = 9.

Help Tieu achieve the minimum average waiting time. For the sake of simplicity, just find the integer part of the minimum average waiting time.

Input Format

The first line contains an integer N, which is the number of customers.
In the next N lines, the ith line contains two space separated numbers Ti and Li. Ti is the time when ith customer order a pizza, and Li is the time required to cook that pizza.
Output Format

Display the integer part of the minimum average waiting time.
Constraints

1 ≤ N ≤ 105
0 ≤ Ti ≤ 109
1 ≤ Li ≤ 109
Note

The waiting time is calculated as the difference between the time a customer orders pizza (the time at which they enter the shop) and the time she is served.

Cook does not know about the future orders.

Sample Input #00

3
0 3
1 9
2 6
Sample Output #00

9
Sample Input #01

3
0 3
1 9
2 5
Sample Output #01

8
Explanation #01

Let's call the person ordering at time = 0 as A, time = 1 as B and time = 2 as C. By delivering pizza for A, C and B we get the minimum average wait time to be

(3 + 6 + 16)/3 = 25/3 = 8.33 
the integer part is 8 and hence the answer.
 
*/