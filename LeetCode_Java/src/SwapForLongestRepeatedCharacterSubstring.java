/**
 * Given a string text, we are allowed to swap two of the characters in the string. Find the length 
 * of the longest substring with repeated characters.
 * Example 1:
 * Input: text = "ababa"
 * Output: 3
 * Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. 
 * Then, the longest repeated character substring is "aaa", which its length is 3.
 * Example 2:
 * Input: text = "aaabaaa"
 * Output: 6
 * Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character 
 * substring "aaaaaa", which its length is 6.
 * Example 3:
 * Input: text = "aaabbaaa"
 * Output: 4
 * Example 4:
 * Input: text = "aaaaa"
 * Output: 5
 * Explanation: No need to swap, longest repeated character substring is "aaaaa", length is 5.
 * Example 5:
 * Input: text = "abcdef"
 * Output: 1
 * Constraints:
 * 1. 1 <= text.length <= 20000
 * 2. text consist of lowercase English characters only.
 * @author wendi
 *
 */
public class SwapForLongestRepeatedCharacterSubstring {
	
	
	/**
	 * sliding window:
	 * At each char, we will see how far right we can go. Obviously, if it is the same char, we can 
	 * move forward otherwise we record we saw one diff char by isSwap=true and mark the next start 
	 * position.
	 * count < counts[c-'a'] will ensure we have enough current char occurrence to proceed when we 
	 * saw the different char.
	 * @param String text
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int swapForLongestRepeatedCharacterSubstring(String text) {
    	if (text == null || text.length() == 0) return 0;
        int n = text.length();
        int res = 0;
        int[] counts = new int[26];
        for (char c: text.toCharArray()) counts[c - 'a']++;
        for (int start = 0; start < n;) {
        	int end = start;
        	int count = 0;
        	boolean isSwap = false;
        	char c = text.charAt(start);
        	while (end < n && (text.charAt(end) == c || !isSwap)) {
        		if (text.charAt(end) != c) {
        			isSwap = true;
        			start = end;
        		}
        		count++;
        		end++;
        	}
        	res = Math.max(Math.min(count, counts[c - 'a']), res);  // case: "aaabaaa"
        	if (!isSwap) start = end;
        }
        return res;
    }

    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapForLongestRepeatedCharacterSubstring result = new SwapForLongestRepeatedCharacterSubstring();
		System.out.println(result.swapForLongestRepeatedCharacterSubstring("aaabaaa"));
	}

}
