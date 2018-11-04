import java.util.Arrays;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as 
 * one of the numbers from 1 to 9.
 * Given the encoded message containing digits and the character '*', return the total number of 
 * ways to decode it.
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", 
 * "H", "I".
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 * Note:
 * 1. The length of the input string will fit in range [1, 105].
 * 2. The input string will only contain the character '*' and digits '0' - '9'.
 * @author wendi
 *
 */
public class DecodeWaysII {
	
	/**
	 * dp + rolling array, same like 91. dicode ways
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int numDecodings(String s) {
    	if (s == null || s.length() == 0) return 0;
    	if (s.charAt(0) == '0') return 0;
    	int n = s.length();
    	long[] dp = new long[3];
    	int mod = 1000000007;
    	// init
    	dp[0] = 1;
    	dp[1] = s.charAt(0) == '*' ? 9 : 1;
    	
    	// update
    	for (int i = 2; i <= n; i++) {
    		char curr = s.charAt(i - 1);
    		char prev = s.charAt(i - 2);
    		if (curr == '0' && prev != '1' && prev != '2' && prev != '*') return 0;
    		dp[i % 3] = 0;
    		if (curr == '*') {
    			dp[i % 3] = 9 * dp[(i - 1) % 3];
    			if (prev == '1' || prev == '*') dp[i % 3] += 9 * dp[(i - 2) % 3];
    			if (prev == '2' || prev == '*') dp[i % 3] += 6 * dp[(i - 2 ) % 3];
    		}
    		else {
    			if (curr != '0') dp[i % 3] = dp[(i - 1) % 3];
    			if (prev == '1' || prev == '*') dp[i % 3] += dp[(i - 2) % 3];
    			if ((prev == '2' || prev == '*') && curr <= '6') dp[i % 3] += dp[(i - 2) % 3];
    		}
    		dp[i % 3] %= mod;
//    		System.out.println(Arrays.toString(dp));
    	}
    	return (int)dp[n % 3];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWaysII result = new DecodeWaysII();
		System.out.println(result.numDecodings("122*3*")); 
	}

}
