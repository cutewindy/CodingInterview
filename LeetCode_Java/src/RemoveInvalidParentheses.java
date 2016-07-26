import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return 
 * all possible results.
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
	 * Method2:DFS(Idea: need which one)
	 * 1 Limit max removal rmL and rmR for backtracking boundary. 
	 * 	 Otherwise it will exhaust all possible valid substrings, not shortest ones.
	 * 2 Scan from left to right, avoiding invalid strs (on the fly) by checking num of open parens.
	 * 3 If it's '(', either use it, or remove it.
	 * 4 If it's ')', either use it, or remove it.
	 * 5 Otherwise, it's alphabet, just append it.
	 * In each step, make sure:
	 * 1 i does not exceed s.length().
 	 * 2 Max removal rmL rmR and num of open parentheses are non negative.
	 * 3 De-duplicate by adding to a HashSet.
	 * @param String s
	 * @return List<String>
	 * Time: O(2^n)
	 * Space: O(2^n)
	 */
	public List<String> removeInvalidParenthesesI(String s) {
		List<String> result = new ArrayList<>();
		if (s == null) {
			return result;
		}
		int rml = 0;
		int rmr = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				rml++;
			}
			if (s.charAt(i) == ')') {
				if (rml > 0) rml--;
				else rmr++;
			}
		}
		Set<String> set = new HashSet<>();
		helper(s, set, 0, rml, rmr, 0, "", result);
		return result;
	}
	
	private void helper(String s, Set<String> set, int i, int rml, int rmr, int open, String combo, List<String> result) {
		// basecase1: find the answer
		if (i == s.length() && rml == 0 && rmr == 0 && open == 0) {
			if (!set.contains(combo)) {
				result.add(combo);
				set.add(combo);
			}
			return;
		}
		// basecase2: out of removing range(cannot change the order of basecase1 and basecase2)
		if (i == s.length() || rml < 0 || rmr < 0 || open < 0) {
			return;
		}
		// condition: add s[i]('(' or ')') to combo or not.
		char c = s.charAt(i);
		if (c == '(') {
			helper(s, set, i + 1, rml, rmr, open + 1, combo + c, result); // not remove '('
			helper(s, set, i + 1, rml - 1, rmr, open, combo, result); // remove '('
		}
		else if (c == ')') {
			helper(s, set, i + 1, rml, rmr, open - 1, combo + c, result); // not remove ')'
			helper(s, set, i + 1, rml, rmr - 1, open, combo, result); // remove ')'
		}
		else {
			helper(s, set, i + 1, rml, rmr, open, combo + c, result); // c is alphabet, not remove
		}
	}
	
	/**
	 * Method1: BFS(Idea: remove which one): with the input string s, we generate all possible states
	 * by removing one ( or ), check if they are valid, if found valid ones on the current level,
	 * put them to the final result list and we are done, otherwise, add them to a queue and carry 
	 * on to the next level.
	 * @param String s
	 * @return List<String>
	 * Time: O(n*2^n)
	 * Space: O(2^n)
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
			// if found, iterate left string in the queue,(since removing rm is ans, removing rm+1 cannot be ans),
			// do not remove '(' or ')' any more. Otherwise, continue remove.
			if (!found) { 
				for (int i = 0; i < curr.length(); i++) {
					if (curr.charAt(i) == '(' || curr.charAt(i) == ')') {  // ignore alphabet
						String subStr = curr.substring(0, i) + curr.substring(i + 1);  // remove curr[i]
						if (!visited.contains(subStr)) {  // avoid duplicate
							queue.offer(subStr);
							visited.add(subStr);
						}
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
//		System.out.println(result.removeInvalidParentheses("(a)()))"));
		System.out.println(result.removeInvalidParenthesesI("(a)()))"));
//		System.out.println(result.removeInvalidParenthesesI(")()"));
	}

}
