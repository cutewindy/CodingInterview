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
	 * sliding window, two pointer
	 * @param n
	 * @return String 
	 * Time: O(n * 2^n)  2^n:the longest length of subresult
	 * Space: O(2^n)
	 */
    public String countandSay(int n) {
        String res = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] resArray = res.toCharArray();
            for (int start = 0, end = 0; start < resArray.length; start = end) {
                while (end < resArray.length && resArray[end] == resArray[start]) end++;
                sb.append(end - start).append(resArray[start]);
            }
            res = sb.toString();
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay result = new CountandSay();
		System.out.println(result.countandSay(4));

	}

}
