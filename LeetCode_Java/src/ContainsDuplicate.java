import java.util.Arrays;
import java.util.HashSet;


/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 
 * Tag: Array, HashTable
 * @author wendi
 *
 */
public class ContainsDuplicate {
	/**
	 * Method1: HashSet: iteratively save distinct value in set, if duplicate, return true
	 * @param array nums
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			else {
				set.add(nums[i]);
			}
		}
		return false;
	}
	
	/**
	 * Method2: Sorted array: sort array first, then iterate array, if nums[i]==nums[i+1], 
	 * duplicated, return true
	 * @param nums
	 * @return
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public boolean containsDuplicateI(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicate result = new ContainsDuplicate();
		int[] nums = {1, 3, 5, 2, 9};
		System.out.println(result.containsDuplicate(nums));
		System.out.println(result.containsDuplicateI(nums));

	}

}
