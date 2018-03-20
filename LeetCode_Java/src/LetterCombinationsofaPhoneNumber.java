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
	
//	public List<String> letterCombinationofaPhoneNumber(String digits) {
//		List<StringBuilder> result = new ArrayList();
//		if (digits == null || digits.length() == 0) {
//			return null;
//		}
//		Map<Character, String> hash = new HashMap();
//		hash.put('1', "");
//		hash.put('2', "abc");
//		hash.put('3', "def");
//		hash.put('4', "ghi");
//		hash.put('5', "jkl");
//		hash.put('6', "mno");
//		hash.put('7', "pqrs");
//		hash.put('8', "tuv");
//		hash.put('9', "wxyz");
//		List<StringBuilder> oldRes = null;
//		for (int i = 0; i < digits.length(); i++) {
//			char digit = digits.charAt(i);
//			String letters = hash.get(digit);
//			oldRes = new ArrayList(result);
//			result.clear();
//			System.out.println(oldRes.size());
//			if (oldRes.size() == 0) {
//				for (int j = 0; j < letters.length(); j++) {
//					StringBuilder letter = new StringBuilder();
//					letter.append(String.valueOf(letters.charAt(j)));
//					result.add(letter);
//				}
//			}
//			else {
//				for (StringBuilder res: oldRes) {
//					for (int j = 0; j < letters.length(); j++) {
//						res.append(String.valueOf(letters.charAt(j)));
//						result.add(res);
//					}
//				}
//			}
//		}
//		List<String> newResult = new ArrayList();
//		for (StringBuilder sb: result) {
//			newResult.add(sb.toString());
//		}
//		return newResult;
//	}
	
	
	/**
	 * DFS
	 * @param String digits
	 * @return List<String>
	 * Time:O(k^n), k is the average length of digits
	 * Space:O(n), n level depth stack space, not included result(O(k^n))
	 */
	public List<String> letterCombinationofaPhoneNumber(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		Map<Character, List<String>> hash = new HashMap<>();
		hash.put('1', Arrays.asList(""));
		hash.put('2', Arrays.asList("a", "b", "c"));
		hash.put('3', Arrays.asList("d", "e", "f"));
		hash.put('4', Arrays.asList("g", "h", "i"));
		hash.put('5', Arrays.asList("j", "k", "l"));
		hash.put('6', Arrays.asList("m", "n", "o"));
		hash.put('7', Arrays.asList("p", "q", "r", "s"));
		hash.put('8', Arrays.asList("t", "u", "v"));
		hash.put('9', Arrays.asList("w", "x", "y", "z"));
		hash.put('0', Arrays.asList(" "));
		helper(digits, hash, "", 0, result);
		return result;
	}
	
	private void helper(String digits, Map<Character, List<String>> hash, String combo, int position, List<String> result) {
		if (position == digits.length()) {
			result.add(combo);
			return;
		}
		List<String> letters = hash.get(digits.charAt(position));
		for (int i = 0; i < letters.size(); i++) {
			helper(digits, hash, combo + letters.get(i), position + 1, result);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsofaPhoneNumber res = new LetterCombinationsofaPhoneNumber();
		System.out.println(res.letterCombinationofaPhoneNumber("23"));
	}

}
