/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are 
 * unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted 
 * lexicographically by the rules of this new language. Derive the order of letters in this language.
 * Example 1:
 * Given the following words in dictionary,
		[
		  "wrt",
		  "wrf",
		  "er",
		  "ett",
		  "rftt"
		]
 * The correct order is: "wertf".
 * Example 2:
 * Given the following words in dictionary,
		[
		  "z",
		  "x"
		]
 * The correct order is: "zx".
 * Example 3:
 * Given the following words in dictionary,
		[
		  "z",
		  "x",
		  "z"
		]
 * The order is invalid, so return "".
 * Note:
 * 1. You may assume all letters are in lowercase.
 * 2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * 3. If the order is invalid, return an empty string.
 * 4. There may be multiple valid order of letters, return any one of them is fine.
 * @author wendi
 *
 */
public class AlienDictionary {
	
	
	/**
	 * 
	 * @param String[] words
	 * @return String
	 * Time: O()
	 * Space: O()
	 */
	public String alienDictionary(String[] words) {
		if (words == null || words.length == 0) return "";
		
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienDictionary result = new AlienDictionary();
		System.out.println(result.alienDictionary(new String[] {"wrt", "wrf", "er", "ett", "rftt"}));
	}

}
