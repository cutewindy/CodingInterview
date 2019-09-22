/**
 * 
 * @author wendi
 *
 */
public class ValidTicTacToeState {

	
	/**
	 * 
	 * @param String[] board
	 * @return boolean
	 * Time: O(M * N)
	 * Space: O(M + N)
	 */
    public boolean validTicTacToeState(String[] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int aDiag = 0;
        int cntX = 0;
        int cntO = 0;
        boolean winX = false;
        boolean winO = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    cntX++;
                    rows[i]++;
                    cols[j]++;
                    if (i + j == 2) diag++;
                    if (i == j) aDiag++;
                    if (rows[i] == 3 || cols[j] == 3 || diag == 3 || aDiag == 3) {
                        if (winO) return false;
                        winX = true;
                    }
                }
                else if (c == 'O') {
                    cntO++;
                    rows[i]--;
                    cols[j]--;
                    if (i + j == 2) diag--;
                    if (i == j) aDiag--;
                    if (rows[i] == -3 || cols[j] == -3 || diag == -3 || aDiag == -3) {
                        if (winX) return false;
                        winO = true;
                    }
                }
            }
        }
        if (winX) return cntX - 1 == cntO; // ["XXX","XOO","OO "]
        if (winO) return cntX == cntO;     // ["OXX","XOX","OXO"]
        return cntX == cntO || cntX - 1 == cntO;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidTicTacToeState result = new ValidTicTacToeState();
		System.out.println(result.validTicTacToeState(new String[] {"XOX", "O O", "XOX"}));
	}

}
