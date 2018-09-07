package shuffterfly;
/**
 * partial primes ： 给你一个整数 比如说7169 让你返回最大的为prime的substring， 7169的substrings有：7，1，6，9，
 * 71，16，69，716，169，7169 让你返回 其中最大的prime 这个例子是让你返回 71，注意 最小质数是2，如果没有最大
 * prime substring 返回 0.
 * @author wendi
 *
 */
public class PartialPrimes {
	
	/**
	 * Brute force 
	 * @param int x
	 * @return int
	 * Time: O(n^3)
	 * Space: O(1)
	 */
	public int partialPrimes(String s) {
		if (s == null || s.length() == 0) return 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String subS = s.substring(i, j);
				Integer num = Integer.valueOf(subS);
				if (isPrime(num)) {
					res = Math.max(num, res);
				}
			}
		}
		return res;
	}
	
	private boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartialPrimes result = new PartialPrimes();
		System.out.println(result.partialPrimes("7169"));
	}

}
