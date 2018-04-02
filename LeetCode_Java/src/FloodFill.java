import java.util.Arrays;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of 
 * the image (from 0 to 65535).
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
 * and a pixel value newColor, "flood fill" the image.
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally 
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected 
 * 4-directionally to those pixels (also with the same color as the starting pixel), and so on. 
 * Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 * Example 1:
 * Input: 
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: 
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * 1. The length of image and image[0] will be in the range [1, 50].
 * 2. The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * 3. The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 * @author wendi
 *
 */
public class FloodFill {
	
	/**
	 * DFS
	 * Say color is the color of the starting pixel. Let's floodfill the starting pixel: we change 
	 * the color of that pixel to the new color, then check the 4 neighboring pixels to make sure 
	 * they are valid pixels of the same color, and of the valid ones, we floodfill those, and so on.
	 * @param int[][] image, int sr, int sc, int newColor
	 * @return int[][]
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public int[][] flooddFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length == 0 || image[0].length == 0) return image;
		int color = image[sr][sc];
		fillColor(image, sr, sc, color, newColor);
		return image;
	}
	
	public void fillColor(int[][] image, int i, int j, int color, int newColor) {
		if (i < 0 || i >= image.length || j < 0 || j >= image[0].length 
		 || image[i][j] != color || image[i][j] == newColor) return;
		image[i][j] = newColor;
		fillColor(image, i - 1, j, color, newColor);
		fillColor(image, i, j + 1, color, newColor);
		fillColor(image, i + 1, j, color, newColor);
		fillColor(image, i, j - 1, color, newColor);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FloodFill result = new FloodFill();
		System.out.println(Arrays.deepToString(result.flooddFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2)));
		System.out.println(Arrays.deepToString(result.flooddFill(new int[][] {{0,0,0},{0,1,1}}, 1, 1, 1)));
	}

}
