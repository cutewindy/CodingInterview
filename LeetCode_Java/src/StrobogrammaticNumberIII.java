import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * For example,
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 * Note:
 * Because the range might be a large number, the low and high numbers are represented as string.
 * 
 * Tags: Math, Recursion
 * @author wendi
 *
 */
public class StrobogrammaticNumberIII {

	/**
	 * Method2: 
	 * @param String low, String high
	 * @return int 
	 * Time: O()
	 * Space: O()
	 */
	public int strobogrammaticNumberIIII(String low, String high) {
		if (low == null || low.length() == 0 || high == null || high.length() == 0 || low.length() > high.length()) {
			return 0;
		}
		return 0;
	}	
	
	/**
	 * Method1:(Time Limit Exceeded) Using stronbogrammaticNumberII, and then count satisfied 
	 * strobogrammatic number.
	 * @param int low, int high
	 * @return int 
	 * Time: O()
	 * Space: O()
	 */
	public int strobogrammaticNumberIII(String low, String high) {
		if (low == null || low.length() == 0 || high == null || high.length() == 0 || low.length() > high.length()) {
			return 0;
		}
		// 1 calculate all stro with the length between low.length() and high.length()
		List<String> stro = new ArrayList<>();
		for (int n = low.length(); n <= high.length(); n++) {
			stro.addAll(getStro(n));
		}
		System.out.println(stro);
		// 2 count how many stro numbers satisfied between low and high
		int count = 0;
		for (String str: stro) {
			if (str.length() == low.length() && str.compareTo(low) < 0 ||
				str.length() == high.length() && str.compareTo(high) > 0) {
				continue;
			}
			count++;
			System.out.println(str);
		}
		return count;
	}
	
	private List<String> getStro(int n) {
		List<String> result = new ArrayList<>();
		result.addAll(n % 2 == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
		for (int i = 1; i <= n / 2; i++) {
			List<String> newRes = new ArrayList<>();
			for (String str: result) {
				if (i != n / 2) newRes.add("0" + str + "0");
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
		StrobogrammaticNumberIII result = new StrobogrammaticNumberIII();
		System.out.println(result.strobogrammaticNumberIII("50", "100"));
		System.out.println(result.strobogrammaticNumberIIII("50", "100"));
	}

}
