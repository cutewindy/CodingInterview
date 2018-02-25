import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one 
 * row's of American keyboard like the image below.
 * American keyboard
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * 
 * @author wendi
 *
 */
public class KeyboardRow {
	
	/**
	 * 
	 * @param String[] words
	 * @return String[]
	 * Time: O(mn)
	 * Space: O(26)
	 */
	public String[] keyboardRow(String[] words) {
		String[] str = new String[]{"qwertyuiop", "asdfghjkl","zxcvbnm"};
		Map<Character, Integer> map = new HashMap<>();
		int index = 0;
		for (String s: str) {
			for (char c: s.toCharArray()) {
				map.put(c, index);
			}
			index++;
		}
		List<String> result = new ArrayList<>();
		for (String word: words) {
			int num = map.get(word.toLowerCase().charAt(0));
			boolean is = true;
			for (char c: word.toLowerCase().toCharArray()) {
				if (map.get(c) != num) {
					is = false;
					break;
				}
			}
			if (is) {
				result.add(word);
			}
		}
		return result.toArray(new String[0]);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyboardRow result = new KeyboardRow();
		System.out.println(Arrays.toString(result.keyboardRow(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
	}

}
