/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find 
 * two lines, which together with x-axis forms a container, such that the container contains the 
 * most water.
 * Note: You may not slant the container.
 * 
 * Tags: Array, Two pointers
 * @author wendi
 *
 */
public class ContainerwithMostWater {

	/**
	 * Method：Greedy+Two Pointers
	 * @param int[] height
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int containerwithMostWater(int[] height) {
		if (height == null || height.length == 0) return 0;
		int result = 0;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			result = Math.max(Math.min(height[start], height[end]) * (end - start), result);
			if (height[start] < height[end]) {
				start++;
				while (height[start] < height[start - 1]) start++;
//				while (++start < end && height[start] < height[start - 1]);
			}	
			else {
				end--;
//				while (height[end] < height[end + 1]) end--;
//				while (start < --end && height[end] < height[end + 1]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerwithMostWater result = new ContainerwithMostWater();
		System.out.println(result.containerwithMostWater(new int[] {4, 3, 1, 5, 2, 6, 5, 1}));
	}

}
