package practice.queues;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int q = sc.nextInt();
			Stack<Integer> in = new Stack<>();
			Stack<Integer> out = new Stack<>();
			while(q-->0){
				Integer x = sc.nextInt();
				if(x==1){
					in.push(sc.nextInt());
				}
				else if(x==2){
					if(out.isEmpty()){
						while(!in.isEmpty())
							out.push(in.pop());
					}
					out.pop();
				}
				else if(x==3){
					if(out.isEmpty()){
						while(!in.isEmpty())
							out.push(in.pop());
					}
					System.out.println(out.peek());
				}
			}
		}

	}

}
