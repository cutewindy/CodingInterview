import java.util.Arrays;

/**
 * Three stones are on a number line at positions a, b, and c.
 * Each turn, let's say the stones are currently at positions x, y, z with x < y < z.  You pick up 
 * the stone at either position x or position z, and move that stone to an integer position k, with 
 * x < k < z and k != y.
 * The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
 * When the game ends, what is the minimum and maximum number of moves that you could have made?  
 * Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
 * Example 1:
 * Input: a = 1, b = 2, c = 5
 * Output: [1, 2]
 * Explanation: Move stone from 5 to 4 then to 3, or we can move it directly to 3.
 * Example 2:
 * Input: a = 4, b = 3, c = 2
 * Output: [0, 0]
 * Explanation: We cannot make any moves.
 * @author wendi
 *
 */
public class MovingStonesUntilConsecutive {
	
	
	/**
	 * Edge case 1: all three stones are next to each other (z - x == 2). Return {0, 0}.
	 * Edge case 2: two stones are next to each other, or there is only one space in between. Minimum moves is 1.
	 * Otherwise; minimum moves are 2, maximum = z - x - 2.
	 * @param int a, int b, int c
	 * @return int[] 
	 * Time: O(1)
	 * Space: O(1)
	 */
    public int[] movingStonesUntilConsecutive(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);
        if (array[2] - array[0] == 2) return new int[] {0, 0};
        int[] res = new int[2];
        int diff1 = array[1] - array[0];
        int diff2 = array[2] - array[1];
        res[0] = (diff1 <= 2 || diff2 <= 2) ? 1 : 2;
        res[1] += diff1 - 1 + diff2 - 1;
        return res;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingStonesUntilConsecutive result = new MovingStonesUntilConsecutive();
		System.out.println(Arrays.toString(result.movingStonesUntilConsecutive(3, 1, 5)));
	}

}
