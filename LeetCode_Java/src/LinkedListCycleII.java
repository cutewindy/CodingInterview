/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Tag: LinkedList, Two Pointers
 * @author wendi
 *
 */
public class LinkedListCycleII {
	
	
	/**
	 * 
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode linkedListCycleII(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null && fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null && fast.next != null) {
			while (head != slow) {
				head = head.next;
				slow = slow.next;
			}
			return head;
		}
		return null;
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
