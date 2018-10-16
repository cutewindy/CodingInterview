import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element 
 * accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if 
 * there is some email that is common to both accounts. Note that even if two accounts have the same 
 * name, they may belong to different people as people could have the same name. A person can have 
 * any number of accounts initially, but all of their accounts definitely have the same name.
 * After merging the accounts, return the accounts in the following format: the first element of 
 * each account is the name, and the rest of the elements are emails in sorted order. The accounts 
 * themselves can be returned in any order.
 * Example 1:
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], 
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
 * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation: 
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other 
 * accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], 
 * ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * @author wendi
 *
 */
public class AccountsMerge {
	
	
	/**
	 * Approach2: UnionFindSet
	 * 1. The key task here is to connect those emails, and this is a perfect use case for union find.
	 * 2. to group these emails, each group need to have a representative, or parent.
	 * 3. At the beginning, set each email as its own representative.
	 * 4. Emails in each account naturally belong to a same group, and should be joined by assigning 
	 *    to the same parent (let's use the parent of first email in that list);
	 * a b c // now b, c have parent a
	 * d e f // now e, f have parent d
	 * g a d // now abc, def all merged to group g
	 * 
	 * @param List<List<String>> accounts
	 * @return List<List<String>>
	 * Time: O(nlog(n)) n=a1+a2+a3..+ai, where ai = accounts.get(i)
	 * Space: O(n)
	 */
	public List<List<String>> accountsMergeI(List<List<String>> accounts) {
		Map<String, String> emlToName = new HashMap<>();
		Map<String, Integer> emlToId = new HashMap<>();
		int id = 0;
		for (List<String> a: accounts) {
			String name = a.get(0);
			for (int i = 1; i < a.size(); i++) {
				String eml = a.get(i);
				if (emlToName.containsKey(eml)) continue;
				emlToName.put(eml, name);
				emlToId.put(eml, id++);
			}
		}
		
		UnionFindSet ufs = new UnionFindSet(id);
		for (List<String> a: accounts) {
			int firstId = emlToId.get(a.get(1));
			for (int i = 2; i < a.size(); i++) {
				int currId = emlToId.get(a.get(i));
				ufs.union(firstId, currId);
			}
		}
		
		Map<Integer, Set<String>> map = new HashMap<>();
		for (String eml: emlToId.keySet()) {
			int emlId = emlToId.get(eml);
			int rootEmlId = ufs.find(emlId);
			if (!map.containsKey(rootEmlId)) map.put(rootEmlId, new HashSet<String>());
			map.get(rootEmlId).add(eml);
		}
		
		List<List<String>> res = new ArrayList<>();
		for (Integer rootEmlId: map.keySet()) {
			Set<String> emlsSet = map.get(rootEmlId);
			List<String> emlsList = new ArrayList<>(emlsSet);
			Collections.sort(emlsList);
			String name = emlToName.get(emlsList.get(0));
			emlsList.add(0, name);
			res.add(emlsList);
		}
		
		return res;
	}
	
	
	class UnionFindSet {
		int[] parents;
		public UnionFindSet(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}
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
				parents[pA] = pB;
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Approach1: build graph + dfs search
	 * 
	 * Basicly, this is a graph problem. Notice that each account[i] tells us some edges. What we 
	 * have to do is as follows:
	 * 1. Use these edges to build some components. Common email addresses are like the intersections 
	 *    that connect each single component for each account.
	 * 2. Because each component represents a merged account, do DFS search for each components and 
	 *    add into a list. Before add the name into this list, sort the emails. Then add name string 
	 *    into it.
	 *    
	 * Examples: Assume we have two accounts, we connect them like this in order to use DFS.
	 * {Name, 1, 2, 3} => [1: (2)], [2: (1, 3)], [3: (2)]
	 * {Name, 2, 4, 5, 6} => [2: (1, 3, 4)], [4: (2, 5)], [5: (4, 6)], [6: (5)]
	 * finally:
	 * [1: (2)], [2: (1, 3, 4)], [3: (2)], [4: (2, 5)], [5: (4, 6)], [6: (5)]
	 * 
	 * @param List<List<String>> accounts
	 * @return List<List<String>>
	 * Time: O(nlog(n)) n=a1+a2+a3..+ai, where ai = accounts.get(i)
	 * Space: O(n)
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> res = new ArrayList<>();
		if (accounts == null || accounts.size() == 0) return res;
		
		Map<String, String> names = new HashMap<>();      // [key, val]: [email, name]
		Map<String, Set<String>> graph = new HashMap<>(); // [key, val]: [email, [neighbor's email]]
		buildGraph(accounts, names, graph);
		
		Set<String> visited = new HashSet<>();
		for (String email: names.keySet()) {
			if (visited.contains(email)) continue;
			visited.add(email);
			List<String> emails = new ArrayList<>(Arrays.asList(email));
			dfs(graph, email, visited, emails);
			Collections.sort(emails);
			emails.add(0, names.get(email));
			res.add(emails);
		}
		
		return res;
	}
	
	// build graph that connect neighbors
	private void buildGraph(List<List<String>> accounts, Map<String, String> names, Map<String, Set<String>> graph) {
		for (List<String> account: accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String email = account.get(i);
				names.put(email, name);
				if (!graph.containsKey(email)) graph.put(email, new HashSet<String>());
				if (i == 1) continue;
				graph.get(email).add(account.get(i - 1));
				graph.get(account.get(i - 1)).add(email);
			}
		}
	}
	
	// dfs to walk graph finding neighbors, than add to the same group
	private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> emails) {
		for (String next: graph.get(email)) {
			if (visited.contains(next)) continue;
			emails.add(next);
			visited.add(next);
			dfs(graph, next, visited, emails);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountsMerge result = new AccountsMerge();
		List<List<String>> list = new ArrayList<>();
		list.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		list.add(Arrays.asList("John", "johnnybravo@mail.com"));
		list.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
		list.add(Arrays.asList("Mary", "mary@mail.com"));
		System.out.println(result.accountsMerge(list));
		System.out.println(result.accountsMergeI(list));
	}

}
