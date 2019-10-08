import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", 
 * "T".
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE 
 * mutation is defined as ONE single character changed in the gene string.
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be 
 * in the bank to make it a valid gene string.
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of 
 * mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * Note:
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * Example 1:
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * return: 1
 * Example 2:
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * return: 2
 * Example 3:
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * return: 3
 * @author wendi
 *
 */
public class MinimumGeneticMutation {
	
	
	/**
	 * BFS
	 * @param String start, String end, String[] bank
	 * @return int
	 * Time: O(I thought time complexity was O(N * N * M * K) where:
				N is length of start string
				M is number of letters in gene
				K is number of strings in bank)
	 * Space: O()
	 */
    public int minimumGeneticMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        if (bank == null || bank.length == 0) return -1;
        Set<String> genes = new HashSet<>();
        for (String g: bank) genes.add(g);
        if (!genes.contains(end)) return -1;
        char[] chars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                String u = queue.poll();
                for (int i = 0; i < u.length(); i++) {
                    for (char c: chars) {
                        String v = u.substring(0, i) + c + u.substring(i + 1);
                        if (v.equals(end)) return step;
                        if (!genes.contains(v) || visited.contains(v)) continue;
                        visited.add(v);
                        queue.offer(v);
                    }
                }
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
