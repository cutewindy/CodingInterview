import java.util.Arrays;

/**
 * A chess knight can move as indicated in the chess diagram below:
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and 
 * the knight makes N-1 hops.  Each hop must be from one key to another numbered key.
 * Each time it lands on a key (including the initial placement of the knight), it presses the 
 * number of that key, pressing N digits total.
 * How many distinct numbers can you dial in this manner?
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 * Example 1:
 * Input: 1
 * Output: 10
 * Example 2:
 * Input: 2
 * Output: 20
 * Example 3:
 * Input: 3
 * Output: 46
 * Note:
 * 1 <= N <= 5000
 * @author wendi
 *
 */
public class KnightDialer {
	
	/**
	 * Approach2: DP, another edition base on dial
	 * @param int N
	 * @return int
	 * Time: O(k*m*n)
	 * Space: O(m*n)
	 */
    public int knightDialerI(int N) {
        if (N <= 0) return 0;
        int[][] dirt = new int[][] {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int mod = 1000000007;
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        while (--N > 0) {
        	int[] newDp = new int[10];
        	for (int i = 0; i < 10; i++) {
        		for (int j = 0; j < dirt[i].length; j++) {
        			int pos = dirt[i][j];
        			newDp[pos] = (dp[i] + newDp[pos]) % mod;
        		}
        	}
        	dp = newDp;
        }
        
        int res = 0;
        for (int i = 0; i < 10; i++) {
        	res = (dp[i] + res) % mod;
        }
        
        return res;
    }
	
	
	/**
	 * Approach1: DP
	 * dp[k][i][j]: number of ways ends on position [i][j] after k hops
	 * dp[k][i][j] = sum(dp[k - 1][i'][j'])
	 * @param int N
	 * @return int
	 * Time: O(k*m*n)
	 * Space: O(m*n)
	 */
    public int knightDialer(int N) {
        if (N <= 0) return 0;
        int m = 4;
        int n = 3;
        int[][] dp = new int[m][n];
        int[][] dirt = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        int mod = 1000000007;
        // init
        for (int[] d: dp) Arrays.fill(d, 1);
        dp[3][0] = 0;
        dp[3][2] = 0;
        
        // update
        while (--N > 0) {
        	int[][] newDp = new int[m][n];
        	for (int i = 0; i < m; i++) {
        		for (int j = 0; j < n; j++) {
        			for (int k = 0; k < 8; k++) {
        				int x = dirt[k][0] + i;
        				int y = dirt[k][1] + j;
        				if (x < 0 || x >= m || y < 0 || y >= n || x == 3 && y != 1) continue;
        				newDp[x][y] = (newDp[x][y] + dp[i][j]) % mod;
        			}
        		}
        	}
        	dp = newDp;
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		res = (dp[i][j] + res) % mod;
        	}
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightDialer result = new KnightDialer();
		System.out.println(result.knightDialer(1));
		System.out.println(result.knightDialer(2));
		System.out.println(result.knightDialer(3));
		System.out.println(result.knightDialerI(1));
		System.out.println(result.knightDialerI(2));
		System.out.println(result.knightDialerI(3));
	}

}
