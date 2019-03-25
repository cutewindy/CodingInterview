import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has a lamp.
 * Initially, some number of lamps are on.  lamps[i] tells us the location of the i-th lamp that is 
 * on.  Each lamp that is on illuminates every square on its x-axis, y-axis, and both diagonals 
 * (similar to a Queen in chess).
 * For the i-th query queries[i] = (x, y), the answer to the query is 1 if the cell (x, y) is 
 * illuminated, else 0.
 * After each query (x, y) [in the order given by queries], we turn off any lamps that are at cell 
 * (x, y) or are adjacent 8-directionally (ie., share a corner or edge with cell (x, y).)
 * Return an array of answers.  Each value answer[i] should be equal to the answer of the i-th query 
 * queries[i].
 * Example 1:
 * Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * Output: [1,0]
 * Explanation: 
 * Before performing the first query we have both lamps [0,0] and [4,4] on.
 * The grid representing which cells are lit looks like this, where [0,0] is the top left corner, 
 * and [4,4] is the bottom right corner:
 * 1 1 1 1 1
 * 1 1 0 0 1
 * 1 0 1 0 1
 * 1 0 0 1 1
 * 1 1 1 1 1
 * Then the query at [1, 1] returns 1 because the cell is lit.  After this query, the lamp at [0, 0] 
 * turns off, and the grid now looks like this:
 * 1 0 0 0 1
 * 0 1 0 0 1
 * 0 0 1 0 1
 * 0 0 0 1 1
 * 1 1 1 1 1
 * Before performing the second query we have only the lamp [4,4] on.  Now the query at [1,0] 
 * returns 0, because the cell is no longer lit.
 * Note:
 * 1. 1 <= N <= 10^9
 * 2. 0 <= lamps.length <= 20000
 * 3. 0 <= queries.length <= 20000
 * 4. lamps[i].length == queries[i].length == 2
 * @author wendi
 *
 */
public class GridIllumination {
	
	
	/**
	 * HashMap
	 * @param int N, int[][] lamps, int[][] queries
	 * @return int[] 
	 * Time: O()
	 * Space: O()
	 */
	public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] res = new int[queries.length];
        if (queries == null || queries.length == 0) return res;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diaMap = new HashMap<>();
        Map<Integer, Integer> disDiaMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] lamp: lamps) {
            int row = lamp[0];
            int col = lamp[1];
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
            colMap.put(col, colMap.getOrDefault(col, 0) + 1);
            diaMap.put(row + col, diaMap.getOrDefault(row + col, 0) + 1);
            disDiaMap.put(row - col, disDiaMap.getOrDefault(row - col, 0) + 1);
            set.add(row * N + col);
        }
        
        for (int k = 0; k < queries.length; k++) {
            int row = queries[k][0];
            int col = queries[k][1];
            if (rowMap.containsKey(row) || colMap.containsKey(col) || diaMap.containsKey(row + col) || disDiaMap.containsKey(row - col)) 
            	res[k] = 1;
            for (int i = row - 1; i < row + 2; i++) {
                if (i < 0 || i >= N) continue;
                for (int j = col - 1; j < col + 2; j++) {
                    if (j < 0 || j >= N) continue;
                    if (set.contains(i * N + j)) {
                        rowMap.put(i, rowMap.get(i) - 1);
                        if (rowMap.get(i) == 0) rowMap.remove(i);
                        colMap.put(j, colMap.get(j) - 1);
                        if (colMap.get(j) == 0) colMap.remove(j);
                        diaMap.put(i + j, diaMap.get(i + j) - 1);
                        if (diaMap.get(i + j) == 0) diaMap.remove(i + j);
                        disDiaMap.put(i - j, disDiaMap.get(i - j) - 1);
                        if (disDiaMap.get(i - j) == 0) disDiaMap.remove(i - j);
                        set.remove(i * N + j);
                    }
                }
            }
        }
        
        return res;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridIllumination result = new GridIllumination();
		System.out.println(Arrays.toString(result.gridIllumination(5, new int[][] {{0, 0}, {4, 4}}, new int[][] {{1, 1}, {1, 0}})));
	}

}
