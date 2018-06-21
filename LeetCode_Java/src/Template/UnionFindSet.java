package Template;

import java.util.Arrays;

/**
 * Find: Determine which subset a particular element is in. This can be used for determining if two 
 *       elements are in the same subset.
 * Union: Join two subsets into a single subset.
 * Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not, and
 * accounts merge.
 * 
 * 
 * Similar questions:
 * 128	Longest Consecutive Sequence
 * 130	Surrounded Regions	
 * 200	Number of Islands	
 * 261	Graph Valid Tree
 * 305	Number of Islands II
 * 323	Number of Connected Components in an Undirected Graph
 * 547	Friend Circles		
 * 684	Redundant Connection	
 * 685	Redundant Connection II	
 * 721	Accounts Merge	
 * 737	Sentence Similarity II
 * 765	Couples Holding Hands		
 * 778	Swim in Rising Water	
 * 803	Bricks Falling When Hit
 * 839	Similar String Groups
 * @author wendi
 *
 */
public class UnionFindSet {
	
	int[] parents;
	
	public UnionFindSet(int n) {
		parents = new int[n];
		for (int i = 0; i < n; i++) parents[i] = i;
	}
	
	/**
	 * Time: amortized O(1)
	 */
	public int find(int x) {
		int input = x;
		while (parents[x] != x) {
			x = parents[x];
		}		
		while (parents[input] != x) {   // pass compression
			int next = parents[input];
			parents[input] = x;
			input = next;
		}
		return x;
	}
	
	/**
	 * Time: amortized O(1)
	 */
	public boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA != parentB) {
			parents[parentA] = parentB;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionFindSet ufs = new UnionFindSet(7);
		System.out.println(Arrays.toString(ufs.parents));
		ufs.union(2, 0);
		ufs.union(1, 2);
		ufs.union(3, 2);
		ufs.union(3, 4);
		ufs.union(5, 6);
		System.out.println(Arrays.toString(ufs.parents));
	}

}
