import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * @author wendi
 *
 */
public class MinStack {
	
    /**
     * Method3: two stacks
     */
    Stack<Integer> stackII = null;
    Stack<Integer> minStack = null;
    public MinStack() {
        stackII = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void pushII(int x) {
        stackII.push(x);
        if (minStack.isEmpty()) minStack.push(x);
        else minStack.push(Math.min(minStack.peek() ,x));
    }
    
    public void popII() {
        stackII.pop();
        minStack.pop();
    }
    
    public int topII() {
        return stackII.peek();
    }
    
    public int getMinII() {
        return minStack.peek();
    }	
	

	/**
	 * Method2: Using only one stack and a global value minNum
	 */
	private int minNum = Integer.MAX_VALUE;
	private Stack<Integer> stackI;
//	public MinStack() {
//		stackI = new Stack<>();
//	}
	
	public void pushI(int x) {
		if (x <= minNum) {
			stackI.push(minNum);
			minNum = x;
		}
		stackI.push(x);
	}
	
	public void popI() {
		int pop = stackI.pop();
		if (pop == minNum) {
			minNum = stackI.pop();
		}
	}
	
	public int topI() {
		return stackI.peek();
	}
	
	public int getMinI() {
		return minNum;
	}
	
	/**
	 * Method1: Create class Pair which contains val and current minimum number in stack.
	 */
	class Pair {
		int val;
		int min;
		public Pair(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}
	
	private Stack<Pair> stack = new Stack<>();
	
//	public MinStack() {
//		stack = new Stack<>();
//	}
	
	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(new Pair(x, x));
		}
		else {
			int currMin = Math.min(x, stack.peek().min);
			stack.push(new Pair(x, currMin));
		}
	}
	
	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		stack.pop();
	}
	
	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek().val;
	}
	
	public int getMin() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek().min;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-3);
//		System.out.println(minStack.getMin());
//		minStack.pop();
//		System.out.println(minStack.top());
//		System.out.println(minStack.getMin());
		
//		minStack.pushI(-2);
//		minStack.pushI(0);
//		minStack.pushI(-3);
//		System.out.println(minStack.getMinI());
//		minStack.popI();
//		System.out.println(minStack.topI());
//		System.out.println(minStack.getMinI());
		
		minStack.pushII(-2);
		minStack.pushII(0);
		minStack.pushII(-3);
		System.out.println(minStack.getMinII());
		minStack.popII();
		System.out.println(minStack.topII());
		System.out.println(minStack.getMinII());
	}

}
