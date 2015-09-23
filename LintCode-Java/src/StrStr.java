
//strstr (a.k.a find sub string), is a useful function in string 
//operation. Your task is to implement this function.
//
//For a given source string and a target string, you should output 
//the first index(from 0) of target string in source string.
//
//If target does not exist in source, just return -1.

//Example
//If source = "source" and target = "target", return -1.
//
//If source = "abcdabcdefg" and target = "bcd", return 1.
//
//Challenge
//O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)


public class StrStr {

	
	public static int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}
		if (target.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < source.length() - target.length() + 1; i++) {
			for (int j = 0; j < target.length(); j++) {
				if (source.charAt(i + j) != target.charAt(j)) {
					break;
				}
				if (j == target.length() - 1) {
					return i;
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("abcd", "c"));

	}

}
