/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * @author wendi
 *
 */
public class ImplementStrStr {

	/**
	 * use iH+iN as the index of haysatck and iN as the index of needle.
	 * if chars are equal, iN++, compare the next char pairs; else iH++, iN=0, 
	 * compare from beginning of needle.
	 * @param String haystack
	 * @param String needle
	 * @return int the first position of needle in haystack
	 * Time: O(mn) m: the length of haystack; n: the length of needle
	 * Space: O(1)
	 */
	public int implementStrStr(String haystack, String needle) {
		if (haystack == null || needle == null || (haystack.length() == 0 && needle.length() != 0)) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		if (haystack.length() < needle.length()) {
			return -1;
		}
		int iH = 0;
		int iN = 0;
		while (iH + iN < haystack.length() && iN < needle.length()) {
			if (haystack.charAt(iH + iN) == needle.charAt(iN)) {
				iN++;
			}
			else {
				iH++;
				iN = 0;
			}
		}	
		return iN == needle.length() ? iH : -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStrStr result = new ImplementStrStr();
		System.out.println(result.implementStrStr("wendiweng", "weni"));
		System.out.println(result.implementStrStr("", ""));

	}

}
