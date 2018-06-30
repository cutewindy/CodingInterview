import java.util.HashMap;
import java.util.Map;

/**
 * Given a picture consisting of black and white pixels, and a positive integer N, find the number 
 * of black pixels located at some specific row R and column C that align with all the following rules:
 * Row R and column C both contain exactly N black pixels.
 * For all rows that have a black pixel at column C, they should be exactly the same as row R
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and 
 * white pixels respectively.
 * Example:
 * Input:                                            
 * [['W', 'B', 'W', 'B', 'B', 'W'],    
 *  ['W', 'B', 'W', 'B', 'B', 'W'],    
 *  ['W', 'B', 'W', 'B', 'B', 'W'],    
 *  ['W', 'W', 'B', 'W', 'B', 'W']] 
 * N = 3
 * Output: 6
 * Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
 *         0    1    2    3    4    5         column index                                            
 * 0    [['W', 'B', 'W', 'B', 'B', 'W'],    
 * 1     ['W', 'B', 'W', 'B', 'B', 'W'],    
 * 2     ['W', 'B', 'W', 'B', 'B', 'W'],    
 * 3     ['W', 'W', 'B', 'W', 'B', 'W']]    
 * row index
 * Take 'B' at row R = 0 and column C = 1 as an example:
 * Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels. 
 * Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly 
 * the same as row R = 0.
 * Note:
 * 1. The range of width and height of the input 2D array is [1,200].
 * @author wendi
 *
 */
public class LonelyPixelII {
	
	/**
	 * HashMap
	 * 1. Scan each row. If that row has N black pixels, put a string signature, which is 
	 * concatenation of each characters in that row, as key and how many times we see that signature 
	 * into a HashMap. Also during scan each row, we record how many black pixels in each column in 
	 * an array colCount and will use it in step 2.
	 * 2. Go through the HashMap and if the count of one signature is N, those rows potentially 
	 * contain black pixels we are looking for. Then we validate each of those columns. For each 
	 * column of them has N black pixels (lookup in colCount array), we get N valid black pixels.
	 * @param char[][] picture, int N
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m+n)
	 */
    public int lonelyPixelII(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        
        int[] col = new int[picture[0].length];
        Map<String, Integer> map = new HashMap<>();
        for (char[] p: picture) {
        	String row = scanRow(p, col, N);
        	if (row.length() == 0) continue;
        	if (!map.containsKey(row)) map.put(row, 0);
        	map.put(row, map.get(row) + 1);
        }
        
        int res = 0;
        for (String row: map.keySet()) {
        	if (map.get(row) != N) continue;   // rule2
        	for (int j = 0; j < picture[0].length; j++) {
        		if (row.charAt(j) == 'B' && col[j] == N) {  // rule1
        			res += map.get(row);
        		}
        	}
        }
        
        return res;
    }
    
    private String scanRow(char[] p, int[] col, int N) {
    	StringBuilder sb = new StringBuilder();
    	int count = 0;
    	for (int j = 0; j < p.length; j++) {
    		if (p[j] == 'B') {
    			col[j] += 1;
    			count++;
    		}
    		sb.append(p[j]);
    	}
    	return count == N ? sb.toString() : ""; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LonelyPixelII result = new LonelyPixelII();
		System.out.println(result.lonelyPixelII(new char[][] {{'W', 'B', 'W', 'B', 'B', 'W'},    
															  {'W', 'B', 'W', 'B', 'B', 'W'},    
															  {'W', 'B', 'W', 'B', 'B', 'W'},    
															  {'W', 'W', 'B', 'W', 'B', 'W'}}, 3));
	}

}
