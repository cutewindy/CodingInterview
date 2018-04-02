import java.util.Arrays;
import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction 
 * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one 
 * will explode. If both are the same size, both will explode. Two asteroids moving in the same 
 * direction will never meet.
 * Example 1:
 * Input: 
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation: 
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input: 
 * asteroids = [8, -8]
 * Output: []
 * Explanation: 
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input: 
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation: 
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input: 
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation: 
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 * 1. The length of asteroids will be at most 10000.
 * 2. Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 * @author wendi
 *
 */
public class AsteroidCollision {
	
	/**
	 * Stack: 
	 * Say we have our answer as a stack with rightmost asteroid top, and a new asteroid comes in. 
	 * If new is moving right (new > 0), or if top is moving left (top < 0), no collision occurs.
	 * Otherwise, if abs(top) < abs(new), then the new asteroid will blow up; 
	 * if abs(top) == abs(new) then both asteroids will blow up; and if abs(top) > abs(new), 
	 * then the top asteroid will blow up (and possibly more asteroids will, so we should continue 
	 * checking.)
	 * @param int[] asteroids
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length == 0) return asteroids;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < asteroids.length) {
			if (stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0) stack.push(asteroids[i]);
			else {                                          // make sure stack.peek()>0 && a<0
				if (stack.peek() == -asteroids[i]) {        // |top| = |new|
					stack.pop();								
				}
				else if (stack.peek() < -asteroids[i]) {    // |top| < |new|
					stack.pop();
					i--;
				}
			}
			i++;
		}
		int[] result = new int[stack.size()];
		for (int j = result.length - 1; j >= 0; j--) {
			result[j] = stack.pop();
		}
		return result;
	}
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AsteroidCollision result = new AsteroidCollision();
		System.out.println(Arrays.toString(result.asteroidCollision(new int[] {-1, -2, 5, 10, -5, -11})));
	}

}
