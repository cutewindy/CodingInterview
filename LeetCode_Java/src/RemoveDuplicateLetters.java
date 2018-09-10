import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every 
 * letter appear once and only once. You must make sure your result is the smallest in lexicographical 
 * order among all possible results.
 * Example:
 * Given "bcabc"
 * Return "abc"
 * Given "cbacdcbc"
 * Return "acdb"
 * 
 * Tags: Stack, Greedy
 * @author wendi
 *
 */
public class RemoveDuplicateLetters {
		
	/**
	 * Stack
	 * Stack: Using int[26] to record the frequency of each char in string and boolean[26] to record 
	 * whether the char is in stack. If c doesn't appear in stack && c < stack.peek() && the left 
	 * string has stack.peek(), we can pop it from stack without matter. 
	 * which in stack right now.
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(26)
	 */
	public String removeDuplicatedLetters(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int[] freq = new int[26]; //contain number of occurences of character (i+'a')
		boolean[] visiting = new boolean[26]; // true if character (i+'a') is present in current Stack
		for (char c: s.toCharArray()) {
			freq[c - 'a']++;
		}
		Stack<Character> stack = new Stack<>();
		for (char c: s.toCharArray()) {
			freq[c - 'a']--; //decrement number of characters remaining in the string to be analyzed
			if (visiting[c - 'a']) continue; //if character is already present in stack, dont bother
			while (!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] > 0) {
				visiting[stack.pop() - 'a'] = false;
			}
			stack.push(c); //add current character and mark it as visited
			visiting[c - 'a'] = true;
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return res.reverse().toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateLetters result = new RemoveDuplicateLetters();
		System.out.println(result.removeDuplicatedLetters("cbcab"));
	}

}
