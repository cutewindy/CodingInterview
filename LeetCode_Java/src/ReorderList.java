/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class ReorderList {

	/**
	 * 1 Using fast and slow method to find the mid node of list, mid = slow.
	 * 2 Using reverse list method to reverse mid.next.
	 * 3 Cutting down slow.next, l1 = head, l2 = slow.next.
	 * 4 Using merge method to merge l1 and l2.
	 * @param ListNode head
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		// 1 find mid of list
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 2 reverse mid.next
		reverseList(slow);
//		ListNode.printLinkedList(slow.next);
		// 3 cut down slow.next
		ListNode l1 = head;
		ListNode l2 = slow.next;
		slow.next = null;
		// 4 merge two lists
		mergeTwoList(l1, l2);
	}
	
	private void reverseList(ListNode dummy) {
		if (dummy.next == null) return;
		ListNode tail = dummy.next;
		ListNode curr = dummy.next.next;
		while (curr != null) {
			tail.next = curr.next;
			curr.next = dummy.next;
			dummy.next = curr;
			curr = tail.next;
		}
	}
	
	private void mergeTwoList(ListNode l1, ListNode l2) {
		while (l1 != null && l2 != null) {
			ListNode n1 = l1.next;
			ListNode n2 = l2.next;
			l1.next = l2;
			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList result = new ReorderList();
		ListNode head1 = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5, 6});
		ListNode head2 = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7});
		ListNode.printLinkedList(head1);
		result.reorderList(head1);
		ListNode.printLinkedList(head1);
		ListNode.printLinkedList(head2);
		result.reorderList(head2);
		ListNode.printLinkedList(head2);
	}

}
