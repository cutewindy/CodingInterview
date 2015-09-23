import java.util.Arrays;


public class Test {
	
//递归求和	
	private boolean isFirst = true;
	
	public int sum(int n) {
		int sum = 0;
		if (n > 0) {
			if (isFirst) {
				isFirst = false;	
				sum = sum(n - 1);
			}
			else {
				sum = n + sum(n - 1);
			}
		}
		return sum;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test t = new Test();
//		System.out.println(t.sum(4));
		
		String s = "the sky is blue";
		String[] s1 = s.split(" ");
		System.out.println(Arrays.toString(s1));
		
		

	}

}
