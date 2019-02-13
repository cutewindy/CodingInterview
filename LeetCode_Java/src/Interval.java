import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Interval {
	
	int start;
	int end;
	Interval() {
		this.start = 0;
		this.end = 0;	
	}
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public static List<Interval> arrayListtoIntervalList(int[][] array) {
		List<Interval> list = new ArrayList<>();
		if (array == null || array.length == 0 || array[0].length == 0) return list;
		for (int[] arr: array) {
			list.add(new Interval(arr[0], arr[1]));
		}
		return list;
	}
	
	public static int[][] intervalListtoArrayList(List<Interval> list) {
		int[][] array = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = list.get(i).start;
			array[i][1] = list.get(i).end;
		}
		return array;
	}
	
	public static Interval[] arraytoIntervalArray(int[][] array) {
		Interval[] intervals = new Interval[array.length];
		for (int i = 0; i < array.length; i++) {
			intervals[i] = new Interval(array[i][0], array[i][1]);
		}
		return intervals;
	}
	
	public static int[][] intervalArraytoArray(Interval[] intervals) {
		int[][] array = new int[intervals.length][2];
		for (int i = 0; i < intervals.length; i++) {
			array[i][0] = intervals[i].start;
			array[i][1] = intervals[i].end;
		}
		return array;
	}
	
	public static void printIntervalList(List<Interval> list) {
		System.out.println(Arrays.deepToString(intervalListtoArrayList(list)));
	}
	
	public static void printInterval(Interval[] intervals) {
		System.out.println(Arrays.deepToString(intervalArraytoArray(intervals)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{1, 2}, {3, 4}, {5, 6}};
		List<Interval> list = arrayListtoIntervalList(array);
		printIntervalList(list);
		Interval[] intervals = arraytoIntervalArray(array);
		printInterval(intervals);
	}

}
