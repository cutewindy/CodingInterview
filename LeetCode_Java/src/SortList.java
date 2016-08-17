/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Tags: LinkedList, Sort
 * @author wendi
 *
 */
public class SortList {

	/**
	 * MergeSort
	 * Using helper function to find the mid node of list, then merging sort head list and mid list.
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		return helper(head);
	}
	
	private ListNode helper(ListNode head) {
		if (head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode mid;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		mid = slow.next;
		slow.next = null;
		return mergeSort(helper(head), helper(mid));
	}
	
	private ListNode mergeSort(ListNode head1, ListNode head2) {
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				node.next = head1;
				head1 = head1.next;
			}
			else {
				node.next = head2;
				head2 = head2.next;
			}
			node = node.next;
		}
		node.next = head1 != null ? head1 : head2;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortList result = new SortList();
		ListNode head = ListNode.generateLinkedList(new int[] {6, 2, 5, 3, 1, 4, 7});
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.sortList(head));
	}

}
