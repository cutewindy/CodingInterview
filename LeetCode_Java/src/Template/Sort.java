package Template;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion 
 * sort, quick sort, heap sort, merge sort, bucket sort, or..
 * Example
 * Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 * @author wendi
 *
 */
public class Sort {
	
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
		

	/**
	 * Selection sort: unstable sort, in-place sort
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int[] selectionSort(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		int n = nums.length;
		for (int l = 0; l < n - 1; l++) {
			int iMin = l;
			for (int r = l + 1; r < n; r++) {
				if (nums[r] < nums[iMin]) iMin = r;
			}
			swap(nums, iMin, l);
		}
		return nums;
	}
	
	
	/**
	 * Bubble sort (optimized): stable sort, in-place sort
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int[] bubbleSort(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		boolean swapped = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (!swapped) return nums;
			swapped = false;
			for (int j = 1; j < nums.length; j++) {
				if (nums[j - 1] > nums[j]) {
					swap(nums, j - 1, j);
					swapped = true;
				}
			}
		}
		return nums;
	}
	
	
	/**
	 * Insertion sort: stable sort, in-place sort
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int[] insertionSort(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		for (int r = 0; r < nums.length; r++) {
			int l = r;
			while (l > 0 && nums[l - 1] > nums[l]) {
				swap(nums, l - 1, l);
				l--;
			}
		}
		return nums;
	}
	
	
	/**
	 * Quick sort: unstable, in-place sort
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int[] quickSort(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		quickSortRecursion(nums, 0, nums.length - 1);
		return nums;
	}

	private void quickSortRecursion(int[] nums, int l, int r) {
		if (l >= r) return;
		int p = partition(nums, l, r);
		quickSortRecursion(nums, l, p - 1);
		quickSortRecursion(nums, p + 1, r);
	}
	
	private int partition(int[] nums, int l, int r) {
		if (l >= r) return l;
		int pivot = nums[r];
		int index = l;  // index - 1 is the ending index of nums smaller than pivot
		for (int i = l; i < r; i++) {
			if (nums[i] < pivot) {
				swap(nums, index, i);
				index++;
			}
		}
		swap(nums, index, r);
		return index;
	}

	
	/**
	 * Heap sort: unstable, in-place sort
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int[] heapSort(int[] nums) {
		if (nums == null || nums.length == 0) return nums;

		return nums;
	}
	
	
	/**
	 * Merge sort: stable sort, out-place sort
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public int[] mergeSort(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		mergeSortRecursion(nums, 0, nums.length - 1);
		return nums;
	}
	
	private void mergeSortRecursion(int[] nums, int l, int r) {
		if (l >= r) return;
		int mid = l + (r - l) / 2;
		mergeSortRecursion(nums, l, mid);
		mergeSortRecursion(nums, mid + 1, r);
		merge(nums, l, mid, r);
	}
	
	private void merge(int[] nums, int l, int mid, int r) {
		int[] res = new int[r - l + 1];
		int i = l;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= r) {
			if (nums[i] < nums[j]) res[k++] = nums[i++];
			else res[k++] = nums[j++];
		}
		while (i <= mid) res[k++] = nums[i++];
		while (j <= r) res[k++] = nums[j++];
		for (k = l; k <= r; k++) {
			nums[k] = res[k - l];
		}
	}

	/**
	 * Bucket sort: stable sort, out-place sort
	 * Time: worse case: O(nlog(n)), better case: O(n)
	 * Space: O(n)
	 */
	public int[] bucketSort(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		int n = nums.length;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int num: nums) {
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		int bucketSize = (int) Math.ceil((double) (max - min + 1) / n);
		int bucketNum = (int) Math.ceil((double) (max - min + 1) / bucketSize);
		List<Integer>[] buckets = new ArrayList[bucketNum];
		for (int num: nums) {
			int i = (num - min) / bucketSize;
			if (buckets[i] == null) buckets[i] = new ArrayList<>();
			buckets[i].add(num);
		}
		int k = 0;
		for (List<Integer> bucket: buckets) {
			if (bucket == null) continue;
			Collections.sort(bucket);
			for (Integer num: bucket) {
				nums[k++] = num;
			}
		}
		return nums;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort result = new Sort();
//		System.out.println(Arrays.toString(result.selectionSort(new int[] {3, 2, 1, 4, 5})));
//		System.out.println(Arrays.toString(result.bubbleSort(new int[] {3, 2, 1, 4, 5})));
//		System.out.println(Arrays.toString(result.insertionSort(new int[] {3, 2, 1, 4, 5})));
//		System.out.println(Arrays.toString(result.quickSort(new int[] {3, 2, 1, 4, 5})));
//		System.out.println(Arrays.toString(result.heapSort(new int[] {3, 2, 1, 4, 5})));
//		System.out.println(Arrays.toString(result.mergeSort(new int[] {3, 2, 1, 4, 5})));
		System.out.println(Arrays.toString(result.bucketSort(new int[] {1, 10, 3, 2, 1, 4, 5})));
	}

}
