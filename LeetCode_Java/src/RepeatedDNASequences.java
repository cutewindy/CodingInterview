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
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < 10) {
			return result;
		}
		Map<Character, Integer> mapping = new HashMap<>();
		mapping.put('A', 0);
		mapping.put('C', 1);
		mapping.put('G', 2);
		mapping.put('T', 3);
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			int key = 0;
			for (int j = i; j < i + 10; j++) {
				key = (key << 2) + mapping.get(s.charAt(j)); // calculate the key of hash
				// or use
//				key <<= 2;
//				key |= mapping.get(s.charAt(j));
			}
			if (!hash.containsKey(key)) {
				hash.put(key, 1);
			}
			else {
				hash.put(key, hash.get(key) + 1);
			}
			if (hash.get(key) == 2) {
				result.add(s.substring(i, i + 10));
			}
		}
		return result;
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
