/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * 
 * Tag: LinkedList
 * @author wendi
 *
 */
public class SwapNodesinPairs {

	/**
	 * Burst
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode swapNodesinPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode a = head;
		ListNode b = head.next;
		ListNode next = b.next;
		while (a != null &&b != null) {
			prev.next = b;
			b.next = a;
			a.next = next;
			prev = a;
			if (next != null && next.next != null) {
				a = next;
				b = next.next;
				next = b.next;
			}
			else {
				break;
			}
		}	
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNodesinPairs result = new SwapNodesinPairs();
		int[] array = {1, 2, 3, 4, 5};
		ListNode head = ListNode.generateLinkedList(array);
		ListNode.printLinkedList(result.swapNodesinPairs(head));
	}

}
