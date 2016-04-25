/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * @author wendi
 *
 */
public class CountandSay {
	
	/**
	 * two pointer, i used for index which c, count used for how many time c occur.
	 * @param n
	 * @return String 
	 * Time: O(n * 2^n)  2^n:the longest length of subresult
	 * Space: O(2^n)
	 */
	public String countandSay(int n) {
		if (n == 0) {
			return "";
		}
		String result = "1";
		while (n > 1) {
			String oldResult = result;
			result = "";
			int i = 0;
			while (i < oldResult.length()) {
				int count = 1;
				while (i + 1 < oldResult.length() && oldResult.charAt(i) == oldResult.charAt(i + 1)) {
					count++;
					i++;
				}
				result += String.valueOf(count) + String.valueOf(oldResult.charAt(i));
				i++;
			}
			n--;
		}
		return result;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay result = new CountandSay();
		System.out.println(result.countandSay(20));

	}

}
