
/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways 
 * can you climb to the top?
 * @author wendi
 * Tag: DP
 */
public class ClimbingStairs {
	
	/**
	 * DP: Only two ways to climb the ith stairs, from stairs i-1 and stairs i-2.
	 * dp[i] = dp[i-1] + dp[i-2].
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(n) can improve to O(1) by using rolling array
	 */
	public int climbingStairs(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[n % 3];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs result = new ClimbingStairs();
		System.out.println(result.climbingStairs(4));
	}

}
