/**
 * There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. 
 * Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them 
 * under the tree one by one. The squirrel can only take at most one nut at one time and can move in 
 * four directions - up, down, left and right, to the adjacent cell. The distance is represented by 
 * the number of moves.
 * Example 1:
 * Input: 
 * Height : 5
 * Width : 7
 * Tree position : [2,2]
 * Squirrel : [4,4]
 * Nuts : [[3,0], [2,5]]
 * Output: 12
 * Explanation:
 * Note:
 * 1. All given positions won't overlap.
 * 2. The squirrel can take at most one nut at one time.
 * 3. The given positions of nuts have no order.
 * 4. Height and width are positive integers. 3 <= height * width <= 10,000.
 * 5. The given positions contain at least one nut, only one tree and one squirrel.
 * @author wendi
 *
 */
public class SquirrelSimulation {
	
	
	/**
	 * Brute force
	 * The order in which the nuts are picked doesn't affect the final result, except one of the 
	 * nuts which needs to be visited first from the squirrel's starting position. For the rest of 
	 * the nuts, it is mandatory to go from the tree to the nut and then come back as well.
	 * @param int height, int width, int[] tree, int[] squirrel, int[][] nuts
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int squirrelSimulation(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int maxDiff = 0;
		int res = 0;
		for (int[] nut: nuts) {
			int dist = getDistance(nut, tree);
			maxDiff = Math.max(dist - getDistance(nut, squirrel), maxDiff);
			res += 2 * dist;
		}
		return res - maxDiff;
	}
	
	
	private int getDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquirrelSimulation result = new SquirrelSimulation();
		System.out.println(result.squirrelSimulation(5, 7, new int[] {2,2}, new int[] {4,4}, new int[][] {{3,0},{2,5}}));
	}

}
