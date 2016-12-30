import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a 
 * function to compute the fewest number of coins that you need to make up that amount. If that 
 * amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class CoinChange {
	
	/**
	 * DP: 
	 * dp[i]: min number of coins that need to make up i. (0 <= i <= amount)
	 * dp[i] = min(dp[i - coins[j]] + 1, dp[i]);
	 * @param int[] coins, int amount
	 * @return int
	 * Time: O(n*amount)
	 * Space: O(amount)
	 */
	public int coinChange(int[] coins, int amount) {
		if (amount == 0) return 0;
		if (coins == null || coins.length == 0) return -1;
		Arrays.sort(coins);
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin: coins) {
				if (i - coin < 0) break;
				else if (dp[i - coin] != -1 && (dp[i] == -1 || dp[i - coin] + 1 < dp[i])) {
					dp[i] = dp[i - coin] + 1;
				}
			}
		}
		return dp[amount];
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange result = new CoinChange();
		System.out.println(result.coinChange(new int[] {1, 2, 5}, 11));
//		System.out.println(result.coinChange(new int[] {2}, 3));

	}

}
