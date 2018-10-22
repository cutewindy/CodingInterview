import java.util.LinkedList;
import java.util.Queue;

/**
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly 
 * K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right 
 * square is (N-1, N-1).
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares 
 * in a cardinal direction, then one square in an orthogonal direction.
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even 
 * if the piece would go off the chessboard) and moves there.
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. 
 * Return the probability that the knight remains on the board after it has stopped moving.
 * Example:
 * Input: 3, 2, 0, 0
 * Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * Note:
 * N will be between 1 and 25.
 * K will be between 0 and 100.
 * The knight always initially starts on the board.
 * @author wendi
 *
 */
public class KnightProbabilityinChessboard {
	
	/**
	 * Approach3: DP
	 * dp[k][x][y]: number of ways from [k-1][i][j] move to [k][x][y];
	 * dp[k][x][y] = sum(dp[k-1][i][j]), for all (i,j) can move to (x,y);
	 * ans = sum(dp[k][x][y]) / (8^K)
	 * 
	 * At every k and position i j we store the probability that the knight landed at position i j 
	 * at step k. We know that this probability is the sum of probabilities of the 8 directions in 
	 * the previous step k-1 because in the previous step all 8 of those knight's have a chance of 
	 * moving here. For example since one of the directions is 2, 1 we take the current i-2 and j-1 
	 * and add that probability/8.0 (because if the knight is currently at i-2, j-1 the chance is 
	 * only /8.0 that he'll choose this direction out of his 7 other choices).
	 * We initialize the r , c index of the k==0 board to 1, because at step 0, we already have the 
	 * knight at position r, c so the chance it lands there in 0 steps is 100%.
	 * The result is the sum of probabilities in all areas of the board in the Kth index Board.
	 * @param int N, int K, int r, int c
	 * @return double 
	 * Time: O(k*N^2)
	 * Space: O(K*N^2) -> O(N^2)
	 */
    public double knightProbabilityinChessboardII(int N, int K, int r, int c) {
//    	double[][][] dp = new double[K + 1][N][N];
    	double[][] dp = new double[N][N];
    	dp[r][c] = 1;
    	int[][] D = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    	for (int k = 1; k <= K; k++) {
    		double[][] newDp = new double[N][N];
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				for (int d = 0; d < 8; d++) {
    					int x = i + D[d][0];
    					int y = j + D[d][1];
    					if (x < 0 || x >= N || y < 0 || y >= N) continue;
    					newDp[i][j] += dp[x][y];
    				}
    			}
    		}
    		dp = newDp;
    	}
    	
    	double cnt = 0;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			cnt += dp[i][j];
    		}
    	}
    	
    	return cnt / Math.pow(8, K);  
    }

    
	/**
	 * Approach2: DFS + Memorization
	 * 分子是走完K步还在棋盘上的走法，分母是没有限制条件的总共的走法。
	 * 那么分母最好算，每步走有8种跳法，那么K步就是8的K次方种了。
	 * 关键是要求出分子，以给定位置为起始点，然后进行BFS，每步遍历8种情况，遇到在棋盘上的就计数器加1.
	 * @param int N, int K, int r, int c
	 * @return double 
	 * Time: O(8^k)
	 * Space: O(8^k)
	 */
    public double knightProbabilityinChessboardI(int N, int K, int r, int c) {
    	return 0.0;
    }
    
	/**
	 * Approach1: BFS: MLE
	 * 分子是走完K步还在棋盘上的走法，分母是没有限制条件的总共的走法。
	 * 那么分母最好算，每步走有8种跳法，那么K步就是8的K次方种了。
	 * 关键是要求出分子，以给定位置为起始点，然后进行BFS，每步遍历8种情况，遇到在棋盘上的就计数器加1.
	 * @param int N, int K, int r, int c
	 * @return double 
	 * Time: O(8^k)
	 * Space: O(8^k)
	 */
    public double knightProbabilityinChessboard(int N, int K, int r, int c) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r * N + c);
        int res = 1;
        int times = K;
        int[][] d = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        while (!queue.isEmpty() && times-- > 0) {
        	int size = queue.size();
        	int currRes = 0;
        	while (size-- > 0) {
        		int currPos = queue.poll();
        		for (int k = 0; k < 8; k++) {
        			int i = currPos / N + d[k][0];
        			int j = currPos % N + d[k][1];
        			if (i < 0 || i >= N || j < 0 || j >= N) continue;
        			currRes++;
        			queue.offer(i * N + j);
        		}
        	}
        	res = currRes;
        }
        return (double)res / Math.pow(8, K);  
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightProbabilityinChessboard result = new KnightProbabilityinChessboard();
		System.out.println(result.knightProbabilityinChessboard(3, 2, 0, 0));
		System.out.println(result.knightProbabilityinChessboardI(3, 2, 0, 0));
		System.out.println(result.knightProbabilityinChessboardII(3, 2, 0, 0));
	}

}
