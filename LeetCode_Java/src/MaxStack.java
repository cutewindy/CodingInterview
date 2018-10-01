import java.util.Stack;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one 
 * maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5); 
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 * @author wendi
 *
 */
public class MaxStack {
	
	/**
	 * Approach2: TreeMap + DDL
	 * push(log(n)), pop(log(n)), top(1), peekMax(1), popMap(log(n))
	 */

	/**
	 * Approach1: Two stacks
	 * push(1), pop(1), top(1), peekMax(1), popMap(n)
	 */
	Stack<Integer> stack = null;
	Stack<Integer> maxStack = null;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        pushHelp(x);
    }
    
    private void pushHelp(int x) {
    	stack.push(x);
        if (!maxStack.isEmpty() && maxStack.peek() > x) {
        	maxStack.push(maxStack.peek());
        }
        else maxStack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack<>();
        while (stack.peek() != max) {
        	buffer.push(stack.pop());
        	maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!buffer.isEmpty()) {
        	pushHelp(buffer.pop());
        }
        return max;
    }
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxStack result = new MaxStack();
		result.push(5);
		result.push(1);
		result.push(5);
		System.out.println(result.top());
		System.out.println(result.popMax());
		System.out.println(result.top());
		System.out.println(result.peekMax());
		System.out.println(result.pop());
		System.out.println(result.top());
	}

}
