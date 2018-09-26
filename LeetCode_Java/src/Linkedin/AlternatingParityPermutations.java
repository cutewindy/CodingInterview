package Linkedin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author wendi
 *
 */
public class AlternatingParityPermutations {
	
	/**
	 * 
	 * @return
	 */
	public List<List<Integer>> alternatingParityPermutations(int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (n <= 0) return res;
		Set<Integer> visited = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		int turn = 1;
		for (int i = 1; i <= n; i++) {
			visited.add(i);
			list.add(i);
			dfs(n, turn ^ 1, visited, list, res);
			list.remove(list.size() - 1);
			visited.remove(i);
			turn ^= 1;
		}
		return res;
	}
	
	private void dfs(int n, int turn, Set<Integer> visited, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == n) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (visited.contains(i) || i % 2 != turn) continue;
			visited.add(i);
			list.add(i);
			dfs(n, turn ^ 1, visited, list, res);
			list.remove(list.size() - 1);
			visited.remove(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlternatingParityPermutations result = new AlternatingParityPermutations();
		System.out.println(result.alternatingParityPermutations(4));
	}

}
