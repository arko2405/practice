package practice.interviewquestions;

import java.util.Scanner;

public class FindNoOfZombieClusters {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			String _zombies[] = new String[n];
			for (int i = 0; i < _zombies.length; i++) {
				_zombies[i] = sc.next();
			}
			System.out.println(zombieCluster(_zombies));
		}

	}

	private static Integer zombieCluster(String[] _zombies) {
		int size = _zombies.length;
		int parents[] = new int[size];
		for (int i = 0; i < parents.length; i++) {
			parents[i]=i;
		}
		for (int i = 0; i < size; i++) {
			String temp = _zombies[i];
			for (int j = i+1; j < temp.length(); j++) {
				if(temp.charAt(j) == '1'){
					if(parents[j] != parents[i]){
						int low = Math.min(parents[i], parents[j]);
						int high = Math.max(parents[i], parents[j]);
						for (int k = 0; k < parents.length; k++) {
							if (parents[k] == high) {
								parents[k] = low;
							}
						}
					}
				}
			}
			

		}
		int count = 0;
		for (int i = 0; i < parents.length; i++) {
			if (parents[i] == i) {
				count++;
			}
		}
		return count;
	}

}
