/**
 * Design your implementation of the circular double-ended queue (deque).
 * Your implementation should support following operations:
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * isEmpty(): Checks whether Deque is empty or not. 
 * isFull(): Checks whether Deque is full or not.
 * Example:
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 * circularDeque.insertLast(1);			// return true
 * circularDeque.insertLast(2);			// return true
 * circularDeque.insertFront(3);			// return true
 * circularDeque.insertFront(4);			// return false, the queue is full
 * circularDeque.getRear();  			// return 2
 * circularDeque.isFull();				// return true
 * circularDeque.deleteLast();			// return true
 * circularDeque.insertFront(4);			// return true
 * circularDeque.getFront();			// return 4
 * Note:
 * 1. All values will be in the range of [0, 1000].
 * 2. The number of operations will be in the range of [1, 1000].
 * 3. Please do not use the built-in Deque library.
 * @author wendi
 *
 */
public class DesignCircularDeque {
	
    int[] array; // rear -> [ ...] -> front
    int front; // exclude
    int rear;  // exclude
    int size;
    int k;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque(int k) {
        this.array = new int[k];
        this.front = 1;
        this.rear = 0;
        this.size = 0;
        this.k = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == k) return false;
        array[front] = value;
        front = (front + 1) % k;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == k) return false;
        array[rear] = value;
        rear = (rear - 1 + k) % k;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) return false;
        front = (front - 1 + k) % k;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        rear = (rear + 1) % k;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        int index = (front - 1 + k) % k;
        return array[index];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        int index = (rear + 1) % k;
        return array[index];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignCircularDeque result = new DesignCircularDeque(3);
		System.out.println(result.insertLast(1));     // true
		System.out.println(result.insertLast(2));     // true
		System.out.println(result.insertFront(3));    // true
		System.out.println(result.insertFront(4));    // false
		System.out.println(result.getRear());         // 2
		System.out.println(result.isFull());          // true
		System.out.println(result.deleteLast());      // true
		System.out.println(result.insertFront(4));    // true
		System.out.println(result.getFront());        // 4
	}

}
