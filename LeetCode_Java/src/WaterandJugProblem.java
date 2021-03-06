/**
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water 
 * supply available. You need to determine whether it is possible to measure exactly z litres using 
 * these two jugs.
 * If z liters of water is measurable, you must have z liters of water contained within one or both 
 * buckets by the end.
 * Operations allowed:
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug 
 * itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 * Input: x = 2, y = 6, z = 5
 * Output: False
 * @author wendi
 *
 */
public class WaterandJugProblem {
	
	
	/**
	 * Math
	 * 先把5升水罐装满水，倒到3升水罐里，这时5升水罐里还有2升水，然后把3升水罐里的水都倒掉，把5升水罐中的2升水倒入3升水罐中,
	 * 这时候把5升水罐解满，然后往此时有2升水的3升水罐里倒水，这样5升水罐倒出1升后还剩4升即为所求。这个很多人都知道，但是这
	 * 道题随意给我们了三个参数，问有没有解法，这就比较难了。这里我就照搬网上大神的讲解吧：
	 * 
	 * 这道问题其实可以转换为有一个很大的容器，我们有两个杯子，容量分别为x和y，问我们通过用两个杯子往里倒水，和往出舀水，问
	 * 能不能使容器中的水刚好为z升。那么我们可以用一个公式来表达：
	 * z = m * x + n * y
	 * 
	 * 其中m，n为舀水和倒水的次数，正数表示往里舀水，负数表示往外倒水，那么题目中的例子可以写成: 4 = (-2) * 3 + 2 * 5，
	 * 即3升的水罐往外倒了两次水，5升水罐往里舀了两次水。那么问题就变成了对于任意给定的x,y,z，存不存在m和n使得上面的等式
	 * 成立。根据裴蜀定理，ax + by = d的解为 d = gcd(x, y)，那么我们只要只要z % d == 0，上面的等式就有解，所以问题
	 * 就迎刃而解了，我们只要看z是不是x和y的最大公约数的倍数就行了，别忘了还有个限制条件x + y >= z，因为x和y不可能称出比
	 * 它们之和还多的水
	 * @param int x, int y, int z
	 * @return boolean
	 * Time: O(max(a, b))
	 * Space: O(1)
	 */
    public boolean waterandJugProblem(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaterandJugProblem result = new WaterandJugProblem();
		System.out.println(result.waterandJugProblem(3, 5, 4));
	}

}
