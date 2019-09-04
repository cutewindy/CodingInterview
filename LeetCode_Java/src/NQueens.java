import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no 
 * two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' 
 * and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class NQueens {

	/**
	 * Backtracking: Use an array queensPos[i]=j to save the position that has Queen.
	 * Another position (row, col) can have Queen when it satisfies j!=col && j-col!=i-row && 
	 * j-col!=-(i-row).
	 * @param int n
	 * @return List<List<String>>
	 * Time: O(n^n)
	 * Space: O(n)
	 */
	public List<List<String>> nQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n == 0) return result;
		helper(n, result, new int[n], 0);
		return result;
	}
	
	private void helper(int n, List<List<String>> result, int[] QueensPos, int row) {
		if (row == n) {
			result.add(NQueensProcess(QueensPos));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValidPos(QueensPos, row, col)) {
				QueensPos[row] = col;
				helper(n, result, QueensPos, row + 1);
			}

		}
	}
	
	private boolean isValidPos(int[] QueensPos, int row, int col) {
		System.out.println("row: " + row + " col: " + col + " " + Arrays.toString(QueensPos));
		for (int i = 0; i < row; i++) {
			int j = QueensPos[i];
			if (j == col || j - col == i - row || j - col == -(i - row)) {
				return false;
			}
		}
		return true;
	}
	
	private List<String> NQueensProcess(int[] QueensPos) {
		List<String> board = new ArrayList<>();
		for (int i = 0; i < QueensPos.length; i++) {
			StringBuilder rowBoard = new StringBuilder();
			for (int j = 0; j < QueensPos.length; j++) {
				if (j == QueensPos[i]) rowBoard.append("Q");
				else rowBoard.append(".");
			}
			board.add(rowBoard.toString());
		}
		return board;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens result = new NQueens();
		System.out.println(result.nQueens(4));
	}

}
