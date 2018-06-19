/**
 * Imagine you have a special keyboard with the following keys:
 * Key 1: (A): Print one 'A' on screen.
 * Key 2: (Ctrl-A): Select the whole screen.
 * Key 3: (Ctrl-C): Copy selection to buffer.
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 * Now, you can only press the keyboard for N times (with the above four keys), find out the maximum 
 * numbers of 'A' you can print on screen.
 * Example 1:
 * Input: N = 3
 * Output: 3
 * Explanation: 
 * We can at most get 3 A's on screen by pressing following key sequence:
 * A, A, A
 * Example 2:
 * Input: N = 7
 * Output: 9
 * Explanation: 
 * We can at most get 9 A's on screen by pressing following key sequence:
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 * Note:
 * 1. 1 <= N <= 50
 * 2. Answers will be in the range of 32-bit signed integer.
 * @author wendi
 *
 */
public class FourKeysKeyboard {
	
	
	/**
	 * DP
	 * We either press 'A', or press 'CTRL+A', 'CTRL+C', and some number of 'CTRL+V's. Thus, in the 
	 * context of making N keypresses to write the letter 'A' M times, there are only two types of 
	 * moves:
	 * 1. Add (1 keypress): Add 1 to M.
	 * 2. Multiply (k+1 keypresses): Multiply M by k, where k >= 2.
	 * @param int N
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int fourKeysKeyboard(int N) {
		int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 3; j < i - 2; j++) {
                dp[i] = Math.max(dp[j] * (i - j - 1), dp[i]);
            }
        }
        return dp[N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourKeysKeyboard result = new FourKeysKeyboard();
		System.out.println(result.fourKeysKeyboard(7));
	}

}
