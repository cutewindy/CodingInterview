import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar 
 * is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * 
 * Tags: Array, Stack
 * @author wendi
 *
 */
public class LargestRectangleinHistogram {

	/**
	 * Stack: Increasing order to save the index, then the left bound is next level in stack.
	 * If heights[i] < heights[stack.peek()], then find the right bound.
	 * Thus, right = i, height = stack.pop(), left = stack.peek(),
	 * Area = (right - left - 1) * height;
	 * @param int[] heights
	 * @return int
	 * Time: T(n)
	 * Space: O(n)
	 */
	public int largestRectangleinHistogram(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i <= heights.length) {
			int h = i == heights.length ? 0 : heights[i];
			if (stack.isEmpty() || h > heights[stack.peek()]) {
				stack.push(i);
				i++;
			}
			else {
				int right = i;
				int height = heights[stack.pop()];
				int left = !stack.isEmpty() ? stack.peek() : -1;
				result = Math.max((right - left - 1) * height, result);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleinHistogram result = new LargestRectangleinHistogram();
		System.out.println(result.largestRectangleinHistogram(new int[] {2,1,5,6,2,3}));
		System.out.println(result.largestRectangleinHistogram(new int[] {1, 2, 3, 4, 1}));
	}

}
