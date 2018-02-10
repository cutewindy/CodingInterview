import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the 
 * stones you have.  Each character in S is a type of stone you have.  You want to know how many of 
 * the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are 
 * case sensitive, so "a" is considered a different type of stone from "A".
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 * 
 * @author wendi
 *
 */
public class JewelsandStones {
	
	/**
	 * Using set
	 * @param String J, String S
	 * @return int
	 * Time: O(max(J.length(), S.length()))
	 * Space: O(J.length())
	 */
	public int jewelsandStones(String J, String S) {
		if (J == null || J.length() == 0 || S == null || S.length() == 0) {
			return 0;
		}
		int result = 0;
		Set<Character> set = new HashSet<>();
		for (char c: J.toCharArray()) {
			set.add(c);
		}
		for (char c: S.toCharArray()) {
			if (set.contains(c)) {
				result += 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JewelsandStones result = new JewelsandStones();
		System.out.println(result.jewelsandStones("aA", "aAAbbbb"));
		System.out.println(result.jewelsandStones("z", "ZZ"));
	}

}
