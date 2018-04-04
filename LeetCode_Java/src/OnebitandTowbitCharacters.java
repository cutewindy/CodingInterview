/**
 * We have two special characters. The first character can be represented by one bit 0. The second 
 * character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits. Return whether the last character must be a 
 * one-bit character or not. The given string will always end with a zero.
 * Example 1:
 * Input: 
 * bits = [1, 0, 0]
 * Output: True
 * Explanation: 
 * The only way to decode it is two-bit character and one-bit character. So the last character is 
 * one-bit character.
 * Example 2:
 * Input: 
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation: 
 * The only way to decode it is two-bit character and two-bit character. So the last character is 
 * NOT one-bit character.
 * Note:
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 * @author wendi
 *
 */
public class OnebitandTowbitCharacters {
	
	/**
	 * Method2: Increasing pointer
	 * When reading from the i-th position, if bits[i] == 0, the next character must have 1 bit; 
	 * else if bits[i] == 1, the next character must have 2 bits. We increment our read-pointer i 
	 * to the start of the next character appropriately. At the end, if our pointer is at bits.length - 1, 
	 * then the last character must have a size of 1 bit.
	 * @param int[] bits
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean onebitandTowbitCharactersI(int[] bits) {
		if (bits == null || bits.length == 0) return false;
		int i = 0;
		while (i < bits.length - 1) {
			i += bits[i] + 1;
		}
		return i == bits.length - 1;
	}
	
	
	/**
	 * Method1: 
	 * @param int[] bits
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean onebitandTowbitCharacters(int[] bits) {
		if (bits == null || bits.length == 0) return false;
		int i = 0;
		boolean lastOne = false;
		while (i < bits.length) {
			if (bits[i] == 1) {
				lastOne = false;
				i += 2;
			}
			else {
				lastOne = true;
				i += 1;
			}
		}
		return lastOne;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnebitandTowbitCharacters result = new OnebitandTowbitCharacters();
		System.out.println(result.onebitandTowbitCharacters(new int[] {1, 0, 0}));
		System.out.println(result.onebitandTowbitCharacters(new int[] {1, 1, 1, 0}));
		System.out.println(result.onebitandTowbitCharactersI(new int[] {1, 0, 0}));
		System.out.println(result.onebitandTowbitCharactersI(new int[] {1, 1, 1, 0}));
	}

}
