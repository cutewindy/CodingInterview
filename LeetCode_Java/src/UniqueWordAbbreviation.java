import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some 
 * examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 *      1
 * b) d|o|g                   --> d1g
 *               1    1  1
 *      1---5----0----5--8 
 * c) i|nternationalizatio|n  --> i18n
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the 
 * dictionary. A word's abbreviation is unique if no other word from the dictionary has the same 
 * abbreviation.
 * Example: 
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * 
 * Tags: HashTable, Design
 * @author wendi
 *
 */
public class UniqueWordAbbreviation {

	/**
	 * Method2: HashTable<abbr, word> like reverse index in web search
	 * If there is more than one string belong to the same key,
     * then the key will be invalid, we set the value to ""
	 */
	Map<String, String> hash = new HashMap<>();
	public UniqueWordAbbreviation(String[] dictionary)  {		
		for (String word: dictionary) {
			String abbr = getAbbr(word);
//			if (hash.containsKey(abbr) && hash.get(abbr) != word) {
			if (hash.containsKey(abbr) && !hash.get(abbr).equals(word)) { // be care about equals, cannot use !=
				hash.put(abbr, "");
			}
			if (!hash.containsKey(abbr)) {
				hash.put(abbr, word);
			}
		}
		for (String str: hash.keySet()) {
			System.out.println(str + ": " + hash.get(str));
		}
 	}
 	
	public boolean isUnique(String word) {
		String abbr = getAbbr(word);
		if (hash.containsKey(abbr) &&!hash.get(abbr).equals(word)) {  // be care about equals
			return false;
		}
		return true;
	}
	
	public String getAbbr(String word) {
		String abbr = new String();
		if (word.length() <= 2) {
			abbr = word;
		}
		else {
			abbr = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
		}
		return abbr;
	}
	
	
	
	/**
	 * Method1: HashTable<abbr, freq> + Set<word>
	 */
//	Map<String, Integer> hash = new HashMap<>();
//	Set<String> set = new HashSet<>();
//	public UniqueWordAbbreviation(String[] dictionary)  {		
//		for (String word: dictionary) {
//			String abbr = getAbbr(word);
//			if (hash.containsKey(abbr) && !set.contains(word)) {
//				hash.put(abbr, hash.get(abbr) + 1);
//			}
//			if (!hash.containsKey(abbr)) {
//				hash.put(abbr, 1);
//			}
//			set.add(word);
//		}
//		for (String str: hash.keySet()) {
//			System.out.println(str + ": " + hash.get(str));
//		}
// 	}
// 	
//	public boolean isUnique(String word) {
//		String abbr = getAbbr(word);
//		if (hash.containsKey(abbr) && hash.get(abbr) > 1 || hash.containsKey(abbr) && !set.contains(word)) {
//			return false;
//		}
//		return true;
//	}
//	
//	public String getAbbr(String word) {
//		String abbr = new String();
//		if (word.length() <= 2) {
//			abbr = word;
//		}
//		else {
//			abbr = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
//		}
//		return abbr;
//	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueWordAbbreviation result = new UniqueWordAbbreviation(new String[] {"deer", "door", "cake", "card", "cake"});
		System.out.println(result.isUnique("dear"));
		System.out.println(result.isUnique("cart"));
		System.out.println(result.isUnique("cane"));
//		System.out.println(result.isUnique("make"));
		System.out.println(result.isUnique("cake"));
		
//		String s1 = new String("a");
//		String s2 = new String("a");
//		UniqueWordAbbreviation result = new UniqueWordAbbreviation(new String[] {s1, s2});
//		System.out.println(result.isUnique("a"));

	}

}
