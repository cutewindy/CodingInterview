import java.util.Arrays;

/**
 * Given a string S and a character C, return an array of integers representing the shortest 
 * distance from the character C in the string.
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * Note:
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 * @author wendi
 *
 */
public class ShortestDistancetoaCharacter {
	
	
	/**
	 * min array
	 * For each index S[i], let's try to find the distance to the next character C going left, and 
	 * going right. The answer is the minimum of these two values.
	 * @param String S, char C
	 * @return int[]
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public int[] shortestDistancetoaCharacter(String S, char C) {
		char[] s = S.toCharArray();
		int n = s.length;
		int[] res = new int[n];
		int left = -n;
		for (int i = 0; i < n; i++) {
			if (s[i] == C) left = i;
			res[i] = i - left;
		}
		int right = 2 * n;
		for (int i = s.length - 1; i >= 0; i--) {
			if (s[i] == C) right = i;
			res[i] = Math.min(right - i, res[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestDistancetoaCharacter result = new ShortestDistancetoaCharacter();
		System.out.println(Arrays.toString(result.shortestDistancetoaCharacter("loveleetcode", 'e')));
	}

}
