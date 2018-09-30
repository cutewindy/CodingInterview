import java.util.Arrays;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a 
 * row, and each pile has a positive integer number of stones piles[i].
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so 
 * there are no ties.
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of 
 * stones from either the beginning or the end of the row.  This continues until there are no more 
 * piles left, at which point the person with the most stones wins.
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 * Example 1:
 * Input: [5,3,4,5]
 * Output: true
 * Explanation: 
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 * Note:
 * 1. 2 <= piles.length <= 500
 * 2. piles.length is even.
 * 3. 1 <= piles[i] <= 500
 * 4. sum(piles) is odd.
 * @author wendi
 *
 */
public class StoneGame {
	
	/**
	 * Approach4: Math:
	 * 这是一个数学问题，要注意的有两点，第一，有偶数堆，第二，总数为奇数，不存在平局。所以这样想，如果有2堆，亚历克斯选一个
	 * 多的，肯定赢了，如果有4堆，平分两堆，亚历克斯每两堆中先选一堆多的，最后是亚历克斯赢，推广到2*N 堆，按照两堆来分，亚历
	 * 克斯每两堆中选择一堆多的，所以无论怎么样，亚历克斯都会赢的。
	 * @param int[] piles
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean stoneGameIII(int[] piles) {
		return true;
	}
	
	/**
	 * Approach3: DP + rolling array
	 * @param int[] piles
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
    public boolean stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) dp[i % 2][i] = piles[i];
        
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                dp[start % 2][end] = Math.max(piles[start] - dp[(start + 1) % 2][end], piles[end] - dp[start % 2][end - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
	
	
	/**
	 * Approach2: DP
	 * @param int[] piles
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n^2)
	 */
    public boolean stoneGameI(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                dp[start][end] = Math.max(piles[start] - dp[start + 1][end], piles[end] - dp[start][end - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
	
    
	/**
	 * Approach1: DFS + Memorization
	 * minmax: both you and opponent take the best move
	 * dp[i][j]: best relative score of subarray piles[i,..,j]
	 * @param int[] piles
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n^2)
	 */
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int[] d: dp) Arrays.fill(d, -1);
        return getStore(piles, 0, piles.length - 1, dp) >= 0;
    }
    
    private int getStore(int[] piles, int start, int end, int[][] dp) {
        if (start == end) return piles[start];
        if (dp[start][end] != -1) return dp[start][end];
        dp[start][end] = Math.max(piles[start] - getStore(piles, start + 1, end, dp), 
                                  piles[end] - getStore(piles, start, end - 1, dp));
        return dp[start][end];
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoneGame result = new StoneGame();
		System.out.println(result.stoneGame(new int[] {5,3,4,5}));
		System.out.println(result.stoneGameI(new int[] {5,3,4,5}));
		System.out.println(result.stoneGameII(new int[] {5,3,4,5}));
		System.out.println(result.stoneGameIII(new int[] {5,3,4,5}));
	}

}
