import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so 
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link 
 * to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in 
 * which each node has no more than N children. There is no restriction on how your serialization/
 * deserialization algorithm should work. You just need to ensure that an N-ary tree can be 
 * serialized to a string and this string can be deserialized to the original tree structure.
 * For example, you may serialize the following 3-ary tree
 * 					 1
 *              /    |     \
 *             3     2      4
 *           /   \
 *          5     6    
 * 
 * as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and 
 * come up with different approaches yourself.
 * Note:
 * N is in the range of [1, 1000]
 * Do not use class member/global/static variables to store states. Your serialize and deserialize 
 * algorithms should be stateless.
 * @author wendi
 *
 */
public class SerializeandDeserializeN_aryTree {
	
	class Node{
		int val;
		List<Node> children;
		public Node() {}
		public Node(int val, List<Node> children) {
			this.val = val;
			this.children = children;
		}
	}
	
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" # ");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node child: curr.children) {
                sb.append(child.val).append(" ");
                queue.offer(child);
            }
            sb.append("# ");
        }
        return sb.toString().trim();    //  "1 # 3 2 4 # 5 6 #"
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        int index = 0;
        String[] datas = data.split(" ");
        Node root = new Node(Integer.parseInt(datas[index++]), new ArrayList<Node>());
        index++;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            while (!datas[index].equals("#")) {
                Node child = new Node(Integer.parseInt(datas[index++]), new ArrayList<Node>());
                curr.children.add(child);
                queue.offer(child);
            }
            index++;
        }
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
