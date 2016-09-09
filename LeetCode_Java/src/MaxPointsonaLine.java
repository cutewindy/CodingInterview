import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Tags: HashTable, Math
 * @author wendi
 *
 */
class Point {
	int x;
	int y;
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MaxPointsonaLine {
	
	/**
	 * HashTable:
	 * Given point A, we need to calculate all slopes between A and other points. 
	 * There will be three cases:
	 * Case 1: Some other point is the same as point A.
	 * Case 2: Some other point has the same x coordinate as point A, which will result to a positive 
	 * 		   infinite slope.
	 * Case 3: General case. We can calculate slope.
	 * We can store all slopes in a hash table. And we find which slope shows up mostly. Then add 
	 * the number of same points to it. Then we know the maximum number of points on the same line 
	 * for point A.
	 * We can do the same thing to point B, point C... 
	 * Finally, just return the maximum result among point A, point B, point C...
	 * @param Point[] points
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int maxPointsonaLine(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int global = 0;
		for (int i = 0; i < points.length; i++) {   // choose points[i] as center to calculate all dup, ver and slops
			int local = 0;
			int duplicates = 0;
			int verticals = 0;
			Map<Double, Integer> hash = new HashMap<>();
			for (int j = i; j < points.length; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					duplicates++;
				}
				else if (points[j].x == points[i].x) {
					verticals++;
				}
				else {
					double slop = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
					if (slop == -0.0) {
						slop = 0.0;
					}
					if (hash.containsKey(slop)) {
						hash.put(slop, hash.get(slop) + 1);
					}
					else {
						hash.put(slop, 1);
					}
					local = Math.max(hash.get(slop), local);
				}
			}
			local = Math.max(verticals, local) + duplicates;
			global = Math.max(local, global);
		}
		return global;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPointsonaLine result = new MaxPointsonaLine();
//		Point[] points = {new Point(0, 0), new Point(2, 2), new Point(-1, 0), new Point(-1, 2), 
//						  new Point(1, 1), new Point(3, 3), new Point(0, 1), new Point(0, 0),
//						  new Point(0, 2), new Point(0, 0)};
		Point[] points = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
		System.out.println(result.maxPointsonaLine(points));
	}

}
