import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 * When you get an instruction "R", your car does the following: if your speed is positive then 
 * speed = -1 , otherwise speed = 1.  (Your position stays the same.)
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 
 * 1->2->4->-1.
 * Now for some target position, say the length of the shortest sequence of instructions to get there.
 * Example 1:
 * Input: 
 * target = 3
 * Output: 2
 * Explanation: 
 * The shortest instruction sequence is "AA".
 * Your position goes from 0->1->3.
 * Example 2:
 * Input: 
 * target = 6
 * Output: 5
 * Explanation: 
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0->1->3->7->7->6.
 * Note:
 * 1 <= target <= 10000.
 * @author wendi
 *
 */
public class RaceCar {
	
	/**
	 * BFS is very straightforward with two important pruning
	 * 1. when current position is negative, there is no need to iterate it
	 * 2. when current position is bigger than 2 times of target, there is no need to iterate it
	 * @param int target
	 * @return int
	 * Time: O(n*log(n)) n = target
	 * Space: O(n*log(n))
	 */
	public int raceCar(int target) {
		if (target == 1) return 1;
		Queue<int[]> queue = new LinkedList<>();  // [position, speed]
		queue.offer(new int[] {0, 1});
		Set<String> visited = new HashSet<>();
		visited.add(0 + "_" + 1);
		int level = -1;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				if (curr[0] == target) return level;
				// case1: accelerate instruction
				int[] next = new int[] {curr[0] + curr[1], 2 * curr[1]};
				if (0 < next[0] && next[0] <= 2 * target && !visited.contains(next[0] + "_" + next[1])) {
					visited.add(next[0] + "_" + next[1]);
					queue.offer(next);
				}
				// case2: reverse instruction
				next = new int[] {curr[0], curr[1] > 0 ? -1 : 1};
				if (0 < next[0] && next[0] <= 2 * target && !visited.contains(next[0] + "_" + next[1])) {
					visited.add(next[0] + "_" + next[1]);
					queue.offer(next);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RaceCar result = new RaceCar();
		System.out.println(result.raceCar(6));
	}

}
