package IBM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	/**
	 * two pointers
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int[] sortedArraytwoSum(int[] nums, int target) {
    	int i = 0;
    	int j = nums.length - 1;
    	while (i < j) {
    		int sum = nums[i] + nums[j];
    		if (sum == target) return new int[] {i, j};
    		else if (sum < target) i++;
    		else j--;
    	}
    	return null;
    }
	
	
	/**
	 * Map
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum result = new TwoSum();
		System.out.println(Arrays.toString(result.twoSum(new int[] {2, 4, 1, 3, 5}, 3)));
		System.out.println(Arrays.toString(result.sortedArraytwoSum(new int[] {1, 2, 3, 4, 5}, 4)));
	}

}
