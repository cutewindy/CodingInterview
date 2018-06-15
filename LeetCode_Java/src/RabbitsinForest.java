import java.util.HashMap;
import java.util.Map;

/**
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you 
 * how many other rabbits have the same color as them. Those answers are placed in an array.
 * Return the minimum number of rabbits that could be in the forest.
 * Examples:
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that 
 * didn't.
 * Input: answers = [10, 10, 10]
 * Output: 11
 * Input: answers = []
 * Output: 0
 * Note:
 * 1. answers will have length at most 1000.
 * 2. Each answers[i] will be an integer in the range [0, 999].
 * @author wendi
 *
 */
public class RabbitsinForest {
	
	
	/**
	 * HashMap
	 * @param int[] answers
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int rabbitsinForest(int[] answers) {
		if (answers == null || answers.length == 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: answers) {
            if (!map.containsKey(n) || n + 1== map.get(n)) {
                map.put(n, 1);
                res += n + 1;
            }
            else map.put(n, map.get(n) + 1);
        }
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RabbitsinForest result = new RabbitsinForest();
		System.out.println(result.rabbitsinForest(new int[] {1, 1, 1, 3, 3}));
	}

}
