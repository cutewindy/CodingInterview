/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given 
 * stock on day i; and a non-negative integer fee representing a transaction fee.
 * You may complete as many transactions as you like, but you need to pay the transaction fee for 
 * each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the 
 * stock share before you buy again.)
 * Return the maximum profit you can make.
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 * 1. 0 < prices.length <= 50000.
 * 2. 0 < prices[i] < 50000.
 * 3. 0 <= fee < 50000.
 * @author wendi
 *
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
	
	
	/**
	 * DP
	 * sold[i]表示第i天卖掉股票此时的最大利润，hold[i]表示第i天保留手里的股票此时的最大利润。那么我们来分析递推公式，在
	 * 第i天，如果我们要卖掉手中的股票，那么此时我们的总利润应该是前一天手里有股票的利润(不然没股票卖毛啊)，加上此时的卖出价
	 * 格，减去交易费得到的利润总值，跟前一天卖出的利润相比，取其中较大值，如果前一天卖出的利润较大，那么我们就前一天卖了，
	 * 不留到今天了。然后来看如果第i天不卖的利润，就是昨天股票卖了的利润然后今天再买入股票，得减去今天的价格，得到的值和昨天
	 * 股票保留时的利润相比，取其中的较大值，如果昨天保留股票的利润大，那么我们就继续保留到今天，所以递推时可以得到：
	 * sold[i] = max(sold[i - 1], hold[i - 1] + prices[i] - fee);
	 * hold[i] = max(hold[i - 1], sold[i - 1] - prices[i]);
	 * @param int[] prices, int fee
	 * @return T: O(n)
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int bestTimetoBuyandSellStockwithTransactionFee(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] sold = new int[2];
        int[] hold = new int[2];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            sold[i % 2] = Math.max(hold[(i - 1) % 2] + prices[i] - fee, sold[(i - 1) % 2]);
            hold[i % 2] = Math.max(sold[(i - 1) % 2] - prices[i], hold[(i - 1) % 2]);
        }
        return Math.max(sold[(n - 1) % 2], hold[(n - 1) % 2]);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockwithTransactionFee result = new BestTimetoBuyandSellStockwithTransactionFee();
		System.out.println(result.bestTimetoBuyandSellStockwithTransactionFee(new int[] {1, 3, 2, 8, 4, 9}, 2));
	}

}
