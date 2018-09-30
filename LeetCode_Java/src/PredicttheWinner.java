import java.util.Arrays;

/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from 
 * either end of the array followed by the player 2 and then player 1 and so on. Each time a player 
 * picks a number, that number will not be available for the next player. This continues until all 
 * the scores have been chosen. The player with the maximum score wins.
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays 
 * to maximize his score.
 * Example 1:
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2. 
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then 
 * player 1 will be left with 1 (or 2). 
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
 * Hence, player 1 will never be the winner and you need to return False.
 * Example 2:
 * Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter 
 * which number player 2 choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing 
 * player1 can win.
 * Note:
 * 1. 1 <= length of the array <= 20.
 * 2. Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 * 3. If the scores of both players are equal, then player 1 is still the winner.
 * @author wendi
 *
 */
public class PredicttheWinner {
	// like 877 "Stone Game"
	/**
	 * Approach4: DP, same like approach3 but with rolling array
	 * 我能够获得的最大分数-对手能够获得的最大分数
	 * dp[i][j]: how much more scores that the first-in-action player will get from i to j than the 
	 * second player. First-in-action means whomever moves first, might not play1.
	 * @param nums
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n);
	 */
    public boolean predicttheWinnerIII(int[] nums) {
    	int n = nums.length;
    	int[][] dp = new int[2][nums.length];
    	for (int i = 0; i < n; i++) dp[i % 2][i] = nums[i];
    	for (int len = 2; len <= n; len++) {
    		for (int i = 0; i <= n - len; i++) {
    			int j = i + len - 1;
    			dp[i % 2][j] = Math.max(nums[i] - dp[(i + 1) % 2][j], nums[j] - dp[i % 2][j - 1]);
    		}
    	}
    	return dp[0][nums.length - 1] >= 0;
    }
	
	/**
	 * Approach3: DP, same like approach2
	 * 我能够获得的最大分数-对手能够获得的最大分数
	 * dp[i][j]: how much more scores that the first-in-action player will get from i to j than the 
	 * second player. First-in-action means whomever moves first, might not play1.
	 * @param nums
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n^2);
	 */
    public boolean predicttheWinnerII(int[] nums) {
    	int[][] dp = new int[nums.length][nums.length];
    	for (int i = 0; i < nums.length; i++) dp[i][i] = nums[i];
    	for (int len = 2; len <= nums.length; len++) {
    		for (int i = 0; i <= nums.length - len; i++) {
    			int j = i + len - 1;
    			dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
    		}
    	}
    	return dp[0][nums.length - 1] >= 0;
    }
    
	
	/**
	 * Approach2: DFS + Memorization (minMax)
	 * 我能够获得的最大分数-对手能够获得的最大分数
	 * @param nums
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(1);
	 * Stack space: O(n)
	 */
    public boolean predicttheWinnerI(int[] nums) {
    	int[][] dp = new int[nums.length][nums.length];
    	for (int[] d: dp) Arrays.fill(d, -1);
    	return getDifferenceScore(nums, 0, nums.length - 1, dp) >= 0;
    }
    
    private int getDifferenceScore(int[] nums, int start, int end, int[][] dp) {
    	if (start > end) return 0;
    	if (dp[start][end] != -1) return dp[start][end];
    	dp[start][end] = Math.max(nums[start] - getDifferenceScore(nums, start + 1, end, dp), 
    			nums[end] - getDifferenceScore(nums, start, end - 1, dp));
    	return dp[start][end];
    }
    
	
	/**
	 * Approach1: DFS
	 * 当前玩家赢返回true的条件就是递归调用下一个玩家输返回false。
	 * 我们需要一个变量来标记当前是第几个玩家，还需要两个变量来分别记录两个玩家的当前数字和。
	 * 在递归函数里面，如果当前数组为空了，直接比较两个玩家的当前得分返回当前玩家是否胜利。
	 * 如果数组有多个数字，分别取首元素，或尾元素，然后根据玩家标识分别调用不同的递归，只要下一个玩家两种情况中任意一种返回
	 * false了，那么当前玩家就可以赢了，
	 * @param nums
	 * @return boolean
	 * Time: O(2^n)
	 * Space: O(1);
	 * Stack space: O(n)
	 */
    public boolean predicttheWinner(int[] nums) {
    	if (nums == null || nums.length <= 1) return true;
        return dfs(nums, 0, nums.length - 1, 0, 0, 1);
    }
    
    private boolean dfs(int[] nums, int start, int end, int sum1, int sum2, int turn) {
        if (start > end) {
            if (turn == 1) return sum1 >= sum2;
            if (turn == 2) return sum1 < sum2;
        }
        if (turn == 1) {
            return !dfs(nums, start + 1, end, sum1 + nums[start], sum2, 2) || 
                !dfs(nums, start, end - 1, sum1 + nums[end], sum2, 2);
        }
        else {
            return !dfs(nums, start + 1, end, sum1, sum2 + nums[start], 1) ||
                !dfs(nums, start, end - 1, sum1, sum2 + nums[end], 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PredicttheWinner result = new PredicttheWinner();
		System.out.println(result.predicttheWinner(new int[] {1, 5, 2}));
		System.out.println(result.predicttheWinner(new int[] {1, 5, 233, 7}));
		System.out.println(result.predicttheWinnerI(new int[] {1, 5, 2}));
		System.out.println(result.predicttheWinnerI(new int[] {1, 5, 233, 7}));
		System.out.println(result.predicttheWinnerII(new int[] {1, 5, 2}));
		System.out.println(result.predicttheWinnerII(new int[] {1, 5, 233, 7}));
		System.out.println(result.predicttheWinnerIII(new int[] {1, 5, 2}));
		System.out.println(result.predicttheWinnerIII(new int[] {1, 5, 233, 7}));
	}

}
