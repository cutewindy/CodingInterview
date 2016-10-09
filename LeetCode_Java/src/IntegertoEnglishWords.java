/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to 
 * be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Hint:
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function that takes a number 
 * less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? Does your code work with input such as 
 * 0? Or 1000010? (middle chunk is zero and should not be printed out)
 * 
 * Tags: Math, String
 * @author wendi
 *
 */
public class IntegertoEnglishWords {
	
	/**
	 * Like "Roman to Integer"
	 * @param int num
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String integertoEnglishWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		StringBuilder result = new StringBuilder();
		if (num >= 1000000000) {
			result.append(helper(num / 1000000000)).append("Billion ");
			num %= 1000000000;
		}
		if (num >= 1000000) {
			result.append(helper(num / 1000000)).append("Million ");
			num %= 1000000;
		}
		if (num >= 1000) {
			result.append(helper(num / 1000)).append("Thousand ");
			num %= 1000;
		}
		result.append(helper(num));
		return result.substring(0, result.length() - 1).toString();
	}
	
	private String helper(int num) {
		StringBuilder sb = new StringBuilder();
		String[] nums = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", 
				"Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", 
				"Seventeen ", "Eighteen ", "Nineteen "};
		String[] tens = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ","Sixty ", "Seventy ", "Eighty ", 
				"Ninety "};
		int a = num / 100;
		int b = num % 100;
		sb.append(a == 0 ? "" : nums[a] + "Hundred ");
		sb.append(b < 20 ? nums[b] : tens[b / 10] + nums[b % 10]);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegertoEnglishWords result = new IntegertoEnglishWords();
		System.out.println(result.integertoEnglishWords(1234567));
	}

}
