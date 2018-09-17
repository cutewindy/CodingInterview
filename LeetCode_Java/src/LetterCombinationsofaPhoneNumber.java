import java.util.ArrayList;
import java.util.Arrays;
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
	 * DFS
	 * @param String digits
	 * @return List<String>
	 * Time:O(k^n), k is the average length of digit's letter list
	 * Space:O(n), n level depth stack space, not included result(O(k^n))
	 */
	public List<String> letterCombinationofaPhoneNumber(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        dfs(digits, 0, map, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(String digits, int index, Map<Character, List<Character>> map, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (Character c: map.get(digits.charAt(index))) {
            sb.append(c);
            dfs(digits, index + 1, map, sb, res);
            sb.setLength(sb.length() - 1);
        }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsofaPhoneNumber res = new LetterCombinationsofaPhoneNumber();
		System.out.println(res.letterCombinationofaPhoneNumber("23"));
	}

}
