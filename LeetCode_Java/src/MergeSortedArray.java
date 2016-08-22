import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
 * additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and 
 * n respectively.
 * 
 * Tags: Array, Two Pointers
 * @author wendi
 *
 */
public class MergeSortedArray {

	/**
	 * Two Pointers:
	 * @param int[] nums1, int[] nums2
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return;
		int p1 = m - 1;
		int p2 = n - 1;
		while (p1 >= 0 && p2 >= 0) {
			if (nums1[p1] > nums2[p2]) {
				nums1[p1 + p2 + 1] = nums1[p1];
				p1--;
			}
			else {
				nums1[p1 + p2 + 1] = nums2[p2];
				p2--;
			}
		}
		while (p2 >= 0) {
			nums1[p2] = nums2[p2];
			p2--;
		}
//		System.out.println(Arrays.toString(nums1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray result = new MergeSortedArray();
		result.mergeSortedArray(new int[] {3, 5, 0, 0, 0, 0, 0}, 2, new int[] {1, 2, 4, 6, 7}, 5);
	}

}
