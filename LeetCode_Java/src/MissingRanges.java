import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range 
 * [lower, upper], return its missing ranges.
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 * @author wendi
 *
 */
public class MissingRanges {
	
	
	/**
	 * Brute force
	 * @param int[] nums, int lower, int upper
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(1)
	 */
    public List<String> missingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long l = lower;  // take care case: [2147483647], 0, 2147483647
        for (int num: nums) {
            if (l > upper || num > upper) break;
            if (num < l) continue;
            else if (num == l) l = (long)num + 1;
            else {
                res.add(getRange((int)l, num - 1));
                l = (long)num + 1;
            }
        }
        if (l <= upper) res.add(getRange((int)l, upper));
        return res;
    }
    
    private String getRange(int l, int r) {
        if (l == r) return "" + l;
        return l + "->" + r;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingRanges result = new MissingRanges();
		System.out.println(result.missingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
	}

}
