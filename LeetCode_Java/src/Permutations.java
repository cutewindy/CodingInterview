import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
		[
		  [1,2,3],
		  [1,3,2],
		  [2,1,3],
		  [2,3,1],
		  [3,1,2],
		  [3,2,1]
		]
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class Permutations {

	/**
	 * Backtracking
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(n!)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, new HashSet<Integer>(), new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, Set<Integer> visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            list.add(nums[i]);
            dfs(nums, visited, list, res);
            list.remove(list.size() - 1);
            visited.remove(i);
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations result = new Permutations();
		System.out.println(result.permutations(new int[] {1, 2, 3}));
	}

}
