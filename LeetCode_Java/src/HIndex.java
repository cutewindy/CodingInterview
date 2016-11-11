import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a 
 * function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N 
 * papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total 
 * and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 
 * papers with at least 3 citations each and the remaining two with no more than 3 citations each, 
 * his h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * Hint:
 * 1. An easy approach is to sort the array first.
 * 2. What are the possible values of h-index?
 * 3. A faster approach is to use extra space.
 * 
 * Tags: Hash Table, Sort
 * @author wendi
 *
 */
public class HIndex {
	
	/**
	 * Bucket sort:
	 * 1.assume n is the total number of papers, if we have n+1 buckets, number from 0 to n, then 
	 * for any paper with reference corresponding to the index of the bucket, we increment the count 
	 * for that bucket. The only exception is that for any paper with larger number of reference 
	 * than n, we put in the n-th bucket.
	 * 2.Then we iterate from the back to the front of the buckets, whenever the total count exceeds 
	 * the index of the bucket, meaning that we have the index number of papers that have reference 
	 * greater than or equal to the index. Which will be our h-index result. The reason to scan from 
	 * the end of the array is that we are looking for the greatest h-index.
	 * @param int[] citations
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int hIndexI(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int n = citations.length;
		int[] bucket = new int[n + 1];
		for (int c: citations) {
			if (c <= n) {
				bucket[c]++;
			}
			else {
				bucket[n]++;
			}
		}
		int count = 0;
		for (int i = n; i >= 0; i--) {
			count += bucket[i];
			if (count >= i) return i;
		}
		return 0;
	}
	
	/**
	 * Method1: Brute Force: Sort + Using index
	 * @param int[] citations
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int n = citations.length;
		Arrays.sort(citations);
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n - i) return n - i;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HIndex result = new HIndex();
		System.out.println(result.hIndex(new int[] {2, 0, 6, 1, 5}));
		System.out.println(result.hIndexI(new int[] {2, 0, 6, 1, 5}));
	}

}
