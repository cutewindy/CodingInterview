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
	 * Merge two linked list into a new one, choose the smaller one as curr.next until one of l1 or
	 * l2 is null. Then merge the left of l1 or l2 to curr.next.
	 * @param ListNode l1, ListNode l2
	 * @return ListNode
	 * Time: O(m+n)
	 * Space: O(1)
	 */
	public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;		
		if (l2 == null) return l1;		
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			}
			else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 != null ? l1 : l2;
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
