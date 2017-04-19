
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
	 * 
	 * @param int n, int k
	 * @return String
	 * Time: O()
	 * Space: O()
	 */
	public String permutationSequence(int n, int k) {
		String result = new String();
		if (n == 0) {
			return result;
		}
		return result;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence result = new PermutationSequence();
		System.out.println(result.permutationSequence(3, 6));
	}

}
