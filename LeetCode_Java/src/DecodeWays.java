/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * Tags: DP, String
 * @author wendi
 *
 */
public class DecodeWays {
	
	/**
	 * DP: use dp[i] to record the decode ways to s[i].
	 * If s[i]==0, dp[i] = s[i-1]=='1' || s[i-1]=='2' ? dp[i-1] : 0. If it's 0, return.
	 * Otherwise, dp[i] = s[i-1]=='1' || (s[i-1]=='2'&&s[i]<'7') ? dp[i-1]+dp[i-2] : dp[i-1].
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int decodeWays(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        // init
        dp[0] = 1;
        dp[1] = 1;
        
        // update
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') return 0;
            if (s.charAt(i - 1) != '0') dp[i] = dp[i - 1];
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') dp[i] += dp[i - 2];
        }
        return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays result = new DecodeWays();
		System.out.println(result.decodeWays("22420"));
		System.out.println(result.decodeWays("22430"));
	}

}
