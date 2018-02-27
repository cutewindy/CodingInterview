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
		List<Interval> result = new ArrayList<>();
		if (array == null || array.length == 0 || array[0].length == 0) return result;
		for (int[] arr: array) {
			result.add(new Interval(arr[0], arr[1]));
		}
		return result;
	}
	
	public static int[][] intervalListtoArrayList(List<Interval> list) {
		int[][] array = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = list.get(i).start;
			array[i][1] = list.get(i).end;
		}
		return array;
	}
	
	public static void printIntervalList(List<Interval> list) {
		System.out.println(Arrays.deepToString(intervalListtoArrayList(list)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{1, 2}, {3, 4}, {5, 6}};
		List<Interval> list = arrayListtoIntervalList(array);
		printIntervalList(list);
	}

}
