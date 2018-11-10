package FB_onsite;
/**
 * [3, 1, -1, 2,1,2]  结果为1，[2,1,2] subarray 可以存水
 * [3, 1, 1, 2,1,2]  结果为3，subarray  [3, 1, 1, 2]  [2,1,2] 都可以存水
 * 
 * 我第一题的思路是用two pointer, 记住左／右墙的位置，碰到-1从墙到现在位置的水减掉，再reset左／右墙,其他情况正常做。
 * @author wendi
 *
 */
public class TrappingRainWaterWithV {

	/**
	 * like "42. trapping rain water" 
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int trappingRainWaterWithV(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int h = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] > nums[h]) h = i;
		}
		int res = 0;
		
		// from left to highest
		int left = 0;
		for (int i = 0; i < h; i++) {
			if (nums[i] >= nums[left]) left = i;
			else if (nums[i] == -1) {
				int index = i - 1;
				while (index > left) {
					res -= (nums[left] - nums[index]);
					index--;
				}
				left = i;
			}
			else {
				res += nums[left] - nums[i];
			}
		}
		
		// from right to highest
		int right = n - 1;
		for (int i = n - 1; i > h; i--) {
			if (nums[i] >= nums[right]) right = i;
			else if (nums[i] == -1) {
				int index = i + 1;
				while (index < right) {
					res -= (nums[right] - nums[index]);
					index++;
				}
				right = i;
			}
			else {
				res += nums[right] - nums[i];
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWaterWithV result = new TrappingRainWaterWithV();
		System.out.println(result.trappingRainWaterWithV(new int[] {2,1,2,-1,1,3,1,-1,2,1,2}));
		System.out.println(result.trappingRainWaterWithV(new int[] {3,1,1,2,1,2}));
	}

}
