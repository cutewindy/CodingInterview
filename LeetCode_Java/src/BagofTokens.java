import java.util.Arrays;

/**
 * You have an initial power P, an initial score of 0 points, and a bag of tokens.
 * Each token can be used at most once, has a value token[i], and has potentially two ways to use it.
 * If we have at least token[i] power, we may play the token face up, losing token[i] power, and 
 * gaining 1 point.
 * If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 
 * 1 point.
 * Return the largest number of points we can have after playing any number of tokens.
 * Example 1:
 * Input: tokens = [100], P = 50
 * Output: 0
 * Example 2:
 * Input: tokens = [100,200], P = 150
 * Output: 1
 * Example 3:
 * Input: tokens = [100,200,300,400], P = 200
 * Output: 2
 * Note:
 * 1. tokens.length <= 1000
 * 2. 0 <= tokens[i] < 10000
 * 3. 0 <= P < 10000
 * @author wendi
 *
 */
public class BagofTokens {
	
	/**
	 * Arrays sort + two pointers + Greedy
	 * Sort tokens.
	 * Buy at the cheapest and sell at the most expensive.
	 * @param int[] tokens, int P
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
    public int bagofTokens(int[] tokens, int P) {
        if (tokens == null || tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int points = 0;
        int res = 0;
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i++];
                points += 1;
                res = Math.max(points, res);
            }
            else if (points > 0) {
                P += tokens[j--];
                points -= 1;
            }
            else break;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BagofTokens result = new BagofTokens();
		System.out.println(result.bagofTokens(new int[] {100,200,300,400}, 200));
	}

}
