import java.util.Arrays;
import java.util.Stack;

/**
 * By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a 
 * decreasing relationship between two numbers, 'I' represents an increasing relationship between 
 * two numbers. And our secret signature was constructed by a special integer array, which contains 
 * uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). 
 * For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], but won't 
 * be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string 
 * that can't represent the "DI" secret signature.
 * On the other hand, now your job is to find the lexicographically smallest permutation of 
 * [1, 2, ... n] could refer to the given secret signature in the input.
 * Example 1:
 * Input: "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", 
 * where the number 1 and 2 construct an increasing relationship.
 * Example 2:
 * Input: "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI", 
 * but since we want to find the one with the smallest lexicographical permutation, you need to 
 * output [2,1,3]
 * Note:
 * The input string will only contain the character 'D' and 'I'.
 * The length of input string is a positive integer and will not exceed 10,000
 * @author wendi
 *
 */
public class FindPermutation {
	
	/**
	 * Method3: Two Pointers
	 * keep on filling the numbers in ascending order in res for I's found in the pattern s. 
	 * Whenever we find a D in s, we can store the current position l, whenever we find the first I 
	 * following this last consecutive set of D's, say at the r, we know, that the elements from l 
	 * to r in res need to be filled with the numbers from l to r in reverse order.
	 * @param String s
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] findPermutationII(String s) {
		if (s == null || s.length() == 0) return new int[0];
		int[] res = new int[s.length() + 1];
		int num = 1;
		int l = 0;
		int r =  0;
		char[] S = s.toCharArray();
		while (r <= S.length) {
			while (r < S.length && S[r] == 'D') r++;
			for (int k = r; k >= l; k--) res[k] = num++;
			r++;
			l = r;
		}
		return res;
	}

	
	
	/**
	 * Method2: Reverse subarray
	 * For example, given IIDDDDI we start with sorted sequence 1234567
	 * Then for each continuous D starting at l and ending at r we need to reverse [l, r] portion of 
	 * the sorted sequence. For the given example, [l,r] = [2,5].
	 * @param String s
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] findPermutationI(String s) {
		if (s == null || s.length() == 0) return new int[0];
		int[] res = new int[s.length() + 1];
		for (int i = 0; i < res.length; i++) res[i] = i + 1;
		char[] S = s.toCharArray();
		int l = 0;
		int r = 0;
		while (r < S.length) {
			while (r < S.length && S[r] == 'D') r++;
			if (l != r) reverse(res, l, r);
			r++;
			l = r;
		}
		return res;
	}
	
	private void reverse(int[] res, int l, int r) {
		while (l < r) {
			int temp = res[l];
			res[l] = res[r];
			res[r] = temp;
			l++;
			r--;
		}
	} 
	
	/**
	 * Method1: Stack
	 * @param String s
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] findPermutation(String s) {
		if (s == null || s.length() == 0) return new int[0];
		int[] res = new int[s.length() + 1];
		int i = 0;
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		stack.push(num++);
		for (char c: s.toCharArray()) {
			if (c == 'I') {
				while (!stack.isEmpty()) res[i++] = stack.pop();
			}
			stack.push(num++);
		}
		while (!stack.isEmpty()) res[i++] = stack.pop();
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPermutation result = new FindPermutation();
		System.out.println(Arrays.toString(result.findPermutation("DIIDDDDIDD")));
		System.out.println(Arrays.toString(result.findPermutationI("DIIDDDDIDD")));
		System.out.println(Arrays.toString(result.findPermutationII("DIIDDDDIDD")));
	}

}
