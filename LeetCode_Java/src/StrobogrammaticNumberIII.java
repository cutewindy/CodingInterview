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
	 * 
	 * @param int low, int high
	 * @return int 
	 * Time: O()
	 * Space: O()
	 */
	public int strobogrammaticNumberIII(String low, String high) {
		if (low == null || low.length() == 0 || high == null || high.length() == 0 || low.length() > high.length()) {
			return 0;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrobogrammaticNumberIII result = new StrobogrammaticNumberIII();
		System.out.println(result.strobogrammaticNumberIII("50", "100"));
	}

}
