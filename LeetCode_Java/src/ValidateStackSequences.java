import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could 
 * have been the result of a sequence of push and pop operations on an initially empty stack.
 * Example 1:
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * Note:
 * 1. 0 <= pushed.length == popped.length <= 1000
 * 2. 0 <= pushed[i], popped[i] < 1000
 * 3. pushed is a permutation of popped.
 * 4. pushed and popped have distinct values.
 * @author wendi
 *
 */
public class ValidateStackSequences {
	
	
	/**
	 * stack + greedy
	 * For each value, push it to the stack.
	 * Then, greedily pop values from the stack if they are the next values to pop.
	 * At the end, we check if we have popped all the values successfully.
	 * @param int[] pushed, int[] popped
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateStackSequences result = new ValidateStackSequences();
		System.out.println(result.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
	}	

}
