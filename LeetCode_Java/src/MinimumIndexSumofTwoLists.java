import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of 
 * favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum. If there is 
 * a choice tie between answers, output all of them with no order requirement. You could assume 
 * there always exists an answer.
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index 
 * sum 1 (0+1).
 * Note:
 * 1. The length of both lists will be in the range of [1, 1000].
 * 2. The length of strings in both lists will be in the range of [1, 30].
 * 3. The index is starting from 0 to the list length minus 1.
 * 4. No duplicates in both lists.
 * @author wendi
 *
 */
public class MinimumIndexSumofTwoLists {
	
	/**
	 * Two HashMap:
	 * @param String[] list1, String[] list2;
	 * @return String[]
	 * Time: O(n1+n2+max(n1, n2))
	 * Space: O(n1+n2)
	 */
	public String[] minimumIndexSumofTwoLists(String[] list1, String[] list2) {
		if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) return new String[0];
		Map<String, Integer> map = new HashMap<>();           // map<string in list1, index>
		Map<Integer, List<String>> resSum = new HashMap<>();  // resSum<index sum, restaurant list>
		int minIndexSum = Integer.MAX_VALUE;
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				int indexSum = map.get(list2[i]) + i;
				if (!resSum.containsKey(indexSum)) resSum.put(indexSum, new ArrayList<String>());
				resSum.get(indexSum).add(list2[i]);
				minIndexSum = Math.min(indexSum, minIndexSum);
			}
		}
		List<String> list = resSum.get(minIndexSum);
		String[] result = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumIndexSumofTwoLists result = new MinimumIndexSumofTwoLists();
		System.out.println(Arrays.toString(result.minimumIndexSumofTwoLists
				(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"}, 
				new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
		System.out.println(Arrays.toString(result.minimumIndexSumofTwoLists
				(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"}, 
				new String[] {"KFC", "Shogun", "Burger King"})));
	}

}
