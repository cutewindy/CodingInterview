package IBM;

import java.util.ArrayList;
import java.util.List;

/**
 * integer Print出来valid的parenthesis
 * 
 * @author wendi
 *
 */
public class PrintValidParenthesis {
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public List<String> printValidParenthesis(int n) {
		List<String> res = new ArrayList<>();
		dfs(n, n, new StringBuilder(), res);
		return res;
	}
	
	private void dfs(int left, int right, StringBuilder sb, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(sb.toString());
			return;
		}
		if (left > 0) {
			sb.append('(');
			dfs(left - 1, right, sb, res);
			sb.setLength(sb.length() - 1);
		}
		if (right > 0 && left < right) {
			sb.append(')');
			dfs(left, right - 1, sb, res);
			sb.setLength(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintValidParenthesis result = new PrintValidParenthesis();
		System.out.println(result.printValidParenthesis(3));
	}

}
