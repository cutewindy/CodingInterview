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
        for (int i = 1; i < n; i++) {
            String curr = result;
            result = "";
            int count = 1;
            for (int j = 0; j < curr.length(); j++) {
                if (j + 1 < curr.length() && curr.charAt(j) == curr.charAt(j + 1)) {
                    count++;
                }
                else {
                    result += String.valueOf(count) + String.valueOf(curr.charAt(j));
                    count = 1;
                }
            }
        }
        return result;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay result = new CountandSay();
		System.out.println(result.countandSay(4));

	}

}
