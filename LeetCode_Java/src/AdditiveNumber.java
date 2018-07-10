/**
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two 
 * numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive 
 * number.
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 
 * 3 is invalid.
 * Example 1:
 * Input: "112358"
 * Output: true 
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 * Input: "199100199"
 * Output: true 
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 *              1 + 99 = 100, 99 + 100 = 199
 * Follow up:
 * How would you handle overflow for very large input integers?
 * @author wendi
 *
 */
public class AdditiveNumber {
	
	/**
	 * Backtracking
	 * 1. Choose the first number A, it can be the leftmost 1 up to i digits. i<=(L-1)/2 because the 
	 * third number should be at least as long as the first number
	 * 2. Choose the second number B, it can be the leftmost 1 up to j digits excluding the first 
	 * number. the limit for j is a little bit tricky, because we don't know whether A or B is 
	 * longer. The remaining string (with length L-j) after excluding A and B should have a length 
	 * of at least max(length A, length B), where length A = i and length B = j-i, thus L-j >= max(j-i, i)
	 * 3. Calls the recursive checker function and returns true if passes the checker function, or 
	 * continue to the next choice of B (A) until there is no more choice for B or A, in which case 
	 * returns a false.
	 * @param String num
	 * @return boolean
	 * Time: O(n^3)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public boolean additiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        int n = num.length() - 1;
        for (int i = 1; i <= n; i++) {
        	long a = parse(num.substring(0, i));
        	if (a == -1) continue;
        	for (int j = i + 1; j < n; j++) {
        		long b = parse(num.substring(i, j));
        		if (b == -1) continue;
        		if (dfs(num, j, a, b)) return true;
        	}
        }
        return false;
    }
	
	private boolean dfs(String num, int start, long a, long b) {
		if (start == num.length()) return true;
		for (int i = start + 1; i <= num.length(); i++) {
			long c = parse(num.substring(start, i));
			if (c == -1) continue;
			if (a == c - b && dfs(num, i, b, c)) return true;
			if (a < c - b) break;
		}
		return false;
	}
	
	private long parse(String num) {
		if (!num.equals("0") && num.startsWith("0")) return -1;
		return Long.parseLong(num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditiveNumber result = new AdditiveNumber();
		System.out.println(result.additiveNumber("199100199"));
	}

}
