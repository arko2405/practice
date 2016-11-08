package practice.interviewquestions;

import java.util.Scanner;

public class AliceAndHerSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			double n = sc.nextDouble();
			System.out.println((long)((Math.pow(3, n)-3*Math.pow(2, n)+3))%1000000007);
		}
	}

}
/*

Alice and her sequence
Max. Marks 100
Alice is very fond of Sequence. But she got stuck in a problem. She wants to generate sequences of length n , consisting only of numbers 1,2,3. In any sequence each number occurs atleast once.
So, she wants your help now to compute this. She has given n , the sequence of length , you have to find out how many sequences of length n , has the property which described above.
The number is so large so you need to compute answer modulo 1000000007.
Input
First line consist of number of test cases. The next t lines consist of number n the length of the sequence.
Output
You have to print the number of sequences of length n in each line consisting only of numbers 1,2,3. With each number occurs at least once.
Constraints
0<= N <= 600000
T <= 100000
Sample Input
(Plaintext Link)
5 1 2 3 4 5
Sample Output
(Plaintext Link)
0 0 6 36 150

*/