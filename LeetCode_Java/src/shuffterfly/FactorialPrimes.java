package shuffterfly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * factorial primes： 给你一个非负整数 n， 让你返回 n的阶乘里包含的各个prime的个数，比如n=5 n!=5*4*3*2*1 返回 
 * “3 1 1” 即 三个2  一个3 一个5.
 * @author wendi
 *
 */
public class FactorialPrimes {
	
	/**
	 * 
	 * @param int n
	 * @return List<Integer>
	 * Time: O()
	 * Space: O()
	 */
	public List<Integer> factorialPrimes(int n) {
		if (n <= 1) return new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 2; i <= n; i++) {
			int x = i;
			int y = 2;
			while (x != 1) {
				if (x % y == 0) {
					count.put(y, count.getOrDefault(y, 0) + 1);
					x /= y;
				}
				else y++;
			}
		}
		List<Integer> res = new ArrayList<>();
		res.addAll(count.values());
		return res;
	}
	
//		if (n <= 1) return new ArrayList<>();
//		Map<Integer, Integer> count = new HashMap<>();
//		Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
//		for (int i = 2; i <= n; i++) {
//			Map<Integer, Integer> currRes = dfs(i, 2, memo);
//			for (Integer key: currRes.keySet()) {
//				count.put(key, count.getOrDefault(key, 0) + 1);
//			}
//		}
//		List<Integer> res = new ArrayList<>();
//		res.addAll(count.values());
//		return res;
//	}
//	
//	private Map<Integer, Integer> dfs(int x, int start, Map<Integer, Map<Integer, Integer>> memo) {
//		if (x == 1) return null;
//		if (memo.containsKey(x)) {
//			return memo.get(x);
//		}
//		Map<Integer, Integer> res = new HashMap<>();
//		for (int y = start; y <= x; y++) {
//			if (x % y != 0) continue;
//			Map<Integer, Integer> temp = dfs(x / y, y, memo);
//			if (temp != null) {
//				for (Integer key: temp.keySet()) {
//					res.put(key, temp.get(key));
//				}
//			}
//			res.put(y, res.getOrDefault(y, 0) + 1);
//			break;
//		}
//		return res;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialPrimes result = new FactorialPrimes();
		System.out.println(result.factorialPrimes(10));
	}

}
