/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes 
 * greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * Tags: LinkedList, Two Pointers
 * @author wendi
 *
 */
public class PartitionList {

	/**
	 * Method2:Two linked list: create two linked list, one list's val<x, the other list's val>=x.
	 * Then combine this two lists. (Don't forget cut down tail first)
	 * @param ListNode head, int x
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode partitionListI(ListNode head, int x) {
		if (head == null || head.next == null) return head;	
		ListNode smalHead = new ListNode(0);
		ListNode largHead = new ListNode(0);		
		ListNode smal = smalHead;
		ListNode larg = largHead;
		// 1 create smaller list and larger list
		while (head != null) {
			if (head.val < x) {
				smal.next = head;
				smal = smal.next;
			}
			else {
				larg.next = head;
				larg = larg.next;
			}
			head = head.next;
		}
		// 2 combine smaller list and larger list
		larg.next = null;  // take care, must cut down the tail
		smal.next = largHead.next;
		return smalHead.next;
	}
	
	
	/**
	 * Method1: Brute force
	 * @param ListNode head, int x
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode partitionList(ListNode head, int x) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		ListNode pre = dummy;
		ListNode curr = head;
		while (curr != null) {
			if (curr.val < x && p == pre) {
				p = p.next;
				pre = pre.next;
				curr = curr.next;
			}
			else if (curr.val < x && p != pre) {
				pre.next = curr.next;
				curr.next = p.next;
				p.next = curr;
				p = p.next;
				curr = pre.next;
			}
			else {
				pre = pre.next;
				curr = curr.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionList result = new PartitionList();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3});
		ListNode.printLinkedList(head);
		ListNode.printLinkedList(result.partitionList(head, 3));
//		ListNode.printLinkedList(result.partitionListI(head, 3));
	}

}
