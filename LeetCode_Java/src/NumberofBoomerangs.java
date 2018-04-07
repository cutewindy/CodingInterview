import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points 
 * (i, j, k) such that the distance between i and j equals the distance between i and k (the order 
 * of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points 
 * are all in the range [-10000, 10000] (inclusive).
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * Output:
 * 2
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * @author wendi
 *
 */
public class NumberofBoomerangs {
	
	
	/**
	 * HashMap
	 * @param int[][] points
	 * @return int
	 * Time: O(m * n)
	 * Space: O(m)
	 */
	public int numberofBoomerangs(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0) return 0;
		int result = 0;
		for (int[] a: points) {
			Map<Integer, Integer> counter = new HashMap<>();
			for (int[] b: points) {
				if (a == b) continue;
				int distance = getDistanceSqrt(a, b);
				if (!counter.containsKey(distance)) counter.put(distance, 0);
				counter.put(distance, counter.get(distance) + 1);
			}
			for (Integer val: counter.values()) {
				result += val * (val - 1);
			}
		}
		return result;
	}

	public int getDistanceSqrt(int[] a, int[] b) {
		if (a == b) return 0;
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		return dx * dx + dy * dy;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofBoomerangs result = new NumberofBoomerangs();
		System.out.println(result.numberofBoomerangs(new int[][] {{0,0},{1,0},{2,0}}));
	}

}
