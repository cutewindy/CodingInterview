/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope
 *  is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can
 *  Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 * Tags: Binary Search, DP
 * @author wendi
 *
 */
public class RussianDollEnvelopes {

	/**
	 * DP: 
	 * @param int[][] envelopes
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int russianDollEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RussianDollEnvelopes result = new RussianDollEnvelopes();
		System.out.println(result.russianDollEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
	}

}
