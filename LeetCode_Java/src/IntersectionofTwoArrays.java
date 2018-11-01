import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * Tags: BinarySearch, HashTable, TwoPointers, Sort
 * @author wendi
 *
 */
public class IntersectionofTwoArrays {

	/**
	 * (8 ms)Method3: BinarySearch + remove duplicate
	 * 1 sort nums1
	 * 2 using binary search method to find whether element in nums2 is in nums1, save result into
	 * list
	 * @param int[] nums1, int[] nums2
	 * @return int[]
	 * Time: O(nlog(n) + mlog(n))
	 * Space: O(n)
	 */
	public int[] intersectionofTwoArraysII(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		for (int i = 0; i < nums2.length; i++) {
			if (i != 0 && nums2[i - 1] == nums2[i]) continue; // remove duplicate
			if(binarySearch(nums1, nums2[i])) {
				result.add(nums2[i]);
			}
		}
		int[] res = new int[result.size()];
		int i = 0;
		for (Integer n: result) {
			res[i++] = n;
		}
		return res;
	}
	
	private boolean binarySearch(int[] sortedArray, int num) {
		if (sortedArray == null || sortedArray.length == 0) return false;
		int start = 0;
		int end = sortedArray.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (sortedArray[mid] == num) return true;
			else if (sortedArray[mid] < num) start = mid;
			else end = mid;
		}
		return sortedArray[start] == num || sortedArray[end] == num;
	}
	
	/**
	 * (6 ms)Method2: Two sets: one set to save nums1, the other set to save the result.
	 * 1 save elements of nums1 into set num.
	 * 2 if set num contains element from nums2, add it into result set.
	 * @param int[] nums1, int[] nums2
	 * @return int[]
	 * Time: O(m+n)
	 * Space: O(max(m,n))
	 */
	public int[] intersectionofTwoArraysI(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
		Set<Integer> num = new HashSet<>();
		Set<Integer> result = new HashSet<>();
		// 1 save elements of nums1 into set num.
		for (int num1: nums1) {
			num.add(num1);
		}
		// 2 if set num contains element from nums2, it's intersection element.
		for (int num2: nums2) {
			if (num.contains(num2)) result.add(num2);
		}
		int [] res = new int[result.size()];
		int i = 0;
		for (Integer n: result) {
			res[i++] = n;
		}
		return res;
		}
	
	
	/**
	 * (8 ms)Method1: Two Pointers + one set: Sort two arrays first, then find the intersection elements 
	 * using two pointers, save them into set to skip duplicate.
	 * @param int[] nums1, int[] nums2
	 * @return int[]
	 * Time: O(nlog(n) + mlog(m) + m+n)
	 * Space: O(n)
	 */
	public int[] intersectionofTwoArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] > nums2[j]) j++;
            else i++;
            while (i != 0 && i < nums1.length && nums1[i] == nums1[i - 1]) i++;
            while (j != 0 && j < nums2.length && nums2[j] == nums2[j - 1]) j++;
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionofTwoArrays result = new IntersectionofTwoArrays();
		System.out.println(Arrays.toString(result.intersectionofTwoArrays(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
		System.out.println(Arrays.toString(result.intersectionofTwoArraysI(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
		System.out.println(Arrays.toString(result.intersectionofTwoArraysII(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
	}

}
