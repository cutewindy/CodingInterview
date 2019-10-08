/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 * You will have direct access to the node but not to the root of the tree. Each node will have a 
 * reference to its parent node.
 * Example 1:
        2
      /   \
     1     3  
 * Input: 
 * root = {"$id":"1","left":{"$id":"2","left":null,"parent":{"$ref":"1"},"right":null,"val":1},
 * "parent":null,"right":{"$id":"3","left":null,"parent":{"$ref":"1"},"right":null,"val":3},"val":2}
 * p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of Node 
 * type.
 * Example 2:
 *                 5
 *               /   \
 *              3     6
 *            /   \
 *           2     4
 *          /
 *         1  
 * Input: 
 * root = {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"parent":
 * {"$ref":"3"},"right":null,"val":1},"parent":{"$ref":"2"},"right":null,"val":2},"parent":
 * {"$ref":"1"},"right":{"$id":"5","left":null,"parent":{"$ref":"2"},"right":null,"val":4},"val":3},
 * "parent":null,"right":{"$id":"6","left":null,"parent":{"$ref":"1"},"right":null,"val":6},"val":5}
 * p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 * Example 3:
 *                       15
 *                  /           \
 *                 6             18
 *              /     \         /  \
 *             3       7       17  20
 *            / \       \  
 *           2   4       13
 *                      /
 *                     9             
 * Input: 
 * root = {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"parent":
 * {"$ref":"3"},"right":null,"val":2},"parent":{"$ref":"2"},"right":{"$id":"5","left":null,"parent":
 * {"$ref":"3"},"right":null,"val":4},"val":3},"parent":{"$ref":"1"},"right":{"$id":"6","left":null,
 * "parent":{"$ref":"2"},"right":{"$id":"7","left":{"$id":"8","left":null,"parent":{"$ref":"7"},
 * "right":null,"val":9},"parent":{"$ref":"6"},"right":null,"val":13},"val":7},"val":6},"parent":null,
 * "right":{"$id":"9","left":{"$id":"10","left":null,"parent":{"$ref":"9"},"right":null,"val":17},
 * "parent":{"$ref":"1"},"right":{"$id":"11","left":null,"parent":{"$ref":"9"},"right":null,"val":20},
 * "val":18},"val":15}
 * p = 15
 * Output: 17
 * Example 4:
 * Input: 
 * root = {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"parent":
 * {"$ref":"3"},"right":null,"val":2},"parent":{"$ref":"2"},"right":{"$id":"5","left":null,"parent":
 * {"$ref":"3"},"right":null,"val":4},"val":3},"parent":{"$ref":"1"},"right":{"$id":"6","left":null,
 * "parent":{"$ref":"2"},"right":{"$id":"7","left":{"$id":"8","left":null,"parent":{"$ref":"7"},
 * "right":null,"val":9},"parent":{"$ref":"6"},"right":null,"val":13},"val":7},"val":6},"parent":null,
 * "right":{"$id":"9","left":{"$id":"10","left":null,"parent":{"$ref":"9"},"right":null,"val":17},
 * "parent":{"$ref":"1"},"right":{"$id":"11","left":null,"parent":{"$ref":"9"},"right":null,"val":20},
 * "val":18},"val":15}
 * p = 13
 * Output: 15
 * Note:
 * 1. If the given node has no in-order successor in the tree, return null.
 * 2. It's guaranteed that the values of the tree are unique.
 * 3. Remember that we are using the Node type instead of TreeNode type so their string representation 
 * are different.
 * 
 * Follow up:
 * Could you solve it without looking up any of the node's values?
 * @author wendi
 *
 */
public class InorderSuccessorinBSTII {
	

	/**
	 * Approach2: follow up
	 * If the given node has a right, then the left most node on the right side must be the successor.
	 * If the given node is on the left side and its parent's right is pointing to the given node, 
	 * then we must find a parent node whose left is current node for it to become the successor.
	 * @param Node x
	 * @return Node
	 * Time: O(log(n))
	 * Space: O(1)
	 */
    public Node inorderSuccessorinBSTIII(Node x) {
        if (x == null) return null;
        if (x.right != null) {
            Node res = x.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
        else {
            Node res = x.parent;
            while (res != null && res.left != x) {
                x = res;
                res = res.parent;
            }
            return res;
        }
    }
    
    

	/**
	 * Approach1: using BFS, compare node's value
	 * @param Node x
	 * @return Node
	 * Time: O(log(n))
	 * Space: O(1)
	 */
    public Node inorderSuccessorinBSTII(Node x) {
        if (x == null) return null;
        if (x.right != null) {
            Node res = x.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
        else {
            Node res = x.parent;
            while (res != null && res.val < x.val) {
                res = res.parent;
            }
            return res;
        }
    }
    
    
    
class Node {
	int val;
	Node left;
	Node right;
	Node parent;
	public Node (int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
