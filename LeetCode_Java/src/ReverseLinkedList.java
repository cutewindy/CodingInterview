/**
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class ReverseLinkedList {
	
	/**
	 * Method2:(Recursively) Like iteratively method
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public ListNode reverseLinkedListI(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return helper(null, head);
	}
	
	private ListNode helper(ListNode pre, ListNode head) { // be care ListNode is inreference data type
		if (head == null) {
			return pre;
		}
		ListNode next = head.next;
		head.next = pre;
		return helper(head, next);	
	}
	
	/**
	 * Method1:(Iteratively) use prev, head, next to record the position of ListNode. 
	 * Change the arrow from prev -> head to prev <- head. Then prev = head, head = next.
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
		ListNode.printLinkedList(result.reverseLinkedList(head));
		ListNode.printLinkedList(result.reverseLinkedListI(head));
	}

}
