import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next 
 * should be: [1, 3, 2, 4, 5, 6].
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * Clarification for the follow up question - Update (2015-09-18):
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not 
 * look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
 * 
 * Tags: Design
 * @author wendi
 *
 */
public class ZigzagIterator {
	
	/**
	 * Using two iterator i, j, always print i except i.hasNext() = false, then swap i, j
	 * Time: O(n)
	 * Space: O(1)
	 */
	private Iterator<Integer> i;
	private Iterator<Integer> j;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.i = v1.iterator();
		this.j = v2.iterator();
	}
	
	public int next() {
		Integer res;
		if (i.hasNext()) {
			res = i.next();
			Iterator<Integer> temp = i;
			i = j;
			j = temp;
		}
		else {
			res = j.next();
		}
		return res;
	}
	
	public boolean hasNext() {
		return i.hasNext() || j.hasNext();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> v1 = new ArrayList<>(Arrays.asList(1, 2));
		List<Integer> v2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
		ZigzagIterator it = new ZigzagIterator(v1, v2);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
