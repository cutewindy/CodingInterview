/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must 
 * have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 * n = 5
 * The coins can form the following rows:
		¤
		¤ ¤
		¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * n = 8
 * The coins can form the following rows:
		¤
		¤ ¤
		¤ ¤ ¤
		¤ ¤
 * Because the 4th row is incomplete, we return 3.
 * 
 * Tags: Binary Search, Math
 * @author wendi
 *
 */
public class ArrangingCoins {

	
	/**
	 * Method3: Math: find x that satisfy the following condition:1 + 2 + 3 + 4 + ... + x <= n.
	 * (1 + x) * x / 2 <=n. Using quadratic formula, we can get x = 1 / 2 (sqrt(1 + 8n) - 1), 
	 * ignoring the negative result.
	 * @param int n
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int arrangingCoinsII(int n) {
		if (n <= 0) {
			return 0;
		}	
		return (int) (0.5 * (Math.sqrt(1 + (long) 8 * n) - 1)); // take care of the range
	}	
	
	
	/**
	 * Method2: Binary Search: find x that satisfy the following condition:1 + 2 + 3 + 4 + ... + x <= n.
	 * (1 + x) * x / 2 <=n. Using binary search to find x.
	 * @param int n
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int arrangingCoinsI(int n) {
		if (n <= 0) {
			return 0;
		}	
		int start = 1;
		int end = n;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if ((1 + (long)mid) * mid * 0.5 <= n) {   // take care of the range
				start = mid;
			}
			else {
				end = mid;
			}
		}
		return (1 + (long)end) * end * 0.5 <= n ? end : start; // take care of the range
	} 
	
	
	/**
	 * Method1: Brute Force
	 * @param int n
	 * @return int
	 * Time: O(solution space)
	 * Space: O(1)
	 */
	public int arrangingCoins(int n) {
		if (n <= 0) {
			return 0;
		}
		int result = 0;
		int coins = 0;
		while (n > 0) {
			coins++;
			n -= coins;
			result++;
		}
		return n == 0 ? result : result - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrangingCoins result = new ArrangingCoins();
		System.out.println(result.arrangingCoins(5));
		System.out.println(result.arrangingCoins(6));
		System.out.println(result.arrangingCoinsI(5));
		System.out.println(result.arrangingCoinsI(1804289383));
		System.out.println(result.arrangingCoinsI(5));
		System.out.println(result.arrangingCoinsI(1804289383));
	}

}
