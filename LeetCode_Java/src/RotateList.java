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
	 * Two pointers: be care about if k > length of list
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
		while (head != null) {
			length++;
			head = head.next;
		}
		k %= length;
		if (k == 0) return dummy.next;
		// 2 head go to k steps first
		head = dummy.next;
		for (int i = 0; i < k; i++) {
			head = head.next;
			
		}
		// 3 head and pre go to same step until head.next=null, in order to find the rotated node,
		// which is pre.next = rotated node
		ListNode pre = dummy.next;
		while (head.next != null) {
			head = head.next;
			pre = pre.next;
		}
		// 4 rotate
		head.next = dummy.next;
		dummy.next = pre.next;
		pre.next = null;
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
