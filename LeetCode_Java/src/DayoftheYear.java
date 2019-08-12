/**
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the 
 * day number of the year.
 * Example 1:
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 * Example 2:
 * Input: date = "2019-02-10"
 * Output: 41
 * Example 3:
 * Input: date = "2003-03-01"
 * Output: 60
 * Example 4:
 * Input: date = "2004-03-01"
 * Output: 61
 * Constraints:
 * 1. date.length == 10
 * 2. date[4] == date[7] == '-', and all other date[i]'s are digits
 * 3. date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
 * @author wendi
 *
 */
public class DayoftheYear {
	
	
	/**
	 * Brute force
	 * @param String date
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int dayoftheYear(String date) {
		if (date == null || date.length() == 0) return 0;
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int res = 0;
		for (int i = 1; i < month; i++) {
			res += days[i];
			if (i == 2 && isLeap(year)) res += 1;
		}
		res += day;
		return res;
	}
	
	private boolean isLeap(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 100 == 0 && year % 400 == 0) return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DayoftheYear result = new DayoftheYear();
		System.out.println(result.dayoftheYear("1900-03-25"));  // 84
		System.out.println(result.dayoftheYear("2004-03-01"));  // 61
	}

}
