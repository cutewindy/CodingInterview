import java.util.Arrays;
import java.util.List;

/**
 * Given a sequence of words, check whether it forms a valid word square.
 * A sequence of words forms a valid word square if the kth row and column read the exact same 
 * string, where 0 ≤ k < max(numRows, numColumns).
 * Note:
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
		Input:
		[
		  "abcd",
		  "bnrt",
		  "crmy",
		  "dtye"
		]
		Output:
		true
		Explanation:
		The first row and first column both read "abcd".
		The second row and second column both read "bnrt".
		The third row and third column both read "crmy".
		The fourth row and fourth column both read "dtye".
		Therefore, it is a valid word square.
 * Example 2:
		Input:
		[
		  "abcd",
		  "bnrt",
		  "crm",
		  "dt"
		]
		Output:
		true
		Explanation:
		The first row and first column both read "abcd".
		The second row and second column both read "bnrt".
		The third row and third column both read "crm".
		The fourth row and fourth column both read "dt".
		Therefore, it is a valid word square.
 * Example 3:
		Input:
		[
		  "ball",
		  "area",
		  "read",
		  "lady"
		]
		Output:
		false
		Explanation:
		The third row reads "read" while the third column reads "lead".
		Therefore, it is NOT a valid word square.
 * @author wendi
 *
 */
public class ValidWordSquare {
	
	/**
	 * Just compare char one by one
	 * @param List<String> words
	 * @return boolea
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public boolean validWordSquare(List<String> words) {
		if (words == null || words.size() == 0) {
			return true;
		}
		int m = words.size();
		for (int i = 0; i < m; i++) {
			int n = words.get(i).length();
			for (int j = 0; j < n; j++) {   // j start from 0 in order to check the case out of range
				if (j >= m || i >= words.get(j).length() 
						|| words.get(i).charAt(j) != words.get(j).charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidWordSquare result = new ValidWordSquare();
		System.out.println(result.validWordSquare(Arrays.asList("abcd", "bnrt", "crm", "dt")));
		System.out.println(result.validWordSquare(Arrays.asList("ball", "asee", "let", "lep")));
	}

}
