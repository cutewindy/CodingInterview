import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice 
 * and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does 
 * not count as extra space.
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 * @author wendi
 *
 */
public class FindAllNumbersDisappearedinanArray {
	
	/**
	 * Method2: iterate through the input array and mark elements as negative using 
	 * nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will be 
	 * marked as negative. In the second iteration, if a value is not marked as negative, it implies 
	 * we have never seen that index before, so just add it to the return list.
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> findAllNumbersDisappearedinanArrayI(int[] nums) {	
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) return result;
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) nums[index] = - nums[index];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) result.add(i + 1);
		}
		return result;
	}
	
	
	/**
	 * Method1: Using index and swap to find disappeared number
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> findAllNumbersDisappearedinanArray(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) return result;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
			else i++;
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] - 1 != i) result.add(i + 1);
		}
		return result;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllNumbersDisappearedinanArray result = new FindAllNumbersDisappearedinanArray();
		System.out.println(result.findAllNumbersDisappearedinanArray(new int[] {4,3,2,7,8,2,3,1}));
		System.out.println(result.findAllNumbersDisappearedinanArrayI(new int[] {4,3,2,7,8,2,3,1}));
	}

}
