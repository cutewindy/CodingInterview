/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
                      ↘
                        c1 → c2 → c3
                      ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class IntersectionofTwoLinkedLists {
	
	/**
	 * Method2: add list A to the end of B, and add B to the end of A, then if they have intersection, 
	 * the intersection would located at the end of the combined node. Otherwise, the combined node
	 * is null.
	 * @param ListNode headA, ListNode headB
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode intersectionofTwoLinkedListsI(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		while (nodeA != nodeB) {
			nodeA = nodeA == null ? headB : nodeA.next;
			nodeB = nodeB == null ? headA : nodeB.next;
		}
		return nodeA;
	}
	
	/**
	 * Method1: Get the different of length
	 * 1 Get the length of the two lists.
	 * 2 Align them to the same start point.
	 * 3 Move them together until finding the intersection point, or the end null
	 * @param ListNode headA, ListNode headB
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode intersectionofTwoLinkedLists(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		// 1 Get the length of the two lists
		int lengA = 0;
		int lengB = 0;
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		while (nodeA != null) {
			lengA++;
			nodeA = nodeA.next;
		}
		while (nodeB != null) {
			lengB++;
			nodeB = nodeB.next;
		}
		// 2 Align them to the same start point.
		while (lengB < lengA) {
			headA = headA.next;
			lengA--;
		}
		while (lengA < lengB) {
			headB = headB.next;
			lengB--;
		}
		// 3 Move them together until finding the intersection point
		while (headA != null && headB != null) {
			if (headA == headB) return headA;
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionofTwoLinkedLists result = new IntersectionofTwoLinkedLists();
		
	}

}
