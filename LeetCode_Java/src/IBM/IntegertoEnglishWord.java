package IBM;

public class IntegertoEnglishWord {
	
	
	String[] nums = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", 
			"Eight", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", 
			"Fifteen ", "Seventeen ", "Eighteen ", "Nineteen "};
	String[] tens = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", 
			"Eighty ", "Ninety "};
	String[] thousands = {"", "Thousand ", "Million ", "Billion "};
	
	public String integertoEnglishWord(int num) {
		String res = new String();
		int i = 0;
		while (num != 0) {
			String curr = getWord(num % 1000);
			if (curr != null) res = curr + thousands[i++] + res;
			num /= 1000;
		}
		return res.trim();
	}
	
	private String getWord(int num) {
		if (num == 0) return null;
		int a = num / 100;
		int b = num % 100;
		String res = new String();
		if (a != 0) res = nums[a] + "Hundred ";
		if (b != 0) res = res + (b < 20 ? nums[b] : tens[b / 10] + nums[b % 10]);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegertoEnglishWord result = new IntegertoEnglishWord();
		System.out.println(result.integertoEnglishWord(4523342));
	}

}
