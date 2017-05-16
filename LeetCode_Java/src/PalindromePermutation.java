import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * Tags: Hash Table
 * @author wendi
 *
 */
public class PalindromePermutation {
	
	/**
	 * Method2: Set, one pass
	 * The idea is to iterate over string, adding current character to set if set doesn't contain 
	 * that character, or removing current character from set if set contains it.
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean palindromePermutationI(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Set<Character> counters = new HashSet<>();
		for (char c: s.toCharArray()) {
			if (counters.contains(c)) {
				counters.remove(c);
			}
			else {
				counters.add(c);
			}
		}
		return counters.size() <= 1;
	}
	
	/**
	 * Method1: HashMap, two pass
	 * @param String s
	 * @return boolean
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public boolean palindromePermutation(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Map<Character, Integer> counters = new HashMap<>();
		for (char c: s.toCharArray()) {
			if (counters.containsKey(c)) {
				counters.put(c, counters.get(c) + 1);
			}
			else {
				counters.put(c, 1);
			}
		}
		int single = 0;
		for (Integer count: counters.values()) {
			if (count % 2 != 0) {
				single += 1;
			}
		}
		return single < 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePermutation result = new PalindromePermutation();
		System.out.println(result.palindromePermutation("aad"));
		System.out.println(result.palindromePermutationI("aad"));
	}

}
