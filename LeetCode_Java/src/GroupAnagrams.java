import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
  * [
    ["ate", "eat","tea"],
    ["nat","tan"],
    ["bat"]
 *  ]
 *  
 * Tag: HashTable, String
 * @author wendi
 * 
 */
public class GroupAnagrams {
	
	/**
	 * Using HashMap<String, List<String>>, key is the sorted string, value is the original string
	 * @param strs
	 * Time: O(n*klog(k)+nlog(n)), k is the average length of string in strs
	 * Space: O(n) 
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList();
		if (strs == null || strs.length == 0) {
			return result;
		}
		Map<String, List<String>> hash = new HashMap();
		for (String s: strs) {
			String sortedStr = sorted(s);
			if (hash.containsKey(sortedStr)) {
				hash.get(sortedStr).add(s);
			}
			else {
				List<String> list = new ArrayList();
				list.add(s);
				hash.put(sortedStr, list);
			}
		}
		for (List<String> list: hash.values()) {
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
	
	private String sorted(String s) {
		char[] array = s.toCharArray();
		Arrays.sort(array);
		return String.valueOf(array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams res = new GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(res.groupAnagrams(strs));
		
	}

}
