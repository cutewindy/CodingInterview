/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output 
 * the digits in ascending order.
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid 
 * inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 * @author wendi
 *
 */
public class ReconstructOriginalDigitsfromEnglish {
	
	
	
	/**
	 * Math
	 * 思路是先要统计出各个字符出现的次数，然后算出每个单词出现的次数，然后就可以重建了。由于题目中限定了输入的字符串一定是有
	 * 效的，那么不会出现无法成功重建的情况，这里需要用个trick。我们仔细观察这些表示数字的单词
	 * "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"，
	 * 我们可以发现有些的单词的字符是独一无二的，比如z，只出现在zero中，还有w，u，x，g这四个单词，分别只出现在
	 * two，four，six，eight中，那么这五个数字的个数就可以被确定了，由于含有o的单词有zero，two，four，one，
	 * 其中前三个都被确定了，那么one的个数也就知道了；由于含有h的单词有eight，three，其中eight个数已知，
	 * 那么three的个数就知道了；由于含有f的单词有four，five，其中four个数已知，那么five的个数就知道了；
	 * 由于含有s的单词有six，seven，其中six个数已知，那么seven的个数就知道了；
	 * 由于含有i的单词有six，eight，five，nine，其中前三个都被确定了，那么nine的个数就知道了，
	 * 知道了这些问题就变的容易多了，我们按这个顺序
	 * "zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"就能找出所有的个数了
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
    public String reconstructOriginalDigitsfromEnglish(String s) {
        if (s == null || s.length() == 0) return "";
        int[] cnts = new int[256];
        for (char c: s.toCharArray()) {
            cnts[c]++;
        }
        int[] digits = new int[10];
        digits[0] = cnts['z'];
        digits[2] = cnts['w'];
        digits[4] = cnts['u'];
        digits[6] = cnts['x'];
        digits[8] = cnts['g'];
        digits[1] = cnts['o'] - digits[0] - digits[2] - digits[4];
        digits[3] = cnts['h'] - digits[8];
        digits[5] = cnts['f'] - digits[4];
        digits[7] = cnts['s'] - digits[6];
        digits[9] = cnts['i'] - digits[5] - digits[6] - digits[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digits[i]; j++) {
                sb.append(i);
            }
        } 
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructOriginalDigitsfromEnglish result = new ReconstructOriginalDigitsfromEnglish();
		System.out.println(result.reconstructOriginalDigitsfromEnglish("owoztneoerowoztneoer"));
	}

}
