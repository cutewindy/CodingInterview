/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is 
 * a substring of it. If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is 
 * not a substring of A repeated two times ("abcdabcd").
 * Note:
 * The length of A and B will be between 1 and 10000.
 * @author wendi
 *
 */
public class RepeatedStringMatch {

	
	/**
	 * Method: Brute Force 
	 * @param String A, String B
	 * @return int
	 * Time: O(N*(N+M)), where M, N are the lengths of strings A, B. We create two strings A * q, 
	 * 		 A * (q+1) which have length at most O(M+N). When checking whether B is a substring of 
	 * 		 A, this check takes naively the product of their lengths.
	 * Space: O(M+N)
	 */
	public int repeatedStringMatch(String A, String B) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (sb.length() < B.length()) {
			sb.append(A);
			count++;
		}
		if (sb.indexOf(B) > 0) return count;
		if (sb.append(A).indexOf(B) > 0) return count + 1;
		return -1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedStringMatch result = new RepeatedStringMatch();
		System.out.println(result.repeatedStringMatch("abcd", "cdabcdab"));
	}

}
