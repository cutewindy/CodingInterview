
/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of 
 * painting each house with a certain color is different. You have to paint all the houses such that 
 * no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For 
 * example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of 
 * painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 * Note:
 * All costs are positive integers.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class PaintHouseII {

	/**
	 * DP[i][j]: paint the house i with color j
	 * Use min1 and min2 to track the indices of the 1st and 2nd smallest cost till previous house, 
	 * if the current color is same as min1's color, then we have to go with min2, otherwise we can 
	 * safely go with min1. For each house, maintain the current currMin1, currMin2 and currColor1.
	 * @param int[][] costs
	 * @return int
	 * Time: O(nk)
	 * Space: O(1)
	 */
	public int paintHouseII(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}
		int n = costs.length;
		int k = costs[0].length;
		int min1 = 0;
		int min2 = 0;
		int color1 = -1;
		for (int i = 0; i < n; i++) {
			int cost = 0;
			int currMin1 = Integer.MAX_VALUE;
			int currMin2 = Integer.MAX_VALUE;
			int currColor1 = -1;
			for (int j = 0; j < k; j++) {
				cost = costs[i][j] + (j == color1 ? min2 : min1);
				if (cost < currMin1) {
					currMin2 = currMin1;
					currMin1 = cost;
					currColor1 = j;
				}
				else if (cost < currMin2) {
					currMin2 = cost;
				}
				
			}
			min1 = currMin1;
			min2 = currMin2;
			color1 = currColor1;
			System.out.println("min1 : " + min1 + ", min2: " + min2 + ", color1: " + color1);
		}
		return min1;
	}
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintHouseII result = new PaintHouseII();
		System.out.println(result.paintHouseII(new int[][] {{1, 2, 1, 2}, {3, 1, 2, 1}, {2, 1, 1, 2}}));
	}

}
