import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that 
 * the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain 
 * leading zeroes.
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * @author wendi
 *
 */
public class RemoveKDigits {
	
	/**
	 * Stack
	 * @param String num, int k
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
    public String removeKDigits(String num, int k) {
        if (num == null || num.length() == 0) return "";
        if (k >= num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
        	//whenever meet a digit which is less than the previous digit, discard the previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        // corner case like "1111"
        while (k-- > 0) {  
            stack.pop();
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        //remove all the 0 at the head
        String res = sb.reverse().toString();
        int startIdx = 0;
        while (startIdx < res.length() && res.charAt(startIdx) == '0') {
            startIdx++;
        }
        if (startIdx == res.length()) return "0";
        
        return res.substring(startIdx);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveKDigits result = new RemoveKDigits();
		System.out.println(result.removeKDigits("1432219", 3));
	}

}
