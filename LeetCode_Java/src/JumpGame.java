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
	 * Method2: DP --> Greedy: maxIndex = i + nums[i], where 0<=i<nums.length.
	 * If there is a false in the process, the result will be false.
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1) optimize dpO(n) to O(1)
	 */
	public boolean jumpGameI(int[] nums) {
		if (nums == null || nums.length == 0) return true;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (i > maxIndex) return false;
        	maxIndex = Math.max(i + nums[i], maxIndex);
        }
        return true;
	}
	
	
	/**
	 * Method1: DP(brute force)
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean jumpGame(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n) dp[i + j] = true;
                if (dp[n - 1]) return true;
            }
        }
        return false;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame result = new JumpGame();
		System.out.println(result.jumpGame(new int[] {2,3,1,1,4}));
//		System.out.println(result.jumpGame(new int[] {3,2,1,0,4}));
		System.out.println(result.jumpGameI(new int[] {2,3,1,1,4}));
	}

}
