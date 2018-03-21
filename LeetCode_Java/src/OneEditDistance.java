/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 * @author wendi
 *
 */
public class OneEditDistance {
	
	/**
	 * tow pointers
	 *  There're 3 possibilities to satisfy one edit distance apart: 
	 * 1) Replace 1 char:
	 	  s: a B c
	 	  t: a D c
	 * 2) Delete 1 char from s: 
		  s: a D  b c
		  t: a    b c
	 * 3) Delete 1 char from t
		  s: a   b c
		  t: a D b c
	 * @param String s, String t
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean oneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
		for (int i = 0; i < s.length() && i < t.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (s.length() == t.length()) {      // case1: replace
					return s.substring(i + 1).equals(t.substring(i + 1));
				}
				else {                   // case2: delete char from s  case3: delete char from t
					return s.substring(i + 1).equals(t.substring(i)) || s.substring(i).equals(t.substring(i + 1));
				}
			}
		}
		return Math.abs(s.length() - t.length()) == 1;   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneEditDistance result = new OneEditDistance();
		System.out.println(result.oneEditDistance("abd", "ad"));
	}

}
