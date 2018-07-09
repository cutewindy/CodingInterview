import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an 
 * empty list if no palindromic permutation could be form.
 * Example 1:
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 * Input: "abc"
 * Output: []
 * @author wendi
 *
 */
public class PalindromePermutationII {
	
	/**
	 * Backtracking: perform permutation on half of the palindromic string and then form the full 
	 * palindromic result.
	 * @param String s
	 * @return List<String>
	 * Time: O(2n + (n/2)!)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<String> palindromePermutationII(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        // 1. build character count map and count odds
        Map<Character, Integer> map = new HashMap<>();
        int oldCnt = 0;
        for (char c: s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        	if (map.get(c) % 2 == 0) oldCnt -= 1;
        	else oldCnt += 1;
        }
        if (oldCnt > 1) return res; //cannot form any palindrome string
        
        // 2. add half count of each character to list
        String mid = "";
        List<Character> list = new ArrayList<>();
        for (Character c: map.keySet()) {
        	if (map.get(c) % 2 != 0) mid += c;
        	for (int i = 0; i < map.get(c) / 2; i++) list.add(c);
        }
        
        // 3. generate all unique permutation from list
        dfs(list, mid, new boolean[list.size()], new StringBuilder(), res);
        
        return res;
    }

	private void dfs(List<Character> list, String mid, boolean[] visited, StringBuilder path, List<String> res) {
		if (path.length() == list.size()) {
			String ans = path.toString() + mid + path.reverse().toString();
			res.add(ans);
			path.reverse();
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (i != 0 && list.get(i) == list.get( i - 1) && !visited[i - 1] || visited[i]) continue;
			visited[i] = true;
			path.append(list.get(i));
			dfs(list, mid, visited, path, res);
			path.setLength(path.length() - 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePermutationII result = new PalindromePermutationII();
		System.out.println(result.palindromePermutationII("aaa"));
	}

}
