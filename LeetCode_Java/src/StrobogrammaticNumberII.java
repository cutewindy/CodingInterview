import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 * Hint:
 * Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 * 
 * Tags: Math, Recursion
 * @author wendi
 *
 */
public class StrobogrammaticNumberII {

	/**
	 * Iterate: notice that 0 cannot be head of number
	 * 1. judge whether is odd or even digits number
	 * 2. add  0-0, 1-1, 6-9, 8-8, 9-6 pairs in newRes n/2 times.
	 * @param int n
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> strobogrammaticNumberII(int n) {
		List<String> result = new ArrayList<>();
		if (n <= 0) return result;
		result.addAll(n % 2 == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));  // be care not have 6 and 9
		for (int i = 1; i <= n / 2; i++) {
			List<String> newRes = new ArrayList<>();
			for (String str: result) {
				if (i != n / 2) {  // be care
					newRes.add("0" + str + "0"); 
				}
				newRes.add("1" + str + "1");
				newRes.add("6" + str + "9");
				newRes.add("8" + str + "8");
				newRes.add("9" + str + "6");
			}
			result = newRes;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrobogrammaticNumberII result = new StrobogrammaticNumberII();
		System.out.println(result.strobogrammaticNumberII(3));
	}

}
