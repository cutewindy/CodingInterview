/**
 * You are given coins of different denominations and a total amount of money. Write a function to 
 * compute the number of combinations that make up that amount. You may assume that you have 
 * infinite number of each kind of coin.
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 * Input: amount = 10, coins = [10] 
 * Output: 1
 * Note:
 * You can assume that
 * 1. 0 <= amount <= 5000
 * 2. 1 <= coin <= 5000
 * 3. the number of coins is less than 500
 * 4. the answer is guaranteed to fit into signed 32-bit integer
 * @author wendi
 *
 */
public class CoinChange2 {
	
	
	/**
	 * 多重背包
	 * @param int amount, int[] coins
	 * @return int
	 * Time: O(n * amount) n = coins.length
	 * Space: O(1) rolling array
	 */
    public int coinChange2(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins == null || coins.length == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[2][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (j >= coins[i - 1]) dp[i % 2][j] += dp[i % 2][j - coins[i - 1]];
            }
        }
        return dp[n % 2][amount];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange2 result = new CoinChange2();
		System.out.println(result.coinChange2(5, new int[] {1, 2 ,5}));
	}

}
