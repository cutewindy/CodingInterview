/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * Tags: Backtracking, Math
 * @author wendi
 *
 */
public class PermutationSequence {

	/**
	 * Backtracking
	 * @param int n, int k
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 * Stack space: O(k)
	 */
    private int K;
    private String res;
    public String permutationSequence(int n, int k) {
        K = k;
        res = new String();
        helper(n, "", new boolean[n + 1] );
        return res;
    }
    
    private void helper(int n, String curr, boolean[] visited) {
        if (curr.length() == n) {
            if (--K == 0) res = curr;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            curr += i;
            visited[i] = true;
            helper(n, curr, visited);
            if (res.length() > 0) return;
            curr = curr.substring(0, curr.length() - 1);
            visited[i] = false;
        }
     }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence result = new PermutationSequence();
		System.out.println(result.permutationSequence(3, 3));
	}

}
