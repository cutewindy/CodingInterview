import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a positive integer N, return the number of positive integers less than or equal to N that 
 * have at least 1 repeated digit.
 * Example 1:
 * Input: 20
 * Output: 1
 * Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
 * Example 2:
 * Input: 100
 * Output: 10
 * Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 
 * 66, 77, 88, 99, and 100.
 * Example 3:
 * Input: 1000
 * Output: 262
 * Note:
 * 1 <= N <= 10^9
 * @author wendi
 *
 */
public class NumbersWithRepeatedDigits {
	
	
	/**
	 * Math:
	 * 步骤很简单，反过来考虑就可以了。
如果想找出小于等于某个数且至少有一个重复数字的个数，先计算出没有重复数字的个数，再用当前数去剪就可以了。

计算没有重复数字个数的步骤，我们以 7654 为例。
1.先计算百位以及百位以下的数。
我们有
XXX ---- 9 * 9 * 8
XX--------9 * 9
X----------9

总共有 9 * 9 * 8 + 9 * 9 + 9 = 738

2.计算包含前缀的没有重复的数字
XXXX --- 6 * 9 * 8 * 7 (第1位小于7， 不包括0，有6个数)
7XXX --- 6 * 8 * 7 (第2位小于6， 包括0， 有6个数)
76XX --- 5 * 7 (第3位小于5， 包括0， 有5个数)
765X --- 5 (第4位小于等于4， 包括0， 有5个数)

结果为7654 - 4138 = 3516

corner case1. N = 20 (N 以0 结尾)
把N+1当做input， 理解了代码就会发现，我们不用把最后一位单独处理了，不然的的话最后一位就要翻译0和非0两种情况讨论，非常麻烦

corner case2. N = 220 （N 里面有重复的数字）
如果有重复的数字，break掉整个loop
	 * @param int N
	 * @return int
	 * Time: O(log(N))
	 * Space: O(log(N))
	 */
	public int numDupDigitsAtMostN(int N) {
		if (N == 1) return 0;
		int res = 0;
		int[] array = getArray(N + 1);
		for (int i = 1; i < array.length; i++) {
			res += 9 * P(9, i - 1);
		}
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i]; j++) {
				if (i == 0 && j == 0) continue; // skip case 0XXX
				if (visited.contains(j)) continue;
				res += P(9 - i, array.length - i - 1);
			}
			if (visited.contains(array[i])) break;
			visited.add(array[i]);
		}
		return N - res;
	}
	
	private int P(int m, int n) {
		if (n == 0) return 1;
		int res = 1;
		while (n-- > 0) {
			res *= m;
			m--;
		}
		return res;
	}
	
	private int[] getArray(int N) {
		List<Integer> list = new ArrayList<>();
		while (N != 0) {
			list.add(0, N % 10);
			N /= 10;
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumbersWithRepeatedDigits result = new NumbersWithRepeatedDigits();
		System.out.println(result.numDupDigitsAtMostN(20));
		System.out.println(result.numDupDigitsAtMostN(10));
	}

}
