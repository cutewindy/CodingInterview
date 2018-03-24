import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> 
 * "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to 
 * the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * A solution is:
		[
		  ["abc","bcd","xyz"],
		  ["az","ba"],
		  ["acef"],
		  ["a","z"]
		]
 * @author wendi
 *
 */
public class GroupShiftedStrings {
	
	/**
	 * Hashmap: set key as (s[i]-s[i-1]+26)%26+","
	 * The basic idea is to set a key for each group: the sum of the difference between the adjacent 
	 * chars in one string. Then we can easily group the strings belonging to the same shifting 
	 * sequence with the same key.
	 * @param String[] strings
	 * @return List<List<String>>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<String>> groupShiftedStrings(String[] strings) {
		List<List<String>> result = new ArrayList<>();
		if (strings == null || strings.length == 0) return result;
		Map<String, List<String>> map = new HashMap<>();
		for (String s: strings) {
			char[] S = s.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < S.length; i++) {
				sb.append((S[i] - S[i - 1] + 26) % 26).append(",");
			}
			String key = sb.toString();
			if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		for (List<String> list: map.values()) {
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupShiftedStrings result = new GroupShiftedStrings();		
		System.out.println(result.groupShiftedStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
	}

}
