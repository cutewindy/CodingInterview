/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Tag: LinkedList, Two Pointers
 * @author wendi
 *
 */
public class LinkedListCycleII {
	// prove:
	// credit: "https://www.qiujiawei.com/leetcode-problem-142/"
	// slow: L1 + L2
	// fast: L1 + L2 + n * C
	// 2*slow=fast ==> 2*(L1+L2)=L1+L2+n*C ==> L1=(n-1)*C+(C-L2)
	
	/**
	 * Two pointers: slow and fast + math
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode linkedListCycleII(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) break;
		}
		if (fast.next == null || fast.next.next == null) { // no cycle
			return null;
		}
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycleII result = new LinkedListCycleII();
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		ListNode head = ListNode.generateLinkedList(array);
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
//		System.out.println(tail.val);
		tail.next = head.next.next;
		System.out.println("cycle begins: " + tail.next.val);
		System.out.println(result.linkedListCycleII(head).val);
	}

}
