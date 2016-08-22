import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The 
 * algorithm should run in linear time and in O(1) space.
 * Hint:
 * How many majority elements could it possibly have?
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class MajorityElementII {

	/**
	 * Moore's majority vote method
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> majorityElementII(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		int cand1 = -1;
		int count1 = 0;
		int cand2 = -2;
		int count2 = 0;
		for (int num: nums) {
			if (num == cand1) count1++;
			else if (num == cand2) count2++;
			else if (count1 == 0) {
				cand1 = num;
				count1 = 1;
			}
			else if (count2 == 0) {
				cand2 = num;
				count2 = 1;
			}
			else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num: nums) {
			if (num == cand1) count1++;
			if (num == cand2) count2++;
		}
		if (count1 > nums.length / 3) result.add(cand1);
		if (count2 > nums.length / 3) result.add(cand2);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElementII result = new MajorityElementII();
		System.out.println(result.majorityElementII(new int[] {2, 2, 1, 3, 3, 1, 1, 3}));
		System.out.println(result.majorityElementII(new int[] {2, 2, 1, 3, 3, 1, 1}));
	}

}
