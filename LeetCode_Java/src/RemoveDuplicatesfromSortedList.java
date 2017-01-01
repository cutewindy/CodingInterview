/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author wendi
 * Tag: Linked List
 */
public class RemoveDuplicatesfromSortedList {

	/**
	 * Brute force
	 * @param ListNode head
	 * @return ListNode head
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode removeDuplicatesfromSortedList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		while (node.next != null) {
			if (node.next.val == node.val) {
				node.next = node.next.next;
			}
			else {
				node = node.next;
			}
		}
		return head;
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedList result = new RemoveDuplicatesfromSortedList();
		int[] array = {1, 1, 2, 3, 3, 4, 4, 4, 4};
		ListNode head = ListNode.generateLinkedList(array);
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.removeDuplicatesfromSortedList(head));
	}

}
