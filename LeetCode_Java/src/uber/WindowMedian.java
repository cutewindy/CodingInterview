package uber;
/**
 * 二维矩阵(m*m), 一个二维window(n*n), 滑动window, 计算这个window包含的元素的median, 要求打印出window median矩阵
 */
import java.util.ArrayList;
import java.util.List;

public class WindowMedian {
	
	/**
	 * 
	 * @param matrix, int k
	 * @return List<List<Integer>>
	 * Time: O()
	 * Space: O()
	 */
	public List<List<Integer>> windowMedian(int[][] matrix, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0) return res;
		int m = matrix.length;
		int n = matrix[0].length;
		int sum = 0;
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowMedian result = new WindowMedian();
		System.out.println(result.windowMedian(new int[][] {{2,1,4,3}, {1,1,2,1}, {3,4,2,1}, {5,1,1,1}},  3));
	}

}
