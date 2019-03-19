package dropbox;

import java.util.Arrays;

/**
 * highest minimum sharpness，大家一搜地里也很
多代码也有，主要就是dp，
// Given a 2-d array of "sharpness" values. Find a path from the leftmost column to the rightmost column which has the highest minimum sharpness.
// Output the highest minimum sharpness. Each move can only move to the top right, right or bottom right grid.
// Example: 3*3 matrix
// 5 7 2
// 7 5 8
// 9 1 5
// The path with highest minimum sharpness is 7-->7-->8, because 7 is the highest minimum value in all the paths.
 * 在这个例子中，理想路径是.7->.7->.8因为这条路径中的最小值.7在所有路径中最大。只需要返回这个值，不需要返回路径。
// Idea: Use DP dp[r][c] = min(max(dp[r-1][c-1], dp[r][c-1], dp[r+1][c-1]), grid[r][c])


但没有看到说的很明白的follow up，我就想说下这个。
首先dp完对面就问说如果matrix是1M*1M那么大你要怎么优化代码？
答：每次我们只存2列在memory里面，这样更新一列，然后读下一列，循环操作
问：那你要怎么读这个文件才能让提高时间效率？
答：把矩阵转置，如果按列读的话每次指针要跳转，按行的话省时间
问：那你怎么转置呢？在哪转置？
之后的过程中楼主一直在和面试官试探和讨论：. 1point3acres
答：如果读文件的时候按列读2列，指针跳转2M次，这样读进memory自然成了行（实现所谓转置），再操作就不用跳转，比如说把结果写进文件
就是0跳转，总共2M跳转。1M*1M matrix读写一共1M*1M次跳转。（对！突然不知道从哪里就冒出了还有写文件的事？？？）
问：这个可以，还有没有更好的办法？提示1k*1k
答：读文件一次读1k*1k的matrix，跳转1k次，写文件时1k跳转，总共2k跳转。1M*1M matrix读写一1k*1k*2k次跳转，要比上面那个号。（
一共有1k*1k个1k*1k的matrix）
感觉这是面试官最后想要的答案。

如果图片是1million*1million的怎么办，整张图片读不进内存，我答说dp结构可以改成一维的，然后每次只读一列。小哥说每次读一列的第一个字符非常耗时，
因为要不断的跳读指针，然后我说可以对这个矩阵转置写到另外一个文件里，然后每次想做这个函数就对这个新文件操作就好了，这样就能按行读。
小哥就问我怎么转置再存到另外一个文件里，我说根据内存大小可以多读几列。然后小哥就说还可以再优化，他说这有一个balance，读行输出列，写文件就很耗时，读列输出行，
读文件就很耗时（主要问题是 写指针或读指针跳转到下一行 所带来的时间消耗），其实听到这里我就应该有反应了，但当时还是傻傻的想。
最后结果是每次根据内存大小读一个接近正方形的矩形，将他们写到新文件，再读下一块矩形。这样的话，读写指针跳转次数就最小了。
 * @author wendi
 *
 */
public class HighestMinimumSharpness {
	
	/**
	 * DP + greedy: 
	 * dp[i][j]: minimum value in the path, which in coming from the maximum value from the previous path
	 * dp[i][j] = min(max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1]), matrix[i][j])
	 * res = max(dp[i][n-1])
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int highestMinimumSharpness(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = matrix[i][0];
		}
		
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < m; i++) {
				dp[i][j] = dp[i][j - 1];
				if (i - 1 >= 0) dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j]);
				if (i + 1 < m) dp[i][j] = Math.max(dp[i + 1][j - 1], dp[i][j]);
				dp[i][j] = Math.min(matrix[i][j], dp[i][j]);
			}
		}
		
		int res = 0;
		for (int i = 0; i < m; i++) {
			res = Math.max(dp[i][n - 1], res);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HighestMinimumSharpness result = new HighestMinimumSharpness();
		System.out.println(result.highestMinimumSharpness(new int[][] {{5, 7, 2}, {7, 5 ,8}, {9, 1, 5}}));
	}

}
