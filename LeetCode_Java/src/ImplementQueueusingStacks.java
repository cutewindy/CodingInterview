import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from 
 * top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by 
 * using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be 
 * called on an empty queue).
 * 
 * Tags: Stack, Design
 * @author wendi
 *
 */
public class ImplementQueueusingStacks {
	
	/**
	 * Method2: Just edit when push, change it to queue
	 * Time: push: O(n) pop: O(1)
	 * Space: O(n)
	 */
	private Stack<Integer> stack = new Stack<>();
	public void pushI(int x) {
		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) temp.push(stack.pop());
		stack.push(x);
		while (!temp.isEmpty()) stack.push(temp.pop());
	}
	
	public int popI() {
		if (stack.isEmpty()) return -1;
		return stack.pop();
	}
	
	public int peekI() {
		if (stack.isEmpty()) return -1;
		return stack.peek();
	}
	
	public boolean emptyI() {
		return stack.isEmpty();
	}
	
	
	
	/**
	 * Method1: Using two stacks, edit when pop and peek.
	 * Time: push:O(1) pop:O(1)
	 * Space: O(n)
	 */
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	public void push(int x) {
		stack1.push(x);
	}
	
	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) stack2.push(stack1.pop());	
		}
		if (stack2.isEmpty()) return -1;
		return stack2.pop();
	}
	
	public int peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) stack2.push(stack1.pop());
		} 
		if (stack2.isEmpty()) return -1; 
		return stack2.peek();
	}
	
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ImplementQueueusingStacks queue = new ImplementQueueusingStacks();
	}

}
