package backpack_problems;
/**
 * Lintcode: 1538. Card Game II
 * You are playing a card game with your friends, there are n cards in total. Each card costs 
 * cost[i] and inflicts damage[i] damage to the opponent. You have a total of totalMoney dollars and 
 * need to inflict at least totalDamage damage to win. And Each card can only be used once. 
 * Determine if you can win the game.
 * Example
 * Example1
 * Input:
 * cost = [1,2,3,4,5]
 * damage = [1,2,3,4,5]
 * totalMoney = 10
 * totalDamage = 10
 * Output: true
 * Explanation: We can use the [1,4,5] to cause 10 damage, which costs 10.
 * Example2
 * Input:
 * cost = [1,2]
 * damage = [3,4]
 * totalMoney = 10
 * totalDamage = 10
 * Output: false
 * Explanation: We can only cause 7 damage at most.
 * @author wendi
 *
 */
public class CardGameII {

	
	
	/**
	 * DP
	 * 本题其实是一个背包问题，用totalMoney的花费得到的最大的收益，判断收益是否达到totalDamage即可
	 * @param int[] cost, int[] damage, int totalMoney, int totalDamage
	 * @return boolean
	 * Time: O(m*n) n = totalMoney
	 * Space: O(n)
	 */
    public boolean cardGameII(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        int m = cost.length;
        int[][] dp = new int[2][totalMoney + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= totalMoney; j++) {
                if (j - cost[i - 1] >= 0) dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j - cost[i - 1]] + damage[i - 1], dp[(i - 1) % 2][j]);
                else dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (dp[i % 2][j] >= totalDamage) return true; 
            }
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardGameII result = new CardGameII();
		System.out.println(result.cardGameII(new int[] {1,2,3,4,5}, new int[] {1,2,3,4,5}, 10, 10));
	}

}
