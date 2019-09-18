import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * For example,
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 * Note:
 * Because the range might be a large number, the low and high numbers are represented as string.
 * 
 * Tags: Math, Recursion
 * @author wendi
 *
 */
public class StrobogrammaticNumberIII {

	/**
	 * Method2: 
	 * 基于第二道的基础上，不保存所有的结果，而是在递归中直接计数，根据之前的分析，需要初始化 n=0 和 n=1 的情况，然后在其
	 * 基础上进行递归，递归的长度 len 从 low 到 high 之间遍历，然后看当前单词长度有没有达到 len，如果达到了，首先要去掉
	 * 开头是0的多位数，然后去掉长度和 low 相同但小于 low 的数，和长度和 high 相同但大于 high 的数，然后结果自增1，然后
	 * 分别给当前单词左右加上那五对对称数，继续递归调用
	 * @param String low, String high
	 * @return int 
	 * Time: O((high - low)^2)
	 * Space: O(1)
	 */
	public int strobogrammaticNumberIIII(String low, String high) {
		if (low == null || low.length() == 0 || high == null || high.length() == 0 || low.length() > high.length()) {
			return 0;
		}
		int[] res = new int[1];
		for (int i = low.length(); i <= high.length(); i++) {
			dfs(i, low, high, "", res);
			dfs(i, low, high, "0", res);
			dfs(i, low, high, "1", res);
			dfs(i, low, high, "8", res);
		}
		return res[0];
	}	
	
	private void dfs(int len, String low, String high, String curr, int[] res) {
		if (curr.length() > len) return;
		if (curr.length() == len) {
			if (curr.length() != 1 && curr.charAt(0) == '0') return;
			if (len == low.length() && curr.compareTo(low) < 0 ||
				len == high.length() && curr.compareTo(high) > 0) return;
			res[0]++;
		}
		dfs(len, low, high, "0" + curr + "0", res);
		dfs(len, low, high, "1" + curr + "1", res);
		dfs(len, low, high, "6" + curr + "9", res);
		dfs(len, low, high, "8" + curr + "8", res);
		dfs(len, low, high, "9" + curr + "6", res);
	}
	
	/**
	 * Method1:(Time Limit Exceeded) Using stronbogrammaticNumberII, and then count satisfied 
	 * strobogrammatic number.
	 * @param int low, int high
	 * @return int 
	 * Time: O()
	 * Space: O()
	 */
	public int strobogrammaticNumberIII(String low, String high) {
		if (low == null || low.length() == 0 || high == null || high.length() == 0 || low.length() > high.length()) {
			return 0;
		}
		// 1 calculate all stro with the length between low.length() and high.length()
		List<String> stro = new ArrayList<>();
		for (int n = low.length(); n <= high.length(); n++) {
			stro.addAll(getStro(n));
		}
		System.out.println(stro);
		// 2 count how many stro numbers satisfied between low and high
		int count = 0;
		for (String str: stro) {
			if (str.length() == low.length() && str.compareTo(low) < 0 ||
				str.length() == high.length() && str.compareTo(high) > 0) {
				continue;
			}
			count++;
			System.out.println(str);
		}
		return count;
	}
	
	private List<String> getStro(int n) {
		List<String> result = new ArrayList<>();
		result.addAll(n % 2 == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
		for (int i = 1; i <= n / 2; i++) {
			List<String> newRes = new ArrayList<>();
			for (String str: result) {
				if (i != n / 2) newRes.add("0" + str + "0");
				newRes.add("1" + str + "1");
				newRes.add("6" + str + "9");
				newRes.add("8" + str + "8");
				newRes.add("9" + str + "6");
 			}
			result = newRes;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrobogrammaticNumberIII result = new StrobogrammaticNumberIII();
		System.out.println(result.strobogrammaticNumberIII("50", "100"));
		System.out.println(result.strobogrammaticNumberIIII("50", "100"));
	}

}
