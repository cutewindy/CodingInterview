/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits 
 * the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * Example:
 * For the given grid
		0 E 0 0
		E 0 W E
		0 E 0 0
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class BombEnemy {
	
	/**
	 * 
	 * @param int[][] grid
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int bombEnemy(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int result = 0;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BombEnemy result = new BombEnemy();
		System.out.println(result.bombEnemy(new char[][] 
				{{'0', 'E', '0', '0'}, 
				 {'E', '0', 'W', 'E'}, 
				 {'0', 'E', '0', '0'}}));
	}

}
