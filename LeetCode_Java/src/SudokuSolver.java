import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * A sudoku puzzle...
 * ...and its solution numbers marked in red.
 * @author wendi
 *
 */
public class SudokuSolver {
	
	/**
	 * Backtracking: Try 1 through 9 for each cell.
	 * @param char[][] board
	 * Time: O(9^81) 81 represents the number of blanks to be filled in
	 * Space: O(1)
	 */
	public void sudokuSolver(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) return;
		helper(board, 0);
	}
	
	public boolean helper(char[][] board, int index) {
		if (index > 80) return true;
		int row = index / 9;
		int col = index % 9;
		if (board[row][col] != '.') return helper(board, index + 1);
		for (char c = '1'; c <= '9'; c++) {
			if (isValid(board, row, col, c)) {
				board[row][col] = c;
				if (helper(board, index + 1)) return true;
				board[row][col] = '.';
			}	
		}
		return false;
	}	
	
	public boolean isValid(char[][] board, int row, int col, char c) {
		for (int k = 0; k < 9; k++) {
			if (board[row][k] == c || board[k][col] == c    // check row and column
			 || board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c) {  // check cube
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuSolver result = new SudokuSolver();
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
						  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
						  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
						  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
						  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
						  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
						  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
						  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
						  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		result.sudokuSolver(board);
		for (char[] arr: board) {
			System.out.println(Arrays.toString(arr));
		}
	}

}
