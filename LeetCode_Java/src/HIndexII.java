/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you 
 * optimize your algorithm?
 * Hint:
 * Expected runtime complexity is in O(log n) and the input is sorted.
 * 
 * Tags: Binary Search
 * @author wendi
 *
 */
public class HIndexII {

	/**
	 * Binary Search
	 * @param int[] citations
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int hIndexII (int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int n = citations.length;
		int start = 0;
		int end = n - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] == n - mid) return n - mid;
			else if (citations[mid] < n - mid) start = mid;
			else end = mid;
		}
		if (citations[start] >= n - start) return n - start;
		if (citations[end] >= n - end) return n - end;   // take care: eg {0}. Cannot use return c[s]>=s?s:e directly.
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HIndexII result = new HIndexII();
		System.out.println(result.hIndexII(new int[] {0, 1, 2, 5, 6}));
	}

}
