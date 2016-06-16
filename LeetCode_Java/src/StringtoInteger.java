
public class StringtoInteger {
	public int stringtoInteger(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		String result = "";
		int i = 0;
		boolean begin = false;
		// remove front " "
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		// check whether is Empty
		
		while (i < s.length()) {
			if (s.charAt(i) == '+' && !begin) {
				begin = true;
				continue;
			}
			else if (s.charAt(i) == '-' && !begin) {
				begin = true;
				result += s.charAt(i);
			}
			else if (Integer.valueOf(s.charAt(i)) >= 0 && Integer.valueOf(s.charAt(i)) <= 9) {
				result += s.charAt(i);
			}
			else {
				break;
			}
			i++;
		}
		
		return Integer.valueOf(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringtoInteger result = new StringtoInteger();
		System.out.println(result.stringtoInteger("   234+32"));
		

	}

}
