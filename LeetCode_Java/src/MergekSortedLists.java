/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * Tags: Divide and Conquer, LinkedList, Heap
 * @author wendi
 *
 */
public class MergekSortedLists {

	/**
	 * Method1(Time Limit Exceeded): merge two by two by using mergeTwoSortedLists function.
	 * @param ListNode[] lists
	 * @return ListNode
	 * Time: O(n^2) ??
	 * Space: O(1)
	 */
	public ListNode mergekSortedLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		for (int i = 1; i < lists.length; i++) {
			lists[0] = mergeTwoSortedLists(lists[0], lists[i]);
		}
		return lists[0];
	}
	
	private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
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
		MergekSortedLists result = new MergekSortedLists();
		ListNode l1 = ListNode.generateLinkedList(new int[] {1, 3, 6, 7});
		ListNode l2 = ListNode.generateLinkedList(new int[] {2, 5});
		ListNode l3 = ListNode.generateLinkedList(new int[] {4, 8, 9});
		ListNode.printLinkedList(result.mergekSortedLists(new ListNode[] {l1, l2, l3}));
	}

}