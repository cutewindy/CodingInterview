/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
 * transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * Tags: Array, Greedy
 * @author wendi
 *
 */
public class BestTimetoBuyandSellStockII {
	
	/**
	 * Greedy: If 3,4,5, you can say 3->5 is the best, but result of 3->4 and 4->5, which is the same.
	 * @param int[] prices
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int bestTimetoBuyandSellStockII(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int result = 0;
		int n = prices.length;
		for (int i = 1; i < n; i++) {
			if (prices[i] - prices[i - 1] > 0) {
				result += prices[i] - prices[i - 1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockII result = new BestTimetoBuyandSellStockII();
		System.out.println(result.bestTimetoBuyandSellStockII(new int[] {4, 3, 2, 1, 6, 3, 5, 2}));
	}

}
