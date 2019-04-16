/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a 
 * move consisting of:
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * Example 1:
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 * Note:
 * 1. 1 <= N <= 1000
 * @author wendi
 *
 */
public class DivisorGame {
	
	
	/**
	 * Math
	 * Mathematical Induction Prove （Bottom-up)
	N = 1, lose directly
	N = 2, will win choosing x = 1.
	N = 3, must lose choosing x = 1.
	N = 4, will win choosing x = 1.
	....
	
	For N <= n, we have find that:
	If N is even, can win.
	If N is odd, will lose.
	
	For the case N = n + 1
	If N is even, we can win choosing x = 1,
	give the opponent an odd number N - 1 = n,
	force him to lose,
	because we have found that all odd N <= n will lose.
	
	If N is odd, there is no even x that N % x == 0.
	As a result, we give the opponent a even number N - x,
	and the opponent can win,
	because we have found that all even N <= n can win.
	
	Now we prove that, for all N <= n,
	If N is even, can win.
	If N is odd, will lose.
	 * @param int N
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivisorGame result = new DivisorGame();
		System.out.println(result.divisorGame(2));
		System.out.println(result.divisorGame(3));
	}

}
