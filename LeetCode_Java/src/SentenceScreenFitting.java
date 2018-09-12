/**
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many 
 * times the given sentence can be fitted on the screen.
 * Note:
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word is greater than 0 and won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 * Example 1:
 * Input:
 * rows = 2, cols = 8, sentence = ["hello", "world"]
 * Output: 
 * 1
 * Explanation:
 * hello---
 * world---
 * The character '-' signifies an empty space on the screen.
 * Example 2:
 * Input:
 * rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 * Output: 
 * 2
 * Explanation:
 * a-bcd- 
 * e-a---
 * bcd-e-
 * The character '-' signifies an empty space on the screen.
 * Example 3:
 * Input:
 * rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 * Output: 
 * 1
 * Explanation:
 * I-had
 * apple
 * pie-I
 * had--
 * The character '-' signifies an empty space on the screen.
 * @author wendi
 *
 */
public class SentenceScreenFitting {
	
	/**
	 * Approach2: 
	 * Say sentence=["abc", "de", "f], rows=4, and cols=6.
	 * The screen should look like
	 * "abc de"
	 * "f abc "
	 * "de f  "
	 * "abc de"
	 * Consider the following repeating sentence string, with positions of the start character of 
	 * each row on the screen.
	 * "abc de f abc de f abc de f ..."
	 *  ^      ^     ^    ^      ^
	 *  0      7     13   18     25
	 * Our goal is to find the start position of the row next to the last row on the screen, which 
	 * is 25 here. Since actually it's the length of everything earlier, we can get the answer by 
	 * dividing this number by the length of (non-repeated) sentence string. Note that the 
	 * non-repeated sentence string has a space at the end; it is "abc de f " in this example.
	 * Here is how we find that position. In each iteration, we need to adjust start based on spaces 
	 * either added or removed.
	 * "abc de f abc de f abc de f ..." // start=0
	 *  012345                          // start=start+cols+adjustment=0+6+1=7 (1 space removed in screen string)
	 *         012345                   // start=7+6+0=13
	 *               012345             // start=13+6-1=18 (1 space added)
	 *                    012345        // start=18+6+1=25 (1 space added)
	 *                           012345
	 * @param String[] sentence, int rows, int cols
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int sentenceScreenFittingI(String[] sentence, int rows, int cols) {
//        if (sentence == null || sentence.length == 0) return 0;
//        String s = String.join(" ", sentence) + " ";
//        int n = s.length();
//        int index = 0;
//        for (int i = 0; i < rows; i++) {
//        	index += cols;
//        	if (s.charAt(index % n) == ' ') index++;
//        	else {
//        		while (index >= 0 && s.charAt(index % n) != ' ') {
//        			index--;
//        		}
//        	}
//        }
//        return index / n;
		return 0;
	}
	
	/**
	 * Approach1: brute force, two pointer / sliding window(TLE)
	 * @param String[] sentence, int rows, int cols
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int sentenceScreenFitting(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0) return 0;
        int n = sentence.length;
        int length = 0;
        int level = 0;
        int start = 0, end = 0;
        while (level != rows) {
            while (length + sentence[end % n].length() + end - start <= cols) {
                length += sentence[end % n].length();
                end++;
            }
            level++;
            length = 0;
            start = end;
        }
        return end / n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SentenceScreenFitting result = new SentenceScreenFitting();
		System.out.println(result.sentenceScreenFitting(new String[] {"I", "had", "apple", "pie"}, 4, 5));
		System.out.println(result.sentenceScreenFittingI(new String[] {"I", "had", "apple", "pie"}, 4, 5));
	}

}
