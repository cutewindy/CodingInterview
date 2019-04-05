package IBM;

import data_structure.ListNode;

/**
 * nth node from the end of linked list
 * @author wendi
 *
 */
public class NthNodefromtheEndofLinkedList {
	
	
	/**
	 * fast slow two pointers
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode nthNodefromtheEndofLinkedList(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		while (n-- > 0) fast = fast.next;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthNodefromtheEndofLinkedList result = new NthNodefromtheEndofLinkedList();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(head);
		System.out.println(result.nthNodefromtheEndofLinkedList(head, 2).val);
	}

}
