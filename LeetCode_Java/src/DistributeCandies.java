import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array with even length, where different numbers in this array represent different 
 * kinds of candies. Each number means one candy of the corresponding kind. You need to distribute 
 * these candies equally in number to brother and sister. Return the maximum number of kinds of 
 * candies the sister could gain.
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
 * The sister has three different kinds of candies. 
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
 * The sister has two different kinds of candies, the brother has only one kind of candies. 
 * Note:
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 * @author wendi
 *
 */
public class DistributeCandies {

	/**
	 * Math: the result is the min of candies.length/2 and kinds of candies
	 * @param int[] candies
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int distributeCandies(int[] candies) {
		if (candies == null || candies.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int candy: candies) {
			set.add(candy);
		}
 		return Math.min(candies.length / 2, set.size());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistributeCandies result = new DistributeCandies();
		System.out.println(result.distributeCandies(new int[] {1,1,2,2,3,3}));
		System.out.println(result.distributeCandies(new int[] {1, 1, 2, 3}));
	}

}
