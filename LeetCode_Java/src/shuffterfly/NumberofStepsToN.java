package shuffterfly;

/**
 * 给两个操作, plus 1 或者  reverse (45 -> 54).  问给定一个整数N， 从1开始最少需要变换多少步能到N。
 * @author wendi
 *
 */
public class NumberofStepsToN {
	
	/**
	 * DP
	 * dp[i]: minimum steps of exchange from 1 to i
	 * dp[i] = min(dp[i - 1] + 1, dp[revers(i) + 1])
	 * @param int N
	 * @return int
	 * Time: O(N)
	 * Space: O(N)
	 */
	private int numberofStepsToN(int N) {
		if (N <= 1) return 0;
		int[] dp = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i <= 10 || (i & 1) == 0) continue;
			long reversI = reverse(i);
			if (reversI < i) dp[i] = Math.min(dp[(int)reversI] + 1, dp[i]);
		}
		return dp[N];
	}

	private long reverse(int n) {
		long res = 0;
		while (n != 0) {
			res = res * 10 + n % 10;
			n /= 10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofStepsToN result = new NumberofStepsToN();
		System.out.println(result.numberofStepsToN(24));
	}

}
