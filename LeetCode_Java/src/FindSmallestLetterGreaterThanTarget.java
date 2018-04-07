/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target 
 * letter target, find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], 
 * the answer is 'a'.
 * Examples:
	Input:
	letters = ["c", "f", "j"]
	target = "a"
	Output: "c"
	Input:
	letters = ["c", "f", "j"]
	target = "c"
	Output: "f"
	Input:
	letters = ["c", "f", "j"]
	target = "d"
	Output: "f"
	Input:
	letters = ["c", "f", "j"]
	target = "g"
	Output: "j"
	Input:
	letters = ["c", "f", "j"]
	target = "j"
	Output: "c"
	Input:
	letters = ["c", "f", "j"]
	target = "k"
	Output: "c"
 * Note:
 * 1. letters has a length in range [2, 10000].
 * 2. letters consists of lowercase letters, and contains at least 2 unique letters.
 * 3. target is a lowercase letter.
 * @author wendi
 *
 */
public class FindSmallestLetterGreaterThanTarget {
	
	/**
	 * Method2: binary search
	 * @param char[] letters, char target
	 * @return char
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public char findSmallestLetterGreaterThanTargetI(char[] letters, char target) {
		int start = 0;
		int end = letters.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (letters[mid] <= target) start = mid;
			else end = mid;
		}
		if (letters[start] > target) return letters[start];
		if (letters[end] > target) return letters[end];
		return letters[0];
	}
	
	/**
	 * Method1: linear scan
	 * @param char[] letters, char target
	 * @return char
	 * Time: O(n)
	 * Space: O(1)
	 */
	public char findSmallestLetterGreaterThanTarget(char[] letters, char target) {
		for (char c: letters) {
			if (c > target) return c;
		}
		return letters[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSmallestLetterGreaterThanTarget result = new FindSmallestLetterGreaterThanTarget();
		System.out.println(result.findSmallestLetterGreaterThanTarget(new char[] {'c','f','j'}, 'd'));
		System.out.println(result.findSmallestLetterGreaterThanTargetI(new char[] {'c','f','j'}, 'd'));
	}

}
