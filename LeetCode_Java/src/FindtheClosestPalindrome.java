import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 * The 'closest' is defined as absolute difference minimized between two integers.
 * Example 1:
 * Input: "123"
 * Output: "121"
 * Note:
 * 1. The input n is a positive integer represented by string, whose length will not exceed 18.
 * 2. If there is a tie, return the smaller one as answer.
 * @author wendi
 *
 */
public class FindtheClosestPalindrome {
	
	
	/**
	 * Math: compare five candidates, get result,
	 * 
	 * 比如如果给你个131，那么就需要返回121。而且返回的回文数可能位数还不同，比如当n为100的时候，我们就应该返回99，或者给
	 * 了我们99时，需要返回101。那么实际上最近回文数是有范围的，比如说n为三位数，那么其最近回文数的范围在[99, 1001]之间，
	 * 这样我们就可以根据给定数字的位数来确定出两个边界值，要和其他生成的回文数进行比较，取绝对差最小的。

	 * 下面我们来看如何求一般情况下的最近回文数，我们知道回文数就是左半边和右半边互为翻转，奇数情况下中间还有个单独的值。
	 * 那么如何将一个不是回文数的数变成回文数呢，我们有两种选择，要么改变左半边，要么改变右半边。由于我们希望和原数绝对差最小，
	 * 肯定是改变低位上的数比较好，所以我们改变右半边，那么改变的情况又分为两种，一种是原数本来就是回文数，这种情况下，我们
	 * 需要改变中间的那个数字，要么增加1，要么减小1，比如121，可以变成111和131。另一种情况是原数不是回文数，我们只需要改变
	 * 右半边就行了，比如123，变成121。那么其实这三种情况可以总结起来，分别相当于对中间的2进行了-1, +1, +0操作，那么我们
	 * 就可以用一个-1到1的for循环一起处理了，先取出包括中间数的左半边，比如123就取出12，1234也取出12，然后就要根据左半边
	 * 生成右半边，为了同时处理奇数和偶数的情况，我们使用一个小tricky，在反转复制左半边的时候，我们给rbegin()加上len&1，
	 * 当奇数时，len&1为1，这样就不会复制中间数了；为偶数时，len&1为0，这就整个翻转复制了左半边。我们把每次生成的回文串转
	 * 为转为数字后加入到一个集合set中，把之前的两个边界值也同样加进去，最后我们在五个candidates中找出和原数绝对差最小的
	 * 那个返回，记得别忘了在集合中删除原数，因为如果原数时回文的话, i=0时就把自己也加入集合了
	 * @param String n
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
    public String findtheClosestPalindrome(String n) {
        if (n == null || n.length() == 0) return "0";
        int len = n.length();
        int mid = len % 2 == 0 ? len / 2 - 1 : len / 2;
        long left = Long.parseLong(n.substring(0, mid + 1));
        List<Long> candidates = new ArrayList<>();
        // n = 12345 or 1234
        for (int i = -1; i <= 1; i++) {
            candidates.add(getPalindrome(left + i, len % 2 != 0));   // 12221, 12321, 12421 or 1111, 1221, 1331
        }
        candidates.add((long) Math.pow(10, len - 1) - 1); // 9999 or 999
        candidates.add((long) Math.pow(10, len) + 1);     // 100001 or 10001
        long res = candidates.get(0);
        long num = Long.parseLong(n);
        Collections.sort(candidates);
        for (Long candidate: candidates) {
            if (candidate == num) continue;
            if (Math.abs(candidate - num) < Math.abs(res - num)) {
                res = candidate;
            }
        }
        return String.valueOf(res);
    }
    
    private long getPalindrome(long left, boolean odd) {
        long res = left;
        if (odd) left /= 10;
        while (left != 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindtheClosestPalindrome result = new FindtheClosestPalindrome();
		System.out.println(result.findtheClosestPalindrome("123"));
		System.out.println(result.findtheClosestPalindrome("1234"));
	}

}
