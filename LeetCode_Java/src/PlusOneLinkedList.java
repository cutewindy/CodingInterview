/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Example:
 * Input:
 * 1->2->3
 * Output:
 * 1->2->4
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class PlusOneLinkedList {

	/**
	 * Method2: Two Pointers: find the last node which node.val!=9, then all next nodes after
	 * last are nodes that node.val = 9, set last.val++ and all next node.val = 0.
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode plusOne(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode last = dummy;
		// 1 find last node which node.val != 9
		while (head != null) {
			if (head.val != 9) {
				last = head; 
			}
			head = head.next;
		}
		// 2 last.val+1
		last.val++;
		// 3 set all nodes after last as node.val = 0
		while (last.next != null) {
			last = last.next;
			last.val = 0;
		}		
		return dummy.val == 1 ? dummy : dummy.next;
	}
	
	/**
	 * Method1: reverse the inputs, add one, then reverse back
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOneLinkedList result = new PlusOneLinkedList();
		ListNode head1 = ListNode.generateLinkedList(new int[] {1, 2, 3});
		ListNode.printLinkedList(head1);
		ListNode.printLinkedList(result.plusOne(head1));
		ListNode head2 = ListNode.generateLinkedList(new int[] {9, 9, 9});
		ListNode.printLinkedList(head2);
		ListNode.printLinkedList(result.plusOne(head2));
	}

}
