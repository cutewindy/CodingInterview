/**
 * The Tribonacci sequence Tn is defined as follows: 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 * Input: n = 25
 * Output: 1389537
 * Constraints:
 * 1. 0 <= n <= 37
 * 2. The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 * @author wendi
 *
 */
public class N_thTribonacciNumber {
	
	
	/**
	 * DP + rolling array
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int n_thTribonacciNumber(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] t = new int[4];
        t[1] = 1;
        t[2] = 1;
        for (int i = 3; i <= n; i++) {
            t[i % 4] = t[(i - 1) % 4] + t[(i - 2) % 4] + t[(i - 3) % 4];
        }
        return t[n % 4];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_thTribonacciNumber result = new N_thTribonacciNumber();
		System.out.println(result.n_thTribonacciNumber(4));
		System.out.println(result.n_thTribonacciNumber(25));
	}

}
