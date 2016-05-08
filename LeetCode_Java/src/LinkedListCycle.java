/**
 * Given a linked list, determine if it has a cycle in it.

 * Follow up:
 * Can you solve it without using extra space?
 * @author wendi
 * Tag: Linked List, Two pointers
 */
public class LinkedListCycle {

	/**
	 * Two pointers: fast and slow, in each iteration, slow go one step while fast go two steps,
	 * if fast==slow, exit cycle.
	 * @param ListNode head
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean linkedListCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycle result = new LinkedListCycle();
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		ListNode head = ListNode.generateLinkedList(array);
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		System.out.println(tail.val);
		tail.next = head.next.next;
		System.out.println(tail.next.val);
		System.out.println(result.linkedListCycle(head));
	}

}
