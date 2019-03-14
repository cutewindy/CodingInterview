/**
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, 
 * and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase 
 * characters represent white pieces, and lowercase characters represent black pieces.
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, 
 * west, and south), then moves in that direction until it chooses to stop, reaches the edge of the 
 * board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, 
 * rooks cannot move into the same square as other friendly bishops.
 * Return the number of pawns the rook can capture in one move.
 * Example 1:
 * Input: 
 * [[".",".",".",".",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".","R",".",".",".","p"],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * In this example the rook is able to capture all the pawns.
 * Example 2:
 * Input: 
 * [[".",".",".",".",".",".",".","."],
 *  [".","p","p","p","p","p",".","."],
 *  [".","p","p","B","p","p",".","."],
 *  [".","p","B","R","B","p",".","."],
 *  [".","p","p","B","p","p",".","."],
 *  [".","p","p","p","p","p",".","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation: 
 * Bishops are blocking the rook to capture any pawn.
 * Example 3:
 * Input: 
 * [[".",".",".",".",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  ["p","p",".","R",".","p","B","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".","B",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * The rook can capture the pawns at positions b5, d6 and f5.
 * Note:
 * 1. board.length == board[i].length == 8
 * 2. board[i][j] is either 'R', '.', 'B', or 'p'
 * 3. There is exactly one cell with board[i][j] == 'R'
 * @author wendi
 *
 */
public class AvailableCapturesforRook {
	
	
	/**
	 * Brute force
	 * @param char[][] board
	 * @return int
	 * Time: O(m*n)
	 * Space: O(1)
	 */ 
    public int availableCapturesforRook(char[][] board) {
        if (board == null || board.length == 0) return 0;
        int row = -1;
        int col = -1;
        int m = board.length;
        int n = board[0].length;
        boolean found = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        
        int res = 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            for (int step = 1; step < 8; step++) {
                int i = row + step * dir[k][0];
                int j = col + step * dir[k][1];
                if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'B') break;
                if (board[i][j] == 'p') {
                    res++;
                    break;
                }
            }
        }
        return res;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvailableCapturesforRook result = new AvailableCapturesforRook();
//		System.out.println(result.availableCapturesforRook(new char[][] {{".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]}))
	}

}
