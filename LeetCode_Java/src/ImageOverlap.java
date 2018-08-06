import java.util.HashMap;
import java.util.Map;

/**
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary 
 * matrix has only 0s and 1s as values.)
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), 
 * and place it on top of the other image.  After, the overlap of this translation is the number of 
 * positions that have a 1 in both images.
 * (Note also that a translation does not include any kind of rotation.)
 * What is the largest possible overlap?
 * Example 1:
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes: 
 * 1. 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 2. 0 <= A[i][j], B[i][j] <= 1
 * @author wendi
 *
 */
public class ImageOverlap {

	/**
	 * Hashmap
	 * 枚举A中和B中的所有点，计算每一对的距离，然后用map统计距离相同的点有多少个，取最多的即可
	 * @param int[][] A, int[][] B
	 * @return int
	 * Time: O(n^4)
	 * Space: O(n^2)
	 */
	public int imageOverlap(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        Map<String, Integer> count = new HashMap<>();
        int n = A.length;
        for (int Ai = 0; Ai < n; Ai++) {
        	for (int Aj = 0; Aj < n; Aj++) {
        		if (A[Ai][Aj] == 0) continue;
        		for (int Bi = 0; Bi < n; Bi++) {
        			for (int Bj = 0; Bj < n; Bj++) {
        				if (B[Bi][Bj] == 0) continue;
        				String pos = (Ai - Bi) + ":" + (Aj - Bj); // get distance between (Ai, Aj) and (Bi, Bj)
        				count.put(pos, count.getOrDefault(pos, 0) + 1);
        			}
        		}
        	}
        }
        
        int res = 0;
        for (Integer cnt: count.values()) {
        	res = Math.max(cnt, res);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageOverlap result = new ImageOverlap();
//		System.out.println(result.imageOverlap(new int[][] {{1,1,0},{0,1,0},{0,1,0}}, new int[][] {{0,0,0},{0,1,1},{0,0,1}}));
		System.out.println(result.imageOverlap(new int[][] {{0,1},{1,1}}, new int[][] {{1,1}, {1,0}}));

	}

}
