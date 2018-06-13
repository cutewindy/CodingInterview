/**
 * Find the minimum length word from a given dictionary words, which has all the letters from the 
 * string licensePlate. Such a word is said to complete the given string licensePlate
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first 
 * in the array.
 * The license plate might have the same letter occurring multiple times. For example, given a 
 * licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * 1. licensePlate will be a string with length in range [1, 7].
 * 2. licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * 3. words will have a length in the range [10, 1000].
 * 4. Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 * @author wendi
 *
 */
public class ShortestCompletingWord {
	
	
	/**
	 * HashMap
	 * @param String licensePlate, String[] words
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.replaceAll("[0-9\\s+]", "").toLowerCase();
        int[] charMap = new int[26];
        for (char c: licensePlate.toCharArray()) charMap[c - 'a']++;
        int min = Integer.MAX_VALUE;
        String res = "";
        for (String word: words) {
            if (word.length() < licensePlate.length()) continue;
            int[] counter = new int[26]; 
            int cont = 0;
            for (char c: word.toCharArray()) {
                if (counter[c - 'a']++ < charMap[c - 'a']) cont++;
                if (cont == licensePlate.length() && word.length() < min) {
                    res = word;
                    min = word.length();
                    break;
                }
            }
        }
        return res;		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestCompletingWord result = new ShortestCompletingWord();
		System.out.println(result.shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"}));
	}

}
