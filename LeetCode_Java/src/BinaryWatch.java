import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the 
 * bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return 
 * all possible times the watch could represent.
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * 1. The order of output does not matter.
 * 2. The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * 3. The minute must be consist of two digits and may contain a leading zero, for example "10:2" is 
 * not valid, it should be "10:02".
 * 
 * Tags: Backtracking, Bit Manipulation
 * @author wendi
 *
 */
public class BinaryWatch {

	
	/**
	 * (32m)
	 * Method2: Just go through the possible times and collect those with the correct number of one-bits. 
	 * @param int num
	 * @return List<String>
	 * Time: O(12 * 60)
	 * Space: O(1)
	 */
	public List<String> binaryWatchI(int num) {
		List<String> result = new ArrayList<>();
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
					result.add(String.format("%d:%02d", h, m));
				}
			}
		}
		return result;
	}
	
	
	/**
	 * (4m)
	 * Method1: Backtracking: combination + permutation
	 * For each i(i LED as hours), get possible hours and minutes and then do combination to get result.
	 * Using permutation to calculate hours and minutes.
	 * @param int num
	 * @return List<String> 
	 * Time: O()
	 * Space: O()
	 * Stack space: O()
	 */
    public List<String> binaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] hours = {8, 4, 2, 1};
        int[] minutes = {32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            if (i > 4 || num - i > 6) continue;    // Don't forget
            List<Integer> hourList = new ArrayList<>();
            List<Integer> minuteList = new ArrayList<>();
            getDigit(hours, 0, 0, i, hourList);
            getDigit(minutes, 0, 0, num - i, minuteList);
            for (Integer hour: hourList) {
                if (hour >= 12) continue;        // Don't forget
                for (Integer minute: minuteList) {
                    if (minute >= 60) continue;  // Don't forget
                    res.add(hour + ":" + (minute >= 10 ? minute : "0" + minute));
                }
            }
        }
        return res;
    }
    
    private void getDigit(int[] nums, int pos, int sum, int totalNum, List<Integer> res) {
        if (totalNum == 0) {
            res.add(sum);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            getDigit(nums, i + 1, sum + nums[i], totalNum - 1, res);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryWatch result = new BinaryWatch();
		System.out.println(result.binaryWatch(1));
		System.out.println(result.binaryWatchI(1));
	}

}
