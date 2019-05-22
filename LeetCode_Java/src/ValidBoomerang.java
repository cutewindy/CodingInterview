/**
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.
 * Given a list of three points in the plane, return whether these points are a boomerang.
 * Example 1:
 * Input: [[1,1],[2,3],[3,2]]
 * Output: true
 * Example 2:
 * Input: [[1,1],[2,2],[3,3]]
 * Output: false
 * Note:
 * 1. points.length == 3
 * 2. points[i].length == 2
 * 3. 0 <= points[i][j] <= 100
 * @author wendi
 *
 */
public class ValidBoomerang {
	
	
	/**
	 * Approach2: slope
	 * calculate the slope of AB and AC.
	 * K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
	 * K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])
	 * We check if K_AB != K_AC, instead of calculate a fraction.
	 * @param int[][] points
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
    public boolean validBoomerangI(int[][] points) {
    	int[][] p = points;
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }

	
	/**
	 * Approach1: area
	 * @param int[][] points
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
    public boolean validBoomerang(int[][] points) {
        int[][] p = points;
        double area = 1.0 / 2 * ((p[0][0] * p[1][1] - p[1][0] * p[0][1]) + (p[1][0] * p[2][1] - p[2][0] * p[1][1]) + (p[2][0] * p[0][1] - p[0][0] * p[2][1]));
        return area != 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidBoomerang result = new ValidBoomerang();
		System.out.println(result.validBoomerang(new int[][] {{1,1},{2,3},{3,2}}));
		System.out.println(result.validBoomerang(new int[][] {{1,1},{2,2},{3,3}}));
		System.out.println(result.validBoomerangI(new int[][] {{1,1},{2,3},{3,2}}));
		System.out.println(result.validBoomerangI(new int[][] {{1,1},{2,2},{3,3}}));
	}

}
