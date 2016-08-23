import java.util.Arrays;

/**
 * Given a sorted array of integers nums and integer values a, b and c. Apply a function of the 
 * form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * Result: [-23, -5, 1, 7]
 * 
 * Tags: Math, Two Pointers
 * @author wendi
 *
 */
public class SortTransformedArray {

	/**
	 * Math + Two pointers:
	 * @param int nums, int a, int b, int c
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		if (nums == null || nums.length == 0) return new int[0];
		int[] result = new int[nums.length];
		if (a > 0) {  // open up, two ends are bigger than center
			int i = nums.length - 1;
			int start = 0;
			int end = nums.length - 1;
			while (start <= end) {
				int startNum = quadratic(nums[start], a, b, c);
				int endNum = quadratic(nums[end], a, b, c);
				if (startNum > endNum) {
					result[i] = startNum;
					start++;
				}	
				else {
					result[i] = endNum;
					end--;					
				}
				i--;
			}
		}
		else {       // open down, center is bigger than two ends
			int i = 0;
			int start = 0;
			int end = nums.length - 1;
			while (start <= end) {
				int startNum = quadratic(nums[start], a, b, c);
				int endNum = quadratic(nums[end], a, b, c);
				if (startNum < endNum) {
					result[i] = startNum;
					start++;
				}	
				else {
					result[i] = endNum;
					end--;					
				}
				i++;
			}			
		}
		return result;
	}
	
	private int quadratic(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortTransformedArray result = new SortTransformedArray();
		System.out.println(Arrays.toString(result.sortTransformedArray(new int[] {-4, -2,  2,  4}, 1, 3, 5)));
		System.out.println(Arrays.toString(result.sortTransformedArray(new int[] {-4, -2,  2,  4}, -1, 3, 5)));
	}

}
