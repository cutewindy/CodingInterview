/**
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 * Tags: LinkedList, Two Pointers
 * @author wendi
 *
 */
public class PalindromeLinkedList {

	/**
	 * Method2: Two pointers(fast and slow) + reverse linked list.
	 * Reverse left half of list, and reverse it back when comparing.
	 * @param ListNode head
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean palindromeLinkedListI(ListNode head) {
		if (head == null || head.next == null) return true;
		boolean isPa = true;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 1 reverse the left half of list until going to mid of list
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// doing reverse
			head.next = slow.next;
			slow.next = dummy.next;
			dummy.next = slow;
			slow = head;
		}
		// 2 find left list head and right list head
		ListNode left = dummy.next;
		ListNode right = slow.next;
		if (fast.next == null) {
			left = left.next;
		}
		// 3 compare left and right, and re-reverse left half list
		head = dummy.next;
		while (right != null) {
			isPa = isPa && left.val == right.val;
			// doing re-reverse
			if (head != left) {
				head.next = left.next;
				left.next = dummy.next;
				dummy.next = left;
			}
			left = head.next;
			right = right.next;
					
		}
		return isPa;
	}
	
	/**
	 * Method1: Two pointers(fast and slow) + reverse linked list.
	 * Reverse right half of list, and compare it with the left half list.
	 * @param ListNode head
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean palindromeLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		// 1 find mid of list using two pointers(fast and slow)
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 2 reverse right half of list
		slow.next = reverseLinkedList(slow.next);
		// 3 compare left half and right half
		slow = slow.next;
		while (slow != null) {
			if (head.val != slow.val) {
				return false;
			}
			head = head.next;
			slow = slow.next;
		}
		return true;
	}
	
	private ListNode reverseLinkedList(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = head.next;
		while (curr != null) {
			head.next = curr.next;
			curr.next = dummy.next;
			dummy.next = curr;
			curr = head.next;
		}
		head.next = null;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList result = new PalindromeLinkedList();
		ListNode head1 = ListNode.generateLinkedList(new int[] {1, 2, 3, 2, 1});
		ListNode head2 = ListNode.generateLinkedList(new int[] {1, 2, 3, 3, 2, 1});
		ListNode.printLinkedList(head1);
		ListNode.printLinkedList(head2);
//		System.out.println(result.palindromeLinkedList(head1));
//		System.out.println(result.palindromeLinkedList(head2));
		System.out.println(result.palindromeLinkedListI(head1));
		System.out.println(result.palindromeLinkedListI(head2));
	}

}
