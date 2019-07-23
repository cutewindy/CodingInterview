import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only 
 * if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to 
 * another domino.
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is 
 * equivalent to dominoes[j].
 * Example 1:
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 * Constraints:
 * 1. 1 <= dominoes.length <= 40000
 * 2. 1 <= dominoes[i][j] <= 9
 * @author wendi
 *
 */
public class NumberofEquivalentDominoPairs {
	
	/**
	 * Map + smartkey according to constraints.
	 * @param int[][] dominoes
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] d: dominoes) {
            int key = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            if (map.containsKey(key)) res += map.get(key);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofEquivalentDominoPairs result = new NumberofEquivalentDominoPairs();
		System.out.println(result.numEquivDominoPairs(new int[][] {{1,2},{2,1},{3,4},{5,6}}));
	}

}
