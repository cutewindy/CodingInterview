package FB_onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给两个array [2,1,1,3,3,4,5,8,7], [2,1,3] 按照第二个array的顺序来sort第一个array，如果没有出现，就按照大小来sort
 * 其实这题 可以either用hashmap排第二个数组，记录顺序，也可以用hashmap排第一个数组，存count，然后再根据第二个数组的顺序
 * 一个个写出来。我觉得要跟面试官确认一下哪个数组更大，怎么做更efficient。
 * 
 * @author wendi
 *
 */
public class SortArray {
	
	/**
	 * Approach: comparator
	 * @param int[] nums1, int[] nums2
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public List<Integer> sortArray(List<Integer> list1, List<Integer> list2) {
		final Map<Integer, Integer> map = new HashMap<>();  // [key, value] = [value, index in list2]
		for (int i = 0; i < list2.size(); i++) {
			map.put(list2.get(i), i);
		}
		Collections.sort(list1, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (map.containsKey(a) && map.containsKey(b)) return map.get(a) - map.get(b);
				else if (map.containsKey(a)) return -1;
				else if (map.containsKey(b)) return 1;
				return a - b;
			}
		});
		return list1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortArray result = new SortArray();
		List<Integer> list1 = new ArrayList<>(Arrays.asList(5,2,0,1,3,4));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(2,1,3));
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println("sort : " + result.sortArray(list1, list2));
	}

}
