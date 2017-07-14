package practice.interviewquestions;

// Question find the smallest substring in String s that contains all chars of String word 
public class SmallestSubstringToContainAllCharsOfAString {

	public static void main(String[] args) {
		String s = "mi Name is Farmaiaairm";
		String word = "rim";
		System.out.println(getShortest(s, word));
		System.out.println(smlSubStr(s, word));

	}

	private static String getShortest(String mainString, String subString) {
		int[] count = new int[256];
		boolean[] str2 = new boolean[256];
		boolean[] taken = new boolean[mainString.length()];
		String ans = "";
		Integer min = Integer.MAX_VALUE;
		int i = 0, j = 0, m = 0, sum = subString.length();
		for (i = 0; i < subString.length(); i++) {
			count[subString.charAt(i)]++;
			str2[subString.charAt(i)] = true;
		}
		i = 0;
		while (str2[mainString.charAt(i)] != true) {
			i++;
		}
		j = i + 1;
		sum--;
		taken[i] = true;
		count[mainString.charAt(i)]--;
		while (j < mainString.length()) {
			while (sum != 0 && j < mainString.length()) {
				if (count[mainString.charAt(j)] == 0 && mainString.charAt(j) == mainString.charAt(i)) {
					count[mainString.charAt(i)]++;
					sum++;
					taken[i] = false;
					i++;
					while (str2[mainString.charAt(i)] != true)
						i++;
					if (taken[i] == false) {
						if (count[mainString.charAt(i)] != 0) {
							sum--;
							count[mainString.charAt(i)]--;
							taken[i] = true;
						}
					}
				}
				if (count[mainString.charAt(j)] != 0) {
					sum--;
					count[mainString.charAt(j)]--;
					taken[j] = true;
				}
				if (sum == 0) {
					break;
				}
				j++;

			}
			m = j - i + 1;
			if (m < min && sum == 0) {
				min = m;
				ans = mainString.substring(i, i + m);
			}
			count[mainString.charAt(i)]++;
			sum++;
			taken[i] = false;
			i++;
			while (str2[mainString.charAt(i)] != true)
				i++;
			if (taken[i] == false) {
				j--;
				if (count[mainString.charAt(i)] != 0) {
					sum--;
					count[mainString.charAt(i)]--;
					taken[i] = true;
				}
			}
			j++;
		}
		return ans;
	}

	static int smlSubStr(String s, String a) {

		int[] count = new int[256];
		int[] substr = new int[256];
		boolean[] str2 = new boolean[256];
		int i = 0, j = 0, m = 0, sum = a.length();
		for (i = 0; i < a.length(); i++) {
			count[a.charAt(i)]++;
			str2[a.charAt(i)] = true;
		}
		i = 0;
		while (str2[s.charAt(i)] != true) {
			i++;
		}
		j = i;
		while (sum != 0 && j < s.length()) {
			if (count[s.charAt(j)] != 0) {
				sum--;
				count[s.charAt(j)]--;
			}
			if (str2[s.charAt(j)]) {
				substr[s.charAt(j)]++;
			}
			if (sum == 0) {
				break;
			}
			j++;

		}
		if (j == s.length()) {
			return 0;
		}
		m = j - i + 1;
		// again update array count[] and str2[]
		for (int k = 0; k < a.length(); k++) {
			count[a.charAt(k)]++;
			str2[a.charAt(k)] = true;
		}
		// System.out.println(s.substring(i,m+i));
		j++;
		// loop for checking minimum length
		while (j < s.length()) {

			if (str2[s.charAt(j)]) {
				substr[s.charAt(j)]++;
			}
			if (s.charAt(j) == s.charAt(i)) {
				substr[s.charAt(i)]--;
				i++;
				while (str2[s.charAt(i)] != true || substr[s.charAt(i)] > count[s.charAt(i)]) {

					if (str2[s.charAt(i)]) {
						substr[s.charAt(i)]--;
					}
					i++;
				}

			}
			if (j - i + 1 < m) {
				m = j - i + 1;
			}
			j++;

		}

		//System.out.println(s.substring(i,m+i));
		return m;

	}

}
