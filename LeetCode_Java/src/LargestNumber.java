import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * @author wendi
 *
 */
public class LargestNumber {
	
	/**
	 * Array sort
	 * The idea here is basically implement a String comparator to decide which String should come 
	 * first during concatenation. Because when you have 2 numbers (let's convert them into String), 
	 * you'll face only 2 cases:
	 * For example:
	 * String a = "9";
	 * String b = "31";
 	 * String s1 = a + b; // 931
 	 * String s2 = b + a; // 319
	 * Apparently, case1 is greater than case2 in terms of value.
	 * So, we should always put s1 in front of s2.
	 * @param int[] nums
	 * @return String
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) return "";
		int n = nums.length;
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) strs[i] = String.valueOf(nums[i]);
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String a, String b) {
				String s1 = a + b;
				String s2 = b + a;
				return s2.compareTo(s1);
			}
		});
		if (strs[0].equals("0")) return "0";
		StringBuilder res = new StringBuilder();
		for (String str: strs) res.append(str);
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber result = new LargestNumber();
		System.out.println(result.largestNumber(new int[] {10,2}));
		System.out.println(result.largestNumber(new int[] {3,30,34,5,9}));
		System.out.println(result.largestNumber(new int[] {0,0}));
	}

}
