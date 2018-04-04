/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number 
 * of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 * Substrings that occur multiple times are counted the number of times they occur.
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", 
 * "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 
 * 1's and 0's.
 * Note:
 * 1. s.length will be between 1 and 50,000.
 * 2. s will only consist of "0" or "1" characters.
 * @author wendi
 *
 */
public class CountBinarySubstring {
	
	/**
	 * Method3: Optimizing Group by character
	 * We can amend our Method2 to calculate the answer on the fly. Instead of storing groups, 
	 * we will remember only prev = groups[-2] and cur = groups[-1]. Then, the answer is the sum of 
	 * min(prev, cur) over each different final (prev, cur) we see. 
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int countBinarySubstringII(String s) {
		if (s == null || s.length() == 0) return 0;
		int result = 0;
		char[] S = s.toCharArray();
		int prev = 0;
		int curr = 1;
		for (int i = 1; i < S.length; i++) {
			if (S[i] == S[i - 1]) curr++;
			else {
				result += Math.min(curr, prev);
				prev = curr;
				curr = 1;
			}
		}
		return result + Math.min(curr, prev);
	}
	
	/**
	 * Method2: Group by character
	 * We can convert the string s into an array groups that represents the length of same-character 
	 * contiguous blocks within the string. For example, if s = "110001111000000", 
	 * then groups = [2, 3, 4, 6].
	 * For every binary string of the form '0' * k + '1' * k or '1' * k + '0' * k, the middle of 
	 * this string must occur between two groups.
	 * Let's try to count the number of valid binary strings between groups[i] and groups[i+1]. 
	 * If we have groups[i] = 2, groups[i+1] = 3, then it represents either "00111" or "11000". We 
	 * clearly can make min(groups[i], groups[i+1]) valid binary strings within this string. 
	 * Because the binary digits to the left or right of this string must change at the boundary, 
	 * our answer can never be larger.
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int countBinarySubstringI(String s) {
		if (s == null || s.length() == 0) return 0;
		int k = 0;
		int[] group = new int[s.length()];
		group[0] = 1;
		char[] S = s.toCharArray();
		for (int i = 1; i < S.length; i++) {
			if (S[i] == S[i - 1]) group[k] += 1;
			else group[++k] += 1;
		}
		int result = 0;
		for (int i = 1; i <= k; i++) {
			result += Math.min(group[i], group[i - 1]);
		}
		return result;
	}
	
	
	
	/**
	 * Method1: Brute force
	 * @param String s
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int countBinarySubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		int result = 0;
		char[] S = s.toCharArray();
		for (int i = 0; i < S.length - 1; i++) {
			int left = i; 
			int right = i + 1;
			if (S[left] != S[right]) {
				result++;
				while (--left >= 0 && ++right < S.length && 
					  S[left] == S[left + 1] && S[right] == S[right - 1]) {
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountBinarySubstring result = new CountBinarySubstring();
		System.out.println(result.countBinarySubstring("00110011"));
		System.out.println(result.countBinarySubstring("10101"));
		System.out.println(result.countBinarySubstringI("00110011"));
		System.out.println(result.countBinarySubstringI("10101"));
		System.out.println(result.countBinarySubstringII("00110011"));
		System.out.println(result.countBinarySubstringII("10101"));
	}

}
