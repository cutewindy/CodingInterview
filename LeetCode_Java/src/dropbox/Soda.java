package dropbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * // Let's assume sodas are sold in packages of 1, 2, 6, 12, 24.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
// e.g. if N = 10, you could buy 1 x 10,  6 + 2 + 2, 6 + 1 + 1 + 1 + 1, ....
// input : N
// output : all possible combinations, for instance N=10 { {1,1,...,1}, {6,2,2}, {6,1,1,1,1}, 
 * {6,2,1,1}, {2,1,..,1}, .... } (don't include {2,2,6} since we have {6,2,2})
combination sum (递归的时间复杂，如何减少递归的层数, dfs时间复杂度O(n!), 还要会用DP写)

经典买soda题，用dfs，要求改进，用dp，然后分析两者复杂度。


一个人去买罐装汽水，只能一罐一罐或者一箱一箱地买。箱子有几种不同大小，比如一箱12罐，一箱6罐等等。这个input是个list。让输出
所有买法（就是每种package买几个这样）DP一下就可以了。给了两种解法，问complexity，推了一下说exponential（画树），但是不
是很紧的渐进，面试官要求再紧一点，臣妾做不到…
http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * @author wendi
 *
 */
public class Soda {
	
	/**
	 * Method3: DP
	 * @param int[] array, int N
	 * @return List<List<Integer>>
	 * Time: O(m*n) m=array.length
	 * Space: O(n)
	 */
	public List<List<Integer>> sodaII(int[] array, int N) {
		List<List<Integer>> result = new ArrayList<>();
		int m = array.length;
		List<List<Integer>>[] dp = new List[N + 1];
		dp[0] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = array[i]; j <= N; j++) {
				if (dp[j] == null) dp[j] = new ArrayList<>();
				if (dp[j - array[i]].size() == 0) {
					dp[j].add(new ArrayList<>(Arrays.asList(array[i])));
				}
				else {
					for (int k = 0; k < dp[j - array[i]].size(); k++) {
						List<Integer> list = new ArrayList<>(dp[j - array[i]].get(k));
						list.add(array[i]);
						dp[j].add(list);
					}
				}
			}
		}
		return dp[N];
 	}
	
	/**
	 * Method2: DP
	 * @param int[] array, int N
	 * @return int
	 * Time: O(m*n) m=array.length
	 * Space: O(n)
	 */
	public int sodaI(int[] array, int N) {
		int m = array.length;
		int[] dp = new int[N + 1];
		dp[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = array[i]; j <= N; j++) {
				dp[j] += dp[j - array[i]];
			}
		}
		return dp[N];
	}

	
	/**
	 * Method1: DFS
	 * @param int[] array, int N
	 * @return List<List<Integer>>
	 * Time: O(2^m) m=array.length
	 * Space: O(m)
	 */
	public List<List<Integer>> soda(int[] array, int N) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(array);
		dfs(array, 0, N, new ArrayList<Integer>(), res);
		return res;
	}
	
	private void dfs(int[] array, int start, int N, List<Integer> curr, List<List<Integer>> res) {
		if (N == 0) {
			res.add(new ArrayList<>(curr));
			return;
		}
		for (int i = start; i < array.length; i++) {
			if (array[i] > N) break;
			curr.add(array[i]);
			dfs(array, i, N - array[i], curr, res);
			curr.remove(curr.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soda result = new Soda();
		System.out.println(result.soda(new int[] {1, 2, 6, 12, 24}, 10));
		System.out.println(result.sodaI(new int[] {1, 2, 6, 12, 24}, 10));
		System.out.println(result.sodaII(new int[] {1, 2, 6, 12, 24}, 10));
	}

}
