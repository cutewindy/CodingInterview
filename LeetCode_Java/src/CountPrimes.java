import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * @author wendi
 *
 */
public class CountPrimes {
	

	/**
	 * Using boolean array
	 * @param int n
	 * @return int 
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int countPrimes(int n) {
		if (n < 2) return 0;
		int res = 0;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				res++;
				for (int j = 2; j * i < n; j++) {
					isPrime[j * i] = false;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrimes result = new CountPrimes();
		System.out.println(result.countPrimes(10));
	}

}
