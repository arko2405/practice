package practice.interviewquestions;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicates {

	public static void main(String[] args) {

	}
	
	public int countDuplicates(int[] numbers){
		int count = 0 ;
		Map<Integer, Integer> nums = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if(nums.containsKey(numbers[i])){
				int c = nums.get(numbers[i]);
				if(c==1)
					count++;
				nums.put(numbers[i], c+1);
			}
			else
				nums.put(numbers[i], 1);
		}
		
		return count;
		
	}

}
