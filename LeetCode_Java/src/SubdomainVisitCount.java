import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, 
 * we have "com", at the next level, we have "leetcode.com", and at the lowest level, 
 * "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit 
 * the parent domains "leetcode.com" and "com" implicitly.
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain 
 * received), followed by a space, followed by the address. An example of a count-paired domain might 
 * be "9001 discuss.leetcode.com".
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired 
 * domains, (in the same format as the input, and in any order), that explicitly counts the number 
 * of visits to each subdomain.
 * Example 1:
 * Input: 
 * ["9001 discuss.leetcode.com"]
 * Output: 
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation: 
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain 
 * "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 * Example 2:
 * Input: 
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output: 
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com",
 * "951 com"]
 * Explanation: 
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and 
 * "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, 
 * "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * Notes:
 * 1. The length of cpdomains will not exceed 100. 
 * 2. The length of each domain name will not exceed 100.
 * 3. Each address will have either 1 or 2 "." characters.
 * 4. The input count in any count-paired domain will not exceed 10000.
 * 5. The answer output can be returned in any order.
 * @author wendi
 *
 */
public class SubdomainVisitCount {

	/**
	 * HashMap
	 * @param String[] cpdomains
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> subdomainVisitCount(String[] cpdomains) {
		List<String> result = new ArrayList<>();
		if (cpdomains == null || cpdomains.length == 0) return result;
		Map<String, Integer> counter = new HashMap<>();
		for (String str: cpdomains) {
			String[] pair = str.split("\\s+");
			int count = Integer.valueOf(pair[0]);
			String domain = pair[1];
			for (int i = -1; i < domain.length(); i++) {
				if (i == -1 || domain.charAt(i) == '.') {
					String key = domain.substring(i + 1, domain.length());
					if (!counter.containsKey(key)) counter.put(key, 0);
					counter.put(key, counter.get(key) + count);
				}
			}
		}
		for (Map.Entry<String, Integer> e: counter.entrySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(e.getValue()).append(" ").append(e.getKey());
			result.add(sb.toString());
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubdomainVisitCount result = new SubdomainVisitCount();
		System.out.println(result.subdomainVisitCount(new String[] 
				{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
	}

}
