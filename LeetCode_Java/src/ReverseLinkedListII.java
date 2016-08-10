/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class ReverseLinkedListII {

	/**
	 * 1 Find the pre of m node.
	 * 2 Put all n - m node after pre one by one.
	 * 3 Return dummy.next.
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(m - n)
	 * Space: O(1)
	 */
	public ListNode reverseLinkedListII(ListNode head, int m, int n) {
		if (head == null || head.next == null || m >= n) {
			return head;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}
		ListNode tail = prev.next;
		ListNode curr = tail.next;
		for (int i = 0; i < n - m; i++) {
			tail.next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			curr = tail.next;
		}
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedListII result = new ReverseLinkedListII();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.reverseLinkedListII(head, 2, 4));
	}

}
