import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
 * being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are 
 * well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits 
 * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc". 
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * Tags: DFS, Stack
 * @author wendi
 *
 */
public class DecodeString {
	
	/**
	 * Approach2: Stack
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String decodeStringI(String s) {
		if (s == null || s.length() == 0) return "";
		int num = 0;
		String str = "";
		Stack<Integer> nums = new Stack<>();
		Stack<String> strs = new Stack<>();
		for (char c: s.toCharArray()) {
			// four different cases
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			else if (c == '[') {
				nums.push(num);
				strs.push(str);
				num = 0;
				str = "";
			}
			else if (c == ']') {
				String newStr = "";
				int times = nums.pop();
				for (int j = 0; j < times; j++) {
					newStr += str;
				}
				str = strs.pop() + newStr;
			}
			else {
				str += c;
			}
		}
		return str;
	}
	
	
	/**
	 * Approach1: DFS
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public String decodeString(String s) {
		if (s == null || s.length() == 0) return "";
		int[] index = new int[1];  // global index
		return dfs(s, index);
	}
	
	private String dfs(String s, int[] index) {
		StringBuilder sb = new StringBuilder();
		while (index[0] < s.length()) {
			int num = 0;
			while (Character.isDigit(s.charAt(index[0]))) {
				num = num * 10 + s.charAt(index[0]) - '0';
				index[0]++;
			}
			char c = s.charAt(index[0]);
			index[0]++;
			if (c == '[') {
				String next = dfs(s, index);
				while (num-- > 0) {
					sb.append(next);
				}
			}
			else if (c == ']') {
				return sb.toString();
			}
			else {
				sb.append(c);
			}
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString result = new DecodeString();
		System.out.println(result.decodeString("2[ab3[c]]1[d]e"));
		System.out.println(result.decodeStringI("2[ab3[c]]1[d]e"));
	}

}
