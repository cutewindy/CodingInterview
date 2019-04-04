package IBM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShuffleanArray {
	
	
	/**
	 * Approach2: shuffle in-place
	 * @param nums
	 * @return
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] shuffleanArrayI(int[] nums) {
		Random r = new Random();
		for (int i = nums.length - 1; i >= 0; i--) {
			int j = r.nextInt(i + 1);
			swap(nums, i, j);
		}
		return nums;
	}
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * Approach1: list
	 * @param nums
	 * @return
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int[] shuffleanArray(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num: nums) list.add(num);
		Random r = new Random();
		int[] res = new int[nums.length];
		for (int i = 0;i < nums.length; i++) {
			int index = r.nextInt(list.size());
			res[i] = list.get(index);
			list.remove(index);
		}
		return res;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShuffleanArray result = new ShuffleanArray();
		System.out.println(Arrays.toString(result.shuffleanArray(new int[] {1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(result.shuffleanArrayI(new int[] {1, 2, 3, 4, 5})));
	}

}
