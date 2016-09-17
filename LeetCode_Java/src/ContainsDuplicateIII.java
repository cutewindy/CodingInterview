import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i 
 * and j is at most k.
 * 
 * Tags: Binary Search Tree
 * @author wendi
 *
 */
public class ContainsDuplicateIII {
	
	/**
	 * Method3: Bucket + HashTable: 
	 * check t: two numbers a and b
	 * 1. a and b in the same bucket, |a-b| <= t.
	 * 2. b in bucker y-1, a in bucket y, need to check whether a-b <= t.
	 * 3. a in bucket y, b in bucket y+1, need to check whether b-a <= t.
	 * @param int[] nums, int k, int t
	 * @return boolean
	 * Time: O(n)
	 * Space: O(k)
	 */
	public boolean containsDuplicateIIIII(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k == 0 || t < 0) {
			return false;
		}
		Map<Long, Integer> hash = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			// check k
			if (i - k - 1 >= 0) {
				hash.remove(((long)nums[i - k - 1] - Integer.MIN_VALUE) / ((long)t + 1));
			}
			// check t
			long bucket = ((long)nums[i] - Integer.MIN_VALUE) / ((long)t + 1);  // deal with negative number
			if (hash.containsKey(bucket) || 
				hash.containsKey(bucket - 1) && (long)nums[i] - hash.get(bucket - 1) <= t ||
				hash.containsKey(bucket + 1) && (long)hash.get(bucket + 1) - nums[i] <= t) {
				return true;
			}
			hash.put(bucket, nums[i]);
		}
		return false;
	}
	
	/**
	 * Method2: TreeSet: if the subset is not empty, means that we have the element that satisfy the 
	 * requirement, return true.
	 * @param int[] nums, int k, int t
	 * @return boolean
	 * Time: O(n*log(k))
	 * Space: O(k)
	 */
	public boolean containsDuplicateIIII(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k == 0 || t < 0) {
			return false;
		}
		TreeSet<Long> treeSet = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i - k - 1 >= 0) {
				treeSet.remove((long)nums[i - k - 1]);
			}
			if (!treeSet.subSet((long) nums[i] - t, (long) nums[i] + t + 1).isEmpty()) {
				return true;
			}
			treeSet.add((long)nums[i]);
		}
		return false;
	}
	
	
	/**
	 * Method1: Set: (Time Limit Exceeded)
	 * @param int[] nums, int k, int t
	 * @return boolean
	 * Time: O(n*k)
	 * Space: O()
	 */
	public boolean containsDuplicateIII(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i - k - 1 >= 0) {
				set.remove(nums[i - k - 1]);
			}
			for (int num: set) {
				if (Math.abs((long)nums[i] - (long)num) <= t) {
					return true;
				}
			}
			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicateIII result = new ContainsDuplicateIII();
//		System.out.println(result.containsDuplicateIII(new int[] {4, 2}, 2, 1));
//		System.out.println(result.containsDuplicateIII(new int[] {-1,2147483647}, 1, 2147483647));
//		System.out.println(result.containsDuplicateIIII(new int[] {4, 2}, 2, 1));
//		System.out.println(result.containsDuplicateIIII(new int[] {-1,2147483647}, 1, 2147483647));
//		System.out.println(result.containsDuplicateIIIII(new int[] {4, 2}, 2, 1));
		System.out.println(result.containsDuplicateIIIII(new int[] {-1,2147483647}, 1, 2147483647));
	}

}
