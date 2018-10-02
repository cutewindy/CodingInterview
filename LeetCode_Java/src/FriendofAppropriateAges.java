/**
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of 
 * the ith person. 
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 * Note that if A requests B, B does not necessarily request A.  Also, people will not friend request 
 * themselves.
 * How many total friend requests are made?
 * Example 1:
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * Example 2:
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * Example 3:
 * Input: [20,30,100,110,120]
 * Output: 3
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 * Notes:
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 * @author wendi
 *
 */
public class FriendofAppropriateAges {
	
	
	/**
	 * prefixSum + count array
	 * Since the age range is limited to [1..120], we can count number of people of each age and 
	 * store in the array. Then we can use that array to count friend requests:
	 * Three conditions could be merged to one:
	 * The Person with age A can request person with age B if B is in range (0.5 * A + 7, A]
	 * @param int[] ages
	 * @return int
	 * Time: O(n + 121)
	 * Space: O(121)
	 */
	public int friendofAppropriateAges(int[] ages) {
		if (ages == null || ages.length == 0) return 0;
		
		// count age
		int[] numinAge = new int[121];
		for (int a: ages) numinAge[a]++;
		
		// get prefix sum
		int[] prefixSum = new int[121];
		for (int i = 1; i <= 120; i++) {
			prefixSum[i] = numinAge[i] + prefixSum[i - 1];
		}
		
		// get res
		int res = 0;
		for (int i = 15; i <= 120; i++) {  // take care, age should start from 15, eg: {108,115,5,24,82}
			if (numinAge[i] == 0) continue;
			int minAge = i / 2 + 7;
			res += numinAge[i] * (prefixSum[i] - prefixSum[minAge] - 1);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FriendofAppropriateAges result = new FriendofAppropriateAges();
		System.out.println(result.friendofAppropriateAges(new int[] {20,30,100,110,120}));
		System.out.println(result.friendofAppropriateAges(new int[] {108,115,5,24,82}));
	}

}
