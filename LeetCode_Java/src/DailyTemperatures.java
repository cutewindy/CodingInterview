import java.util.Arrays;
import java.util.Stack;

/**
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how 
 * many days you would have to wait until a warmer temperature. If there is no future day for which 
 * this is possible, put 0 instead.
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should 
 * be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an 
 * integer in the range [30, 100].
 * @author wendi
 *
 */
public class DailyTemperatures {
	
	
	/**
	 * Method2: Stack
	 * @param int[] temperatures
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] dailyTemperaturesI(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
	}
	
	

	
	/**
	 * Method1: Array
	 * Because temperatures can only be in [30, 100], if the temperature right now is say, T[i] = 50, 
	 * we only need to check for the next occurrence of 51, 52, ..., 100 and take the one that 
	 * occurs soonest.
	 * @param int[] temperatures
	 * @return int[]
	 * Time: O(nw) w = 71
	 * Space: O(n+w)
	 */
	public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int[] tempPos = new int[101];
        Arrays.fill(tempPos, Integer.MAX_VALUE);
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int early = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t < 101; t++) {
                early = Math.min(tempPos[t], early);
            }
            if (early != Integer.MAX_VALUE) res[i] = early - i;
            tempPos[temperatures[i]] = i;
        }
        return res;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyTemperatures result = new DailyTemperatures();
		System.out.println(Arrays.toString(result.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
		System.out.println(Arrays.toString(result.dailyTemperaturesI(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
	}

}
