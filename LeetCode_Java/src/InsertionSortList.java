/**
 * Sort a linked list using insertion sort.
 * 
 * Tags: LinkedList Sort
 * @author wendi
 *
 */
public class InsertionSortList {

	/**
	 * Using pivot to find where the curr node inserts.
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = head;
		ListNode curr = head.next;
		while (curr != null) {
			ListNode pivot = dummy;
			// 1 find the position where curr node inserts.
			while (pivot.next != curr && pivot.next.val < curr.val) {
				pivot = pivot.next;
			}
			// 2.1 insert curr node and move to next step
			if (pivot.next != curr) {
				prev.next = curr.next;
				curr.next = curr.next = pivot.next;
				pivot.next = curr;
				curr = prev.next;
			}
			// 2.2 don't insert curr node and move to next step
			else {
				prev = prev.next;
				curr = prev.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSortList result = new InsertionSortList();
		ListNode head = ListNode.generateLinkedList(new int[] {3, 2, 5, 1, 4, 6, 7});
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.insertionSortList(head));
	}

}
