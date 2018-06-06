import java.util.Arrays;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed 
 * warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius 
 * of heaters so that all houses could be covered by those heaters.
 * So, your input will be the positions of houses and heaters seperately, and your expected output 
 * will be the minimum radius standard of heaters.
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, 
 * then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, 
 * then all the houses can be warmed.
 * @author wendi
 *
 */
public class Heaters {
	
	
	/**
	 * Tow Pointers: the idea is to find the nearest heater for each house, by comparing the next 
	 * heater with the current heater.
	 * @param int[] houses, int[] heaters
	 * @return int
	 * Time: O(mlog(m) + nlog(n))
	 * Space: O(1)
	 */
	public int heaters(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int i = 0;
		int res = 0;
		for (int house: houses) {
			while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] < house * 2) i++;
			res = Math.max(Math.abs(heaters[i] - house), res);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heaters result = new Heaters();
		System.out.println(result.heaters(new int[] {1,2,3,4} , new int[] {1,4}));
	}

}
