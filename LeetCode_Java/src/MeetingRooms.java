import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), determine if a person could attend all meetings.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * 
 * Tags: Sort
 * @author wendi
 *
 */

class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
public class MeetingRooms {
	
	/**
	 * Sort the intervals by start time using Comparator
	 * @param Ubterval[] intervals
	 * @return boolean
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public boolean meetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return true;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return Integer.compare(a.start, b.start);
//				return a.start - b.start;
			}
		});
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingRooms result = new MeetingRooms();
		System.out.println(result.meetingRooms(new Interval[] {new Interval(5, 10), new Interval(0, 30), new Interval(15, 20)}));
		System.out.println(result.meetingRooms(new Interval[] {new Interval(7, 10), new Interval(2, 4)}));
	}

}
