/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before 
 * you buy again).
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class BestTimetoBuyandSellStockIV {
	
	
	/**
	 * DP
	 * dp[i][j]: the max profit up until prices[j] using at most i transactions.
	 * dp[0, j] = 0: 0 transactions makes 0 profit.
	 * dp[i, 0] = 0: if there is only one price data point you can't make any transaction.
	 * currProfit: max profit after i-1 transactions add buy one stock before day j.
	 * dp[i][j] = max(prices[j] - prices[m] + dp[i-1][m](m=0,1,2..j-1), dp[i][j-1])
	 *          = max(prices[j] + (-prices[m] + dp[i-1][m]) (m=0,1,2..j-1), dp[i][j-1])
	 *          = max(prices[j] + currProfit, dp[i][j-1]), where currProfit = max(dp[i-1][j]-prices[j], currProfit)
	 * @param int k, int[] prices
	 * @return int
	 * Time: O(kn)
	 * Space: O(kn)
	 */
	public int bestTimetoBuyandSellStockIV(int k, int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int n = prices.length;
		// if k >= n/2, then you can make maximum number of transactions, like "BestTimetoBuyandSellStackII".
		if (k >= n / 2) {
			int result = 0;
			for (int i = 1; i < n; i++) {
				if (prices[i] > prices[i - 1]) {
					result += prices[i] - prices[i - 1];
				}
			}
			return result;
		}
		// if not k >= n/2, using dp[][]
		int[][] dp = new int[k + 1][n];
		for (int i = 1; i <= k; i++) {
			int currProfit = -prices[0];
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(currProfit + prices[j], dp[i][j - 1]);  // dp[i][j] = max(sell, not sell)
				currProfit = Math.max(dp[i - 1][j - 1] - prices[j], currProfit); // currProfit = max(buy, not buy)
			}
		}
		return dp[k][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockIV result = new BestTimetoBuyandSellStockIV();
		System.out.println(result.bestTimetoBuyandSellStockIV(3, new int[] {2, 3, 5, 2, 1, 6 ,7 ,3}));
	}

}
