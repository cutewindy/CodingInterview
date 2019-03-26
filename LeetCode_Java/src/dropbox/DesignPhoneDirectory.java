package dropbox;

import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**

1. LC379. Design Phone Directory
这题是主要的挂因，10分钟之内顺利写了常见的两种写法
1） 用bitset和queue，空间发杂度高，时间复杂度1
2）只用bitset，空间低，时间ON
3）想了很久以后快速写出了page table的第三种解法 空间是OlgN。最后面试官给的feedback是需要significant hint，讲真人家
真没给啥提示，还是自己想出来的，不过沉思了很久的确很难看。
注意这道题是要说使用内存的。不熟悉的温习下。
 * 
 * 一般讨论的是空间O1时间ON或者时间O1空间ON的方法，面试官要的是时空复杂度都是LogN。
 * @author wendi
 *
 */
public class DesignPhoneDirectory {
	
	/**
	 * Approach2: bitset
	 * Time: O(log(n))
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
    public int get() {
        int res = bitset.nextClearBit(0);
        if (res >= max) return -1;
        bitset.set(res, true);
        return res;
        
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return bitset.get(number) == false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        bitset.set(number, false);
    }	
	
	
	/**
	 * Approach1: set + queue
	 * Time: O(1)
	 * Space: O(n)
	 */
    Set<Integer> set = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    
//    public DesignPhoneDirectory(int maxNumbers) {
//            for (int i = 0; i < maxNumbers; i++) {
//                queue.offer(i);
//                set.add(i);
//            }
//    }
//    
//    /** Provide a number which is not assigned to anyone.
//        @return - Return an available number. Return -1 if none is available. */
//    public int get() {
//        if (queue.isEmpty()) return -1;
//        int res = queue.poll();
//        set.remove(res);
//        return res;
//    }
//    
//    /** Check if a number is available or not. */
//    public boolean check(int number) {
//        return set.contains(number);
//    }
//    
//    /** Recycle or release a number. */
//    public void release(int number) {
//        if (set.contains(number)) return;
//        queue.offer(number);
//        set.add(number);
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
