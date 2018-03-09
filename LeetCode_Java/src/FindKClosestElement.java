import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The 
 * result should also be sorted in ascending order. If there is a tie, the smaller elements are 
 * always preferred.
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 * @author wendi
 *
 */
public class FindKClosestElement {
	
	/**
	 * Binary search: first is to find the closest element to x.
	 * then set the left bound and right bound to find the k closest element 
	 * @param int[] arr, int k, int x
	 * @return List<Integer>
	 * Time: O(log(n) + k)
	 * Space: O(1)
	 */
	public List<Integer> findKClosestElement(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		int left = findClosestElementIndex(arr, x) - 1;  // left bound(exclude)
		int right = left + 2;                            // right bound(exclude)
		while (--k > 0) {
			if (left < 0) right++;
			else if (right > arr.length - 1) left--;
			else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) left--;
			else right++;
		}
		for (int i = left + 1; i < right; i++) {
			result.add(arr[i]);
		}
		return result;
	}
	
	public int findClosestElementIndex(int[] arr, int x) {
		if (arr == null || arr.length == 0) return -1;
		int start = 0;
		int end = arr.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x) return mid;
			else if (arr[mid] < x) start = mid;
			else end = mid;
		}
		if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) return start;
		else return end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKClosestElement result = new FindKClosestElement();
		System.out.println(result.findKClosestElement(new int[] {1, 2, 3, 4, 5}, 4, 3));
		System.out.println(result.findKClosestElement(new int[] {1, 2, 3, 4, 5}, 4, -1));
		System.out.println(result.findKClosestElement(new int[] {1}, 1, -1));
	}

}
