package FB_onsite;
/**
 * 如何取出最少的(或)使其变得匹配, 
 * 左右各扫描一遍搞定。
 * @author wendi
 *
 */
public class RemoveInvalidParenthesesandReturnOne {

	/**
	 * 左右各扫描一遍
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String removeInvalidParenthesesandReturnOne(String s) {
		if (s == null || s.length() == 0) return "";
		String curr = "";
		// iterate from left to right check valid parentheses
		int open = 0;
		for (char c: s.toCharArray()) {
			if (c == '(') {
				curr += c;
				open++;
			}
			else if (c == ')') {
				if (open > 0) {
					curr += ')';
					open--;
				}
			}
			else curr += c;
		}
		// iterate from right to left check valid parentheses
		open = 0;
		String res = "";
		for (int i = curr.length() - 1; i >= 0; i--) {
			char c = curr.charAt(i);
			if (c == ')') {
				res = c + res;
				open++;
			}
			else if (c == '(') {
				if (open > 0) {
					res = c + res;
					open--;
				}
			}
			else res = c + res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveInvalidParenthesesandReturnOne result = new RemoveInvalidParenthesesandReturnOne();
		System.out.println(result.removeInvalidParenthesesandReturnOne("(a((*(bc)(d)"));
		System.out.println(result.removeInvalidParenthesesandReturnOne("(a(bc)*))(d)"));
	}

}
