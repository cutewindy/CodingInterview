import java.util.HashSet;
import java.util.Set;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class NQueensII {

	/**
	 * Method2: Backtracking: Using set to save the col(col), left diagonal(col - row), 
	 * right diagonal(col + row) of queens. If they don't have the new position of queen, then add 
	 * the new position info into them. Move to next position of queen.
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int nQueensIII(int n) {
		if (n == 0) {
			return 0;
		}
		Set<Integer> col = new HashSet<>();
		Set<Integer> lDiag = new HashSet<>();
		Set<Integer> rDiag = new HashSet<>();
		int[] result = new int[1];
 		helper(n, 0, col, lDiag, rDiag, result);
 		return result[0];
	}
	
	private void helper(int n, int row, Set<Integer> cols, Set<Integer> lDiag, Set<Integer> rDiag, int[] result) {
		if (row == n) {
			result[0]++;
			return;
		}
		for (int col = 0; col < n; col++) {
			if (cols.contains(col) || lDiag.contains(col - row) || rDiag.contains(col + row)) continue;
			cols.add(col);
			lDiag.add(col - row);
			rDiag.add(col + row);
			helper(n, row + 1, cols, lDiag, rDiag, result);
			cols.remove(col);
			lDiag.remove(col - row);
			rDiag.remove(col + row);
		}
	}
	
	
	
	/**
	 * Method1: Backtracking:(like NQueens) using int[] queensPos to save the valid position[row, col] 
	 * of queen. If next position of queen is valid
	 * (j == col || j - col == i - row || j - col == -(i - row)), 
	 * then can save new position into queen, until row == n, done.
	 * @param int n
	 * @return int 
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	private int count = 0;
	public int nQueensII(int n) {
		if (n == 0) {
			return 0;
		}
		helper(n, new int[n], 0);
		return count;
	}
	
	private void helper(int n, int[] queensPos, int row) {
		if (row == n) {
			count++;
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(queensPos, row, col)) {
				queensPos[row] = col;
				helper(n, queensPos, row + 1);
			}
		}
	}
	
	private boolean isValid(int[] queensPos, int row, int col) {
		for (int i = 0; i < row; i++) {
			int j = queensPos[i];
			if (j == col || j - col == i - row || j - col == -(i - row)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensII result = new NQueensII();
		System.out.println(result.nQueensII(4));
		System.out.println(result.nQueensIII(4));
	}

}
