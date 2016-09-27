import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * Tags: Array, Union Find
 * @author wendi
 *
 */
public class LongestConsecutiveSequence {
	
	/**
	 * Set: Using a set to collect all elements that hasn't been visited. 
	 * Search num, num++ and num-- elements in set, if find, count++ and eliminates after visiting.
	 * @param int[] nums
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int lonestConsecutiveSequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		Set<Integer> set = new HashSet<>();
		for (int num: nums) {
			set.add(num);
		}
		for (int num: nums) {
			int count = 0;
			if (set.remove(num)) {
				count++;
			}
			int val = num;
			while (set.remove(--val)) {
				count++;
			}
			val = num;
			while (set.remove(++val)) {
				count++;
			}
			result = Math.max(count, result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence result = new LongestConsecutiveSequence();
		System.out.println(result.lonestConsecutiveSequence(new int[] {100, 4, 200, 1, 3, 2}));
	}

}
