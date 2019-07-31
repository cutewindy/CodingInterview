import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: 
 * "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within 
 * the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once 
 * in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * Tags: HashTable, Bit Manipulation
 * @author wendi
 *
 */
public class RepeatedDNASequences {

	/**
	 * Method3: Rolling hash
	 * BitManipulate + HashMap: like method1 except the key in hash is int instead of substring
	 * 20 bits < 32 bits, not out of range of Integer.
	 * @param String s
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> repeatedDNASequencesII(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10) return res;
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        Integer key = 0;
        int mod = 1 << 20;
        for (int i = 0; i < 9; i++) {
            key = (key << 2) + map.get(s.charAt(i));
        }
        for (int i = 9; i < s.length(); i++) {
            key = (key << 2) % mod + map.get(s.charAt(i));
            counts.put(key, counts.getOrDefault(key, 0) + 1);
            if (counts.get(key) == 2) res.add(s.substring(i - 9, i + 1));
        }
        return res;
	}
	
	
	/**
	 * Method2: HashSet: Use one set to record the appeared substring, another set to remove duplicate.
	 * @param String s
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> repeatedDNASequencesI(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < 10) {
			return result;
		}
		Set<String> set = new HashSet<>();
		Set<String> res = new HashSet<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String subs = s.substring(i, i + 10);
			if (set.contains(subs)) {
				res.add(subs);
			}
			else {
				set.add(subs);
			}
		}
		Iterator<String> it = res.iterator();
		while (it.hasNext()) {
			result.add(it.next());
		}
		return result;
	}
	
	/**
	 * Method1: HashMap, key is the substring with length 10, value is the frequency of it. 
	 * If the frequency = 2, means it occur more than once. 
	 * If the frequency > 2, means it's duplicate result. 
	 * @param String s
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> repeatedDNASequences(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < 10) {
			return result;
		}
		Map<String, Integer> hash = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String subs = s.substring(i, i + 10);
			if (!hash.containsKey(subs)) {
				hash.put(subs, 1);
			}
			else {
				hash.put(subs, hash.get(subs) + 1);
			}
			if (hash.get(subs) == 2) {
				result.add(subs);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedDNASequences result = new RepeatedDNASequences();
		System.out.println(result.repeatedDNASequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(result.repeatedDNASequencesI("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(result.repeatedDNASequencesII("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}
