import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers A, find the number of triples of indices (i, j, k) such that:
 * 0 <= i < A.length
 * 0 <= j < A.length
 * 0 <= k < A.length
 * A[i] & A[j] & A[k] == 0, where & represents the bitwise-AND operator.
 * Example 1:
 * Input: [2,1,3]
 * Output: 12
 * Explanation: We could choose the following i, j, k triples:
 * (i=0, j=0, k=1) : 2 & 2 & 1
 * (i=0, j=1, k=0) : 2 & 1 & 2
 * (i=0, j=1, k=1) : 2 & 1 & 1
 * (i=0, j=1, k=2) : 2 & 1 & 3
 * (i=0, j=2, k=1) : 2 & 3 & 1
 * (i=1, j=0, k=0) : 1 & 2 & 2
 * (i=1, j=0, k=1) : 1 & 2 & 1
 * (i=1, j=0, k=2) : 1 & 2 & 3
 * (i=1, j=1, k=0) : 1 & 1 & 2
 * (i=1, j=2, k=0) : 1 & 3 & 2
 * (i=2, j=0, k=1) : 3 & 2 & 1
 * (i=2, j=1, k=0) : 3 & 1 & 2
 * Note:
 * 1. 1 <= A.length <= 1000
 * 2. 0 <= A[i] < 2^16
 * @author wendi
 *
 */
public class TripleswithBitwiseANDEqualToZero {
	
	
	/**
	 * HashMap or use an int[] array[1 << 16] instead of hashmap
	 * @param int[] A
	 * @return int
	 * Time: O(n*2 + n * pn) pn: permutation of n
	 * Space: O(pn)
	 */
	public int tripleswithBitwiseANDEqualToZero(int[] A) {
		if (A == null || A.length == 0) return 0;
		Map<Integer, Integer> cnts = new HashMap<>();  // [a & b, cnts]
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				int and = A[i] & A[j];
				cnts.put(and, cnts.getOrDefault(and, 0) + 1);
			}
		}
		
		int res = 0;
		for (int num: A) {
			for (Integer and: cnts.keySet()){
				if ((and & num) == 0) res += cnts.get(and);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TripleswithBitwiseANDEqualToZero result = new TripleswithBitwiseANDEqualToZero();
		System.out.println(result.tripleswithBitwiseANDEqualToZero(new int[] {2,1,3}));
	}

}
