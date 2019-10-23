import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * Example:
 * Input: 2d vector =
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 * Output: [1,2,3,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements 
 * returned by next should be: [1,2,3,4,5,6].
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 * @author wendi
 *
 */
public class Flatten2DVector implements Iterator<Integer> {

	/**
	 * Approach2: Iterator
	 * Time: O(1)
	 * Space:O(1)
	 */
	Iterator<List<Integer>> matrixItr;
	Iterator<Integer> rowItr;
    public Flatten2DVector(List<List<Integer>> vec2d) {
    	if (vec2d == null || vec2d.size() == 0) return;   
        this.matrixItr = vec2d.iterator();
        rowItr = matrixItr.next().iterator();
        while (!rowItr.hasNext()) {
            if (!matrixItr.hasNext()) break;     // case: [[]]
            rowItr = matrixItr.next().iterator();
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new RuntimeException("sth goes wrong!");
        return rowItr.next();
    }

    @Override
    public boolean hasNext() {
        if (matrixItr == null) return false;    // case: []
        while (!rowItr.hasNext()) {
            if (!matrixItr.hasNext()) return false;
            rowItr = matrixItr.next().iterator();
        }
        return true;
    }
    
    
    
    /**
     * Approach1: Two pointer
	 * Time: O(1)
	 * Space:O(1)
     */

//    int[][] v;
//    int i;
//    int j;
//    Integer next;
//    public Vector2D(int[][] v) {
//        if (v == null) return;
//        this.v = v;
//        this.i = 0;
//        this.j = 0;
//        this.next = null;
//        getNext();
//    }
//    
//    public int next() {
//        if (!hasNext()) return -1;
//        int res = next;
//        getNext();
//        return res;
//    }
//    
//    public boolean hasNext() {
//        return next != null;
//    }
//    
//    private void getNext() {
//        next = null;
//        while (i < v.length) {
//            if (j == v[i].length) {
//                i++;
//                j = 0;
//            }
//            else {
//                next = v[i][j];
//                j++;
//                break;
//            }
//        }
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> vec2d = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(3));
		List<Integer> list3 = new ArrayList<>(Arrays.asList(4, 5, 6));
		vec2d.add(list1);
		vec2d.add(list2);
		vec2d.add(list3);
		Flatten2DVector result = new Flatten2DVector(vec2d);
		while (result.hasNext()) {
			System.out.println(result.next());
		}
	}

}
