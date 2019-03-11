import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters 
 * that show up in all strings within the list (including duplicates).  For example, if a character 
 * occurs 3 times in all strings but not 4 times, you need to include that character three times in 
 * the final answer.
 * You may return the answer in any order.
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * Note:
 * 1. 1 <= A.length <= 100
 * 2. 1 <= A[i].length <= 100
 * 3. A[i][j] is a lowercase letter
 * @author wendi
 *
 */
public class FindCommonCharacters {
	
	
	/**
	 * char array count
	 * we count characters in currCharCnt. Then, we track the minimum count for each character in charCnt.
	 * @param String[] A
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<String> findCommonCharacters(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        int[] charCnt = new int[26];
        Arrays.fill(charCnt, Integer.MAX_VALUE);
        for (String a: A) {
            int[] currCharCnt = new int[26];
            for (char c: a.toCharArray()) {
                currCharCnt[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                charCnt[i] = Math.min(currCharCnt[i], charCnt[i]);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (charCnt[c - 'a']-- != 0) res.add(c + "");
        }
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
