import java.util.HashSet;
import java.util.Set;

/**
 * There is a box protected by a password. The password is n digits, where each letter can be one of 
 * the first k digits 0, 1, ..., k-1.
 * You can keep inputting the password, the password will automatically be matched against the last 
 * n digits entered.
 * For example, assuming the password is "345", I can open it when I type "012345", but I enter a 
 * total of 6 digits.
 * Please return any string of minimum length that is guaranteed to open the box after the entire 
 * string is inputted.
 * Example 1:
 * Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * Example 2:
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * Note:
 * 1. n will be in the range [1, 4].
 * 2. k will be in the range [1, 10].
 * 3. k^n will be at most 4096.
 * @author wendi
 *
 */
public class CrackingtheSafe {
	
	/**
	 * Backtracking
	 * This is kind a greedy approach.
	 * we have k^n combinations of the lock.
	 * So the best way to generate the string is reusing last n-1 digits of previous lock 
	 * @param int n, int k
	 * @return String
	 * Time: O(k^n)
	 * Space: O(k^n)
	 * Stack space: O(k^n)
	 */
	public String crackingtheSafe(int n, int k) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) res.append("0");
		int total = (int) Math.pow(k, n);  // total permutation number of keys
		Set<String> visited = new HashSet<>();
		visited.add(res.toString());
		dfs(n, k, total, visited, res);
		return res.toString();
	}
	
	private boolean dfs(int n, int k, int total, Set<String> visited, StringBuilder res) {
		if (visited.size() == total) return true;
		String last = res.toString().substring(res.length() - n + 1);  // get the last n-1 key's number
		for (int i = 0; i < k; i++) {
			String next = last + i;
			if (visited.contains(next)) continue;
			res.append(i);
			visited.add(next);
			if (dfs(n, k, total, visited, res)) return true;
			visited.remove(next);
			res.setLength(res.length() - 1);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrackingtheSafe result = new CrackingtheSafe();
		System.out.println(result.crackingtheSafe(3, 3));
	}

}
