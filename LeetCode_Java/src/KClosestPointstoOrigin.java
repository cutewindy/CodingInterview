import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the 
 * order that it is in.)
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * Note:
 * 1. 1 <= K <= points.length <= 10000
 * 2. -10000 < points[i][0] < 10000
 * 3. -10000 < points[i][1] < 10000
 * @author wendi
 *
 */
public class KClosestPointstoOrigin {
	
	/**
	 * Approach2: quick select
	 * @param int[][] points, int K
	 * @return int[][]
	 * Time: O(n) worse case: O(n^2)
	 * Space: O(1)
	 */
    public int[][] kClosestPointstoOriginI(int[][] points, int K) {
    	int[][] res = new int[K][2];
    	int s = 0;
    	int e = points.length - 1;
    	while (s + 1 < e) {
    		int mid = quickSelect(points, s, e);
    		if (mid == K - 1) break;
    		else if (mid < K - 1) s = mid + 1;
    		else e = mid - 1;
    	}
    	if (s + 1 == e && compare(points[s], points[e]) > 0) swap(points, s, e);
    	for (int i = 0; i < K; i++) {
    		res[i] = points[i];
    	}
    	return res;
    }
    
    private int quickSelect(int[][] points, int s, int e) {
    	int i = s;
    	for (int j = s; j < e; j++) {
    		if (compare(points[j], points[e]) < 0) {
    			swap(points, i, j);
    			i++;
    		}
    	}
    	swap(points, i, e);
    	return i;
    }
    
    private int compare(int[] a, int[] b) {
    	return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
    }
    
    private void swap(int[][] points, int i, int j) {
    	int[] temp = points[i];
    	points[i] = points[j];
    	points[j] = temp;
    }
	
	
	/**
	 * Approach1: MaxHeap
	 * @param int[][] points, int K
	 * @return int[][]
	 * Time: O(nlog(K))
	 * Space: O(K)
	 */
    public int[][] kClosestPointstoOrigin(int[][] points, int K) {
        if (K == 0) return new int[0][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] p: points) {
            maxHeap.offer(p);
            if (maxHeap.size() > K) maxHeap.poll();
        }
        int[][] res = new int[K][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KClosestPointstoOrigin result = new KClosestPointstoOrigin();
		System.out.println(Arrays.deepToString(result.kClosestPointstoOrigin(new int[][] {{1,3},{-2,2}}, 1)));
		System.out.println(Arrays.deepToString(result.kClosestPointstoOriginI(new int[][] {{1,3},{-2,2}}, 1)));
	}

}
