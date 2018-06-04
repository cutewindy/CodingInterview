import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i 
 * and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * 
 * Tags: Array, HashTable
 * @author wendi
 *
 */
public class ContainsDuplicateII {
	
	/**
	 * Method2: Set
	 * IDEA: it iterates over the array using a sliding window. The front of the window is at i, the 
	 * rear of the window is k steps back. The elements within that window are maintained using a 
	 * set. While adding new element to the set, if add() returns false, it means the element already 
	 * exists in the set. At that point, we return true. If the control reaches out of for loop, it 
	 * means that inner return true never executed, meaning no such duplicate element was found.
	 * @param int[] nums, int k
	 * @return boolean
	 * Time: O(n)
	 * Space: O(k)
	 */
	public boolean containsDuplicateII(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i - k - 1 >= 0) {
				set.remove(nums[i - k - 1]);
			}
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
	
	
	/**
	 * Method1: HashMap
	 * @param int[] nums, int k
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean containsDuplicateIII(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicateII result = new ContainsDuplicateII();
		System.out.println(result.containsDuplicateIII(new int[] {0, 1, 2, 3, 1, 5}, 3));
		System.out.println(result.containsDuplicateII(new int[] {0, 1, 2, 3, 1, 5}, 3));
	}

}
