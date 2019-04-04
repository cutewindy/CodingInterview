package IBM;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
	
	
	/**
	 * Approach4: sum
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int missingNumberIII(int[] nums) {
		int n = nums.length + 1;
		int sum = (1 + n) * n / 2;
		for (int num: nums) sum -= num;
		return sum;
	}
	
	
	/**
	 * Approach3: set
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int missingNumberII(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num: nums) set.add(num);
		for (int i = 1; i <= nums.length; i++) {
			if (!set.contains(i)) return i;
		}
		return -1;
	}
	
	
	/**
	 * Approach2: OXR
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int missingNumberI(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor ^= i + 1;
			xor ^= nums[i];
		}
		return xor ^ (nums.length + 1);
	}
	
	
	
	
	/**
	 * Approach1: array sort
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) return i + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumber result = new MissingNumber();
		System.out.println(result.missingNumberI(new int[] {3, 1, 5, 2}));
		System.out.println(result.missingNumber(new int[] {3, 1, 5, 2}));
		System.out.println(result.missingNumberII(new int[] {3, 1, 5, 2}));
		System.out.println(result.missingNumberIII(new int[] {3, 1, 5, 2}));
	}

}
