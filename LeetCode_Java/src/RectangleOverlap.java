/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its 
 * bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles 
 * that only touch at the corner or edges do not overlap.
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * Example 1:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 * @author wendi
 *
 */
public class RectangleOverlap {
	
	
	/**
	 * Check Area:
	 * If the rectangles overlap, they have positive area. This area must be a rectangle where both 
	 * dimensions are positive, since the boundaries of the intersection are axis aligned.
	 * Thus, we can reduce the problem to the one-dimensional problem of determining whether two 
	 * line segments overlap.
	 * @param int[] rec1, int[] rec2
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean rectangleOverlap(int[] rec1, int[] rec2) {
		if (rec1 == null || rec1.length == 0 || rec2 == null || rec2.length == 0) return false;
		return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) && 
				Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleOverlap result = new RectangleOverlap();
		System.out.println(result.rectangleOverlap(new int[] {0,0,2,2}, new int[] {1,1,3,3}));
	}

}
