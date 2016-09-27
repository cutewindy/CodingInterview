/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may 
 * exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her 
 * but he/she does not know any of them.
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you 
 * are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether 
 * A knows B. You need to find out the celebrity (or verify there is not one) by asking as few 
 * questions as possible (in the asymptotic sense).
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a 
 * function int findCelebrity(n), your function should minimize the number of calls to knows.
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label 
 * if there is a celebrity in the party. If there is no celebrity, return -1.
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class FindtheCelebrity {

	/**
	 * Method2: Two Pointers: The first pass is to pick out the candidate. If candidate knows i, 
	 * then switch candidate. The second pass is to check whether the candidate is real.
	 * @param int n
	 * @return int
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public int findtheCelebrityI(int n) {
		if (n <= 0) {
			return -1;
		}
		int result = 0;
		for (int i = 1; i < n; i++) {
			// if res knows i, that means res cannot be a celebrity, 
			// what's more, if res doesn't know i, that means i cannot be a celebrity(cannot miss).
			if (knows(result, i)) result = i;   
		}
		for (int i = 0; i < n; i++) {
			if (i != result && (knows(result, i) || !knows(i, result))) {
				return -1;
			}
		}
		return result;
	}
	
	
	/**
	 * Mehtod1: Brute Force
	 * @param int n
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int findtheCelebrity(int n) {
		if (n <= 0) {
			return -1;
		}
		for (int i = 0; i < n; i++) {
			if (!knows(i, (i + 1) % n) && knows((i + 1) % n, i)) {
				int j = 0;
				while (j < n) {
					if (j != i && (knows(i, j) || !knows(j, i))) {
						break;
					}
					j++;
				}
				if (j == n) {
					return i;
				}
			}
		}
		return -1;
	}
	
	private boolean knows(int a, int b) {
		boolean T = true;
		boolean F = false;
		boolean[][] matrix = 
			{{T, F, T, F, T, T, T},
			 {F, F, F, T, T, T, T},
			 {F, T, T, T, F, T, F}, 
			 {F, F, F, F, F, T, T},
			 {T, F, F, T, T, T, T},
			 {F, F, F, F, F, F, F},
			 {T, T, T, F, T, T, F}				
			};
		return matrix[a][b];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindtheCelebrity result = new FindtheCelebrity();
		System.out.println(result.findtheCelebrity(7));
		System.out.println(result.findtheCelebrityI(7));
	}

}
