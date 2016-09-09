/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these 
 * two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". 
 * The game ends when a person can no longer make a move and therefore the other person will be the 
 * winner.
 * Write a function to determine if the starting player can guarantee a win.
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping 
 * the middle "++" to become "+--+".
 * Follow up:
 * Derive your algorithm's runtime complexity.
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class FlipGameII {
	
	/**
	 * The idea is try to replace every "++" in the current string s to "--" and see if the opponent 
	 * can win or not, if the opponent cannot win, great, we win!
	 * Can Use a HashMap to avoid duplicate computation.(Didn't do it here)
	 * @param String s
	 * @return boolean
	 * Time: O(n!!)
	 * For the time complexity, here is what I thought, let's say the length of the input string s 
	 * is n, there are at most n - 1 ways to replace "++" to "--" (imagine s is all "+++..."), once 
	 * we replace one "++", there are at most (n - 2) - 1 ways to do the replacement, it's a little 
	 * bit like solving the N-Queens problem, the time complexity is (n - 1) x (n - 3) x (n - 5) x ..., 
	 * so it's O(n!!), double factorial.
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public boolean flipGameII(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' && 
					!flipGameII(s.substring(0, i) + "--" + s.substring(i + 2))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlipGameII result = new FlipGameII();
		System.out.println(result.flipGameII("++++"));
	}

}
