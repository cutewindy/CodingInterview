/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines; 
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * Tags: String
 * @author wendi
 *
 */
public class RansomNote {

	/**
	 * Using char array
	 * @param String ransomNote, String magazine
	 * @return boolean
	 * Time: O(m + n)
	 * Space: O(n)
	 */
	public boolean ransomNote(String ransomNote, String magazine) {
		if (ransomNote == null && magazine == null || ransomNote.length() == 0 && ransomNote.length() == 0) {
			return true;
		}
		if (ransomNote == null || magazine == null || ransomNote.length() == 0 ||  ransomNote.length() > magazine.length()) {
			return false;
		}
        int[] letters = new int[26];
        for (char c: magazine.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c: ransomNote.toCharArray()) {
            if (--letters[c - 'a'] < 0) return false;
        }
        return true;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RansomNote result = new RansomNote();
		System.out.println(result.ransomNote("bab", "abbc"));
	}

}
