import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target 
 * number. You can assume that the given target number must exist in the array.
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * Example:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal 
 * probability of returning.
 * solution.pick(3);
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 * @author wendi
 *
 */
public class RandomPickIndex {

	/**
	 * Approach2: Reservoir random pick
	 * approve:
	 *           0 1 2 3 4 5 6
	 * example: [1,2,3,3,3,3,3], if pick(3) = 4, the possibility should be
	 * 1/3 (been chosen at index 4) * 
	 * 3/4 (not been replaced at index 5) * 
	 * 4/5 (not been replaced at index 6) = 
	 * 1/5
	 * Time: init: O(1) pick: O(n)
	 * Space: O(1)
	 * @param nums
	 */
	int[] nums;
	public RandomPickIndex(int[] nums) {
		this.nums = nums;
	}
	
	public int pick(int target) {
        int cnt = 0;
        int pick = -1;
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            cnt++;
            if (r.nextInt(cnt) == 0) pick = i;
        }
        return pick;	
	}
	
	
	/**
	 * Approach1: HashMap + List
	 * Time: init: O(n) pick: O(1)
	 * Space: O(n)
	 * @param nums
	 */
//	Map<Integer, List<Integer>> map; // (key, value): (num, [index])
//	public RandomPickIndex(int[] nums) {
//        map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<Integer>());
//            map.get(nums[i]).add(i);
//        }		
//	}
//	
//	public int pick(int target) {
//		Random r = new Random();
//        List<Integer> list = map.get(target);
//        return list.get(r.nextInt(list.size()));		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomPickIndex result = new RandomPickIndex(new int[] {1,2,3,3,3});
		System.out.println(result.pick(3));
		System.out.println(result.pick(1));
	}

}
