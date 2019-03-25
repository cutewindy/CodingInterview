import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Design a Phone Directory which supports the following operations:
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 * Example:
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 * PhoneDirectory directory = new PhoneDirectory(3);
 * // It can return any available phone number. Here we assume it returns 0.
 * directory.get();
 * // Assume it returns 1.
 * directory.get();
 * // The number 2 is available, so return true.
 * directory.check(2);
 * // It returns 2, the only number that is left.
 * directory.get();
 * // The number 2 is no longer available, so return false.
 * directory.check(2);
 * // Release number 2 back to the pool.
 * directory.release(2);
 * // Number 2 is available again, return true.
 * directory.check(2);
 * Show Company Tags
 * Hide Tags
 * 
 * Tags: LinkedList, Design
 * @author wendi
 *
 */
public class DesignPhoneDirectory {
	
	/**
	 * Approach2: bitset
	 * Space: O(n)
	 */
	    BitSet bitset;
    int max;
    public DesignPhoneDirectory(int maxNumbers) {
        bitset = new BitSet(maxNumbers);
        max = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    // Time: O(log(n))
    public int get() {
        int res = bitset.nextClearBit(0);
        if (res >= max) return -1;
        bitset.set(res, true);
        return res;
        
    }
    
    /** Check if a number is available or not. */
    // Time: O(1)
    public boolean check(int number) {
        return bitset.get(number) == false;
    }
    
    /** Recycle or release a number. */
    // Time: O(1)
    public void release(int number) {
        bitset.set(number, false);
    }
	
    
    /**
     * Approach1: queue + set
     */
//	private Set<Integer> set = new HashSet<>();  // use to save the number that has been used (or can be use)
//	private Queue<Integer> queue = new LinkedList<>(); // use to save the number that can be use
//    
//	/** Initialize your data structure here
//    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
//	public DesignPhoneDirectory(int maxNumbers) {
//		for (int i = 0; i < maxNumbers; i++) {
//			queue.offer(i);
//		}
//	}
//	
//    /** Provide a number which is not assigned to anyone.
//    @return - Return an available number. Return -1 if none is available. */
//	// Time: O(1)
//	public int get() {
//	    if (queue.isEmpty()) return -1;  // take care
//	    int number = queue.poll();
//	    set.add(number);
//		return number;
//	}
//	
//	/** Check if a number is available or not. */
//	// Time: O(1)
//	public boolean check(int number) {
//	    return !set.contains(number);
//	}
//	
//	/** Recycle or release a number. */
//	// Time: O(1)
//	public void release(int number) {
////	    if (queue.contains(number)) return; // time limited exception 
//		if (!set.contains(number)) return;  // take care
//	    queue.offer(number);
//	    set.remove(number);
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignPhoneDirectory result = new DesignPhoneDirectory(3);
		System.out.println("get: " + result.get());
		System.out.println(result.check(0));
		System.out.println(result.check(1));
		System.out.println(result.check(2));
		result.release(0);
		System.out.println("After release: 0");
		System.out.println(result.check(0));
		System.out.println(result.check(1));
		System.out.println(result.check(2));
	}

}
