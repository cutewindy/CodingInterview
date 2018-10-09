/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins 
 * the game.
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * TicTacToe toe = new TicTacToe(3);
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 * @author wendi
 *
 */
public class DesignTicTacToe {
	
	/**
	 * Record the number of moves for each rows, columns, and two diagonals.
	 * For each move, we -1 for each player 1's move and +1 for player 2's move.
	 * Then we just need to check whether any of the recored numbers equal to n or -n.
	 * Time: O(1)
	 * Space: O(n)
	 */
	
	int[] rows;
	int[] cols;
	int diag;
	int revDiag;
	int n;
	public DesignTicTacToe(int n) {
		this.n = n;
		this.rows = new int[n];
		this.cols = new int[n];
		this.diag = 0;
		this.revDiag = 0;
	}
	
	
    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
            0: No one wins.
            1: Player 1 wins.
            2: Player 2 wins. 
	 */
	public int move(int row, int col, int player) {
	    int score = player == 1 ? -1 : 1;     // player1: -1, player2: +1, when score==n, player win
	    rows[row] += score;
	    cols[col] += score;
	    if (row == n - col - 1) diag += score;
	    if (row == col) revDiag += score;
	    if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
	    	Math.abs(diag) == n || Math.abs(revDiag) == n) return player;
	    return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignTicTacToe result = new DesignTicTacToe(3);
		System.out.println(result.move(0, 0, 1));
		System.out.println(result.move(0, 2, 2));
		System.out.println(result.move(2, 2, 1));
		System.out.println(result.move(1, 1, 2));
		System.out.println(result.move(2, 0, 1));
		System.out.println(result.move(1, 0, 2));
		System.out.println(result.move(2, 1, 1));
	}

}
