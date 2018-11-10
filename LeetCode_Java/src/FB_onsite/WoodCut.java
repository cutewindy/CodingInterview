package FB_onsite;
/**
 * Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee 
 * you could have equal or more than k pieces with the same length. What is the longest length you 
 * can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
 * You couldn't cut wood into float length.
 * If you couldn't get >= k pieces, return 0.
 * Example
 * For L=[232, 124, 456], k=7, return 114.
 * Challenge
 * O(n log Len), where Len is the longest length of the wood.
 * @author wendi
 *
 */
public class WoodCut {
	
	
	/**
	 * binary search
	 * @param int[] L, int k
	 * @return int
	 * Time: O(nlog(len)) len = max(L[i])
	 * Space: O(1)
	 */
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0) return 0;
		int maxLen = 0;
		for (int l: L) {
			maxLen = Math.max(l, maxLen);
		}
		int start = 1;
		int end = maxLen;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (getCnts(L, mid) >= k) start = mid;
			else end = mid;
		}
		if (getCnts(L, end) >= k) return end;
		if (getCnts(L, start) >= k) return start;
		return 0;
	}
	
	private int getCnts(int[] L, int len) {
		int cnt = 0;
		for (int l: L) {
			cnt += l / len;
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WoodCut result = new WoodCut();
		System.out.println(result.woodCut(new int[] {232, 124, 456}, 7));
	}

}
