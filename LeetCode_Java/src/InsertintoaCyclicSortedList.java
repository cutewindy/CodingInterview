/**
 * Given a node from a cyclic linked list which is sorted in ascending order, write a function to 
 * insert a value into the list such that it remains a cyclic sorted list. The given node can be a 
 * reference to any single node in the list, and may not be necessarily the smallest value in the 
 * cyclic list.
 * If there are multiple suitable places for insertion, you may choose any place to insert the new 
 * value. After the insertion, the cyclic list should remain sorted.
 * If the list is empty (i.e., given node is null), you should create a new single cyclic list and 
 * return the reference to that single node. Otherwise, you should return the original given node.
 * The following example may help you understand the problem better:
 * In the figure above, there is a cyclic sorted list of three elements. You are given a reference 
 * to the node with value 3, and we need to insert 2 into the list.
 * The new node should insert between node 1 and node 3. After the insertion, the list should look 
 * like this, and we should still return node 3.
 * @author wendi
 *
 */
public class InsertintoaCyclicSortedList {
	
	class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	/**
	 * One pass
	 * try to find the interval position to insert new node, like  => 2 => 5 => 8 =>
	 * the position should be 
	 * 1. prev < new < curr, like (prev, curr) = (2, 5), new = 3
	 * 2. prev > curr, new > prev, like (prev, curr) = (8, 2), new = 9
	 * 3. prev > curr, new < curr, like (prev, curr) = (8, 2), new = 1 
	 * @param Node head, int insertVal
	 * @return Node
	 * Time: O(n)
	 * Space: O(1)
	 */
	public Node insertintoaCyclicSortedList(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != head) {
            if (prev.val <= insertVal && insertVal <= curr.val) break;
            if (prev.val > curr.val && (prev.val <= insertVal || curr.val >= insertVal)) break;
            prev = curr;
            curr = curr.next;
        }
        prev.next = insertNode;
        insertNode.next = curr;
        return head;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
