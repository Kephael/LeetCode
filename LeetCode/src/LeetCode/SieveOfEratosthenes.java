package LeetCode;
/*
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * Finds prime numbers in O(N^2) time and O(N) space
 */
public class SieveOfEratosthenes {
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
		boolean[] primeArr = sieve(30);
		for (int i = 2; i < primeArr.length; i++) {
			if (primeArr[i]) {
				System.out.println(i);
			}
		}
	}

}
