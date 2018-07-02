/**
 * Given several boxes with different colors represented by different positive numbers. 
 * You may experience several rounds to remove boxes until there is no box left. Each time you can 
 * choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and 
 * get k*k points.
 * Find the maximum points you can get.
 * Example 1:
 * Input:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * Output:
 * 23
 * Explanation:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1] 
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
 * ----> [1, 3, 3, 3, 1] (1*1=1 points) 
 * ----> [1, 1] (3*3=9 points) 
 * ----> [] (2*2=4 points)
 * Note: The number of boxes n would not exceed 100.
 * @author wendi
 *
 */
public class RemoveBoxes {
	
	/**
	 * DFS + Memoization
	 * dp[l][r][k] = max point with {x[l],...,x[r]=y,|y,..,y} => (k+1) y
	 * dp[l][r][k] means value from boxes[left]~boxes[right] followed by k same color boxes.
	 * @param int[] boxes
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) return 0;
        int n = boxes.length;
        return getPoints(boxes, 0, n - 1, 0, new int[n][n][n]);
    }	
    
    private int getPoints(int[] boxes, int l, int r, int k, int[][][] dp) {
    	if (l > r) return 0;
    	if (dp[l][r][k] != 0) return dp[l][r][k];
    	
    	// case1: 1, 2, 3, 4...7,(3, 3, 3)
    	while (l < r && boxes[r] == boxes[r - 1]) {
    		k++;
    		r--;
    	} // (r->3, k=2)
    	dp[l][r][k] = getPoints(boxes, l, r - 1, 0, dp) + (k + 1) * (k + 1);
    	
    	// case2: 
    	for (int i = l; i < r; i++) {
    		if (boxes[i] == boxes[r]) {
    			dp[l][r][k] = Math.max(getPoints(boxes, l, i, k + 1, dp) +    // 1,2,3,[...],3,3,3
    					               getPoints(boxes, i + 1, r - 1, 0, dp), // (4,..7)
    					               dp[l][r][k]);
    		}
    	}
    	
    	return dp[l][r][k];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveBoxes result = new RemoveBoxes();
		System.out.println(result.removeBoxes(new int[] {1, 3, 2, 2, 2, 3, 4, 3, 1}));
	}

}
