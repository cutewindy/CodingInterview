/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by 
 * splicing together the nodes of the first two lists.
 * 
 * Tag: LinkedList
 * @author wendi
 *
 */
public class MergeTwoSortedLists {

	/**
	 * Using l1 as main LinkedList, if l1.val<=l2.val, l1 move to next one, otherwise, merge l2 node to l1,
	 * l1Prev.next=l2, l2.next=l1, l1Prev=l2, then l2 move to next one.
	 * @param ListNode l1
	 * @param ListNode l2
	 * @return ListNode
	 * Time: O(m+n)
	 * Space: O(1)
	 */
	public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null || l2 == null) {
			return l1 != null ? l1 : l2; 
		}
		ListNode dummy = new ListNode(0);
		dummy.next = l1;
		ListNode l1Prev = dummy;
		ListNode l2Next = l2.next;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				l1Prev = l1;
				l1 = l1.next;
			}
			else {
				l1Prev.next = l2;
				l2.next = l1;
				l1Prev = l2;
				l2 = l2Next;
				l2Next = l2 != null ? l2.next : null;
			}
		}
		if (l2 != null) {
			l1Prev.next = l2;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoSortedLists result = new MergeTwoSortedLists();
		int[] array1 = {1, 2, 6, 9, 15, 16};
		int[] array2 = {3, 4, 8, 10, 13};
		ListNode l1 = ListNode.generateLinkedList(array1);
		ListNode l2 = ListNode.generateLinkedList(array2);
		ListNode.printLinkedList(result.mergeTwoSortedList(l1, l2));
	}

}
