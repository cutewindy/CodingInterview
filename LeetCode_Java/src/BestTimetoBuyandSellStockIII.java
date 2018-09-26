/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before 
 * you buy again).
 * 
 * Tags: Array, DP
 * @author wendi
 *
 */
public class BestTimetoBuyandSellStockIII {
	
	/**
	 * DP, two pass
	 * @param int[] prices
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int bestTimetoBuyandSellStockIIII(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[] dp = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);
            min = Math.min(prices[i], min);
        }
        int max = prices[n - 1];
        int res = dp[n - 1]; // take care, eg: [1, 2, 3, 4, 5]
        for (int i = n - 2; i >= 0; i--) {
            dp[i] += Math.max(max - prices[i + 1], 0);
            max = Math.max(prices[i], max);
            res = Math.max(dp[i], res);
        }
        return res;		
	}
	
	
	/**
	 * DP: three pass
	 * first[i]: first max profit transaction before day i;
	 * second[i]: second max profit transaction after day i;
	 * @param int[] prices
	 * @return int
	 * Time: O(3n)
	 * Space: O(2n)
	 */
	public int bestTimetoBuyandSellStockIII(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int n = prices.length;
		// first max profit transaction 
		int[] first = new int[n];
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			first[i] = Math.max(prices[i] - min, first[i - 1]);
			min = Math.min(prices[i], min);
		}
		// second max profit transaction
		int[] second = new int[n];
		int max = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			second[i] = Math.max(max - prices[i], second[i + 1]);
			max = Math.max(prices[i], max);
		}
		// mas result at i
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			result = Math.max(first[i] + second[i], result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockIII result = new BestTimetoBuyandSellStockIII();
		System.out.println(result.bestTimetoBuyandSellStockIII(new int[] {6, 1, 3, 2, 4, 7}));
		System.out.println(result.bestTimetoBuyandSellStockIIII(new int[] {6, 1, 3, 2, 4, 7}));
	}

}
