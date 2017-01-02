/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class RemoveLinkedListElements {

	/**
	 * Using pre to save the previous node of curr, if curr.val == val, remove it.
	 * @param ListNode head, int val
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode removeLinkedListElements(ListNode head, int val) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;				
			}
			else {
				prev = prev.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveLinkedListElements result = new RemoveLinkedListElements();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 6, 3, 4, 5, 6});
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.removeLinkedListElements(head, 6));
	}

}
