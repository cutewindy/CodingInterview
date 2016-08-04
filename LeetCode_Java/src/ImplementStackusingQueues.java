import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from 
 * front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by 
 * using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be 
 * called on an empty stack).
 * 
 * Tags: Stack, Design
 * @author wendi
 *
 */
public class ImplementStackusingQueues {

	private Queue<Integer> queue = new LinkedList<>();
	/**
	 * Just add into queue
	 * @param int x
	 */
	public void push(int x) {
		queue.offer(x);
	}
	
	/**
	 * By moving the part of head to the tail of queue expect the last one, poll it 
	 */
	public void pop() {
		if (queue.isEmpty()) {
			return;
		}
		int size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			queue.offer(queue.poll());
		}
		queue.poll();
	}
	
	/**
	 * By moving the part of head to the tail of queue expect the last one, peek it, then move it to the tail
	 * @return int
	 */
	public int top() {
		if (queue.isEmpty()) {
			return -1;
		}
		int size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			queue.offer(queue.poll());
		}
		int x = queue.peek();
		queue.offer(queue.poll());
		return x;
	}
	
	/**
	 * Just check whether queue is empty
	 * @return boolean
	 */
	public boolean empty() {
		return queue.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStackusingQueues stack = new ImplementStackusingQueues();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.queue);
		stack.pop();
		System.out.println(stack.queue);
		stack.push(4);
		System.out.println(stack.queue);
		System.out.println(stack.top());
		System.out.println(stack.queue);
		System.out.println(stack.top());
		System.out.println(stack.queue);
		System.out.println(stack.empty());
	}

}
