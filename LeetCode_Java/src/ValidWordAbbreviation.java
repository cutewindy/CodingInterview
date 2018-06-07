/**
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the 
 * given abbreviation.
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", 
 * "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other 
 * string is not a valid abbreviation of "word".
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * Return true.
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * Return false.
 * @author wendi
 *
 */
public class ValidWordAbbreviation {
	
	
	/**
	 * Method1: Brute force
	 * @param String word, String abbr
	 * @return boolean
	 * Time: O(m+n)
	 * Space: O(1)
	 */
	public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null && abbr == null) return true;
        if (word == null || abbr == null) return false;
        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();
        int i = 0;
        int j = 0;
        while (i < w.length && j < a.length) {
            int count = 0;
            while (j < a.length && Character.isDigit(a[j])) {
                if (count == 0 && a[j] - '0' == 0) return false;  // case: word:"a"  abbr:"01"
                count = count * 10 + a[j] - '0';
                j++;
            }
            i += count;
            if (i == w.length && j == a.length) return true;
            if (i >= w.length || j >= a.length || w[i] != a[j]) return false;
            i++;
            j++;
        }
        return i == w.length && j == a.length;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidWordAbbreviation result = new ValidWordAbbreviation();
		System.out.println(result.validWordAbbreviation("internationalization", "i12iz4n"));
		System.out.println(result.validWordAbbreviation("apple", "a2e"));
		System.out.println(result.validWordAbbreviation("a", "01"));
	}

}
