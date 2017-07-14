package practice.advanced;

import java.util.HashMap;
import java.util.Map;

public class aaa {

	public static void main(String[] args) {
		Map<String, Boolean> ab = new HashMap<>();
		ab.put("abc", true);
		if(ab.get("abc") == true)
			System.out.println("1111111");
		if(ab.get("abcd") == true)
			System.out.println("2222222");
	}

}
