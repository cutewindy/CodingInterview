/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Tags: Array, Greedy
 * @author wendi
 *
 */
public class JumpGameII {

	/**
	 * Greedy: use currReach to record the farthest index that can jump when count is min one.
	 * If currReach can not jump to current index, update currReach as maxReach.
	 * Then update maxReach by maxReach = max(i + nums[i], maxReach).
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int jumpGameII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxReach = nums[0];
		int currReach = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > maxReach) {
				return -1;
			}
			if (i > currReach) {
				currReach = maxReach;
				count++;
			}
			maxReach = Math.max(i + nums[i], maxReach);
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGameII result = new JumpGameII();
		System.out.println(result.jumpGameII(new int[] {2,3,1,1,4}));
		System.out.println(result.jumpGameII(new int[] {3,2,1,0,4}));
	}

}
