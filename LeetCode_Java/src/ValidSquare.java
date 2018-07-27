import java.util.Arrays;

/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct 
 * a square.
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * Example:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * Note:
 * 1. All the input integers are in the range [-10000, 10000].
 * 2. A valid square has four equal sides with positive length and four equal angles (90-degree 
 * 	  angles).
 * 3. Input points have no order.
 * @author wendi
 *
 */
public class ValidSquare {
	
	/**
	 * Math
	 * 题目要求我们判断四个点能否组成正方形，那么正方形有哪些特征呢。我们容易想到，正方形四条边长度都相等，并且两条对角线长度
	 * 也相等，所以，我们只要求出这四个点两两之间的距离，进行从小到大排序之后，如果这四个点能构成正方形，那么前面四个数就是四
	 * 条边长的长度，后面两个数为两条对角线的长度，因此我们只需要判断前四个数以及后两个数它们是否相等即可。
	 * 这题为避免四个点重叠，因此我们还需要判断一下对角线长度是否大于边长即可。
	 * @param int[] p1, int[] p2, int[] p3, int[] p4
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */ 
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        int[] len = new int[6];
        int index = 0;
        for (int i = 0; i < 3; i++) {
        	for (int j = i + 1; j < 4; j++) {
        		len[index++] = (p[i][0] - p[j][0]) * (p[i][0] - p[j][0]) + (p[i][1] - p[j][1]) * (p[i][1] - p[j][1]);
        	}
        }
        Arrays.sort(len);
        return len[0] == len[3] && len[4] == len[5] && len[0] < len[4];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidSquare result = new ValidSquare();
		System.out.println(result.validSquare(new int[] {0,0}, new int[] {1,1}, new int[] {1,0}, new int[] {0,1}));
	}

}
