/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 * 
 * Tag: array, DP
 * @author wendi
 *
 */
public class BestTimetoBuyandSellStock {
	
	/**
	 * DP: Using minPrice save the min price before curr price, 
	 * maxPrice=max(currPrice-minPrice, maxPrice).
	 * @param int[] prices
	 * @return int
	 * Time:O(n)
	 * Space: O(1)
	 */
	public int bestTimetoBuyandSellStock(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int result = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price: prices) {
			if (price > minPrice) {
				result = Math.max(price - minPrice, result);
			}
			else {
				minPrice = price;
			}
		}		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStock result = new BestTimetoBuyandSellStock();
		int[] prices = {4, 3, 2, 1, 6, 3, 5, 2};
//		int[] prices = {2, 1};
		System.out.println(result.bestTimetoBuyandSellStock(prices));
	}

}
