import java.util.Arrays;
import java.util.Comparator;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each 
 * log has at least one word after its identifier.
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are 
 * ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The 
 * digit-logs should be put in their original order.
 * Return the final order of the logs.
 * Example 1:
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * Note:
 * 1. 0 <= logs.length <= 100
 * 2. 3 <= logs[i].length <= 100
 *  * 3. logs[i] is guaranteed to have an identifier, and a word after the identifier.
 * @author wendi
 *
 */
public class ReorderLogFiles {

	
	/**
	 * Arrays sort
	 * @param String[] logs
	 * @return String[]
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return logs;
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int indexA = a.indexOf(" ");
                int indexB = b.indexOf(" ");
                char cA = a.charAt(indexA + 1);
                char cB = b.charAt(indexB + 1);
                if (!Character.isDigit(cA) && !Character.isDigit(cB)) {
                    return a.substring(indexA + 1).compareTo(b.substring(indexB + 1));
                }
                else if (!Character.isDigit(cA)) {
                    return -1;
                }
                else if (!Character.isDigit(cB)) {
                    return 1;
                }
                else return 0;
            }
        });
        return logs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderLogFiles result = new ReorderLogFiles();
		System.out.println(Arrays.toString(result.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
	}

}
