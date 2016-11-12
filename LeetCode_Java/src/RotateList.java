/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * Tags: LinkedList, Two Pointers
 * @author wendi
 *
 */
public class RotateList {

	/**
	 * Two pointers:fast and slow, take care about if k > length of list
	 * @param ListNode head, int k
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode rotateList(ListNode head, int k) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 1 calculate the length of list, set k = k%length
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		k %= length;
		if (k == 0) return dummy.next;
		// 2 head go to k steps first
		ListNode fast = head;
		ListNode slow = head;
		while (k-- > 0) {
			fast = fast.next;
		}
		// 3 fast and slow go to same step until fast.next=null, in order to find the rotated node,
		// which is slow.next = rotated node
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// 4 rotate
		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList result = new RotateList();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.rotateList(head, 12));
	}

}
