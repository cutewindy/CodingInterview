import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * 1. What if the given array is already sorted? How would you optimize your algorithm? 
 *    (Two pointers)
 * 2. What if nums1's size is small compared to nums2's size? Which algorithm is better? 
 * 	  (If nums2 is sorted, using Binary Search, otherwise, using HashMap(nums1) + list)
 * 3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot 
 *    load all elements into the memory at once?
 *    (Memory records nums1 using HashMap and iterates num2 partly every time from disk)
 * 
 * Tags: BinarySearch, HashTable, Two Pointers, Sort
 * @author wendi
 *
 */
public class IntersectionofTwoArraysII {

	/**
	 * HashMap + list:
	 * @param int[] nums1, int[] nums2
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] intersectionofTwoArraysII(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
		Map<Integer, Integer> hash = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int num1: nums1) {
			if (hash.containsKey(num1)) hash.put(num1, hash.get(num1) + 1);
			else hash.put(num1, 1);
		}
		for (int num2: nums2) {
			if (hash.containsKey(num2) && hash.get(num2) > 0) {
				list.add(num2);
				hash.put(num2, hash.get(num2) - 1);
			}
		}
		int[] res = new int[list.size()];
		int i = 0;
		for (Integer num: list) {
			res[i++] = num;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionofTwoArraysII result = new IntersectionofTwoArraysII();
		System.out.println(Arrays.toString(result.intersectionofTwoArraysII(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
	}

}
