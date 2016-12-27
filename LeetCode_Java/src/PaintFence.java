/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same 
 * color.
 * Return the total number of ways you can paint the fence.
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class PaintFence {
	
	
	/**
	 * DP
	 * 1. If we use same color for the new, there's only one option, and we can only do this when 
	 * the last two have different colors, thus, same[i] = notSame[i-1].
	 * 2. If we use different color, there're k-1 options, 
	 * notSame[i] = (same[i-1] + notSame[i-1]) * (k - 1).
	 * @param int n, int k
	 * @return int 
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int paintFence(int n, int k) {
		if (n == 0 || k == 0) return 0;
		if (n == 1) return k;
		int same = k;
		int notSame = k * (k - 1);
		for (int i = 2; i < n; i++) {
			int temp = notSame;  // use temp to save the count of same color at point i
			notSame = (same + notSame) * (k - 1);
			same = temp;
		}
		return same + notSame;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintFence result = new PaintFence();
		System.out.println(result.paintFence(5, 3));
	}

}
