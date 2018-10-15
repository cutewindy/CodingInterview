/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * @author wendi
 *
 */
public class MedianofTwoSortedArrays {
	
	/**
	 * binary search
	 * @param int[] nums1, int[] nums2
	 * @return double
	 * Time: O(log(min(m, n)))
	 * Space: O(1)
	 */
    public double medianofTwoSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return medianofTwoSortedArrays(nums2, nums1); // make sure nums1 is the shorter one.
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int start = 0;
        int end = n1;
        while (start <= end) {
        	int p1 = (start + end) / 2;        // partition nums1
        	int p2 = (n1 + n2 + 1) / 2 - p1;   // partition nums2
        	
        	int maxLeft1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
        	int minRight1 = p1 == n1 ? Integer.MAX_VALUE : nums1[p1];
        	
        	int maxLeft2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
        	int minRight2 = p2 == n2 ? Integer.MAX_VALUE : nums2[p2];
        	
        	if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
        		if ((n1 + n2) % 2 == 0) {
        			return ((double)Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
        		}
        		else {
        			return (double)Math.max(maxLeft1, maxLeft2);
        		}
        	}
        	
        	else if (maxLeft1 > minRight2) end = p1 - 1; // move to left in nums1
        	else start = p1 + 1; // move to right in nums1
        }
        
//        throw new IllegalArgumentException();
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianofTwoSortedArrays result = new MedianofTwoSortedArrays();
		System.out.println(result.medianofTwoSortedArrays(new int[] {1, 3, 8, 9, 15}, new int[] {7, 11, 18, 19, 21, 25}));
	}

}
