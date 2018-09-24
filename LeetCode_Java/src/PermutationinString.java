/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of 
 * s1. In other words, one of the first string's permutations is the substring of the second string.
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * Note:
 * 1. The input strings only contain lower case letters.
 * 2. The length of both given strings is in range [1, 10,000].
 * @author wendi
 *
 */
public class PermutationinString {
	
	/**
	 * sliding window
	 * How do we know string p is a permutation of string s? Easy, each character in p is in s too. 
	 * So we can abstract all permutation strings of s to a map (Character -> Count). i.e. abba -> 
	 * {a:2, b:2}. Since there are only 26 lower case letters in this problem, we can just use an 
	 * array to represent the map.
	 * How do we know string s2 contains a permutation of s1? We just need to create a sliding 
	 * window with length of s1, move from beginning to the end of s2. When a character moves in 
	 * from right of the window, we subtract 1 to that character count from the map. When a character 
	 * moves out from left of the window, we add 1 to that character count. So once we see all zeros 
	 * in the map, meaning equal numbers of every characters between s1 and the substring in the 
	 * sliding window, we know the answer is true.
	 * @param String s1, String s2
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean permutationinString(String s1, String s2) {
		if (s1.length() > s2.length()) return false;
		int[] cnts = new int[26];
		for (char c: s1.toCharArray()) cnts[c - 'a']++;
		int cnt = 0;
		char[] array2 = s2.toCharArray();
		int n = s1.length();
		// init, check first n-1 values of s2
		for (int i = 0; i < n - 1; i++) {
			if (cnts[array2[i] - 'a']-- > 0) cnt++;
		}
		
		// update
		for (int i = n - 1; i < array2.length; i++) {
			if (cnts[array2[i] - 'a']-- > 0) cnt++;  // add start
			if (cnt == n) return true;
			if (++cnts[array2[i - n + 1] - 'a'] > 0) cnt--; // remove end
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationinString result = new PermutationinString();
		System.out.println(result.permutationinString("ab", "eidbaooo"));
		System.out.println(result.permutationinString("ab", "eidboaoo"));
	}

}
