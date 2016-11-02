/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The 
 * black pixels are connected, i.e., there is only one black region. Pixels are connected 
 * horizontally and vertically. Given the location (x, y) of one of the black pixels, return the 
 * area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * For example, given the following image:
		[
		  "0010",
		  "0110",
		  "0100"
		]
 * and x = 0, y = 2,
 * Return 6.
 * 
 * Tags: Binary Search
 * @author wendi
 *
 */
public class SmallestRectangleEnclosingBlackPixels {
	
	/**
	 * Binary Search: find the left boundary, do the binary search in the [0, y] range and find the 
	 * first column vector who has any black pixel.
	 * To determine if a column vector has a black pixel is O(m) so the search in total is O(mlogn).
	 * Do the same for the other boundaries. The area is then calculated by the boundaries.
	 * @param char[][] image, int x, int y
	 * @return int 
	 * Time: O(2mlog(n) + 2nlog(m))
	 * Space: O(1)
	 */
	public int smallestRectangleEnclosingBlackPixels(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return 0;
		}
		int start, end, i, j;
		int left, right, top, bottom;
		int m = image.length;
		int n = image[0].length;
		// find left bound
		start = 0;
		end = y;
		while (start + 1 < end) {
			i = 0;
			j = start + (end - start) / 2;
			while (i < m && image[i][j] == '0') {
				i++;
			}
			if (i < m) end = j;
			else start = j;
		}
		i = 0;
		while (i < m && image[i][start] == '0') i++;
		left = i < m ? start : end;			
		// find right bound
		start = y;
		end = n - 1;
		while (start + 1 < end) {
			i = 0;
			j = start + (end - start) / 2;
			while (i < m && image[i][j] == '0') i++;
			if (i < m) start = j;
			else end = j;
		}
		i = 0;
		while (i < m && image[i][end] == '0') i++;
		right = i < m ? end : start;
		// find top bound
		start = 0;
		end = x;
		while (start + 1 < end) {
			j = 0;
			i = start + (end - start) / 2;
			while (j < n && image[i][j] == '0') j++;
			if (j < n) end = i;
			else start = i;
		}
		j = 0;
		while (j < n && image[start][j] == '0') j++;
		top = j < n ? start : end;
		// find bottom bound
		start = x;
		end = m - 1;
		while (start + 1 < end) {
			j = 0;
			i = start + (end - start) / 2;
			while (j < n && image[i][j] == '0') j++;
			if (j < n) start = i;
			else end = i;
		}
		j = 0;
		while (j < n && image[end][j] == '0') j++;
		bottom = j < n ? end : start;
		return (right - left + 1) * (bottom - top + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestRectangleEnclosingBlackPixels result = new SmallestRectangleEnclosingBlackPixels();
		System.out.println(result.smallestRectangleEnclosingBlackPixels(new char[][] 
				{{'0', '0', '1', '0'},
				 {'0', '0', '1', '0'},
				 {'0', '1', '0', '0'},
				 {'0', '0', '0', '0'}},
				0, 2));
	}

}
