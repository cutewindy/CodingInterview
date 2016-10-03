import java.util.HashSet;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the 
 * given points.
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * Follow up:
 * Could you do better than O(n2)?
 * Hint:
 * 1. Find the smallest and largest x-value for all points.
 * 2. If there is a line then it should be at y = (minX + maxX) / 2.
 * 3. For each point, make sure that it has a reflected point in the opposite side.
 * 
 * Tags: HashTable, Math
 * @author wendi
 *
 */
public class LineReflection {
	
	class Point {
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) {   // check whether obj is object of Point
				return false;
			}
			Point that = (Point) obj;
			return this.x == that.x && this.y == that.y;
		}
		
		@Override
		public int hashCode() {
			return 41 * (41 + this.x) + this.y;
		}
	}
	
	/**
	 * HashTable: Two times iteration. First time save points in set and find the x-axis. 
	 * Second time, check whether each point has the line reflected point of x-axis.
	 * @param int[][] points
	 * @return boolean
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public boolean lineReflection(int[][] points) {
		if (points == null || points.length == 0) {
			return true;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Set<Point> set = new HashSet<>();
		for (int[] point: points) {
			max = Math.max(point[0], max);
			min = Math.min(point[0], min);
			set.add(new Point(point[0], point[1]));
		}
		double x = min + (max - min) /(double) 2;
		for (int[] point: points) {
			if (!set.contains(new Point((int)(2 * x - point[0]), point[1]))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineReflection result = new LineReflection();
		System.out.println(result.lineReflection(new int[][] {{0, 1}, {2, 1}, {-1, 0}, {3, 0}}));
	}

}
