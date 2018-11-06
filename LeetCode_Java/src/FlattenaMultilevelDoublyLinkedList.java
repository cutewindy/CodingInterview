import java.util.Stack;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could 
 * have a child pointer, which may or may not point to a separate doubly linked list. These child 
 * lists may have one or more children of their own, and so on, to produce a multilevel data 
 * structure, as shown in the example below.
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are 
 * given the head of the first level of the list.
 * Example:
 * Input:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * @author wendi
 *
 */
public class FlattenaMultilevelDoublyLinkedList {
	
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }		
	}
	
	/**
	 * Approach3: Like approach2, iteration with stack
	 * flatten the node "head" and return the tail in its child (if exists)
   	 * the tail means the last node after flattening "head"
	 * @param Node head
	 * @return Node
	 * Time: O(n)
	 * Space: O(1)
	 */
	public Node flattenaMultilevelDoublyLinkedListII(Node head) {
        if (head == null) return head;
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        Node prev = head;
        while (!stack.isEmpty() || curr != null) {
            if (curr == null) {
                curr = stack.pop();
                prev.next = curr;
                curr.prev = prev;
            }
            if (curr.child != null) {
                if (curr.next != null) stack.push(curr.next); // make sure that next will not be null
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;	
	}

	
	/**
	 * Approach2: Recursion
	 * flatten the node "head" and return the tail in its child (if exists)
   	 * the tail means the last node after flattening "head"
	 * @param Node head
	 * @return Node
	 * Time: O(n)
	 * Space: O(1)
	 */
	public Node flattenaMultilevelDoublyLinkedListI(Node head) {
        getTail(head);
        return head;
    }
    
    private Node getTail(Node head) {
        Node tail = head;
        Node curr = head;
        while (curr != null) {
            if (curr.child == null) {
                tail = curr;
                curr = curr.next;
            }
            else {
                Node childTail = getTail(curr.child); // Find the tail of the child
                
                // connect curr and child, and remove curr.child
                Node next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                
                // connect tail and next
                childTail.next = next;
                if (next != null) next.prev = childTail;
                
                tail = childTail;
                curr = next;
            }
        }
        
        return tail;  // tail will not be null
	}
	
	
	/**
	 * Approach1: 
	 * Brute force: Iteration
	 * Basic idea is straight forward:
	 * 1. Start form the head , move one step each time to the next node
	 * 2. When meet with a node with child, say node curr, follow its child chain to the end and 
	 *    connect the tail node with curr.next, by doing this we merged the child chain back to the 
	 *    main thread
	 * 3. Return to curr and proceed until find next node with child.
	 * 4. Repeat until reach null
	 * @param Node head
	 * @return Node
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public Node flattenaMultilevelDoublyLinkedList(Node head) {
        if (head == null) return head;
        Node curr = head;
        while (curr != null) {   
            // if has child, get child, find the tail of the child and link it to curr.next
            if (curr.child != null) {    
                Node child = curr.child;
                Node tail = child;
                Node next = curr.next;
                while (tail.next != null) tail = tail.next; // Find the tail of the child
                
                // connect curr and child, and remove curr.child
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                
                // connect tail and next
                tail.next = next;
                if (next != null) next.prev = tail;
                
            }
            curr = curr.next;
        }
        return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FlattenaMultilevelDoublyLinkedList result = new FlattenaMultilevelDoublyLinkedList();
	}

}
