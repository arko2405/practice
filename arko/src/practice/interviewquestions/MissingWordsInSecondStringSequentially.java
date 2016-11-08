package practice.interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingWordsInSecondStringSequentially {

	public static void main(String[] args) {
		String s = "I am using haker to improve prog";
		String t = "am haker to improve";
		String res[] = missingWords(s, t);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}
static String [] missingWords(String s ,String t){
		
		List<String> missing = new ArrayList<>();
		String t1[]= t.split(" ");
		String s1[] = s.split(" ");
		int beginIndex=0;
		for (int i = 0; i < t1.length; i++) {
			for (int j = beginIndex; j < s1.length; j++) {
				if(t1[i].equals(s1[j])){
					for (int k = beginIndex; k < j; k++) {
						missing.add(s1[k]);
					}
					beginIndex = j+1;
					break;
				}
			}
			
		}
		for (int k = beginIndex; k < s1.length; k++) {
			missing.add(s1[k]);
		}
		String res[] = new String[missing.size()];
		for (int i = 0; i < res.length; i++) {
			res[i]=missing.get(i);
		}
		return res;
		
	}


}
