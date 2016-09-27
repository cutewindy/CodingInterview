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
	 * 
	 * @param char[][] image, int x, int y
	 * @return int 
	 * Time: O()
	 * Space: O()
	 */
	public int smallestRectangleEnclosingBlackPixels(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return 0;
		}
		int start;
		int end;
		int m = image.length;
		int n = image[0].length;
		// find left bound
		start = 0;
		end = y;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			for (int i = 0; i < m; i++) {
				
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestRectangleEnclosingBlackPixels result = new SmallestRectangleEnclosingBlackPixels();
		System.out.println(result.smallestRectangleEnclosingBlackPixels(new char[][] 
				{{'0', '0', '1', '0'},
				 {'0', '1', '1', '0'},
				 {'0', '1', '0', '0'},
				 {'0', '0', '0', '0'}},
				0, 2));
	}

}
