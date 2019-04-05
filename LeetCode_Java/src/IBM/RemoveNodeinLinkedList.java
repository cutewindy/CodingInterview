package IBM;

import data_structure.ListNode;

public class RemoveNodeinLinkedList {
	
	
	/**
	 * replace value
	 * Time: O(1)
	 * Space: O(1)
	 */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveNodeinLinkedList result = new RemoveNodeinLinkedList();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(head);
		ListNode node = head.next;
		result.deleteNode(node);
		ListNode.printLinkedList(head);
	}

}
