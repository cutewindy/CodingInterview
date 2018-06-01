import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one 
 * of the numbers in the set got duplicated to another number in the set, which results in repetition 
 * of one number and loss of another number.
 * Given an array nums representing the data status of this set after the error. Your task is to 
 * firstly find the number occurs twice and then find the number that is missing. Return them in the 
 * form of an array.
 * Example 1: 
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 * @author wendi
 *
 */
public class SetMismatch {
	

	/**
	 * Method2: Swap
	 * @param int[] nums
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] setMismatchII(int[] nums) {
		int[] res = {-1, -1};
		if (nums == null || nums.length == 0) return res;
		int i = 0; 
		while (i < nums.length) {
			if (i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
			else i++;
		}
		for (i = 0; i < nums.length; i++) {
			if (i + 1 != nums[i]) {
				res[0] = nums[i];
				res[1] = i + 1;
			}
		}
		return res;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
	/**
	 * Method1: Set
	 * @param int[] nums
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] setMismatchI(int[] nums) {
		int[] res = {-1, -1};
		if (nums == null || nums.length == 0) return res;
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int n: nums) {
			if (set.contains(n)) {
				res[0] = n;
				continue;
			}
			set.add(n);
			sum += n;
		}
		res[1] = (1 + nums.length) * nums.length / 2 - sum;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetMismatch result = new SetMismatch();
		System.out.println(Arrays.toString(result.setMismatchI(new int[] {1,2,2,4})));
		System.out.println(Arrays.toString(result.setMismatchII(new int[] {1,2,2,4})));
	}

}
