import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k 
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up:
 * Could you solve it in O(n2) runtime?
 * 
 * Tags: Array, Two Pointers
 * @author wendi
 *
 */
public class ThreeSumSmaller {

	/**
	 * Two pointers: Like 3 sum
	 * @param int[] nums, int target
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i <= nums.length - 3; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum < target) {
					result += end - start;
					start++;
				}
				else {
					end--;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumSmaller result = new ThreeSumSmaller();
		System.out.println(result.threeSumSmaller(new int[] {-2, 0, 1, 3}, 2));
	}

}
