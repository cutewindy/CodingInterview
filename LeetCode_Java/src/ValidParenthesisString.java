import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to 
 * check whether this string is valid. We define the validity of a string by these rules:
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an 
 * empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * 1. The string size will be in the range [1, 100].
 * @author wendi
 *
 */
public class ValidParenthesisString {
	
	/**
	 * Approach3: Greedy
	 * Let lo, hi respectively be the smallest and largest possible number of open left brackets 
	 * after processing the current character in the string.
	 * If we encounter a left bracket (c == '('), then lo++, hi++;
	 * Else if we encounter a right bracket (c == ')'), then lo--(lo>0), hi--;
	 * Else we encounter a '*', then three options that make lo--(lo>0), hi++; 
	 * Also, we can never have less than 0 open left brackets. 
	 * At the end, we should check that we can have exactly 0 open left brackets.
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
    public boolean validParenthesisStringII(String s) {
        if (s == null || s.length() == 0) return true;
        int lo = 0;
        int hi = 0;
        for (char c: s.toCharArray()) {
        	if (c == '(') {
        		lo++;
        		hi++;
        	}
        	else if (c == ')') {
        		if (lo > 0) lo--;
        		hi--;
        	}
        	else {
        		if (lo > 0) lo--;
        		hi++;
        	}
        	if (hi < 0) return false;
        }
        return lo == 0;
    } 
	
    
	/**
	 * Approach2: Stack
	 * The basic idea is to track the index of the left bracket and star position.
	 * 
	 * 1. Push all the indices of the star and left bracket to their stack respectively.
	 * 2. Once a right bracket comes, pop left bracket stack first if it is not empty. If the left 
	 * bracket stack is empty, pop the star stack if it is not empty. A false return can be made 
	 * provided that both stacks are empty.
	 * 3. Note that the left bracket CANNOT appear after the star as there is NO way to balance the 
	 * bracket. In other words, whenever there is a left bracket index appears after the Last star, 
	 * a false statement can be made. Otherwise, pop out each from the left bracket and star stack.
	 * 
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
    public boolean validParenthesisStringI(String s) {
    	if (s == null || s.length() == 0) return true;
    	Stack<Integer> leftIdx = new Stack<>();  // save left parentheses '(' index
    	Stack<Integer> starIdx = new Stack<>();  // save star '*' index
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') {
    			leftIdx.push(i);
    		}
    		else if (s.charAt(i) == '*') {
    			starIdx.push(i);
    		}
    		else {
    			if (!leftIdx.isEmpty()) leftIdx.pop();
    			else if (!starIdx.isEmpty()) starIdx.pop();
    			else return false;
    		}
    	}
    	while (!leftIdx.isEmpty()) {
    		if (starIdx.isEmpty() || leftIdx.pop() > starIdx.pop()) return false;
    	}
    	
    	return true;
    }
    
    
	/**
	 * Approach1: DFS
	 * @param String s
	 * @return boolean
	 * Time: O(3^n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
    public boolean validParenthesisString(String s) {
        if (s == null || s.length() == 0) return true;
        return dfs(s, 0, 0);
    }
    
    private boolean dfs(String s, int index, int open) {
        if (index == s.length() && open == 0) return true;
        if (index == s.length() || open < 0) return false;
        if (s.charAt(index) == '(') return dfs(s, index + 1, open + 1);
        else if (s.charAt(index) == ')') return dfs(s, index + 1, open - 1);
        return dfs(s, index + 1, open) || dfs(s, index + 1, open + 1) || dfs(s, index + 1, open - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParenthesisString result = new ValidParenthesisString();
		System.out.println(result.validParenthesisString("(*))"));
		System.out.println(result.validParenthesisStringI("(*))"));
		System.out.println(result.validParenthesisStringII("(*))"));
	}

}
