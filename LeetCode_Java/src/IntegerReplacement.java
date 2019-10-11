import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * Example 1:
 * Input: 8
 * Output: 3
 * Explanation: 8 -> 4 -> 2 -> 1
 * Example 2:
 * Input: 7
 * Output: 4
 * Explanation: 7 -> 8 -> 4 -> 2 -> 1 or 7 -> 6 -> 3 -> 2 -> 1
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class IntegerReplacement {
	
	/**
	 * Bit Manipulation:
	 * If (n != 3) n & 0b11 = 0b11, n + 1.
	 * Else if n & 0b1 = 0b1, n - 1.
	 * Else n / 2.
	 * @param int n
	 * @return int 
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int integerReplacement(int n) {
		if (n <=0) {
			return n;
		}
		int count = 0;
		while (n != 1) {
			if (n != 3 && (n & 3) == 3) {
				n++;
			}
			else if ((n & 1) == 1) {
				n--;
			}
			else {
				n >>>= 1;
			}
			count++;
		}
		return count;
	}
	
	
	/**
	 * dfs + memorization
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
    public int integerReplacementI(int n) {
        // Write your code here
        if (n == 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(n, map);
    }
    
    private int dfs(int n, Map<Integer, Integer> map) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            res = dfs(n / 2, map) + 1;
        }
        else {
            res = Math.min(dfs(n + 1, map), dfs(n - 1, map)) + 1;
        }
        map.put(n, res);
        return res;
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerReplacement result = new IntegerReplacement();
		System.out.println(result.integerReplacement(15));
		System.out.println(result.integerReplacement((13)));
	}

}
