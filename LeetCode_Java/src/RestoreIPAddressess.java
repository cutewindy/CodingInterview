import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * Tags: Backtracking, String
 * @author wendi
 *
 */
public class RestoreIPAddressess {
	/**
	 * Recursion: find the 4 subIP one by one, which satisfied 0-255, 
	 * and the length of IP is equal to the length of s
	 * @param String s
	 * @return List<String>
	 * Time: O(1) = 3^4
	 * Space: O(1)
	 */
	public List<String> restoreIPAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) return result;
		helper(s, 0, new ArrayList<Integer>(), result);	
		return result;
	}
	
	private void helper(String s, int start, List<Integer> currIPAddr, List<String> result) {
		if (currIPAddr.size() == 4 && start == s.length()) {
			result.add(processIPAddr(currIPAddr));
			return;
		}
		if (currIPAddr.size() == 4 || start == s.length()) return;
		for (int i = start; i < s.length() && i < start + 3; i++) {
			if (s.charAt(start) == '0' && i != start) break; // take care
			int num = Integer.parseInt(s.substring(start, i + 1));
			if (num > 255) break;
			currIPAddr.add(num);
			helper(s, i + 1, currIPAddr, result);
			currIPAddr.remove(currIPAddr.size() - 1);
			
		}
	}
	
	/**
	 * process the result by adding '.'
	 * @param currIPAddr
	 * @return
	 */
	private String processIPAddr(List<Integer> currIPAddr) {
		StringBuilder IPAddr = new StringBuilder();
		for (Integer IP: currIPAddr) {
			IPAddr.append(IP).append(".");
		}
		return IPAddr.substring(0, IPAddr.length() - 1).toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddressess result = new RestoreIPAddressess();
		System.out.println(result.restoreIPAddresses("19216811"));
	}

}
