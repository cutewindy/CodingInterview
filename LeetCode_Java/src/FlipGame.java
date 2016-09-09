import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only 
 * these two characters: + and -, you and your friend take turns to flip two consecutive "++" into 
 * "--". The game ends when a person can no longer make a move and therefore the other person will 
 * be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states:
		[
		  "--++",
		  "+--+",
		  "++--"
		]
 * If there is no valid move, return an empty list [].
 * 
 * Tags: String
 * @author wendi
 *
 */
public class FlipGame {
	
	/**
	 * Brute Force
	 * @param String s
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<String> flipGame(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return result;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				result.add(s.substring(0, i) + "--" + s.substring(i + 2));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlipGame result = new FlipGame();
		System.out.println(result.flipGame("++++"));
	}

}
