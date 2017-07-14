package practice.interviewquestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Hotel {

	
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Boolean> userStringsMap = new HashMap<String, Boolean>();
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
        sentence = sentence.toLowerCase();
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

            //do all processing
            reviewSentence = reviewSentence.replace(",", " ");
            reviewSentence = reviewSentence.replace(".", " ");
            reviewSentence = reviewSentence.replace("!", " ");
            reviewSentence = reviewSentence.toLowerCase();

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

        /*List<Integer> x = new ArrayList<Integer>();
        x.add(4);x.add(1);x.add(7);x.add(2);x.add(8);x.add(3);x.add(5);x.add(6);

        Collections.sort(x, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer xv : x) {
            System.out.println(xv);
        }*/

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
		
		for(Entry<Integer, Integer> entry :listOfhotels) {
			System.out.println(entry.getKey());
		}
	}

}
