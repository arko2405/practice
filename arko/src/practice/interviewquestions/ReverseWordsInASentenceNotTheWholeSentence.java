package practice.interviewquestions;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsInASentenceNotTheWholeSentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			reverseWordsInASentenceNotTheWholeSentence(sc.nextLine());
		}

	}

	private static void reverseWordsInASentenceNotTheWholeSentence(String sentence) {
		Stack<Character> temp = new Stack<>();
		String newSentence = "";
		for (int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) != ' ')
				temp.push(sentence.charAt(i));
			else{
				while(!temp.isEmpty())
					newSentence += temp.pop();
				newSentence += ' ';
			}
		}
		while(!temp.isEmpty())
			newSentence += temp.pop();
		System.out.println(newSentence);
		
	}

}
