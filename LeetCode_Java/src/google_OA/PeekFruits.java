package google_OA;

import java.util.HashMap;
import java.util.Map;

/**
 * 采水果。
 * 小红去果园采水果。有2个篮子，可以装无数个水果，但是只能装一种水果。从任意位置的树开始，往右采。遇到2种情况退出，
 * 1. 遇到第三种水果，没有篮子可以放了，
 * 2. 到头了。
 * 返回可以采摘的最多的水果个数。 比如[1,2,1,3,4,3,5,1,2] return 3。[1,2,1,2,1,2,1] return 7
 * 
 * leetcode 159
 * 
 * @author wendi
 *
 */
public class PeekFruits {
	
	/**
	 * sliding window
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int peekFruits(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Map<Integer, Integer> cnts = new HashMap<>();
		int res = 0;
		for (int start = 0, end = 0; start < nums.length; start++) {
			while (end < nums.length && (cnts.size() < 2 || cnts.containsKey(nums[end]))) {
				if (!cnts.containsKey(nums[end])) cnts.put(nums[end], 0);
				cnts.put(nums[end], cnts.get(nums[end]) + 1);
				end++;
			}
			int currRes = 0;
			for (Integer cnt: cnts.values()) currRes += cnt;
			res = Math.max(currRes, res);
			cnts.put(nums[start], cnts.get(nums[start]) - 1);
			if (cnts.get(nums[start]) == 0) cnts.remove(nums[start]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PeekFruits result = new PeekFruits();
		System.out.println(result.peekFruits(new int[] {1,2,1,3,4,3,5,1,2}));
		System.out.println(result.peekFruits(new int[] {1,2,1,2,1,2,1}));
	}

}
