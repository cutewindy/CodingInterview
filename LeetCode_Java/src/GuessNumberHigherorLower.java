/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 *  0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 * 
 * Tags: Binary Search
 * @author wendi
 *
 */
public class GuessNumberHigherorLower {
	
	private int num;
	public GuessNumberHigherorLower(int n) {
		this.num = n;
	}
	
	public int guess(int n) {
		if (n < num) {
			return 1;
		}
		else if (n > num) {
			return -1;
		}
		return 0;
	}

	
	/**
	 * Binary Search
	 * @param int n
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int guessNumberHigherorLower(int n) {
		if (n <= 0) {
			return -1;
		}
		int start = 1;
		int end = n;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int res = guess(mid);
			if (res == 0) {
				return mid;
			}
			else if (res == 1) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return guess(start) == 0 ? start : end;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessNumberHigherorLower result = new GuessNumberHigherorLower(6);
		System.out.println(result.guessNumberHigherorLower(10));
	}

}
