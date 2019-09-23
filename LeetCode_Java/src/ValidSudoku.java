import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need 
 * to be validated.
 * @author wendi
 *
 */
public class ValidSudoku {
	
	/**
	 * Method3: like method2
	 * @param char[][] board
	 * @return boolean
	 * Time: O((9+9+9)*9)
	 * Space: O(9)
	 */	
    public boolean validSudokuII(char[][] board) {
        Set<Integer>[] rows = new Set[9];
        Set<Integer>[] cols = new Set[9];
        Set<Integer>[] cubes = new Set[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                rows[i] = new HashSet<>();
                cols[j] = new HashSet<>();
                cubes[i / 3 * 3 + j / 3] = new HashSet<>();
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (rows[i].contains(num) || cols[j].contains(num) || 
                		cubes[i / 3 * 3 + j / 3].contains(num)) return false;
                rows[i].add(num);
                cols[j].add(num);
                cubes[i / 3 * 3 + j / 3].add(num);
            }
        }
        return true;   
    }
	
	

	/**
	 * Method2: using set to store each row, column and cube
	 * @param char[][] board
	 * @return boolean
	 * Time: O((9+9+9)*9)
	 * Space: O(9)
	 */	
    public boolean validSudokuI(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) return false;
		// check each row
		for (int i = 0; i < 9; i++) {
			if (!helper(board, i, i + 1, 0, 9)) return false;
		}
		// check each column
		for (int j = 0; j < 9; j++) {
			if (!helper(board, 0, 9, j, j + 1)) return false;
		}
		// check each cube
		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				if (!helper(board, i, i + 3, j, j + 3)) return false;
			}
		}
		return true;
	}
	
	public boolean helper(char[][] board, int is, int ie, int js, int je) {
		Set<Character> set = new HashSet<>();
		for (int i = is; i < ie; i++) {
			for (int j = js; j < je; j++) {
				if (board[i][j] != '.' && set.contains(board[i][j])) return false;
				set.add(board[i][j]);
			}
		}
		return true;       
    }
	
	
	
	/**
	 * Method1: brute force
	 * @param char[][] board
	 * @return boolean
	 * Time: O(81*(9+9+9))
	 * Space: O(1)
	 */
	public boolean validSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) return false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!isValid(board, i, j)) return false;
			}
		}
		return true;
	}
	
	public boolean isValid(char[][] board, int row, int col) {
		if (board[row][col] == '.') return true;
		// check row
		for (int j = 0; j < 9; j++) {
			if (j == col) continue;
			if (board[row][j] == board[row][col]) return false;
		}
		// check col
		for (int i = 0; i < 9; i++) {
			if (i == row) continue;
			if (board[i][col] == board[row][col]) return false;
		}
		// check 9
		for (int i = 3 * (row / 3); i < 3 + 3 * (row / 3); i++) {
			for (int j = 3 * (col / 3); j < 3 + 3 * (col / 3); j++) {
				if (i == row && j == col) continue;
				if (board[i][j] == board[row][col]) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidSudoku result = new ValidSudoku();
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
						  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
						  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
						  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
						  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
						  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
						  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
						  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
						  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		for (char[] arr: board) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(result.validSudoku(board));
		System.out.println(result.validSudokuI(board));
	}

}
