import java.util.Arrays;

/**
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the 
 * root) for which all other nodes are descendants of this node, plus every node has exactly one 
 * parent, except for the root node which has no parents.
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct 
 * values 1, 2, ..., N), with one additional directed edge added. The added edge has two different 
 * vertices chosen from 1 to N, and was not an edge that already existed.
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that 
 * represents a directed edge connecting nodes u and v, where u is a parent of child v.
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If 
 * there are multiple answers, return the answer that occurs last in the given 2D-array.
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 *   1
 *  / \
 * v   v
 * 2-->3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the 
 * input array.
 * @author wendi
 *
 */
public class RedundantConnectionII {
	
	
	/**
	 * UnionFindSet
	 * Case1: 有重复的父结点，没环，返回这个node即可；
	 * Case2: 没重复的父结点，有环，则纯的union find解法，找到环的最后一个node即可；
     * Case3: 有重复的父结点，有环，返回{u1, v} or {u2, v}其中那个造成环的结点；
	 * @param int[][] edges
	 * @return int[]
	 * Time: O(e)
	 * Space: O(v)
	 */
	public int[] redundantConnectionII(int[][] edges) {
        int[] candidate1 = null;
        int[] candidate2 = null;
        int[] parent = new int[edges.length + 1];
        for (int[] e: edges) {
            if (parent[e[1]] > 0) {
            	// Delete the later edge
                // 这里是算法关键，找到有两个父结点的结点的两条边，先试探性的删除其中一条，再在后面判断时候还有环存在，
                // 来断定删除是否正确，从而返回答案
                candidate1 = new int[] {e[0], e[1]};
                candidate2 = new int[] {parent[e[1]], e[1]};
                e[0] = e[1] = -1;
            }
            else parent[e[1]] = e[0];
        }
        
        UnionFindSet ufs = new UnionFindSet(edges.length + 1);
        for (int[] e: edges) {
            if (e[0] < 0 && e[1] < 0) continue; // skip tentatively deleted edge
            if (!ufs.union(e[0], e[1])) {
                if (candidate1 != null) return candidate2;   // case3: has duplicate, has cycle
                return e;                                    // case2: no duplicate, has cycle
            } 
        }
        if (candidate1 != null) return candidate1;           // case1: has duplicate, no cycle
        return new int[] {-1, -1};
    }
    
    
    class UnionFindSet {
        int[] parents;
        
        public UnionFindSet(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) parents[i] = i;
        }
        
        public int find(int x) {
            while (parents[x] != x) {
                x = parents[x];
            }
            return x;
        }
        
        public boolean union(int a, int b) {
            int pA = find(a);
            int pB = find(b);
            if (pA != pB) {
                parents[pB] = pA;
                return true;
            }
            return false;
        }
    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedundantConnectionII result = new RedundantConnectionII();
		System.out.println(Arrays.toString(result.redundantConnectionII(
				new int[][] {{1, 2}, {2, 3}, {4, 3}, {1, 4}}))); // case1: has duplicate, no cycle
		System.out.println(Arrays.toString(result.redundantConnectionII(
				new int[][] {{1, 2}, {2, 3}, {3, 1}})));         // case2: no duplicate, has cycle
		System.out.println(Arrays.toString(result.redundantConnectionII(
				new int[][] {{1, 2}, {2, 3}, {3, 1}, {4, 1}}))); // case3: has duplicate, has cycle
	}	

}
