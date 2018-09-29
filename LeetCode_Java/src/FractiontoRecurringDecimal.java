import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction 
 * in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * Example 1:
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * @author wendi
 *
 */
public class FractiontoRecurringDecimal {
	
	/**
	 * HashMap
	 * 解决方法：用一个HashMap记录每一个余数，当出现重复的余数时，那么将会进入循环，两个重复余数之间的部分就是循环体。
	 * 示例：1/13=0.076923076923076923...，当小数部分第二次出现0时，就意味着开始了循环，那么需要把076923用括号括起
	 *      来，结果为0.(076923)。
	 * 涉及技巧：1）在不断相除的过程中，把余数乘以10再进行下一次相除，保证一直是整数相除；
	 *         2）HashMap的key和value分别是<当前余数, 对应结果下标>，这样获取076923时就可根据value值来找。
	 * @param int numerator, int denominator
	 * @return String
	 * Time: O(n) n = res.length()
	 * Space: O(1)
	 */
	public String fractiontoRecurringDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
		StringBuilder sb = new StringBuilder();
        // "+" or "-"
		if (1.0 * numerator / denominator < 0) sb.append("-"); 
		long num = Math.abs((long) numerator);      // take care
		long den = Math.abs((long) denominator);    // take care
        
        // integral part
		sb.append(num / den);
		num %= den;
		if (num == 0) return sb.toString();
        
        // fractional part
		sb.append(".");
		Map<Long, Integer> map = new HashMap<>();
		map.put(num, sb.length());
		while (num != 0) {
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (map.containsKey(num)) {   // has repeating fractional part
				sb.insert(map.get(num), "(");
				sb.append(")");
				return sb.toString();
			}
			map.put(num, sb.length());
		}
		return sb.toString(); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractiontoRecurringDecimal result = new FractiontoRecurringDecimal();
		System.out.println(result.fractiontoRecurringDecimal(1, 6));
		System.out.println(result.fractiontoRecurringDecimal(7, -12));
		System.out.println(result.fractiontoRecurringDecimal(14, -13));
	}

}
