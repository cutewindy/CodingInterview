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
	 * Greedy: two times DP one from left the other from right, then choose the max one
	 * @param int[] rating
	 * @return int 
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int candy(int[] rating) {
		if (rating == null || rating.length == 0) {
			return 0;
		}
		int[] candy = new int[rating.length];
		
		for ()
		return 0;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy result = new Candy();
		System.out.println(result.candy(new int[] {}));
	}

}
