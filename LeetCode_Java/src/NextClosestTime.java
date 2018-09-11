import java.util.Arrays;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current 
 * digits. There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all 
 * valid. "1:34", "12:9" are all invalid.
 * Example 1:
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 
 * minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed 
 * that the returned time is next day's time since it is smaller than the input time numerically.
 * @author wendi
 *
 */
public class NextClosestTime {

	/**
	 * brute force: find the next valid and large time
	 * This approach here is trying to find next digit for each postion in "HH:MM" from right to 
	 * left. If the next digit is greater than current digit, return directly and keep other digits 
	 * unchanged.
	 * 
	 * Here is the steps: (e.g. "17:38")
	 * 1. Retrieve all four digits from given string and sort them in asscending order, "17:38" -> 
	 *    digits[] {'1', '3', '7', '8'}
	 * 2. Apply findNext() from the right most digit to left most digit, try to find next greater digit 
	 *    from digits[] (if exist) which is suitable for current position, otherwise return the minimum 
	 *    digit (digits[0]):
	 * "HH:M_": there is no upperLimit for this position (0-9). Just pick the next different digit 
	 *          in the sequence. In the example above, '8' is already the greatest one, so we change 
	 *          it into the smallest one (digits[0] i.e. '1') and move to next step: "17:38" -> "17:31"
	 * "HH:_M": the upperLimit is '5' (00~59). The next different digit for '3' is '7', which is 
	 *          greater than '5', so we should omit it and try next. Similarly, '8' is beyond the 
	 *          limit, so we should choose next, i.e. '1': "17:38" -> "17:11"
	 * "H_:MM": the upperLimit depends on result[0]. If result[0] == '2', then it should be no more 
	 *          than '3'; else no upperLimit (0-9). Here we have result[0] = '1', so we could choose 
	 *          any digit we want. The next digit for '7' is '8', so we change it and return the 
	 *          result directly. "17:38" -> "18:11"
	 * "_H:MM": the upperLimit is '2' (00~23). e.g. "03:33" -> "00:00"
	 * @param String time
	 * @return String
	 * Time: O(4*4*4)
	 * Space: O(4)
	 */
	public String nextClosestTime(String time) {
		int[] prevTime = new int[4];
        int intTime = Integer.parseInt(time.replaceAll(":", ""));
        for (int i = 3; i >= 0; i--) {
        	prevTime[i] = intTime % 10;
        	intTime /= 10;
        }
        int[] digits = prevTime.clone();
        Arrays.sort(digits);
        
        // find the next large digit
        int[] nextTime = prevTime.clone();
        for (int i = 3; i >= 0; i--) {
        	for (int j = 0; j < 4; j++) {
        		if (j != 0 && digits[j] == digits[j - 1]) continue; // skip duplicate digit
        		nextTime[i] = digits[j];
        		if (isValid(nextTime) && isLarge(nextTime, prevTime)) return getNextTime(nextTime);
        	}
        	// if cannot find the next digit at position i, keep position i as the small valid digit
        	for (int j = 0; j < 4; j++) {  
        		nextTime[i] = digits[j];
        		if (isValid(nextTime)) break;
        	}
        }

        return getNextTime(nextTime);
    }
	
	private String getNextTime(int[] nextTime) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2; i++) sb.append(nextTime[i]);
		sb.append(":");
		for (int i = 2; i < 4; i++) sb.append(nextTime[i]);
		return sb.toString();
	}
	
	private boolean isLarge(int[] nextTime, int[] prevTime) {
		for (int i = 0; i < 4; i++) {
			if (nextTime[i] < prevTime[i]) return false;
			if (nextTime[i] > prevTime[i]) return true; 
		}
		return false;
	}
	
	private boolean isValid(int[] nextTime) {
		int hour = nextTime[0] * 10 + nextTime[1];
		int second = nextTime[2] * 10 + nextTime[3];
		return hour < 24 && second < 60;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextClosestTime result = new NextClosestTime();
		System.out.println(result.nextClosestTime("19:34"));
		System.out.println(result.nextClosestTime("23:59"));
	}

}
