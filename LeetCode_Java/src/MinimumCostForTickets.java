import java.util.HashMap;
import java.util.Map;

/**
 * In a country popular for train travel, you have planned some train travelling one year in advance.  
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 
 * 1 to 365.
 * Train tickets are sold in 3 different ways:
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on 
 * day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 * Example 1:
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation: 
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation: 
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 * Note:
 * 1. 1 <= days.length <= 365
 * 2. 1 <= days[i] <= 365
 * 3. days is in strictly increasing order.
 * 4. costs.length == 3
 * 5. 1 <= costs[i] <= 1000
 * @author wendi
 *
 */
public class MinimumCostForTickets {
	
	/**
	 * Method2: dp
	 * dp[i]: min cost covered from day 1 to day i. 
	 * If no trip on day i, then dp[i] = dp[i - 1].
	 * Otherwise: 
	 * 1. if a 1-day pass on day i. In this case, dp[i] = dp[i - 1] + costs[0];
	 * 2. if a 7-day pass ending on day i, dp[i] = dp[i - 7] + costs[1];
	 * 3. if a 30-day pass ending on day i, dp[i] = dp[i - 30] + costs[2];
	 * @param int[] days, int[] costs
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int minimumCostForTicketsI(int[] days, int[] costs) {
		if (days == null || days.length == 0) return 0;
		int n = days[days.length - 1] + 1;
		Integer[] dp = new Integer[n];
		dp[0] = 0;
		for (int day: days) {
			dp[day] = -1;     // means on that day you will go travel  
		}
		for (int i = 1; i < n; i++) {
			if (dp[i] == null) {
				dp[i] = dp[i - 1];
				continue;
			}
			dp[i] = dp[i - 1] + costs[0];
			dp[i] = Math.min((i - 7 > 0 ? dp[i - 7] : 0) + costs[1], dp[i]);
			dp[i] = Math.min((i - 30 > 0 ? dp[i - 30] : 0) + costs[2], dp[i]);
		}
		return dp[n - 1];
	}
	
	
	/**
	 * Method1: dfs + memorization + binary search
	 * @param int[] days, int[] costs
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public int minimumCostForTickets(int[] days, int[] costs) {
		if (days == null || days.length == 0) return 0;
		return dfs(days, 0, costs, new HashMap<Integer, Integer>());
	}
	
	private int dfs(int[] days, int index, int[] costs, Map<Integer, Integer> minCost) {
		if (index == days.length) return 0;
		if (minCost.containsKey(index)) return minCost.get(index);
		
		// 1 day pass
		int cost1 = costs[0] + dfs(days, index + 1, costs, minCost);
		
		// 7 days pass
		int next7Index = binarySearch(days, index, 7);
		int cost7 = costs[1] + dfs(days, next7Index, costs, minCost);
		
		// 30 days pass
		int next30Index = binarySearch(days, index, 30);
		int cost30 = costs[2] + dfs(days, next30Index, costs, minCost);
		
		int currCost = Math.min(cost1, Math.min(cost7, cost30));
		minCost.put(index, currCost);
		
		return currCost;
	}
	
	private int binarySearch(int[] days, int index, int daysNum) {
		if (index == days.length - 1) return index + 1;
		int start = index + 1;
		int end = days.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (days[mid] - days[index] < daysNum) start = mid;
			else end = mid;
		}
        if (days[start] - days[index] >= daysNum) return start;
        if (days[end] - days[index] >= daysNum) return end;
        return end + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCostForTickets result = new MinimumCostForTickets();
		System.out.println(result.minimumCostForTickets(new int[] {1,4,6,7,8,20}, new int[] {2,7,15}));	
		System.out.println(result.minimumCostForTickets(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2,7,15}));
		System.out.println(result.minimumCostForTicketsI(new int[] {1,4,6,7,8,20}, new int[] {2,7,15}));	
		System.out.println(result.minimumCostForTicketsI(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2,7,15}));	
	}

}
