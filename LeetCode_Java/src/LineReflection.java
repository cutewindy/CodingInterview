import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * Follow up:
 * Could you do better than O(n2)?
 * Hint:
 * Find the smallest and largest x-value for all points.
 * If there is a line then it should be at y = (minX + maxX) / 2.
 * For each point, make sure that it has a reflected point in the opposite side.
 * 
 * Tags: HashTable, Math
 * @author wendi
 *
 */
public class LineReflection {
	
	/**
	 * Brute Force:
	 * @param int[][] points
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public boolean lineReflection(int[][] points) {
		if (points == null || points.length == 0) {
			return true;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int[] point: points) {
			min = Math.min(point[0], min);
			max = Math.max(point[0], max);
		}
		float x = ((float)max + (float)min) / 2;
//		System.out.println(min);
//		System.out.println(x);
		for (int i = 0; i < points.length; i++) {
		    if (points[i][0] == x) continue;  // [1][0]
			boolean find = false;
			for (int j = 0; j < points.length; j++) {
				if (j == i) continue;
				if (points[j][1] == points[i][1] && Math.abs(points[j][0] - x) == Math.abs(points[i][0] - x)) {
					find = true;
				}
			}
			if (!find) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineReflection result = new LineReflection();
		System.out.println(result.lineReflection(new int[][] {{0, 0}, {1, 0}}));
		System.out.println(result.lineReflection(new int[][] {{0, 1}, {2, 1}, {-1, 0}, {3, 0}}));
	}

}
