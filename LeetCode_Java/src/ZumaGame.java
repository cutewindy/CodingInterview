
/**
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), 
 * green(G), and white(W). You also have several balls in your hand.
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost 
 * place and rightmost place). Then, if there is a group of 3 or more balls in the same color 
 * touching, remove these balls. Keep doing this until no more balls can be removed.
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot 
 * remove all the balls, output -1.
 * Examples:
 * Input: "WRRBBW", "RB"
 * Output: -1
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 * Input: "WWRRBBWW", "WRBRW"
 * Output: 2
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * Input:"G", "GGGGG"
 * Output: 2
 * Explanation: G -> G[G] -> GG[G] -> empty 
 * Input: "RBYYBBRRB", "YRBGB"
 * Output: 3
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty 
 * Note:
 * You may assume that the initial row of balls on the table won’t have any 3 or more consecutive 
 * balls with the same color.
 * The number of balls on the table won't exceed 20, and the string represents these balls is called 
 * "board" in the input.
 * The number of balls in your hand won't exceed 5, and the string represents these balls is called 
 * "hand" in the input.
 * Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 * @author wendi
 *
 */
public class ZumaGame {

	
	/**
	 * DFS
	 * @param String board, String hand
	 * @return int
	 * Time: O() m=board.lenth(),n=hand.length
	 * Space: O(1)
	 * Stack space: O(m)
	 */
    public int zumaGame(String board, String hand) {
        int[] balls = new int[26];
        for (char c: hand.toCharArray()) balls[c - 'A']++;
        int res = dfs(board, balls);
        return res == Integer.MAX_VALUE ? -1 : res;
    }	
    
    private int dfs(String board, int[] balls) {
    	if (board.length() == 0) return 0;
    	int l = 0;
    	int r = 0;
    	int res = Integer.MAX_VALUE;
    	while (l < board.length()) {
    		while (r < board.length() && board.charAt(l) == board.charAt(r)) r++;  // board[l]...board[r-1] has the same color
    		char color = board.charAt(l);
    		int needs = 3 - r + l;    //balls need to remove current consecutive balls
    		if (balls[color - 'A'] >= needs) {
    			String newBoard = update(board.substring(0, l) + board.substring(r));// remove the same color balss
    			balls[color - 'A'] -= needs;
    			int ans = dfs(newBoard, balls);
    			if (ans != -1) res = Math.min(ans + needs, res);  // find solution on new board with update balls
    			balls[color - 'A'] += needs;
    		} 
    		l = r;
    	}
    	return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    //remove consecutive balls longer than 3
    private String update(String board) {
    	int l = 0;
    	int r = 0;
    	while (l < board.length()) {
    		while (r < board.length() && board.charAt(l) == board.charAt(r)) r++;
    		if (r - l >= 3) return update(board.substring(0, l) + board.substring(r));
    		l = r;
    	}
    	return board;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZumaGame result = new ZumaGame();
		System.out.println(result.zumaGame("WRRBBW", "RB"));
		System.out.println(result.zumaGame("RBYYBBRRB", "YRBGB"));
	}

}
