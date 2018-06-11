import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and 
 * others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 * @author wendi
 *
 */
public class FindAllDuplicatesinanArray {

	
	/**
	 * Method2: using negative, without destroying the input array
	 * when find a number n, flip the number at position n-1 to negative. 
     * if the number at position n-1 is already negative, n is the number that occurs twice.
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> findAllDuplicatesinanArrayI(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		for (int n: nums) {
			int index = Math.abs(n) - 1;
			if (nums[index] < 0) res.add(Math.abs(n));
			nums[index] = -nums[index];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Math.abs(nums[i]);
		}
		return res;
	}
	
	
	/**
	 * Method1: swap, destroying the input array
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> findAllDuplicatesinanArray(int[] nums) {
		List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) res.add(nums[i]);
        }
        return res;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllDuplicatesinanArray result = new FindAllDuplicatesinanArray();
		System.out.println(result.findAllDuplicatesinanArray(new int[] {4,3,2,7,8,2,3,1}));
		System.out.println(result.findAllDuplicatesinanArrayI(new int[] {4,3,2,7,8,2,3,1}));
	}

}
