/**
 * You are given a string representing an attendance record for a student. The record only contains 
 * the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) 
 * or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 * @author wendi
 *
 */
public class StudentAttendanceRecordI {

	
	/**
	 * Method2: Ragex
	 * @param String s
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean studentAttendanceRecordII(String s) {
		if (s == null || s.length() == 0) return true;
		return !s.matches("^.*A.*A.*|.*LLL.*$");
	}
	
	
	/**
	 * Method1: scan string
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean studentAttendanceRecordI(String s) {
		if (s == null || s.length() == 0) return true;
		char[] S = s.toCharArray();
		int absent = 0;
		int late = 0;
		for (int i = 0; i < S.length; i++) {
			if (S[i] == 'A') {
				absent++;
				late = 0;
			}
			else if (S[i] == 'L') late++;
			else late = 0;
			if (absent > 1 || late > 2) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentAttendanceRecordI result = new StudentAttendanceRecordI();
		System.out.println(result.studentAttendanceRecordI("PPALLP"));
		System.out.println(result.studentAttendanceRecordI("PPALLL"));
		System.out.println(result.studentAttendanceRecordII("PPALLP"));
		System.out.println(result.studentAttendanceRecordII("PPALLL"));
	}

}
