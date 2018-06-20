/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship 
 * is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of 
 * C, then A is an indirect friend of C. And we defined a friend circle is a group of students who 
 * are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class. If 
 * M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And 
 * you have to output the total number of friend circles among all the students.
 * Example 1:
 * Input: 
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input: 
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct 
 * friends, 
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so 
 * return 1.
 * Note:
 * 1. N is in range [1,200].
 * 2. M[i][i] = 1 for all students.
 * 3. If M[i][j] = 1, then M[j][i] = 1.
 * @author wendi
 *
 */
public class FriendCircles {
	

	
	/**
	 * Method2: Union Find Set
	 * @param int[][] M
	 * @return int
	 * Time: O(n*2)
	 * Space: O(n)
	 */
	public int friendCirclesI(int[][] M) {
		int n = M.length;
		UnionFindSet ufs = new UnionFindSet(n);
		int res = n;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] != 0 && ufs.union(i, j)) res--;
			}
		}
		return res;
	}
	
	
	class UnionFindSet {
		int[] parents;
		public UnionFindSet(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) parents[i] = i;
		}
		
		public int find(int x) {
			while (parents[x] != x) {
				x = parents[x];
			}
			return x;
		}
		
		public boolean union(int a, int b) {
			int pA = find(a);
			int pB = find(b);
			if (pA != pB) {
				parents[pA] = pB;
				return true;
			}
			return false;
		}
	}
	
	
	/**
	 * Method1: Brute force
	 * @param int[][] M
	 * @return int
	 * Time: O(n*2)
	 * Space: O(n)
	 */
	public int friendCircles(int[][] M) {
		boolean[] visited = new boolean[M.length];
		int res = 0;
		for (int i = 0; i < M.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			findFriend(M, i, visited);
			res++;
		}
		return res;
	}

	
	private void findFriend(int[][] M, int i, boolean[] visited) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 0 || visited[j]) continue;
			visited[j] = true;
			findFriend(M, j, visited);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FriendCircles result = new FriendCircles();
		System.out.println(result.friendCircles(new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
		System.out.println(result.friendCirclesI(new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
	}

}
