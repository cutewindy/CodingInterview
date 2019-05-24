/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and 
 * ask your friend to guess what the number is. Each time your friend makes a guess, you provide a 
 * hint that indicates how many digits in said guess match your secret number exactly in both digit 
 * and position (called "bulls") and how many digits match the secret number but locate in the wrong 
 * position (called "cows"). Your friend will use successive guesses and hints to eventually derive 
 * the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to 
 * indicate the bulls and B to indicate the cows. 
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * Example 1:
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and 
 * their lengths are always equal.
 * @author wendi
 *
 */
public class BullsandCows {
	

	/**
	 * Method1: int[] array,
	 * @param String secret, String guess
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String bullsandCows(String secret, String guess) {
		int bull = 0;
		int cow = 0;
		int[] sCounts = new int[10];
		int[] gCounts = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g) bull++;
			else {
				sCounts[s - '0']++;
				gCounts[g - '0']++;
			}
		}
		for (int i = 0; i < 10; i++) {
			cow += Math.min(sCounts[i], gCounts[i]);
		}
		return bull + "A" + cow + "B";		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BullsandCows result = new BullsandCows();
		System.out.println(result.bullsandCows("1123", "0111"));
	}

}
