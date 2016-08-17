/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in 
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it 
 * as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Tags: LinkedList, Math
 * @author wendi
 *
 */
public class AddTwoNumbers {

	/**
	 * Brute force
	 * @param ListNode l1, ListNode l2
	 * @return ListNode
	 * Time: O(n1 + n2)
	 * Space: O(1)
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			node.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
			node = node.next;
		}
		while (l1 != null) {  // cannot link directly, carry might be 1, need to be added 
			int sum = l1.val + carry;
			node.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			node = node.next;
		}
		while (l2 != null) {
			int sum = l2.val + carry;
			node.next = new ListNode(sum % 10);
			carry = sum / 10;
			l2 = l2.next;
			node = node.next;
		}
		if (carry == 1) {
			node.next = new ListNode(1);
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers result = new AddTwoNumbers();
		ListNode l1 = ListNode.generateLinkedList(new int[] {5, 1, 6});
		ListNode l2 = ListNode.generateLinkedList(new int[] {5, 6, 4});
		ListNode.printLinkedList(l1);
		ListNode.printLinkedList(l2);
		ListNode.printLinkedList(result.addTwoNumbers(l1, l2));
	}

}
