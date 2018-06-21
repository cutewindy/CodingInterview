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
	 * UnionFindSet
	 * @param List<List<String>> accounts
	 * @return List<List<String>>
	 * Time: O(nlog(n)) n=a1+a2+a3..+ai, where ai = accounts.get(i)
	 * Space: O(n)
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
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
			Set<String> emls = map.get(rootEmlId);
			List<String> sortedEmls = new ArrayList<>(emls);
			Collections.sort(sortedEmls);
			String name = emlToName.get(sortedEmls.get(0));
			sortedEmls.add(0, name);
			res.add(sortedEmls);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountsMerge result = new AccountsMerge();
		List<List<String>> list = new ArrayList<>();
		list.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		list.add(Arrays.asList("John", "johnnybravo@mail.com"));
		list.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
		list.add(Arrays.asList("Mary", "mary@mail.com"));
		System.out.println(result.accountsMerge(list));
	}

}
