import java.util.ArrayList;
import java.util.List;

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
	 * Space: O(n)
	 */
	public int climbingStairs(int n) {
		if (n <= 2) {
			return n;
		}
		List<Integer> ways = new ArrayList<Integer>();
		ways.add(0);
		ways.add(1);
		ways.add(2);
		for (int i = 3; i <= n; i++) {
			ways.add(ways.get(i - 2) + ways.get(i - 1));
		}
		return ways.get(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs result = new ClimbingStairs();
		System.out.println(result.climbingStairs(4));
	}

}
