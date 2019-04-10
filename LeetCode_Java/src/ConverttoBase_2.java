
public class ConverttoBase_2 {
	
	
	/**
	 * base2 function is quite basis of basis.
	 * check last digit, shift to right.
	 * base-2 is totally no difference, just add a sign -.
	 * @param int N
	 * @return String
	 * Time: O(log(N))
	 * Space: O(1)
	 */
    public String converttoBase_2(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            if ((N & 1) == 0) sb.append("0");
            else sb.append("1");
            N = -(N >> 1);
        }
        return sb.reverse().toString();
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConverttoBase_2 result = new ConverttoBase_2();
		System.out.println(result.converttoBase_2(2));
	}

}
