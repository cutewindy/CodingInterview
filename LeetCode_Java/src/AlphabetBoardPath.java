import java.util.LinkedList;
import java.util.Queue;

/**
 * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
 * a b c d e
 * f g h i j
 * k l m n o
 * p q r s t
 * u v w x y
 * z
 * We may make the following moves:
 * 'U' moves our position up one row, if the position exists on the board;
 * 'D' moves our position down one row, if the position exists on the board;
 * 'L' moves our position left one column, if the position exists on the board;
 * 'R' moves our position right one column, if the position exists on the board;
 * '!' adds the character board[r][c] at our current position (r, c) to the answer.
 * (Here, the only positions that exist on the board are positions with letters on them.)
 * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  
 * You may return any path that does so.
 * Example 1:
 * Input: target = "leet"
 * Output: "DDR!UURRR!!DDD!"
 * Example 2:
 * Input: target = "code"
 * Output: "RR!DDRR!UUL!R!"
 * Constraints:
 * 1. 1 <= target.length <= 100
 * 2. target consists only of English lowercase letters.
 * @author wendi
 *
 */
public class AlphabetBoardPath {
	
	
	/**
	 * Approach2: Math: Manhattan distance
	 * Notice that "z" is special
	 * In order to get "e", should move U first than move R, eg: "ze";
	 * In order to get "z", should move L first than move D, eg: "ez";
	 * @param String target
	 * @return String
	 * Time: O(n) n = traget.length()
	 * Space: O(1)
	 */	
    public String alphabetBoardPathI(String target) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        for (char c: target.toCharArray()) {
            int nextI = (c - 'a') / 5;
            int nextJ = (c - 'a') % 5;
            while (i > nextI) {
                res.append("U");
                i--;
            }
            while (j > nextJ) {
                res.append("L");
                j--;
            }
            while (i < nextI) {
                res.append("D");
                i++;
            }
            while (j < nextJ) {
                res.append("R");
                j++;
            }
            res.append("!");
        }
        return res.toString();
    }	
	
    
    
	/**
	 * Approach1: bfs, walk through the whole board
	 * @param String target
	 * @return String
	 * Time: O(26n) n = traget.length()
	 * Space: O(4^26)
	 */
    public String alphabetBoardPath(String target) {
        char[][] board = {{'a', 'b', 'c', 'd', 'e'}, 
                          {'f', 'g', 'h', 'i', 'j'},
                          {'k', 'l', 'm', 'n', 'o'},
                          {'p', 'q', 'r', 's', 't'},
                          {'u', 'v', 'w', 'x', 'y'},
                          {'z'}};

        int row = 0;
        int col = 0;
        StringBuilder res = new StringBuilder();
        for (char c: target.toCharArray()) {
            if (board[row][col] == c) {
                res.append("!");
                continue;
            }
            int[] pos = bfs(board, row, col, c, res);
            row = pos[0];
            col = pos[1];
        }
        return res.toString();
    }
    
    private int[] bfs(char[][] board, int row, int col, char c, StringBuilder res) {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        String[] moves = {"U", "R", "D", "L"};
        int m = 6;
        int n = 5;
        Queue<Integer> dirQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        dirQueue.offer(row * n + col);
        pathQueue.offer("");
        while (true) {
            int curr = dirQueue.poll();
            String path = pathQueue.poll();
            for (int k = 0; k < 4; k++) {
                int i = dir[k][0] + curr / n;
                int j = dir[k][1] + curr % n;
                if (i < 0 || i >= m || j < 0 || j >= n || i == m - 1 && j != 0) continue;
                String newPath = path + moves[k];
                if (board[i][j] == c) {
                    res.append(newPath).append("!");
                    return new int[] {i, j};
                }
                dirQueue.offer(i * n + j);
                pathQueue.offer(newPath);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlphabetBoardPath result = new AlphabetBoardPath();
		System.out.println(result.alphabetBoardPath("leet"));
		System.out.println(result.alphabetBoardPathI("leet"));
	}

}
