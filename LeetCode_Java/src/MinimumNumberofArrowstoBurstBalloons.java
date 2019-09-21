import java.util.Arrays;
import java.util.Comparator;

/**
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, 
 * provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, 
 * y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. 
 * Start is always smaller than end. There will be at most 104 balloons.
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with 
 * xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number 
 * of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to 
 * find the minimum number of arrows that must be shot to burst all balloons.
 * Example:
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and 
 * another arrow at x = 11 (bursting the other two balloons).
 * @author wendi
 *
 */
public class MinimumNumberofArrowstoBurstBalloons {
	
	/**
	 * Greedy(merge intervals)
	 * We know that eventually we have to shoot down every balloon, so for each ballon there must be 
	 * an arrow whose position is between balloon[0] and balloon[1] inclusively. Given that, we can 
	 * sort the array of balloons by their ending position. Then we make sure that while we take 
	 * care of each balloon in order, we can shoot as many following balloons as possible.
	 * So what position should we pick each time? We should shoot as to the right as possible, 
	 * because since balloons are sorted, this gives you the best chance to take down more balloons. 
	 * Therefore the position should always be balloon[i][1] for the ith balloon.
	 * 
	 * @param int[][] points
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
    public int minimumNumberofArrowstoBurstBalloons(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int arrowPos = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
        	System.out.println("p: " + points[i][0] + " : " + points[i][1] + " arrow: " + arrowPos);
            if (points[i][0] <= arrowPos) continue;
            arrowPos = points[i][1];
            res++;
        }
        
        return res;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumNumberofArrowstoBurstBalloons result = new MinimumNumberofArrowstoBurstBalloons();
		System.out.println(result.minimumNumberofArrowstoBurstBalloons(new int[][] {{10,16}, {2,8}, {1,6}, {7,12}}));
//		System.out.println(result.minimumNumberofArrowstoBurstBalloons(new int[][] {{2,4}, {1,4}, {1,5}, {3,6}, {7,10}}));
	}

}
