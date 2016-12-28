/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class BestTimetoBuyandSellStockwithCooldown {

	
	/**
	 * Method2: DP
	 * buy[i]: Max profit till index i. The series of transaction is ending with a buy.
	 * To make a decision whether to buy at i, we either take a rest, by just using the old 
	 * decision at i - 1, or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy 
	 * at i, because of cooldown.
	 * sell[i]: Max profit till index i. The series of transaction is ending with a sell.
	 * To make a decision whether to sell at i, we either take a rest, by just using the 
	 * old decision at i - 1, or buy at/before i - 1, then sell at i.
	 * @param int[] prices
	 * @return int
	 * Time: O(n)
	 * Space: O(n) can be optimize to O(1)
	 */
	public int bestTimetoBuyandSellStockwithCooldownI(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];
		// init
		buy[0] = -prices[0];
		buy[1] = Math.max(-prices[1], -prices[0]);
		sell[1] = Math.max(buy[0] + prices[1], 0);
		// update
		for (int i = 2; i < n; i++) {
			buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
			sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
		}
		return sell[n - 1];
	}
	
	/**
	 * Method1: DP
	 * 4 different states, (has0Buy, has0Cool, has1Sell, has1Cool)
	 *   i-1					i
	 * has0Cool				has0Buy   (state of has0Buy at i only can come from state of has0Cool at i-1 (make sure cooldown));
	 * has0Cool/ has1Sell	has0Cool  (state of has0Cool at i can come from state of has0Cool and has1Sell at i-1);
	 * has0Buy/ has1Cool	has1Sell  (state of has1Sell at i can come from state of has0Buy and has1Cool at i-1);
	 * has0Buy/ has1Cool	has1Cool  (state of has1Cool at i can come from state of has0Buy and has1Cool at i-1);
	 * result = max(has0Buy, has0Cool, has1Sell, has1Cool) at i=prices.length.
	 * @param int[] prices
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int bestTimetoBuyandSellStockwithCooldown(int[] prices) {
		int result = 0;
		if (prices == null || prices.length == 0) {
			return result;
		}
		// init
		int has0Buy = -prices[0];
		int has0Cool = 0;
		int has1Sell = 0;
		int has1Cool = -prices[0];
		// func
		for (int i = 1; i < prices.length; i++) {
			int has0BuyOld = has0Buy;
			int has0CoolOld = has0Cool;
			int has1SellOld = has1Sell;
			int has1CoolOld = has1Cool;
			// update states
			has0Buy = has0CoolOld - prices[i];  // make sure cooldown at i-1 by only having state has0CoolOld
			has0Cool = Math.max(has0CoolOld, has1SellOld);
			has1Sell = Math.max(has0BuyOld, has1CoolOld) + prices[i];
			has1Cool = Math.max(has0BuyOld, has1CoolOld);
		}
		return Math.max(Math.max(has0Buy, has0Cool), Math.max(has1Sell, has1Cool));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockwithCooldown result = new BestTimetoBuyandSellStockwithCooldown();
		System.out.println(result.bestTimetoBuyandSellStockwithCooldown(new int[] {1, 2, 3, 0, 2}));
		System.out.println(result.bestTimetoBuyandSellStockwithCooldownI(new int[] {1, 2, 3, 0, 2}));

	}

}
