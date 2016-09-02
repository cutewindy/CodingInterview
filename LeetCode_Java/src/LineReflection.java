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
		System.out.println(x);
		Map<int[], Integer> hash = new HashMap<>();
		for (int[] p: points) {
			if (p[0] == x) {
				continue;
			}
			else if (p[0] > x) {
				if (hash.containsKey(p)) {
					hash.put(p, hash.get(p) + 1);
				}
				else {
					hash.put(p, 1);
				}
			}
			else {
				int[] op = {(int)(2 * x - p[0]), p[1]};
				if (hash.containsKey(op)) {
					hash.put(op, hash.get(op) - 1);
				}
				else {
					hash.put(op, -1);
				}
			}
		}
//		Iterator it = hash.iterator();
		for (int[] p: hash.keySet()) {
			if (hash.get(p) != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineReflection result = new LineReflection();
//		System.out.println(result.lineReflection(new int[][] {{0, 0}, {1, 0}}));
		System.out.println(result.lineReflection(new int[][] {{0, 1}, {2, 1}, {-1, 0}, {3, 0}}));
	}

}
