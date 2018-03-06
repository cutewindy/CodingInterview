import java.util.ArrayDeque;
import java.util.Deque;

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

	Deque<Integer> stack = null;
	Deque<Integer> maxStack = null;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.offerLast(x);
        if (maxStack.isEmpty()) maxStack.offerLast(x);
        else maxStack.offerLast(maxStack.peekLast() > x ? maxStack.peekLast() : x);
    }
    
    public int pop() {
        maxStack.pollLast();
        return stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int peekMax() {
        return maxStack.peekLast();
    }
    
    public int popMax() {
        int max = maxStack.peekLast();
        Deque<Integer> buffer = new ArrayDeque<>();
        while (stack.peekLast() != max) {
        	buffer.offerLast(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
        	push(buffer.pollLast());
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
