import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand 
 * operation which turns the water at position (row, col) into a land. Given a list of positions to 
 * operate, count the number of islands after each addLand operation. An island is surrounded by 
 * water and is formed by connecting adjacent lands horizontally or vertically. You may assume all 
 * four edges of the grid are all surrounded by water.
 * Example:
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
		0 0 0
		0 0 0
		0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
		1 0 0
		0 0 0   Number of islands = 1
		0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
		1 1 0
		0 0 0   Number of islands = 1
		0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
		1 1 0
		0 0 1   Number of islands = 2
		0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
		1 1 0
		0 0 1   Number of islands = 3
		0 1 0
 * Follow up:
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 * @author wendi
 *
 */
public class NumberofIslandsII {
	
	/**
	 * UnionFindSet
	 * @param int m, int n, int[][] positions
	 * @return List<Integer>
	 * Time: O(m*n + l) l=positions.length
	 * Space: O(m*n)
	 */
	public List<Integer> numberofIslandsII(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<>();
		int count = 0;
		int[][] grid = new int[m][n];
		UnionFindSet ufs = new UnionFindSet(m * n);
		int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		for (int[] p: positions) {
			if (grid[p[0]][p[1]] == 1) {
				res.add(count);
				continue;
			}
			count++;
			for (int k = 0; k < 4; k++) {
				int i = p[0] + dir[k][0];
				int j = p[1] + dir[k][1];
				if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) continue;
				if (ufs.union(p[0] * n + p[1], i * n + j)) count--;
			}
			grid[p[0]][p[1]] = 1;
			res.add(count);
		}
		return res;
	}
	
	
	class UnionFindSet {
		int[] parents;
		public UnionFindSet(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) parents[i] = i;
		}
		
		public int find(int x) {
			while (parents[x] != x) {
				x = parents[x];
			}
			return x;
		}
		
		public boolean union(int a, int b) {
			int pA = find(a);
			int pB = find(b);
			if (pA != pB) {
				parents[pA] = pB;
				return true;
			}
			return false;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofIslandsII result = new NumberofIslandsII();
		System.out.println(result.numberofIslandsII(3, 3, new int[][] {{0,0}, {0,1}, {1,2}, {2,1}}));
	}

}
