/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * Tags: LinkedList, Two Pointers
 * @author wendi
 *
 */
public class RemoveNthNodefromEndofList {

	/**
	 * Fast and slow: fast go to n steps, and then fast and slow go to same step, until fast.next=null,
	 * Remove slow.next.
	 * @param ListNode head, int n
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode removeNthNodefromEndofList(ListNode head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		// 1 fast go to n steps
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		// 2 fast and slow go to same steps
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// 3 remove slow.next
		slow.next = slow.next.next;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveNthNodefromEndofList result = new RemoveNthNodefromEndofList();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.removeNthNodefromEndofList(head, 5));
	}

}
