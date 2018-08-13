import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a 
 * function pickIndex which randomly picks an index in proportion to its weight.
 * Note:
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 * Input: 
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 * Input: 
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has 
 * one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, 
 * even if there aren't any.
 * @author wendi
 *
 */
public class RandomPickwithWeight {
	
//	credit: http://blog.gainlo.co/index.php/2016/11/11/uber-interview-question-weighted-random-numbers/
	
	int[] array;
	int sum;
	/**
	 * Approach3: array (MLE)
	 * preprocessing all the elements once by keeping an array where array[i] stores the index 
	 * corresponding to weight. This allows us to return the area immediately from the array.
	 * Time:construct: O(n), pick: O(1)
	 * Space: O(sum)
	 */
    public RandomPickwithWeight(int[] w) {
    	int n = w.length;
        this.sum = 0;
        for (int i = 1; i < n; i++) w[i] += w[i - 1];
        sum = w[n - 1];
        this.array = new int[this.sum];
        int index = 0;
        for (int i = 0; i < this.sum; i++) {
        	if (i < w[index]) array[i] = index;
        	else array[i] = ++index;
        }
    }
 
    public int pickIndex() {
    	Random r = new Random();
    	return array[r.nextInt(sum)];
    }
	
	
//	int[] w;
//	int sum;
//	/**
//	 * Approach2: Prefix Sum weight + Binary search
//	 * The idea is the same like approach 1, but we use binary search to find the first index that
//	 * R is smaller than sum.
//	 * Time:construct: O(n), pick: O(log(n))
//	 * Space: O(n)
//	 */
//    public RandomPickwithWeight(int[] w) {
//    	int n = w.length;
//        this.w = new int[n];
//        this.sum = 0;
//        for (int i = 0; i < n; i++) {
//        	this.sum += w[i];
//        	this.w[i] = this.sum;
//        }
//    }
// 
//    public int pickIndex() {
//    	Random r = new Random();
//    	int val = r.nextInt(sum);
//    	int start = 0;
//    	int end = w.length - 1;
//    	while (start + 1 < end) {
//    		int mid = start + (end - start) / 2;
//    		if (val == w[mid])  return mid + 1;
//    		else if (val > w[mid]) start = mid + 1;	
//    		else end = mid - 1;
//    	}
//    	if (val < w[start]) return start;
//    	if (val < w[end]) return end;
//    	return end + 1;
//    }
	
	
//	int[] w;
//	int sum;
//	/**
//	 * Approach1: Prefix Sum weight + iteration
//	 * In essence, we can denote the new set above as a horizontal line like this:
//	 * {1,1,1,1,1,2,2,2,2,3}
//	 * The sampling is like randomly select a point and see which area it falls into. Going into 
//	 * this idea, we can have the following algorithm:
//	 * Sum is the sum of all the weights (length of the horizontal line)
//	 * Get a random number R from [0, sum) (randomly select a point)
//	 * Go over each element in order and keep the sum of weights of visited elements. Once R is 
//   * smaller than sum, return the current element. This is finding which area includes the point.
//	 * Time:construct: O(n), pick: O(n)
//	 * Space: O(n)
//	 */
//    public RandomPickwithWeight(int[] w) {
//    	int n = w.length;
//        this.w = new int[n];
//        this.sum = 0;
//        for (int i = 0; i < n; i++) {
//        	this.sum += w[i];
//        	this.w[i] = this.sum;
//        }
//    }
// 
//    public int pickIndex() {
//        Random r = new Random();
//        int val = r.nextInt(sum);
//        for (int i = 0; i < w.length; i++) {
//        	if (val < w[i]) return i;
//        }
//        return -1;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomPickwithWeight result = new RandomPickwithWeight(new int[] {1, 3});
		System.out.println(result.pickIndex());
		System.out.println(result.pickIndex());
		System.out.println(result.pickIndex());
		System.out.println(result.pickIndex());
		System.out.println(result.pickIndex());
	}

}
