/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct 
 * numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * Tags: LinkedList 
 * @author wendi
 *
 */
public class RemoveDuplicatesfromSortedListII {

	/**
	 * Use pre to save the previous node of duplicates. When finding duplicates, skip to the next 
	 * unduplicated node, then set pre.next = head.
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode removeDuplicatesfromSortedListII(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				while (head != null && head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				head = head.next;
				pre.next = head;
			}
			else {
				pre = pre.next;
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedListII result = new RemoveDuplicatesfromSortedListII();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 3, 4, 4, 5});
		ListNode.printLinkedList(result.removeDuplicatesfromSortedListII(head));
	}

}
