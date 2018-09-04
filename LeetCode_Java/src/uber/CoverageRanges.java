package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a new object called Coverage
 * Coverage stores a list of ranges (aka intervals) for integer values
 * ranges are inclusive
 * Within a single instance of a Coverage, the ranges within must not overlap (uses fewest number of 
 * ranges possible)
 * implement 2 methods fro this class.
 * 1) addRange(int start, int end) : add range will add the specified range, and resolve any 
 * overlapping issues
 * 2) toString() : print Coverage contents for debugging
 * example
 * Coverage c = new Coverage()
 * c.addRange(0,10)
 * c.addRange(20,30)
 * c.toString() --> [(0,10),(20,30)]
 * c.addRange(5,25)
 * c.toString() --> [(0,30)]
 * @author wendi
 *
 */
public class CoverageRanges {
	
	List<int[]> list;
	public CoverageRanges() {
		list = new ArrayList<>();
	}
	
	public void addRange(int start, int end) {
		List<int[]> newList = new ArrayList<>();
		int i = 0;
		while (i < list.size() && list.get(i)[1] < start) {
			newList.add(list.get(i++));
		}
		while (i < list.size() && list.get(i)[0] <= end) {
			start = Math.min(list.get(i)[0], start);
			end = Math.max(list.get(i)[1], end);
			i++;
		}
		newList.add(new int[] {start, end});
		while (i < list.size()) {
			newList.add(list.get(i++));
		}
		list = newList;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int[] range: list) {
			sb.append(Arrays.toString(range));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoverageRanges c = new CoverageRanges();
		c.addRange(0, 10);
		c.addRange(20, 30);
		System.out.println(c.toString());
		c.addRange(5, 25);
		System.out.println(c.toString());
	}

}
