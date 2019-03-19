/**
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * 1. 1 ≤ n ≤ 1000
 * 2. 1 ≤ m ≤ min(50, n)
 * Examples:
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * Output:
 * 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * @author wendi
 *
 */
public class SplitArrayLargestSum {
	
	/**
	 * Binary search
	 * @param int[] nums, int m
	 * @return int
	 * Time: O(n*log(sum))
	 * Space: O(1)
	 */
	public int splitArrayLargestSum(int[] nums, int m) {
        int minSum = 0;
        int maxSum = 0;
        for (int n: nums) {
            minSum = Math.max(n, minSum);
            maxSum += n;
        }
        while (minSum + 1 < maxSum) {
            int mid = minSum + (maxSum - minSum) / 2;
            if (isValid(nums, m, mid)) maxSum = mid;
            else minSum = mid + 1;
        }
        if (isValid(nums, m, minSum)) return minSum;
        return maxSum;
    }
    
    private boolean isValid(int[] nums, int m, int maxSum) {
        int currSum = 0;
        for (int n: nums) {
            currSum += n;
            if (currSum == maxSum) {
                currSum = 0;
                m--;
            }
            else if (currSum > maxSum) {
                currSum = n;
                m--;
            }
        }
        if (currSum > 0) m--;
        return m >= 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitArrayLargestSum result = new SplitArrayLargestSum();
		System.out.println(result.splitArrayLargestSum(new int[] {7,2,5,10,8}, 2));
	}

}
