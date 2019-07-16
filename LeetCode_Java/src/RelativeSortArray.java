import java.util.Arrays;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are 
 * also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in 
 * arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * Constraints:
 * 1. arr1.length, arr2.length <= 1000
 * 2. 0 <= arr1[i], arr2[i] <= 1000
 * 3. Each arr2[i] is distinct.
 * 4. Each arr2[i] is in arr1.
 * @author wendi
 *
 */
public class RelativeSortArray {
	
	
	/**
	 * Count sorting
	 * @param int[] arr1, int[] arr2
	 * @return int[]
	 * Time: O(1001)
	 * Space: O(1001)
	 */
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length];
		int index = 0;
		int[] counter = new int[1001];
		for (int num: arr1) {
			counter[num]++;
		}
		for (int num: arr2) {
			while (counter[num] > 0) {
				res[index++] = num;
				counter[num]--;
			}
		}
		for (int num = 0; num <= 1000; num++) {
			while (counter[num] > 0) {
				res[index++] = num;
				counter[num]--;
			}
		}
		return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RelativeSortArray result = new RelativeSortArray();
		System.out.println(Arrays.toString(result.relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[] {2,1,4,3,9,6})));
	}

}
