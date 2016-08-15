/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note 
 * here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) 
 * time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input. 
 * The first node is considered odd, the second node even and so on ...
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class OddEvenLinkedList {

	/**
	 * Two pointers: form a linked list of all odd nodes and another linked list of all even nodes.
	 * Afterwards, link even list to the end of odd list, and return the head of odd list.
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
 	 */
	public ListNode oddEvenLinkedList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = head.next;
		// 1 add first node to the odd list and second node to the even list
		while (even != null && even.next != null) {
			odd.next = even.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		// 2 link even list to odd list
		odd.next = evenHead;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenLinkedList result = new OddEvenLinkedList();
		ListNode head1 = ListNode.generateLinkedList(new int[] {1, 2, 3, 4});
		ListNode.printLinkedList(head1);
		ListNode.printLinkedList(result.oddEvenLinkedList(head1));
		ListNode head2 = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(head2);
		ListNode.printLinkedList(result.oddEvenLinkedList(head2));
	}

}
