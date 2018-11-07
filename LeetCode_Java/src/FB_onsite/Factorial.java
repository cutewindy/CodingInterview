package FB_onsite;
/**
 * 输出一个数的factorial结果
 * @author wendi
 *
 */
public class Factorial {
	
	/**
	 * using char * int not char * char
	 * @param int n
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String factorial(int n) {
		if (n < 0) return "0";
		int minN = getMin();
		System.out.println("min: " + minN);
		if (n <= minN) return getIntFac(n) + "";   // if not out of int range, multiply directly
		String res = getIntFac(minN) + "";         
		System.out.println("curr res: " + res);
		for (int i = minN + 1; i <= n; i++) {      // otherwise, using (char of string) * int
			res = getStrFac(res, i);
		}
		return res;
	}
	
	public String getStrFac(String s, int num) {
		String res = "";
		int prev = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int product = (s.charAt(i) - '0') * num + prev;
			res = product % 10 + res;
			prev = product / 10;
			
		}
		if (prev == 0) return res;
		return prev + res;
	}
	
	private int getIntFac(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	
	private int getMin() {
		int i = 1;
		long fact = 1;
		while (fact * i <= Integer.MAX_VALUE) {
			fact *= i;
			i++;
		}
		return i - 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial result = new Factorial();
		System.out.println(result.factorial(12));
		System.out.println(result.factorial(20));
	}

}
