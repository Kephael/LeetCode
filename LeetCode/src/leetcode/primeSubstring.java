package leetcode;

import java.util.ArrayList;

public class primeSubstring {

	public static boolean[] sieve(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 2; i <= n; i++) { // Let A be an array of Boolean values, indexed by integers 2 to n, initially all set to true.
			primes[i] = true;
		}
		for (int i = 2; i <= Math.sqrt((double) n); i++) {
			if (primes[i]) {
				int count = 0;
				for (int j = i * i; j <= n; j = i * i + (i * count)) {
					primes[j] = false;
					count++;
				}
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		String value = "913211504"; // n! combinations
		int largest = Integer.parseInt(value);
		ArrayList<Integer> combinations = new ArrayList<Integer>();
		for (int i = 0; i < value.length() - 1; i++) {
			String insertVal = "" + value.charAt(i);
			combinations.add(Integer.parseInt(insertVal));
			for (int j = i + 1; j < value.length(); j++) {
				insertVal += value.charAt(j);
				combinations.add(Integer.parseInt(insertVal));
			}
		}
		boolean[] primeResults = sieve(largest);
		int largestPrime = -1;
		for (int i = 0; i < combinations.size(); i++) {
			if (primeResults[combinations.get(i)]) {
				if (combinations.get(i) > largestPrime) {
					largestPrime = combinations.get(i);
				}
			}
		}
		if (largestPrime != -1) {
			System.out.println(largestPrime);
		}
	}

}
