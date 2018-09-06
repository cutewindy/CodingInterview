/**
 * Given two integers n and k, find how many different arrays consist of numbers from 1 to n such 
 * that there are exactly k inverse pairs.
 * We define an inverse pair as following: For ith and jth element in the array, if i < j and 
 * a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
 * Since the answer may be very large, the answer should be modulo 109 + 7.
 * Example 1:
 * Input: n = 3, k = 0
 * Output: 1
 * Explanation: 
 * Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.
 * Example 2:
 * Input: n = 3, k = 1
 * Output: 2
 * Explanation: 
 * The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 * Note:
 * 1. The integer n is in the range [1, 1000] and k is in the range [0, 1000].
 * @author wendi
 *
 */
public class KInversePairsArray {
	
	
//	Credit: "http://www.cnblogs.com/grandyang/p/7111385.html"
	
	/**
	 * DP 
	 * dp[i][j]: represent the number of permutations of (1...i) with j inverse pairs.
	 * dp[i][j] = dp[i][j - 1] + dp[i-1][j] - dp[i - 1][j - i] 
	 * @param int n, int k
	 * @return int
	 * Time: O(nk)
	 * Space: O(nk)
	 */
	public int kInversePairsArray(int n, int k) {
        if (k == 0) return 1;
		if (n <= 1) return 0;
        int mod = 1000000007;
		int[][] dp = new int[n + 1][k + 1];
		// init
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		// update
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
				if (j >= i) dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + mod) % mod;
			}
		}
		
		return dp[n][k];  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KInversePairsArray result = new KInversePairsArray();
		System.out.println(result.kInversePairsArray(3, 1));
	}

}
