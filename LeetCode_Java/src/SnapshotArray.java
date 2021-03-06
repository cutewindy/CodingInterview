import java.util.TreeMap;

/**
 * Implement a SnapshotArray that supports the following interface:
 * SnapshotArray(int length) initializes an array-like data structure with the given length.  
 * Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we 
 * called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot 
 * with the given snap_id
 * Example 1:
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation: 
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 * Constraints:
 * 1. 1 <= length <= 50000
 * 2. At most 50000 calls will be made to set, snap, and get.
 * 3. 0 <= index < length
 * 4. 0 <= snap_id < (the total number of times we call snap())
 * 5. 0 <= val <= 10^9
 * @author wendi
 *
 */
public class SnapshotArray {
	
	/**
	 * Instead of record the history of the whole array,
	 * we will record the history of each cell.
	 * And this is the minimum space that we need to record all information.
	 */
	TreeMap<Integer, Integer>[] array;  // [{snapshot, val}]
	int snapshot;
    public SnapshotArray(int length) {
        array = new TreeMap[length];
        for (int i = 0; i < length; i++) {
        	array[i] = new TreeMap<Integer, Integer>();
        	array[i].put(0, 0);
        }
        snapshot = 0;
    }
    
    public void set(int index, int val) {
        array[index].put(snapshot, val);
    }
    
    public int snap() {
        snapshot++;
        return snapshot - 1;
    }
    
    public int get(int index, int snap_id) {
        return array[index].get(array[index].floorKey(snap_id));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnapshotArray result = new SnapshotArray(3);  // {0, 0, 0}  0
		result.set(0, 5);                             // {5, 0, 0}  0
		System.out.println(result.snap());            // {5, 0, 0}  1
		result.set(0, 6);                             // {6, 0, 0}  1
		System.out.println(result.get(0, 0));         //  5
		
	}

}
