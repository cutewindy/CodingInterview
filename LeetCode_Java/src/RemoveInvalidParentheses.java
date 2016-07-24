import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 * 
 * Tags: DFS, BFS
 * @author wendi
 *
 */
public class RemoveInvalidParentheses {

	/**
	 * BFS
	 * @param String s
	 * @return List<String>
	 * Time: O()
	 * Space: O()
	 */
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		if (s == null) {   // if s = "", return [""]
			return result;
		}
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		boolean found = false;  // used to find the valid parentheses with removing min number of invalid parentheses
		queue.offer(s);
		visited.add(s);
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			if (isValid(curr)) {    // find the answer, add to result and set found flag means that find the parentheses with removing min invalid parentheses
				result.add(curr);
				found = true;
			}
			if (found) continue;
			for (int i = 0; i < curr.length(); i++) {
				if (curr.charAt(i) == '(' || curr.charAt(i) == ')') {  // ignore alphebat
					String subStr = curr.substring(0, i) + curr.substring(i + 1);  // remove curr[i]
					if (!visited.contains(subStr)) {  // avoid duplicate
						queue.offer(subStr);
						visited.add(subStr);
					}
				}
			}
		}
		return result;
	}
	
	private boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			}
			else if (s.charAt(i) == ')') {
				count--;
				if (count < 0) {
					return false;
				}
			}
		}
		return count == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveInvalidParentheses result = new RemoveInvalidParentheses();
		System.out.println(result.removeInvalidParentheses("(a)()))"));
	}

}
