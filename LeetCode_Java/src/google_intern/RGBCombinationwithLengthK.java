package google_intern;

import java.util.ArrayList;
import java.util.List;

/**
 * Given 'R', 'G', 'B' these three character and a length k, return all possible strings that are 
 * made up of the three chars with length k.
 * @author wendi
 *
 */
public class RGBCombinationwithLengthK {
	
	/**
	 * DFS, like leetcode: "77. Combination", but for each node can be chosen multiple times
	 * @param int k
	 * @return List<String>
	 * Time: O(3^k)
	 * Space: O(k)
	 * Stack space: O(k)
	 */
	public List<List<Character>> rGBCombinationwithLengthK(int k) {
		List<List<Character>> res = new ArrayList<>();
		char[] color = {'R', 'G', 'B'};
		dfs(color, k, new ArrayList<Character>(), res);
		return res;
	}

	private void dfs(char[] color, int k, List<Character> path, List<List<Character>> res) {
		if (path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < color.length; i++) {
			path.add(color[i]);
			dfs(color, k, path, res);
			path.remove(path.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RGBCombinationwithLengthK result = new RGBCombinationwithLengthK();
		System.out.println(result.rGBCombinationwithLengthK(2));
	}

}
