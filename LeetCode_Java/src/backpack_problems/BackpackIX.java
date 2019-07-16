package backpack_problems;
/** 
 * Lintcode 800. Backpack IX
 * You have a total of n thousand yuan, hoping to apply for a university abroad. The application is 
 * required to pay a certain fee. Give the cost of each university application and the probability 
 * of getting the University's offer, and the number of university is m. If the economy allows, you 
 * can apply for multiple universities. Find the highest probability of receiving at least one offer.
 * Example
 * Example 1:
 * 	Input:  
 * 		n = 10
 * 		prices = [4,4,5]
 * 		probability = [0.1,0.2,0.3]
 * 	Output:  0.440	
 * 	Explanation：
 * 	select the second and the third school. 
 * Example 2:
 * 	Input: 
 * 		n = 10
 * 		prices = [4,5,6]
 * 		probability = [0.1,0.2,0.3]
 * 	Output:  0.370
 * 	Explanation:
 * 	select the first and the third school.	
 * Notice
 * 0<=n<=10000,0<=m<=10000
 * @author wendi
 *
 */
public class BackpackIX {
	
	/**
	 * DP: dp[i][j]: apply from first i schools, the probability that cannot get an offer
	 * @param int n, int[] prices, double[] probability
	 * @return double
	 * Time: O(m*n)
	 * Space: O(n)
	 */
	public double backpackIX(int n, int[] prices, double[] probability) {
		int m = prices.length;
		double[][] dp = new double[2][n + 1];
		for (int i = 0; i < m; i++) probability[i] = 1 - probability[i]; // probability of no offer
		// init
		for (int j = 0; j <= n; j++) {
			dp[0][j] = 1;
		}
		// update
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (j - prices[i - 1] >= 0) dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - prices[i - 1]] * probability[i - 1], 
						                                            dp[(i - 1) % 2][j]);
				else dp[i % 2][j] = dp[(i - 1) % 2][j];
			}
		}
		return 1 - dp[m % 2][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackpackIX result = new BackpackIX();
		System.out.println(result.backpackIX(10, new int[] {4,5,6}, new double[] {0.1,0.2,0.3}));
	}

}
