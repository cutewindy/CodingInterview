/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * Tags: Array, Greedy
 * @author wendi
 *
 */
public class JumpGame {
	
	/**
	 * Method1: Greedy: maxIndex = i + nums[i], where 0<=i<nums.length.
	 * If there is a false in the process, the result will be false.
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean jumpGame(int[] nums) {
		if (nums == null || nums.length == 0) {
            return true;
        }
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (i > maxIndex) {
        		return false;
        	}
        	maxIndex = Math.max(i + nums[i], maxIndex);
//        	System.out.println(maxIndex);
        }
        return true;
	}
	
	
	/**
	 * Method2: DP(brute force)
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(1)
	 */
//	public boolean jumpGame(int[] nums) {
//		if (nums == null || nums.length == 0) {
//            return true;
//        }
//        boolean[] canJump = new boolean[nums.length];
//        canJump[0] = true;
//        for (int i = 1; i < nums.length; i++) {
//        	for (int j = 0; j < i; j++) {
//        		if (canJump[j] && j + nums[j] >= i) {
//        			canJump[i] = true;
//        			break;
//        		}
//        	}
//        }
//        return canJump[nums.length - 1];
//	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame result = new JumpGame();
		System.out.println(result.jumpGame(new int[] {2,3,1,1,4}));
		System.out.println(result.jumpGame(new int[] {3,2,1,0,4}));
	}

}
