/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly 
 * the same digits existing in the integer n and is greater in value than n. If no such positive 
 * 32-bit integer exists, you need to return -1.
 * Example 1:
 * Input: 12
 * Output: 21
 * Example 2:
 * Input: 21
 * Output: -1
 * @author wendi
 *
 */
public class NextGreaterElementIII {

	
	/**
	 * Same like "Next Permutation"
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int nextGreaterElementIII(int n) {
        char[] array = String.valueOf(n).toCharArray();
        int i = array.length - 2;
        while (i >= 0) {
            if (array[i] < array[i + 1]) break;
            i--;
        }
        
        if (i == -1) return -1;
        
        int j = array.length - 1;
        while (j > i) {
            if (array[j] > array[i]) break;
            j--;
        }
        swap(array, i, j);
        
        reverse(array, i + 1, array.length - 1);
        
        long res = Long.parseLong(new String(array));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
    
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextGreaterElementIII result = new NextGreaterElementIII();
		System.out.println(result.nextGreaterElementIII(230241));
	}

}
