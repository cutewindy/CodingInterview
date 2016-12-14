import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class MaximumXORofTwoNumbersinanArray {
	
	/**
	 * Bit manipulation + set: a ^ b = c => a ^ c = b
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int maximumXORofTwoNumbersinanArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int mask = 0;
		for (int i = 31; i >= 0; i--) {
			mask = mask | (1 << i);
			Set<Integer> set = new HashSet<>();
			for (int num: nums) {
				set.add(num & mask);
			}
			int temp = result | (1 << i);  // temp may be the new result
			for (int prefix: set) {
				if (set.contains(prefix ^ temp)) { // prefix1 ^ temp = prefix2 => prefix1 ^ prefix2 = temp
					result = temp;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumXORofTwoNumbersinanArray result = new MaximumXORofTwoNumbersinanArray();
		System.out.println(result.maximumXORofTwoNumbersinanArray(new int[] {3, 10, 5, 25, 2, 8}));
	}

}
