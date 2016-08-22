import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Tag: Array, Divide & Conquer, Bit manipulation 
 * @author wendi
 *
 */
public class MajorityElement {

	/**
	 * Method3: Moore's majority vote method: 
	 * use a count to record the curr majority occurrence, 
	 * if it's equal to nums[i], count++, otherwise count--.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int majorityElementII(int[] nums) {	
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int cand = -1;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				cand = nums[i];
				count = 1;
			}
			else if (nums[i] == cand) {
				count++;
			}
			else {
				count--;
			}
		}
		// if the majority element doesn't always exist in the array
		count = 0;    
		for (int num: nums) {
			if (num == cand) count++;
		}
		return count > nums.length / 2 ? cand : -1;
	}
	
	
	/**
	 * Method2: Sorted Array: sort the nums first, then return nums[l/2]. (l=s.length).
	 * @param array nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int majorityElementI(int[] nums) {	
		if (nums == null || nums.length == 0) {
			return -1;
		}
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	
	
	/**
	 * Method1: HashMap: using a HashMap to save the occurrence of num, 
	 * if the occurrence of num > nums.length/2( or nums.lengt/2-1),
	 *  then return that num
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		HashMap<Integer, Integer> hash = new HashMap<>();
		int half = nums.length / 2;
		for (int num: nums) {
			if (hash.containsKey(num)) {
				hash.put(num, hash.get(num) + 1);
			}
			else {
				hash.put(num, 1);
			}
			if (hash.get(num) > half) {
				return num;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElement result = new MajorityElement();
//		int[] nums = {1, 2, 4, 3, 2, 2, 1, 2};
		int[] nums = {6, 5, 5};
		System.out.println(result.majorityElement(nums));
		System.out.println(result.majorityElementI(nums));
		System.out.println(result.majorityElementII(nums));


	}

}
