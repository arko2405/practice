package practice.interviewquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class HotelTest {
	
	
	public static void main(String[] args) {
		Map<String, Boolean> userStringsMap = new HashMap<String, Boolean>();
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
        sentence = sentence.toLowerCase();
		String arr[] = sentence.split(" ");
		for (int i = 0; i < arr.length; i++) {
			userStringsMap.put(arr[i], true);
		}
		
		Map<Integer, Integer> hotels = new HashMap<Integer, Integer>();
		int m = Integer.parseInt(in.nextLine());
		while (m-->0) {
			int hotelId = Integer.parseInt(in.nextLine());
			int count = 0;
			String review = in.nextLine();

            //do all processing
            review = review.replace(",", " ");
            review = review.replace(".", " ");
            review = review.replace("!", " ");
            review = review.toLowerCase();

            arr = review.split(" ");
            for (int i = 0; i < arr.length; i++) {
				String s = arr[i];
				if (userStringsMap.containsKey(s)) {
					count++;
				}
			}
			
			if (hotels.containsKey(hotelId)) {
				hotels.put(hotelId, count + hotels.get(hotelId));
			} else {
				hotels.put(hotelId, count);
			}
		}

		List<Entry<Integer, Integer>> listOfhotels = new ArrayList<Entry<Integer, Integer>>();
		for (Entry<Integer, Integer> entry : hotels.entrySet()) {
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
		for (int i = 0; i < listOfhotels.size(); i++) {
			if(i==listOfhotels.size()-1)
				System.out.print(listOfhotels.get(i).getKey());
			else
				System.out.print(listOfhotels.get(i).getKey() + " ");
		}
	}
	

}
