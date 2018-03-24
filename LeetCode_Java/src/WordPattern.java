import java.util.HashSet;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a 
 * non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters 
 * separated by a single space.
 * @author wendi
 *
 */
public class WordPattern {

	/**
	 * char array + set
	 * @param String pattern, String str
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n + 26)
	 */
	public boolean wordPattern(String pattern, String str) {
        if (str == null || str.length() == 0) return true;
        if (pattern == null || pattern.length() == 0) return false;
        String[] Str = str.trim().split(" ");
        char[] p = pattern.toCharArray();
        if (Str.length != p.length) return false;
        String[] map = new String[26];
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < p.length; i++) {
            if (map[p[i] - 'a'] == null && !seen.contains(Str[i])) {
                map[p[i] - 'a'] = Str[i];
                seen.add(Str[i]);
            }
            else if (map[p[i] - 'a'] == null && seen.contains(Str[i]) 
            		|| !map[p[i] - 'a'].equals(Str[i])) return false;
        }
        return true;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPattern result = new WordPattern();
		System.out.println(result.wordPattern("abba", "dog cat cat dog"));
		System.out.println(result.wordPattern("abba", "dog cat cat fish"));
	}

}
