/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or 
 * neither.
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four 
 * decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 
 * 16 bits. The groups are separated by colons (":"). For example, the address 
 * 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros 
 * among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 
 * 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper 
 * cases).
 * However, we don't replace a consecutive group of zero value with a single empty group using two 
 * consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an 
 * invalid IPv6 address.
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * Note: You may assume there is no extra space or special characters in the input string.
 * Example 1:
 * Input: "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * Input: "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 * @author wendi
 *
 */
public class ValidateIPAddress {
	
	/**
	 * Approach2: Regex
	 * @param String IP
	 * @return String
	 * Time: O()
	 * Space: O()
	 */
	public String validateIPAddressI(String IP) {
		if (IP == null) return "Neither";
		String IPv4Pattern = "(([0-9]|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5]) \\.) {3} ([0-9]|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])";
		String IPv6Pattern = "(([0-9 a-f A-F]) {1,4} :) {7} ([0-9 a-f A-F])";
		if (IP.matches(IPv4Pattern)) return "IPv4";
		if (IP.matches(IPv6Pattern)) return "IPv6";
		return "Neither";
	}
	
	/**
	 * Approach1: Check one by one
	 * @param String IP
	 * @return String
	 * Time: O()
	 * Space: O()
	 */
	public String validateIPAddress(String IP) {
		if (IP == null) return "Neither";
		if (isValidIPv4(IP)) return "IPv4";
		if (isValidIPv6(IP)) return "IPv6";
		return "Neither";
	}
	
	private boolean isValidIPv4(String IP) {
		String[] tokens = IP.split("\\.");
		if (tokens.length != 4) return false;
		for (String token: tokens) {
			if (!isValidIPv4Token(token)) return false;
		}
		return true;
	}
	
	private boolean isValidIPv4Token(String token) {
		if (token == null || token.length() == 0) return false;
		if (Integer.parseInt(token) == 0 && token.length() > 1) return false;
		int num = Integer.parseInt(token);
		return 0 <= num && num <= 255;
	}
	
	private boolean isValidIPv6(String IP) {
		if (IP.length() < 15) return false;
		String[] tokens = IP.split(":");
		if (tokens.length != 8) return false;
		for (String token: tokens) {
			if (!isValidIPv6Token(token)) return false;
		}
		return true;
	}
	
	private boolean isValidIPv6Token(String token) {
		if (token == null || token.length() == 0) return false;
//		if (Integer.parseInt(token) == 0 && token.length() > 1) return false;
		for (char c: token.toCharArray()) {
			if (!('0' <= c && c <= '9' || 'a' <= c && c <= 'f' || 'A' <= c && c <= 'F')) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateIPAddress result = new ValidateIPAddress();
		System.out.println(result.validateIPAddress("172.16.254.1"));
		System.out.println(result.validateIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(result.validateIPAddress("256.256.256.256"));
		System.out.println(result.validateIPAddress("2001:0db8:85a3:0000:0000:8A2E:0370:7334"));

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(result.validateIPAddressI("172.16.254.1"));
		System.out.println(result.validateIPAddressI("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(result.validateIPAddressI("256.256.256.256"));
		System.out.println(result.validateIPAddressI("2001:0db8:85a3:0000:0000:8A2E:0370:7334"));
	}

}
