//Given an input string, reverse the string word by word.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//
//Have you met this question in a real interview? Yes
//Example
//Clarification
//What constitutes a word?
//A sequence of non-space characters constitutes a word.
//Could the input string contain leading or trailing spaces?
//Yes. However, your reversed string should not contain leading or trailing spaces.
//How about multiple spaces between two words?
//Reduce them to a single space in the reversed string.


public class ReverseWordsinaString {
	
	public String reverseWordsinaString(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		String[] array = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i >= 0; i--) {
			if (!array[i].equals("")) {
				sb.append(array[i]).append(" ");
			}
		}
		
		//remove the last " "
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	
	
	public String reverseWordsinaStringI(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		//first reverse
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		//second reverse
		String sf = "";
		for (String part: s.split(" ")) {
			if (part.equals("")) {
				continue;
			}
			StringBuilder eachWord = new StringBuilder(part);
			sf += eachWord.reverse().toString() + " ";
		}
		//remove the last " "
		return sf.length() == 0 ? "" : sf.substring(0, sf.length() - 1);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaString result = new ReverseWordsinaString();
//		String str = "the sky is blue";
//		String str = "     ";
		String str = "the        sky";
		System.out.println(result.reverseWordsinaString(str));
		System.out.println(result.reverseWordsinaStringI(str));


	}

}
