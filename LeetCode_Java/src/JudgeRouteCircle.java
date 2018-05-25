/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this 
 * robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character. The 
 * valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or 
 * false representing whether the robot makes a circle.
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 * 
 * 
 * @author wendi
 *
 */
public class JudgeRouteCircle {
	
	/**
	 * 
	 * @param String moves
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean judgeRouteCircle(String moves) {
		if (moves == null || moves.length() == 0) return true;
		int raw = 0;
		int col = 0;
		for (char c: moves.toCharArray()) {
			if (c == 'R') raw += 1;
			else if (c == 'L') raw -= 1;
			else if (c == 'U') col += 1;
			else if (c == 'D') col -= 1;
			else return false;
		}
		return raw == 0 && col == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JudgeRouteCircle result = new JudgeRouteCircle();
		System.out.println(result.judgeRouteCircle("UD"));
		System.out.println(result.judgeRouteCircle("LL"));
	}

}
