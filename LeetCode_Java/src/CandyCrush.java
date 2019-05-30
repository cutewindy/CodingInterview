/**
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 * Given a 2D integer array board representing the grid of candy, different positive integers 
 * board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the 
 * cell at position (i, j) is empty. The given board represents the state of the game following the 
 * player's move. Now, you need to restore the board to a stable state by crushing candies according 
 * to the following rules:
 * If three or more candies of the same type are adjacent vertically or horizontally, "crush" them 
 * all at the same time - these positions become empty.
 * After crushing all candies simultaneously, if an empty space on the board has candies on top of 
 * itself, then these candies will drop until they hit a candy or bottom at the same time. (No new 
 * candies will drop outside the top boundary.)
 * After the above steps, there may exist more candies that can be crushed. If so, you need to 
 * repeat the above steps.
 * If there does not exist more candies that can be crushed (ie. the board is stable), then return 
 * the current board.
 * You need to perform the above rules until the board becomes stable, then return the current board.
 * Example 1:
 * Input:
 * board = 
 * [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],
 * [610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
 * Output:
 * [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],
 * [410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
 * Explanation: 
 * 
 * Note:
 * 1. The length of board will be in the range [3, 50].
 * 2. The length of board[i] will be in the range [3, 50].
 * 3. Each board[i][j] will initially start as an integer in the range [1, 2000].
 * @author wendi
 *
 */
public class CandyCrush {
	
	
	/**
	 * Brute force:
	 * The idea is to traverse the entire matrix again and again to remove crush until no crush can 
	 * be found.
	 * For each traversal of the matrix, we only check two directions, rightward and downward. 
	 * For each cell, if there are at least three candies of the same type rightward or downward, 
	 * set them all to its negative value to mark them.
	 * After each traversal, we need to remove all those negative values by setting them to 0, then 
	 * let the rest drop down to their correct position. A easy way is to iterate through each 
	 * column, for each column, use two pointers to move positive values to the bottom then set the 
	 * rest to 0.
	 * @param int[][] board
	 * @return int[][]
	 * Time: O(m * n)
	 * Space: O(1)
	 */
    public int[][] candyCrush(int[][] board) {
        while (true) {
            boolean foundRow = rowCrush(board);
            boolean foundCol = colCrush(board);
            if (!foundRow && !foundCol) break;
            drop(board);
        }
        return board;
    }

    private void drop(int[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            int start = board.length - 1;
            int end = board.length - 1;
            while (start >= 0 && end >= 0) {
                while (end >= 0 && board[end][j] < 0) end--;
                if (end < 0) break;
                board[start--][j] = board[end--][j];
            }
            while (start >= 0) {
                board[start--][j] = 0;
            }
        }
    }

    private boolean rowCrush(int[][] board) {
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 2;) {
                if (board[i][j] == 0 || board[i][j] != board[i][j + 1] || board[i][j] != board[i][j + 2]) {
                    j++;
                    continue;
                }
                found = true;
                int mark = board[i][j];
                for (; j < board[0].length; j++) {
                    if (board[i][j] != mark) break;
                    board[i][j] = -mark;
                }
            }
        }
        return found;
    }
    
    private boolean colCrush(int[][] board) {
        boolean found = false;
        for (int j = 0; j < board[0].length; j++) {
            for (int i = board.length - 1; i >= 2;) {
            	if (board[i][j] == 0) break;
                if (Math.abs(board[i][j]) != Math.abs(board[i - 1][j]) || Math.abs(board[i][j]) != Math.abs(board[i - 2][j])) {
                    i--;
                    continue;
                }
                found = true;
                int mark = Math.abs(board[i][j]);
                for (; i >= 0; i--) {
                    if (Math.abs(board[i][j]) != mark) break;
                    board[i][j] = -mark;
                }
            }
        }
        return found;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandyCrush result = new CandyCrush();
		int[][] board = {{110,  5,112,113,114},
						 {210,211,  5,213,214},
						 {310,311,  3,313,314},
						 {410,411,412,  5,414},
						 {  5,  1,512,  3,  3},
						 {610,  4,  1,613,614},
						 {710,  1,  2,713,714},
						 {810,  1,  2,  1,  1},
						 {  1,  1,  2,  2,  2},
						 {  4,  1,  4,  4,1014}};
		int[][] res = result.candyCrush(board);
		for (int[] row: res) {
			for (int n: row) System.out.format("%6d", n);
			System.out.println();
		}
	}

}
