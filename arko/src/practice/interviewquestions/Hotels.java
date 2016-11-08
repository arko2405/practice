package practice.interviewquestions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Hotels {

	
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Map<String, Boolean> userStringsMap = new HashMap<String, Boolean>();

		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
        sentence = processString(sentence);
		System.out.println(sentence);
		Scanner myS = new Scanner(sentence);

		while(myS.hasNext()) {
			userStringsMap.put(myS.next(), true);
		}
		
		Map<Integer, Integer> hotelReviewCountMap = new HashMap<Integer, Integer>();
		int m = Integer.parseInt(sc.nextLine());
		while (m-->0) {
			int hotelId = Integer.parseInt(sc.nextLine());
			int count = 0;
			String reviewSentence = sc.nextLine();
			reviewSentence = processString(reviewSentence);
            myS= new Scanner(reviewSentence);
			while (myS.hasNext()) {
				String s = myS.next();
				if (userStringsMap.containsKey(s)) {
					count++;
				}
			}
			
			if (hotelReviewCountMap.containsKey(hotelId)) {
				hotelReviewCountMap.put(hotelId, count + hotelReviewCountMap.get(hotelId));
			} else {
				hotelReviewCountMap.put(hotelId, count);
			}
		}

		List<Entry<Integer, Integer>> listOfhotels = new ArrayList<Entry<Integer, Integer>>();
		for (Entry<Integer, Integer> entry : hotelReviewCountMap.entrySet()) {
			listOfhotels.add(entry);
		}

        //SORT
		Collections.sort(listOfhotels, new Comparator<Entry<Integer, Integer>>() {
		    @Override
		    public int compare(final Entry<Integer, Integer> o1, final Entry<Integer, Integer> o2) {
		    	if (o1.getValue() == o2.getValue()) {
		    		return o1.getKey() - o2.getKey();
		    	}
		    	return o2.getValue() - o1.getValue();
		    }
		});
		
        for (int i =0;i<listOfhotels.size();i++) {
            if (i!=listOfhotels.size()-1) {
                System.out.print(listOfhotels.get(i).getKey() + " ");
            } else {
                System.out.print(listOfhotels.get(i).getKey());
            }
        }
	}

	private static String processString(String str) {
		char arr[] = new char[str.length()+1];
		int i;
		for (i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >=65 && c <=90) {
				arr[i] = (char)(c + 32);
			} else if (c == ',') {
				arr[i] = ' ';
			} else if (c == '.') {
				arr[i] = ' ';

			} else if (c == '!') {
				arr[i] = ' ';
			} 
			 else {
				arr[i] = c;
			}
		}
		//arr[i] = '\n';
		return new String(arr);
	}
}
