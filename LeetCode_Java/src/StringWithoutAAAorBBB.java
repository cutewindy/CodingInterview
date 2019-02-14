/**
 * Given two integers A and B, return any string S such that:
 * S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
 * The substring 'aaa' does not occur in S;
 * The substring 'bbb' does not occur in S.
 * Example 1:
 * Input: A = 1, B = 2
 * Output: "abb"
 * Explanation: "abb", "bab" and "bba" are all correct answers.
 * Example 2:
 * Input: A = 4, B = 1
 * Output: "aabaa"
 * Note:
 * 1. 0 <= A <= 100
 * 2. 0 <= B <= 100
 * 3. It is guaranteed such an S exists for the given A and B.
 * @author wendi
 *
 */
public class StringWithoutAAAorBBB {
	
	/**
	 * Greedy:
	 * 1. If the initial number of As is greater than Bs, we swap A and B.
	 * 2. For each turn, we add 'a' to our string.
	 * 3. If the number of remaining As is greater than Bs, we add one more 'a'.
	 * 4. Finally, we add 'b'.
	 * @param int A, int B
	 * @return String
	 * Time: O(A + B)
	 * Space: O(A + B)
	 */
	public String stringWithoutAAAorBBB(int A, int B) {
		if (A > B) return helper(A, B, 'a', 'b');
		return helper(B, A, 'b', 'a');
	}
	
	private String helper(int A, int B, char a, char b) {
		StringBuilder sb = new StringBuilder();
		while (A-- > 0) {
			sb.append(a);
			if (A > B) {
				sb.append(a);
				A--;
			}
			if (B-- > 0) sb.append(b);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringWithoutAAAorBBB result = new StringWithoutAAAorBBB();
		System.out.println(result.stringWithoutAAAorBBB(4, 1));
	}

}
