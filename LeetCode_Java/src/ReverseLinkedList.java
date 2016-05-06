/**
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @author wendi
 *
 */
public class ReverseLinkedList {
	/**
	 * use prev, head, next to record the position of ListNode. Change the arrow from 
	 * prev -> head to prev <- head. Then prev = head, head = next.
	 * @param ListNode head
	 * @return ListNode newHead
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList result = new ReverseLinkedList();
		int[] array = {1, 2, 3, 4};
		ListNode head = ListNode.generateLinkedList(array);
		ListNode.printLinkedList(head);
		ListNode newHead = result.reverseLinkedList(head);
		ListNode.printLinkedList(newHead);
	}

}
