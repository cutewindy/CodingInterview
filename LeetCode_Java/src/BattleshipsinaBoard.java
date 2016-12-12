/**
 * Given an 2D board, count how many different battleships are in it. The battleships are represented 
 * with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made 
 * of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent 
 * battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example: 
 * ...X
 * XXXX
 * ...X 
 * This is an invalid board that you will not receive - as battleships will always have a cell 
 * separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the 
 * board?
 * @author wendi
 *
 * Tags: 
 */
public class BattleshipsinaBoard {
	
	/**
	 * Method2: No Modification. 
	 * Going over all cells, count only those that are the "first" cell of the battleship. First 
	 * cell is defined as the most top-left cell. 
	 * Check for first cells by only counting cells that do not have an 'X' on the left and on the 
	 * top.
	 * @param char[][] board
	 * @return int
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public int battleshipsinaBoardII(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return 0;
		}
		int result = 0;
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X' 
				 && (i == 0 || board[i - 1][j] == '.') 
				 && (j == 0 || board[i][j - 1] == '.')) {
					result++;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Method1: Modify the board 
	 * @param char[][] board
	 * @return int
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public int battleshipsinaBoardI(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return 0;
		}
		int result = 0;
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					helper(board, i, j);
					result++;
				}
			}
		}
		return result;
	}
	
	public void helper(char[][] board, int row, int col) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
				|| board[row][col] != 'X') {
			return;
		}
		board[row][col] = '.';
		helper(board, row - 1, col);
		helper(board, row + 1, col);
		helper(board, row, col - 1);
		helper(board, row, col + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BattleshipsinaBoard result = new BattleshipsinaBoard();
		System.out.println(result.battleshipsinaBoardI(new char[][] {{'X', '.', '.', 'X'},
																	 {'.', '.', '.', 'X'},
																	 {'.', '.', '.', 'X'}}));
		System.out.println(result.battleshipsinaBoardI(new char[][] {{'X', '.', '.', 'X'},
																	 {'.', '.', '.', 'X'},
																	 {'.', '.', '.', 'X'}}));
	}

}
