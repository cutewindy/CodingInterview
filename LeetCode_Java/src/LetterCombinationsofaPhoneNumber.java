import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order 
 * you want.
 * 
 * Tags: Backtracking, String
 * @author wendi
 *
 */
public class LetterCombinationsofaPhoneNumber {

	/**
	 * backtracking + momerization
	 * @param String digits
	 * @return List<String>
	 * Time:O(k^n), k is the average length of digit's letter list, k=3
	 * Space:O(n), n level depth stack space, not included result(O(k^n))
	 */
	public List<String> letterCombinationofaPhoneNumber(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return dfs(digits, 0, map, new HashMap<Integer, List<String>>());
    }
    
    private List<String> dfs(String digits, int pos, Map<Integer, String> map, Map<Integer, List<String>> visited) {
        if (pos == digits.length()) return null;
        if (visited.containsKey(pos)) return visited.get(pos);
        List<String> res = new ArrayList<>();
        for (char c: map.get(digits.charAt(pos) - '0').toCharArray()) {
            List<String> list = dfs(digits, pos + 1, map, visited);
            if (list == null) {
                res.add(c + "");
                continue;
            }
            for (String next: list) {
                res.add(c + next);
            }
        }
        visited.put(pos, res);
        return res;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsofaPhoneNumber res = new LetterCombinationsofaPhoneNumber();
		System.out.println(res.letterCombinationofaPhoneNumber("23"));
	}

}
