import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: 
 * node_1, node_2, node_3, ... etc.
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such 
 * that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not 
 * exist, the next larger value is 0.
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the 
 * serialization of a linked list with a head node value of 2, second node value of 1, and third 
 * node value of 5.
 * Example 1:
 * Input: [2,1,5]
 * Output: [5,5,0]
 * Example 2:
 * Input: [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 * Example 3:
 * Input: [1,7,5,1,9,2,5,1]
 * Output: [7,9,9,9,0,5,0,0]
 * Note:
 * 1.1 <= node.val <= 10^9 for each node in the linked list.
 * 2.The given list has length in the range [0, 10000].
 * @author wendi
 *
 */
public class NextGreaterNodeInLinkedList {
	
	
	/**
	 * Stack
	 * Transform the linked list to an arraylist,
	 * then it's a normal "next larger element" problem.
	 * @param ListNode head
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.isEmpty() && nums.get(stack.peek()) < nums.get(i)) {
                res[stack.pop()] = nums.get(i);
            }
            stack.push(i);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextGreaterNodeInLinkedList result = new NextGreaterNodeInLinkedList();
		ListNode head = ListNode.generateLinkedList(new int[] {1,7,5,1,9,2,5,1});
		head.printLinkedList(head);
		System.out.println(Arrays.toString(result.nextLargerNodes(head)));
	}

}
