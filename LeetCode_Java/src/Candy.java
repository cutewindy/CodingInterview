import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * 1. Each child must have at least one candy.
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * Tags: Greedy
 * @author wendi
 *
 */
public class Candy {
	
	/**
	 * Greedy: two times DP, one from left the other from right, then choose the max one。
	 * In the given problem each student will have at least 1 candy. So distribute 1 candy to each.
	 * 1: traverse the array from left to right. If rating[i] > rating[i-1], then set the 
	 * candy of (i) child as one candy more than the (i-1) child candies.
	 * 2: Traverse the array from right to left. If rating[i] > rating[i+1] and (1) child candies
	 * is less than one more than (i+1) child candies then update the candies of (i) child as 1+ (i+1) candies.
	 * @param int[] rating
	 * @return int 
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) return 0;
		
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		// go from left
		for (int i = 1; i < candy.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
		}
		// go from right and combine with left result
		for (int i = candy.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
			}
		}
		// summary candys
		int result = 0;
		for (int cand: candy) {
			result += cand;
		}
		System.out.println(Arrays.toString(candy));
		return result;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy result = new Candy();
		System.out.println(result.candy(new int[] {2, 2, 4, 3, 1}));
		System.out.println(result.candy(new int[] {2,3, 2}));
	}

}
