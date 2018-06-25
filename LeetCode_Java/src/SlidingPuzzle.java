import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square 
 * represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * Given a puzzle board, return the least number of moves required so that the state of the board is 
 * solved. If it is impossible for the state of the board to be solved, return -1.
 * Examples:
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 * @author wendi
 *
 */
public class SlidingPuzzle {
	
	/**
	 * BFS
	 * Convert array to string, [[1,2,3],[4,0,5]] -> "123405", hence the corresponding potential 
	 * swap displacements are: -1, 1, -3, 3. Also note, charAt(2) and charAt(3) are not adjacent in 
	 * original 2 dimensional int array and therefore are not valid swaps.
	 * @param int[][] board
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
    public int slidingPuzzle(int[][] board) {
    	String start = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");
        String end = "123450";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int moves = 0;
        int[] d = {-3, -1, 1, 3};
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	while (size-- > 0) {
        		String curr = queue.poll();
        		if (curr.equals(end)) return moves;
        		int i = curr.indexOf('0');
        		char[] currArray = curr.toCharArray();
        		for (int k = 0; k < 4; k++) {
        			int j = i + d[k];
        			if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2) continue;
        			swap(currArray, i, j);
        			String newCurr = new String(currArray);
        			if (!visited.contains(newCurr)) {
        				queue.offer(String.valueOf(newCurr));
        				visited.add(newCurr);
        			}
        			swap(currArray, i, j);
        		}
        	}
        	moves++;
        }
        return -1;
    }	
    
    private void swap(char[] array, int i, int j) {
    	char temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingPuzzle result = new SlidingPuzzle();
		System.out.println(result.slidingPuzzle(new int[][] {{4,1,2},{5,0,3}}));
		System.out.println(result.slidingPuzzle(new int[][] {{1,2,3},{5,4,0}}));
	}

}
