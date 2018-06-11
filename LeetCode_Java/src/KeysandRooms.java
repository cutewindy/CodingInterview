import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, 
 * and each room may have some keys to access the next room. 
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in 
 * [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * Initially, all the rooms start locked (except for room 0). 
 * You can walk back and forth between rooms freely.
 * Return true if and only if you can enter every room.
 * Example 1:
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:  
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * Note:
 * 1. 1 <= rooms.length <= 1000
 * 2. 0 <= rooms[i].length <= 1000
 * 3. The number of keys in all rooms combined is at most 3000.
 * @author wendi
 *
 */
public class KeysandRooms {
	
	/**
	 * BFS: set + queue
	 * We use an unordered_set to record the rooms visited, and a queue for BFS. Push room 0 to 
	 * queue first.
	 * While the queue is not empty, meaning we have more rooms to visit, we check all keys in the 
	 * current room, if we haven't visit all of these rooms, push it to the queue.
	 * @param List<List<Integer>> rooms
	 * @return boolean
	 * Time: O(n)
	 * Space: O(2n)
	 */
	public boolean keysandRooms(List<List<Integer>> rooms) {
		if (rooms == null || rooms.size() == 0) return true;
		Set<Integer> set = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			Integer curr = queue.poll();
			set.add(curr);
			for (Integer next: rooms.get(curr)) {
				if (!set.contains(next)) queue.offer(next);
			}
		}
		return set.size() == rooms.size();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeysandRooms result = new KeysandRooms();
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(Arrays.asList(1, 3));
		rooms.add(Arrays.asList(3, 0, 1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(0));
		System.out.println(result.keysandRooms(rooms));
	}

}
