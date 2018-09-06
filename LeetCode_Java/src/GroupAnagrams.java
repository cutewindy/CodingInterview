import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * Approach2: 
	 * Assign a prime number for a to z, and then multiply all prime numbers together to form a hash key.
	 * @param String strs
	 * @return List<List<String>>
	 * Time: O(n * k), k is the average length of string in strs
	 * Space: O(n) 
	 */
	public List<List<String>> groupAnagramsI(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0) return res;
		int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
		Map<Integer, List<String>> map = new HashMap<>();
		for (String str: strs) {
			int key = 1;
			for (char c: str.toCharArray()) {
				key *= primes[c - 'a'];
			}
			if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(str);
		}
		for (List<String> list: map.values()) {
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
	
	
	/**
	 * Approach1: 
	 * Using HashMap<String, List<String>>, key is the sorted string, value is the original string
	 * @param String strs
	 * @return List<List<String>>
	 * Time: O(n*klog(k)+nlog(n)), k is the average length of string in strs
	 * Space: O(n) 
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return result;
		}
		Map<String, List<String>> hash = new HashMap<>();
		for (String s: strs) {
			String sortedStr = sorted(s);
			if (!hash.containsKey(sortedStr)) {
				hash.put(sortedStr, new ArrayList<String>());
			}
			hash.get(sortedStr).add(s);
		}
		for (List<String> list: hash.values()) {
			Collections.sort(list);  // can ignore
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
		System.out.println(res.groupAnagramsI(strs));
	}

}
