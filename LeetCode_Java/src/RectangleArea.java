/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class RectangleArea {
	
	/**
	 * Math: Calculate the area of each rectangle at first. Judge whether they have intersection. 
	 * If not, return the sum area of them. Otherwise, count the intersection area and subtract it 
	 * by one time of total area.
	 * @param int A, int B, int C, int D, int E, int F, int G, int H
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int rectangleArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int result = (C - A) * (D - B) + (G - E) * (H - F);
//		if (A >= G || C <= E || D <= F || B >= H) {  // second rectangle on the left, right, top or down, no overlap
//			return result;
//		}
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int down = Math.max(B, F);
		if (right > left && top > down) { // cannot use right-left>0 or top-down>0 to check overlap, out of Integer Range
			result -= (right - left) * (top - down);  
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleArea result = new RectangleArea();
		System.out.println(result.rectangleArea(-3, 0, 3, 4, 0, -1, 9, 2));
		System.out.println(result.rectangleArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
	}

}
