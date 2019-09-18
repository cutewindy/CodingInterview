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
	 * 星号什么时候都能当括号来用吗，我们来看两个例子 *) 和 *( ，在第一种情况下，星号可以当左括号来用，而在第二种情况下，
	 * 无论星号当左括号，右括号，还是空，*( 都是不对的。当然这种情况只限于星号和左括号之间的位置关系，而只要星号在右括号前面，
	 * 就一定可以消掉右括号。那么我们使用两个stack，分别存放左括号和星号的位置，遍历字符串，当遇到星号时，压入星号栈star，
	 * 当遇到左括号时，压入左括号栈left，当遇到右括号时，此时如果left和star均为空时，直接返回false；如果left不为空，
	 * 则pop一个左括号来抵消当前的右括号；否则从star中取出一个星号当作左括号来抵消右括号。当循环结束后，我们希望left中没
	 * 有多余的左括号，就算有，我们可以尝试着用星号来抵消，当star和left均不为空时，进行循环，如果left的栈顶左括号的位置在
	 * star的栈顶星号的右边，那么就组成了 *( 模式，直接返回false；否则就说明星号可以抵消左括号，各自pop一个元素。最终退
	 * 出循环后我们看left中是否还有多余的左括号，没有就返回true，否则false
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
