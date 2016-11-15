import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *  compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 
 * units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * Tags: Array, Stack, Two Pointers 
 * @author wendi
 *
 */
public class TrappingRainWater {

	/**
	 * Method2: Two pointers: Find the highest number in the height, then this number is the right 
	 * edge of left part and the left edge of right part. On the left part, try to find the left 
	 * edge of current height[i](excludes i). If left edge > height[i], means in this bar can trap 
	 * rain water. The same on the right part.
	 * @param int[] height
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int trappingRainWaterI(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}
		int result = 0;
		int n = height.length;
		// find the highest bar, the highest is index
		int highest = 0;
		for (int i = 1; i < n; i++) {
			if (height[highest] < height[i]) {
				highest = i;
			}
		}
		// calculate the left trapping rain water
		int leftMax = 0;
		for (int i = 0; i < highest; i++) {
			if (leftMax > height[i]) {
				result += leftMax - height[i];
			}
			else {
				leftMax = height[i];
			}
		}
		// calculate the right trapping rain water
		int rightMax = 0;
		for (int i = n - 1; i > highest; i--) {
			if (rightMax > height[i]) {
				result += rightMax - height[i];
			}
			else {
				rightMax = height[i];
			}
		}
		return result;
	}
	
	
	/**
	 * Method1: Stack: Using stack to save the left bound. when h[i]>stack.peek(), find the right bound.
	 * bottom = h[stack.pop()]
	 * left = h[stack.peek()]
	 * right = h[i]
	 * top = min(left, right)
	 * area = (top - bottom) * (right - left - 1).
	 * @param int[] height
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int trappingRainWater(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[i] < height[stack.peek()]) {
				stack.push(i);
				i++;
			}
			else if (height[i] > height[stack.peek()]) {
				int bottom = height[stack.pop()];
				if (stack.isEmpty()) continue;   // leftBount is -1 and height[-1] = 0 
				int top = Math.min(height[stack.peek()], height[i]);
				int width = i - stack.peek() - 1;
				result += (top - bottom) * width;
			}
			else i++; // when height[i] = height[stack.peek()]  pruning
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater result = new TrappingRainWater();
		System.out.println(result.trappingRainWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(result.trappingRainWaterI(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}

}
