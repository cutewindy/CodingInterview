import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences 
 * of the given array, and the length of an increasing subsequence should be at least 2 .
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * 1. The length of the given array will not exceed 15.
 * 2. The range of integer in the given array is [-100,100].
 * 3. The given array may contain duplicates, and two equal integers should also be considered as a 
 * special case of increasing sequence.
 * @author wendi
 *
 */
public class IncreasingSubsequences {
	
	
	/**
	 * Backtracking
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
    public List<List<Integer>> increasingSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        find(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void find(int[] nums, int start, List<Integer> combo, List<List<Integer>> res) {
        if (combo.size() > 1) res.add(new ArrayList<Integer>(combo));
        Set<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (combo.size() > 0 && nums[i] < combo.get(combo.size() - 1)) continue; // skip non-increase
            if (visited.contains(nums[i])) continue;  // skip duplicate
            visited.add(nums[i]);
            combo.add(nums[i]);
            find(nums, i + 1, combo, res);
            combo.remove(combo.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IncreasingSubsequences result = new IncreasingSubsequences();
		System.out.println(result.increasingSubsequences(new int[] {4, 6, 7, 7}));
	}

}
