/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or 
 * ')', and in any positions ) so that the resulting parentheses string is valid.
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the 
 * resulting string valid.
 * Example 1:
 * Input: "())"
 * Output: 1
 * Example 2:
 * Input: "((("
 * Output: 3
 * Example 3:
 * Input: "()"
 * Output: 0
 * Example 4:
 * Input: "()))(("
 * Output: 4
 * Note:
 * 1. S.length <= 1000
 * 2. S only consists of '(' and ')' characters.
 * @author wendi
 *
 */
public class MinimumAddtoMakeParenthesesValid {
	
	
	/**
	 * check open 
	 * @param String S
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int minimumAddtoMakeParenthesesValid(String S) {
        if (S == null || S.length() == 0) return 0;
        int open = 0;
        int res = 0;
        for (char c: S.toCharArray()) {
            if (c == '(') open++;
            else {
                if (open > 0) open--;
                else {
                    res++;
                }
            }
        }
        return res + open;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumAddtoMakeParenthesesValid result = new MinimumAddtoMakeParenthesesValid();
		System.out.println(result.minimumAddtoMakeParenthesesValid("()))(("));
	}

}
