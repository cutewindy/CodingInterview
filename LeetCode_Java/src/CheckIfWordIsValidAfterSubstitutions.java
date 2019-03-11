import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * We are given that the string "abc" is valid.
 * From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.
 * If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
 * Return true if and only if the given string S is valid.
 * Example 1:
 * Input: "aabcbc"
 * Output: true
 * Explanation: 
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is 
 * "aabcbc".
 * Example 2:
 * Input: "abcabcababcc"
 * Output: true
 * Explanation: 
 * "abcabcabc" is valid after consecutive insertings of "abc".
 * Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is 
 * "abcabcababcc".
 * Example 3:
 * Input: "abccba"
 * Output: false
 * Example 4:
 * Input: "cababc"
 * Output: false
 * Note:
 * 1. 1 <= S.length <= 20000
 * 2. S[i] is 'a', 'b', or 'c'

 * @author wendi
 *
 */
public class CheckIfWordIsValidAfterSubstitutions {
	
	
	/**
	 * Approach2: Stack
	 * @param String S
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean checkIfWordIsValidAfterSubstitutionsI(String S) {
		if (S == null || S.length() == 0) return true;
		Stack<Character> stack = new Stack<>();
		for (char c: S.toCharArray()) {
			if (c == 'a') stack.push(c);
			else if (c == 'b') {
				if (stack.isEmpty() || stack.peek() != 'a') return false;
				stack.push(c);
			}
			else if (c == 'c') {
				if (stack.isEmpty() || stack.pop() != 'b') return false;
				if (stack.isEmpty() || stack.pop() != 'a') return false;
			}
		}
		return stack.isEmpty();
	}
	
	
	/**
	 * Approach1: DFS + memorization
	 * @param String S
	 * @return boolean
	 * Time: O(n!)
	 * Space: O(n!)
	 */
	public boolean checkIfWordIsValidAfterSubstitutions(String S) {
        if (S == null || S.length() == 0) return true;
        if (S.length() % 3 != 0) return false;
        return dfs(S, new HashSet<String>());
    }
    
    private boolean dfs(String S, Set<String> visited) {
        if (S == null || S.length() == 0) return true;
        if (visited.contains(S)) return false;
        for (int i = 0; i <= S.length() - 3; i++) {
            String subs = S.substring(i, i + 3);
            if (subs.equals("abc")) {
                if (i == 0 && dfs(S.substring(i + 3), visited) || dfs(S.substring(0, i) + S.substring(i + 3), visited)) 
                	return true;
            }
        }
        visited.add(S);
        return false;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIfWordIsValidAfterSubstitutions result = new CheckIfWordIsValidAfterSubstitutions();
		System.out.println(result.checkIfWordIsValidAfterSubstitutions("abcabcababcc"));
		System.out.println(result.checkIfWordIsValidAfterSubstitutionsI("abcabcababcc"));
	}

}
