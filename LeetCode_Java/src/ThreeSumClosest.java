import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given 
 * number, target. Return the sum of the three integers. You may assume that each input would have 
 * exactly one solution
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Tags: Array, Two pointers
 * @author wendi
 *
 */
public class ThreeSumClosest {

	/**
	 * Two pointers: 3 pointers to point current element, next element and the last element. If the 
	 * sum is less than target, it means we have to add a larger element so next element move to 
	 * the next. If the sum is greater, it means we have to add a smaller element so last element 
	 * move to the second last element. Keep doing this until the end. Each time compare the 
	 * difference between sum and target, if it is less than minimum difference so far, then replace 
	 * result with it, otherwise keep iterating.
	 * @param int[] nums, int target
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		for (int i = 0; i <= nums.length - 3; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == target) return sum;
				else if (sum < target) start++;
				else end--;
				if (Math.abs(target - sum) < Math.abs(target - result)) {
					result = sum;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest result = new ThreeSumClosest();
		System.out.println(result.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
		System.out.println(result.threeSumClosest(new int[] {0, 0, 0}, 1));
	}

}
