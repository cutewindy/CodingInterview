/**
 * You are given a circular array nums of positive and negative integers. If a number k at an index 
 * is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. 
 * Since the array is circular, you may assume that the last element's next element is the first 
 * element, and the first element's previous element is the last element.
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index 
 * and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. 
 * In other words, a cycle must not consist of both forward and backward movements.
 * Example 1:
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * Example 2:
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length 
 * is 1. By definition the cycle's length must be greater than 1.
 * Example 3:
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from 
 * index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All 
 * movements in a cycle must follow a single direction.
 * Note:
 * 1. -1000 ≤ nums[i] ≤ 1000
 * 2. nums[i] ≠ 0
 * 3. 1 ≤ nums.length ≤ 5000
 * Follow up:
 * Could you solve it in O(n) time complexity and O(1) extra space complexity?
 * @author wendi
 *
 */
public class CircularArrayLoop {
	
	
	/**
	 * fast and slow
	 * 由于题目中说了 nums 中不会有0，所以可以把访问过的位置标记为0.
	 * 对于每个i位置，慢指针指向i，快指针指向下一个位置，这里调用子函数来计算下一个位置。此时慢指针指向的数要和快指针指向的
	 * 数正负相同，保证循环必须 forward 或是 backward。并且慢指针指向的数还要跟快指针的下一个位置上的数符号相同，这个
	 * 原因后面再讲。上面这两个就是 while 循环的条件，我们直到当快慢指针相遇的时候，就是环出现的时候，但是这里有个坑，
	 * 即便快慢指针相遇了，也不同立马返回 true，因为题目中说了了环的长度必须大于1，所以我们要用慢指针指向的数和慢指针下一个
	 * 位置上的数比较，若相同，则说明环的长度为1，此时并不返回 false，而且 break 掉 while 循环。因为这只能说以i位置开始
	 * 的链表无符合要求的环而已，后面可能还会出现符合要求的环。但是若二者不相同的话，则已经找到了符合要求的环，直接返回 true。
	 * 若快慢指针还不相同的，则分别更新，慢指针走一步，快指针走两步。当 while 循环退出后，我们需要标记已经走过的结点，从而
	 * 提高运算效率，方法就是将慢指针重置为i，再用一个 while 循环，条件是 nums[i] 和 慢指针指的数正负相同，然后计算下一个
	 * 位置，并且 nums[slow] 标记为0，并且慢指针移动到 next 位置。最终 for 循环退出后，返回 false 即可
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = getNext(nums, i);
            if (slow == fast) { // the length of circle is only 1 
                nums[i] = 0;
                continue;
            }            
            while (nums[i] * nums[fast] > 0 && nums[i] * nums[getNext(nums, fast)] > 0) {
                if (slow == fast) return true;
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
            } 
            slow = i;
            while (nums[i] * nums[slow] > 0) {
                int next = getNext(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }
    
    private int getNext(int[] nums, int i) {
        int n = nums.length;
        return (((nums[i] + i) % n) + n) % n;
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArrayLoop result = new CircularArrayLoop();
		System.out.println(result.circularArrayLoop(new int[] {2,-1,1,2,2}));
	}

}
