import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its 
 * sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed 
 * integer range.
 * 
 * Tags: Sort
 * @author wendi
 *
 */
public class MaximumGap {
	
	/**
	 * Bucket sort:
	 * Suppose there are N elements in the array, the maximum gap will be no smaller than 
	 * ceiling[(max - min ) / (N - 1)]. That is, in the same bucket, there is not res.
	 * Since the max gap is bucketSize and at most (max - min + 1) numbers, the bucketNum will be no
	 * large than ceilint[(max - min + 1) / bucketSize].
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) return 0;
		int n = nums.length;
		// 1. get the bucketSize and bucketNum by min and max value of array
		int minNum = Integer.MAX_VALUE;
		int maxNum = 0;
		for (int num: nums) {
			minNum = Math.min(num, minNum);
			maxNum = Math.max(num, maxNum);
		}
		int bucketSize = (int)Math.ceil((double)(maxNum - minNum + 1) / n);
		int bucketNum = (int)Math.ceil((double)(maxNum - minNum + 1) / bucketSize);
		// 2. put numbers into buckets
		int[] minNuminBucket = new int[bucketNum];
		int[] maxNuminBucket = new int[bucketNum];
		Arrays.fill(minNuminBucket, Integer.MAX_VALUE);
		Arrays.fill(maxNuminBucket, Integer.MIN_VALUE);
		for (int num: nums) {
			int bucket = (num - minNum) / bucketSize;  // index of the right position in the buckets
			minNuminBucket[bucket] = Math.min(num, minNuminBucket[bucket]);
			maxNuminBucket[bucket] = Math.max(num, maxNuminBucket[bucket]);
		}
		// 3. scan the buckets for the max gap
		int result = 0;
		int prev = minNum;
		for (int i = 0; i < bucketNum; i++) {
			if (minNuminBucket[i] == Integer.MAX_VALUE) continue;   // skip empty bucket
			result = Math.max(minNuminBucket[i] - prev, result);
			prev = maxNuminBucket[i];
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumGap result = new MaximumGap();
		System.out.println(result.maximumGap(new int[] {5, 9, 8, 3, 15}));
	}

}
