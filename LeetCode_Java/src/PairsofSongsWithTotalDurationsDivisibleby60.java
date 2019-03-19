
/**
 * In a list of songs, the i-th song has a duration of time[i] seconds. 
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  
 * Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 * Example 1:
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * Note:
 * 1. 1 <= time.length <= 60000
 * 2. 1 <= time[i] <= 500
 * @author wendi
 *
 */
public class PairsofSongsWithTotalDurationsDivisibleby60 {
	
	
	/**
	 * two sum:
	 * Calculate the time % 60 then it will be exactly same as two sum problem.
	 * take care when time is 60.
	 * @param
	 * @return int
	 * Time: O(n)
	 * Space: O(60)
	 */
	public int pairsofSongsWithTotalDurationsDivisibleby60(int[] time) {
		if (time == null || time.length == 0) return 0;
		int[] cnt = new int[60];
		int res = 0;
		for (int t: time) {
			res += cnt[(60 - t % 60) % 60];
			cnt[t % 60]++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairsofSongsWithTotalDurationsDivisibleby60 result = new PairsofSongsWithTotalDurationsDivisibleby60();
		System.out.println(result.pairsofSongsWithTotalDurationsDivisibleby60(new int[] {30,20,150,100,40}));
		System.out.println(result.pairsofSongsWithTotalDurationsDivisibleby60(new int[] {60,60,60}));
	}

}
