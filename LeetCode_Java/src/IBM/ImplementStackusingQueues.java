package IBM;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
	
	/**
	 * Method2: Using one queue. Just edit push method, move the last in into the first
	 */
	private Queue<Integer> queueI = new LinkedList<>();
	public void pushI(int x) {
		int size = queueI.size();
		queueI.offer(x);
		for (int i = 0; i < size; i++) {
			queueI.offer(queueI.poll());
		}
	}
	
	public void popI() {
		queueI.poll();
	}
	
	public int topI() {
		return queueI.peek();
	}
 	
	public boolean emptyI() {
		return queueI.isEmpty();
	}
	
	/**
	 * Method1: Using one queue, and edit it when pop and top
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
