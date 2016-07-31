import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
		[
		  [2,4],
		  [3,4],
		  [2,3],
		  [1,2],
		  [1,3],
		  [1,4],
		]
 
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class Combinations {

	/**
	 * DFS: 
	 * @param int n, int k
	 * @return List<List<Integer>>
	 * Time: O(n! / (k!*(n-k)!))
	 * Space: O(k)
	 * Stack space: O(k)
	 */
	public List<List<Integer>> combinations(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combo = new ArrayList<>();
		if (n == 0) {
			result.add(new ArrayList<>(combo));
			return result;
		}
		helper(n, k, 1, combo, result);
		return result;
	}
	
	private void helper(int n, int k, int pos, List<Integer> combo, List<List<Integer>> result) {
		if (combo.size() == k) {
			result.add(new ArrayList<>(combo));
			return;
		}
		for (int i = pos; i <= n; i++) {
			combo.add(i);
			helper(n, k, i + 1, combo, result);
			combo.remove(combo.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations result = new Combinations();
		System.out.println(result.combinations(4, 2));
	}

}
