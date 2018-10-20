import java.util.Stack;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right 
 * pointers as synonymous to the previous and next pointers in a doubly-linked list.
 * Let's take the following BST as an example, it may help you understand the problem better:
 * We want to transform this BST into a circular doubly linked list. Each node in a doubly linked 
 * list has a predecessor and successor. For a circular doubly linked list, the predecessor of the 
 * first element is the last element, and the successor of the last element is the first element.
 * The figure below shows the circular doubly linked list for the BST above. The "head" symbol means 
 * the node it points to is the smallest element of the linked list.
 * Specifically, we want to do the transformation in place. After the transformation, the left 
 * pointer of the tree node should point to its predecessor, and the right pointer should point to 
 * its successor. We should return the pointer to the first element of the linked list.
 * The figure below shows the transformed BST. The solid line indicates the successor relationship, 
 * while the dashed line means the predecessor relationship.
 * @author wendi
 *
 */
public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
	
	/**
	 * Approach2: DFS, inorder traversal
	 * @param Node root
	 * @return Node
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    
    Node tail;
    public Node ConvertBinarySearchTreetoSortedDoublyLinkedListI(Node root) {
        if (root == null) return null;
        Node dummyHead = new Node();
        tail = dummyHead;
        dfs(root);
        tail.right = dummyHead.right;
        dummyHead.right.left = tail;
        return dummyHead.right;
    } 
    
    private void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        tail.right = root;
        root.left = tail;
        tail = tail.right;
        dfs(root.right);
    }
	
	
	/**
	 * Approach1: Stack, inorder traversal
	 * @param Node root
	 * @return Node
	 * Time: O(n)
	 * Space: O(log(n))
	 */
	public Node convertBinarySearchTreetoSortedDoublyLinkedList(Node root) {
		if (root == null) return null;
		Node dummyHead = new Node();
		Node tail = dummyHead;
		Stack<Node> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			tail.right = root;
			root.left = tail;
			tail = root;
			root = root.right;
		}
		tail.right = dummyHead.right;
		dummyHead.right.left = tail;
		return dummyHead.right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertBinarySearchTreetoSortedDoublyLinkedList result = new ConvertBinarySearchTreetoSortedDoublyLinkedList();

	}

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
