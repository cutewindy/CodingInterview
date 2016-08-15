/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access 
 * to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class DeleteNodeinaLinkedList {
	 /**
	  * set the deleted node equal to its next node, then delete its next node.
	  * @param ListNode node
	  * Time: O(1)
	  * Space: O(1)
	  */
	public void deleteNodeinaLinkedList(ListNode node) {
		if (node == null) {
			return;
		}
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
		next.next = null;  // alternative
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodeinaLinkedList result = new DeleteNodeinaLinkedList();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4});
		ListNode.printLinkedList(head);
		ListNode node = head.next.next; // val = 3
		result.deleteNodeinaLinkedList(node);
		ListNode.printLinkedList(head);
	}

}
