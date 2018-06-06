import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * Call a group large if it has 3 or more characters.  We would like the starting and ending 
 * positions of every large group.
 * The final answer should be in lexicographic order.
 * Example 1:
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Note:  1 <= S.length <= 1000
 * @author wendi
 *
 */
public class PositionsofLargeGroups {
	
	/**
	 * Tow Pointers:
	 * We scan through the string to identify the start and end of each group. If the size of the 
	 * group is at least 3, we add it to the answer.
	 * @param String S
	 * @return List<List<Integer>>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<List<Integer>> positionsofLargeGroups(String S) {
		List<List<Integer>> res = new ArrayList<>();
		if (S == null || S.length() == 0) return res;
		int s = 0;
		int e = 0;
		char[] array = S.toCharArray();
		while (e < array.length) {
			while (e < array.length && array[e] == array[s]) e++;
			if (e - s > 2) res.add(Arrays.asList(s, e - 1));
			s = e;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PositionsofLargeGroups result = new PositionsofLargeGroups();
		System.out.println(result.positionsofLargeGroups("abcdddeeeeaabbbcd"));
	}

}
