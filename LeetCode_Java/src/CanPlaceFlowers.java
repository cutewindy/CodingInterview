/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, 
 * flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means 
 * not empty), and a number n, return if n new flowers can be planted in it without violating the 
 * no-adjacent-flowers rule.
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 * @author wendi
 *
 */
public class CanPlaceFlowers {
	
	/**
	 * BruteForce: We can find out the extra maximum number of flowers, count, that can be planted 
	 * for the given flowerbed arrangement. To do so, we can traverse over all the elements of the 
	 * flowerbed and find out those elements which are 0(implying an empty position). For every such 
	 * element, we check if its both adjacent positions are also empty. If so, we can plant a flower 
	 * at the current position without violating the no-adjacent-flowers-rule. For the first and last 
	 * elements, we need not check the previous and the next adjacent positions respectively.
 	 * If the count obtained is greater than or equal to n, the required number of flowers to be 
 	 * planted, we can plant n flowers in the empty spaces, otherwise not.
	 * @param int[] flowered, int n
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n <= 0) return true;
		if (flowerbed == null || flowerbed.length == 0) return false;
		for (int i = 0; i < flowerbed.length && n > 0; i++) {
			if (flowerbed[i] == 0 
				&& (i == 0 || flowerbed[i - 1] == 0)
				&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				n--;
			}
		}
		return n == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CanPlaceFlowers result = new CanPlaceFlowers();
		System.out.println(result.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
		System.out.println(result.canPlaceFlowers(new int[] {0}, 1));
	}

}
