import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial 
 * called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open 
 * the door.
 * Given a string ring, which represents the code engraved on the outer ring and another string key, 
 * which represents the keyword needs to be spelled. You need to find the minimum number of steps in 
 * order to spell all the characters in the keyword.
 * Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all 
 * the characters in the string key one by one by rotating the ring clockwise or anticlockwise to 
 * make each character of the string key aligned at 12:00 direction and then by pressing the center 
 * button. 
 * At the stage of rotating the ring to spell the key character key[i]:
 * You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final 
 * purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, 
 * where this character must equal to the character key[i].
 * If the character key[i] has been aligned at the 12:00 direction, you need to press the center 
 * button to spell, which also counts as 1 step. After the pressing, you could begin to spell the 
 * next character in the key (next stage), otherwise, you've finished all the spelling.
 * Example:
 * Input: ring = "godding", key = "gd"
 * Output: 4
 * Explanation:
 *  For the first key character 'g', since it is already in place, we just need 1 step to spell this 
 *  character. 
 *  For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two 
 *  steps to make it become "ddinggo".
 *  Also, we need 1 more step for spelling.
 *  So the final output is 4.
 * Note:
 * 1. Length of both ring and key will be in range 1 to 100.
 * 2. There are only lowercase letters in both strings and might be some duplcate characters in both 
 * strings.
 * 3. It's guaranteed that string key could always be spelled by rotating the string ring.
 * @author wendi
 *
 */
public class FreedomTrail {

	
	/**
	 * Method3: DP
	 * 通过匹配的方法，从key中一一取出一个字符，在ring中匹配，得到转到该字符的最小转数。注意，除了第一个字符外，剩下的字符
	 * 的转数需要由上一个字符的转数加上转动次数决定。本题需要考虑的是当出现了顺、逆时针转动时都有相同转数的匹配，这是应该选择
	 * 顺时针还是逆时针，这里需要将两种结果与下一个匹配的结果相加进行比较来选择。dp[i][j]表示key的从0到i的字符匹配到ring
	 * 的j字符需要的最小的step，
	 * @param String ring, String key
	 * @return int
	 * Time: O(k*r^2) k=ring.length(), r=ring.length()
	 * Space: O(k*r)
	 */
	public int freedomTrailII(String ring, String key) {
		char[] K = key.toCharArray();
		char[] R = ring.toCharArray();
		int m = K.length;
		int n = R.length;
		int[][] dp = new int[m][n];
		for (int[] d: dp) Arrays.fill(d, Integer.MAX_VALUE);
		
		// init
		for (int j = 0; j < n; j++) {
			if (R[j] == K[0]) dp[0][j] = Math.min(j, n - j) + 1;
		}
		
		// update
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (R[j] != K[i]) continue;
				for (int k = 0; k < n; k++) {
					if (dp[i - 1][k] == Integer.MAX_VALUE) continue;
					int diff = Math.abs(k - j);
					int steps = Math.min(diff, n - diff) + 1 + dp[i - 1][k];
					dp[i][j] = Math.min(steps, dp[i][j]);
				}
			}
		}
		
		int res = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			res = Math.min(dp[m - 1][j], res);
		}
		
		return res;
	}
	
	
	/**
	 * Method2: DFS + Memoization
	 * @param String ring, String key
	 * @return int
	 * Time: O(k*r) k=ring.length(), r=ring.length()
	 * Space: O(k+r)
	 * Stack space: O(k)
	 */
	public int freedomTrailI(String ring, String key) {
		return getMinSteps(ring.toCharArray(), key.toCharArray(), 0, 0, new HashMap<String, Integer>());
	}
	
	private int getMinSteps(char[] rings, char[] keys, int keyIdx, int ringIdx, Map<String, Integer> minSteps) {
		if (keyIdx == keys.length) return 0;
		
		String key = keyIdx + "->" + ringIdx;
		if (minSteps.containsKey(key)) return minSteps.get(key);
		
		int minStep = Integer.MAX_VALUE;
		for (int i = 0; i < rings.length; i++) {
			if (rings[i] != keys[keyIdx]) continue;
			int diff = Math.abs(i - ringIdx);
			int step = getMinSteps(rings, keys, keyIdx + 1, i, minSteps) + Math.min(diff, rings.length - diff) + 1;
			minStep = Math.min(step, minStep);
		}

		minSteps.put(key, minStep);
		
		return minStep;
	}
	
	
	/**
	 * Method1: Brute Force DFS(TLE)
	 * @param String ring, String key
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	private int res;
	public int freedomTrail(String ring, String key) {
		res = Integer.MAX_VALUE;
		Map<Character, List<Integer>> map = new HashMap<>();
		char[] R = ring.toCharArray();
		for (int i = 0; i < R.length; i++) {
			if (!map.containsKey(R[i])) map.put(R[i], new ArrayList<Integer>());
			map.get(R[i]).add(i);
		}
		
		dfs(map, key.toCharArray(), 0, 0, 0, R.length);
		
		return res;
    }
	
	private void dfs(Map<Character, List<Integer>> map, char[] keys, int index, int i, int steps, int n) {
		if (index == keys.length) {
			res = Math.min(steps, res);
			return;
		}
		for (Integer j: map.get(keys[index])) {
			dfs(map, keys, index + 1, j, steps + (j - i + n) % n + 1, n);
			dfs(map, keys, index + 1, j, steps + (i - j + n) % n + 1, n);
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FreedomTrail result = new FreedomTrail();
		System.out.println(result.freedomTrail("godding", "gd"));
		System.out.println(result.freedomTrailI("godding", "gd"));
		System.out.println(result.freedomTrailII("godding", "gd"));
	}

}
