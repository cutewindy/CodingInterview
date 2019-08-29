import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset 
 * of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of 
 * nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
 * If it does not exist, output -1 for this number.
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second 
 *     array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, 
 *     so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, 
 *     so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * @author wendi
 *
 */
public class NextGreatElementI {
	
	/**
	 * Method2 : using stack and map
	 * @param int[] nums1, int[] nums2
	 * @return int[]
	 * Time: O(m + n)
	 * Space: O(2n) stack and maps
	 */
	public int[] nextGreatElementI(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i  = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for (int num: nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                int curr = stack.pop();
                if (map.containsKey(curr)) {
                    res[map.get(curr)] = num;
                }
            }
            stack.push(num);
        }
        return res;
        
//		int[] result = new int[nums1.length];
//		Map<Integer, Integer> map = new HashMap<>();
//		Stack<Integer> stack = new Stack<>();
//		for (int num2: nums2) {
//			while (!stack.isEmpty() && stack.peek() < num2) {
//				map.put(stack.pop(), num2);
//			}
//			stack.push(num2);
//		}
//		while (!stack.isEmpty()) {
//			map.put(stack.pop(), -1);
//		}
//		for (int i = 0; i < nums1.length; i++) {
//			result[i] = map.get(nums1[i]);
//		}
//		return result;
	}
	
	/**
	 * Method1
	 * Brute force:  pick up every element of the findNumsfindNums array(say findNums[i]findNums[i]) 
	 * and then search for its own occurrence in the nums array(which is indicated by setting 
	 * found to True). After this, we look linearly for a number in nums which is greater 
	 * than findNums[i]findNums[i], which is also added to the results array to be returned. If no 
	 * such element is found, we put a \text{-1}-1 at the corresponding location.
	 * @param int[] nums1, int[] nums2
	 * @return int[]
	 * Time: O(mn)
	 * Space: O(1)
	 */
//	public int[] nextGreatElementI(int[] nums1, int[] nums2) {
//		int[] result = new int[nums1.length];
//		for (int i = 0; i < nums1.length; i++) {
//			boolean found = false;
//			for (int j = 0; j < nums2.length; j++) {
//				if (nums2[j] == nums1[i]) found = true;
//				if (found && nums2[j] > nums1[i]) {
//					result[i] = nums2[j]; 
//					break;
//				}
//				if (j == nums2.length - 1) result[i] = -1;
//			}
//		}
//		return result;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextGreatElementI result = new NextGreatElementI();
		int[] nums1 = {3, 5, 1, 2};
		int[] nums2 = {2, 5 ,1, 0, 7, 3};
		System.out.println(Arrays.toString(result.nextGreatElementI(nums1, nums2)));
	}

}
