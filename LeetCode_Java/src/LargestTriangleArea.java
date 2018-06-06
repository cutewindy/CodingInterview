/**
 * You have a list of points in the plane. Return the area of the largest triangle that can be 
 * formed by any 3 of the points.
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation: 
 * The five points are show in the figure below. The red triangle is the largest.
 * Notes:
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 *  -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 * @author wendi
 *
 */
public class LargestTriangleArea {
	
	
	/**
	 * Shoelace formula
	 * @param int[][] points
	 * @return double
	 * Time: O(n^3)
	 * Space: O(1)
	 */
	public double largestTriangleArea(int[][] points) {
		double res = 0;
		if (points == null || points.length == 0 || points[0].length == 0) return res;
		for (int i = 0; i < points.length - 2; i++) {
			for (int j = i + 1; j < points.length - 1; j++) {
				for (int k = j + 1; k < points.length; k++) {
					res = Math.max(getArea(points[i], points[j], points[k]), res);
				}
			}
		}
		return res;
	}

	private double getArea(int[] a, int[] b, int[] c) {
		return 1.0 / 2 * Math.abs(a[0]*b[1]+b[0]*c[1]+c[0]*a[1]-b[0]*a[1]-c[0]*b[1]-a[0]*c[1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestTriangleArea result = new LargestTriangleArea();
		System.out.println(result.largestTriangleArea(new int[][] {{0,0},{0,1},{1,0},{0,2},{2,0}}));
	}

}
