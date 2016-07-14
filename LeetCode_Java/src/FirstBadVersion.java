/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 *  the latest version of your product fails the quality check. Since each version is developed 
 *  based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which 
 * causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to 
 * the API.
 * 
 * Tags: BinarySearch
 * @author wendi
 *
 */
public class FirstBadVersion {

	/**
	 * BinarySearch(Template)
	 * @param int n
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int firstBadVersion(int n) {
		if (n == 0) {
			return 0;
		}
		int start = 1;
		int end = n;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (isBadVersion(mid)) {
				end = mid;
			}
			else {
				// cannot use start = mid + 1, Integer out of range. 
				// When firstBadVersion is 2147483647, start = 2147483647 and end = 2147483647, 
				// they will not go out of while loop.
				start = mid;  
			}
		}
		return isBadVersion(start) ? start : end;
	}
	
	private boolean isBadVersion(int n) {
		if (n >= 2147483647) { 
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstBadVersion result = new FirstBadVersion();
		System.out.println(result.firstBadVersion(2147483647));
	}

}
