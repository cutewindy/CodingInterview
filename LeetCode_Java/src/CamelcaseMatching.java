import java.util.ArrayList;
import java.util.List;

/**
 * A query word matches a given pattern if we can insert lowercase letters to the pattern word so 
 * that it equals the query. (We may insert each character at any position, and may insert 0 characters.)
 * Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is 
 * true if and only if queries[i] matches the pattern.
 * Example 1:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * Output: [true,false,true,true,false]
 * Explanation: 
 * "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 * "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 * "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 * Example 2:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * Output: [true,false,true,false,false]
 * Explanation: 
 * "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 * "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 * Example 3:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * Output: [false,true,false,false,false]
 * Explanation: 
 * "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 * Note:
 * 1. 1 <= queries.length <= 100
 * 2. 1 <= queries[i].length <= 100
 * 3. 1 <= pattern.length <= 100
 * 4. All strings consists only of lower and upper case English letters.
 * @author wendi
 *
 */
public class CamelcaseMatching {
	
	
	/**
	 * Approach2: regex
	 * @param String[] queries, String pattern
	 * @return List<Boolean>
	 * Time: O(m*n) m=queries.length, n=queries[i].length()
	 * Space: O(1)
	 */
	public List<Boolean> camelcaseMatchingI(String[] queries, String pattern) {
		List<Boolean> res = new ArrayList<>();
		if (queries == null || queries.length == 0) return res;
		String newPattern = "[a-z]*" + String.join("[a-z]*", pattern.split("")) + "[a-z]*";
		System.out.println(newPattern);
		for (String q: queries) {
			res.add(q.matches(newPattern));
		}
		return res;
	}
	
	
	/**
	 * Approach1: two pointers
	 * @param String[] queries, String pattern
	 * @return List<Boolean>
	 * Time: O(m*n) m=queries.length, n=queries[i].length()
	 * Space: O(1)
	 */
	public List<Boolean> camelcaseMatching(String[] queries, String pattern) {
		List<Boolean> res = new ArrayList<>();
		if (queries == null || queries.length == 0) return res;
		char[] pArray = pattern.toCharArray();
		for (String q: queries) {
			res.add(isMatch(q.toCharArray(), pArray));
		}
		return res;
	}
	
	private boolean isMatch(char[] q, char[] p) {
		int j = 0;
		for (int i = 0; i < q.length; i++) {
			if (j < p.length && q[i] == p[j]) j++;
			else if (Character.isUpperCase(q[i])) return false;
		}
		return j == p.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CamelcaseMatching result = new CamelcaseMatching();
		System.out.println(result.camelcaseMatching(new String[] {"FooBar","FooBarTest","FootBall",
				"FrameBuffer","ForceFeedBack"}, "FB"));
		System.out.println(result.camelcaseMatchingI(new String[] {"FooBar","FooBarTest","FootBall",
				"FrameBuffer","ForceFeedBack"}, "FB"));
	}

}
