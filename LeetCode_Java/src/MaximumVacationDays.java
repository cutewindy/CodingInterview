import java.util.Arrays;

/**
 * LeetCode wants to give one of its best employees the option to travel among N cities to collect 
 * algorithm problems. But all work and no play makes Jack a dull boy, you could take vacations in 
 * some particular cities and weeks. Your job is to schedule the traveling to maximize the number of 
 * vacation days you could take, but there are certain rules and restrictions you need to follow.
 * Rules and restrictions:
 * You can only travel among N cities, represented by indexes from 0 to N-1. Initially, you are in 
 * the city indexed 0 on Monday.
 * The cities are connected by flights. The flights are represented as a N*N matrix (not necessary 
 * symmetrical), called flights representing the airline status from the city i to the city j. If 
 * there is no flight from the city i to the city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1. 
 * Also, flights[i][i] = 0 for all i.
 * You totally have K weeks (each week has 7 days) to travel. You can only take flights at most once 
 * per day and can only take flights on each week's Monday morning. Since flight time is so short, 
 * we don't consider the impact of flight time.
 * For each city, you can only have restricted vacation days in different weeks, given an N*K matrix 
 * called days representing this relationship. For the value of days[i][j], it represents the maximum 
 * days you could take vacation in the city i in the week j.
 * You're given the flights matrix and days matrix, and you need to output the maximum vacation days 
 * you could take during K weeks.
 * Example 1:
 * Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
 * Output: 12
 * Explanation: 
 * Ans = 6 + 3 + 3 = 12. 
 * One of the best strategies is:
 * 1st week : fly from city 0 to city 1 on Monday, and play 6 days and work 1 day. 
 * (Although you start at city 0, we could also fly to and start at other cities since it is Monday.) 
 * 2nd week : fly from city 1 to city 2 on Monday, and play 3 days and work 4 days.
 * 3rd week : stay at city 2, and play 3 days and work 4 days.
 * Example 2:
 * Input:flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]
 * Output: 3
 * Explanation: 
 * Ans = 1 + 1 + 1 = 3. 
 * Since there is no flights enable you to move to another city, you have to stay at city 0 for the 
 * whole 3 weeks. 
 * For each week, you only have one day to play and six days to work. 
 * So the maximum number of vacation days is 3.
 * Example 3:
 * Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]
 * Output: 21
 * Explanation:
 * Ans = 7 + 7 + 7 = 21
 * One of the best strategies is:
 * 1st week : stay at city 0, and play 7 days. 
 * 2nd week : fly from city 0 to city 1 on Monday, and play 7 days.
 * 3rd week : fly from city 1 to city 2 on Monday, and play 7 days.
 * Note:
 * 1. N and K are positive integers, which are in the range of [1, 100].
 * 2. In the matrix flights, all the values are integers in the range of [0, 1].
 * 3. In the matrix days, all the values are integers in the range [0, 7].
 * 4. You could stay at a city beyond the number of vacation days, but you should work on the extra 
 * days, which won't be counted as vacation days.
 * 5. If you fly from the city A to the city B and take the vacation on that day, the deduction 
 * towards vacation days will count towards the vacation days of city B in that week.
 * 6. We don't consider the impact of flight hours towards the calculation of vacation days.
 * @author wendi
 *
 */
public class MaximumVacationDays {
	
	/**
	 * Approach2: dp
	 * dp[i][j]: the max vacation days we can get in week i staying in city j
	 * dp[i][j] = max(dp[i - 1][k] + days[j][i]) (k = 0...N - 1, if we can go from city k to city j). 
	 * Also because values of week i only depends on week i - 1, so we can 
	 * compress two dimensional dp array to one dimension.
	 * @param int[][] flights, int[][] days
	 * @return int
	 * Time: O(k* n^2) n = flights.length, k = days[0].length;
	 * Space: O(k*n) can improve to O(n) with rolling array
	 */
    public int maximumVacationDaysI(int[][] flights, int[][] days) {
    	int n = flights.length;
    	int k = days[0].length;
    	int[][] dp = new int[2][n];   // dp[week][city]
    	
    	// init
    	Arrays.fill(dp[0], -1);
    	dp[0][0] = days[0][0];
    	for (int city = 1; city < n; city++) {
    		if (flights[0][city] == 1) dp[0][city] = days[city][0];
    	}
    	
    	// update
    	for (int week = 1; week < k; week++) {
    		Arrays.fill(dp[week % 2], -1);
    		for (int end = 0; end < n; end++) {
    			for (int start = 0; start < n; start++) {
    				if (dp[(week - 1) % 2][start] == -1 || (start != end && flights[start][end] == 0)) continue;
    				dp[week % 2][end] = Math.max(days[end][week] + dp[(week - 1) % 2][start], dp[week % 2][end]);
    			}
    		}
    	}
    	
    	int res = 0;
    	for (int city = 0; city < n; city++) {
    		res = Math.max(dp[(k - 1) % 2][city], res);
    	}
    	
    	return res;
    }
	
	/**
	 * Approach1: DFS + Memorization
	 * @param int[][] flights, int[][] days
	 * @return int
	 * Time: O(n^k) n = flights.length, k = days[0].length;
	 * Space: O(n*k)
	 * Stack space: O(k)
	 */
    public int maximumVacationDays(int[][] flights, int[][] days) {
        return dfs(flights, days, 0, 0, new int[flights.length][days[0].length]);
    }
    
    private int dfs(int[][] flights, int[][] days, int city, int week, int[][] dp) {
    	if (week == days[0].length) return 0;
    	if (dp[city][week] != 0) return dp[city][week];
    	int res = 0;
    	for (int i = 0; i < flights.length; i++) {
    		if (i == city || flights[city][i] == 1) {
    			int currRes = days[i][week] + dfs(flights, days, i, week + 1, dp);
    			res = Math.max(currRes, res);
    		}
    	}
    	dp[city][week] = res;
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumVacationDays result = new MaximumVacationDays();
		System.out.println(result.maximumVacationDays(new int[][] {{0,1,1},{1,0,1},{1,1,0}}, new int[][] {{1,3,1},{6,0,3},{3,3,3}}));
		System.out.println(result.maximumVacationDaysI(new int[][] {{0,1,1},{1,0,1},{1,1,0}}, new int[][] {{1,3,1},{6,0,3},{3,3,3}}));
	}

}
