/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a 
 * height balanced BST.
 * 
 * Tags: DFS, Linked List
 * @author wendi
 *
 */
public class ConvertSortedListtoBinarySearchTree {
	
	/**
	 * Two pointers: using fast and slow to find the mid as root 
	 * @param ListNode head
	 * @return TreeNode
	 * Time: O(nlog(n)) n is the number of nodes
	 * Space: O(1)
	 */
	public TreeNode convertSortedListtoBinarySearchTreeI(ListNode head) {
		if (head == null) {
			return null;
		}
		return helperI(head);
	}
	
	private TreeNode helperI(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.next.val);
		root.right = helperI(slow.next.next);
		slow.next = null; // take care: cut down the left child
		root.left = helperI(head);
		return root;
		
	}
	
	
    /**
     * Method1: DFS(recursion) Inorder(left -> root -> right).
     * currListNode is the node that need to convert to TreeNode.
     * @param ListNode head
     * @return TreeNode
     * Time: O(n) n is the number of nodes
     * Space: O(1)
     */
    private ListNode currListNode;   // inorder to generate BST
	public TreeNode convertSortedListtoBinarySearchTree(ListNode head) {
		if (head == null) {
			return null;
		}
		// calculate the length of list
		int size = 0;
		ListNode node = head;
		while (node != null) {
			size++;
			node = node.next;
		}
		currListNode = head;
		return helper(size);
	}
	
	private TreeNode helper(int size) {
		if (size <= 0) {
			return null;
		}
		TreeNode left = helper(size/ 2); 
		TreeNode root = new TreeNode(currListNode.val);
		currListNode = currListNode.next;
		TreeNode right = helper(size  - size / 2 - 1);  // rightSize = size - leftSize - 1
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListtoBinarySearchTree result = new ConvertSortedListtoBinarySearchTree();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5, 6 ,7, 8});
//		ListNode head = ListNode.generateLinkedList(new int[] {3, 5, 8});
		ListNode.printLinkedList(head);
//		TreeNode.printCBT(result.convertSortedListtoBinarySearchTree(head));	
		TreeNode.printCBT(result.convertSortedListtoBinarySearchTreeI(head));
	}

}
