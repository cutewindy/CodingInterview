/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * 
 * Tags: Twp Pointers, String
 * @author wendi
 *
 */
public class ImplementStrStr {

	/**
	 * Method2: Using build-in function of indexOf().
	 * @param String haystack, String needle
	 * @return int 
	 * Time: O()
	 * Space: O()
	 */
	public int implementStrStrI(String haystack, String needle) {
		return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
	}	
	
	
	/**
	 * Method1: Two Pointers: use iH+iN as the index of haysatck and iN as the index of needle.
	 * if chars are equal, iN++, compare the next char pairs; else iH++, iN=0, 
	 * compare from beginning of needle.
	 * @param String haystack, String needle
	 * @return int (the first position of needle in haystack)
	 * Time: O(m * n) m: the length of haystack; n: the length of needle
	 * Space: O(1)
	 */
	public int implementStrStr(String haystack, String needle) {
		if (haystack == null || needle == null || (haystack.length() < needle.length())) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
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
		System.out.println(result.implementStrStr("wendi weng", "weng"));
		System.out.println(result.implementStrStr("", ""));

	}

}
