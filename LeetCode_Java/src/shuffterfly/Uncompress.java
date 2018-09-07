package shuffterfly;
/**
 * Consider the string ‘AAAABCCCCCDDDD’ consisting of alphabetic characters only. This string is of 
 * length 14. Since the string consists of alphabetic characters only, duplicate characters can be 
 * removed and replaced with a duplication factor n. With this technique the string can be compressed 
 * and represented by ‘4AB5C4D’. The compressed string is of length 7. Write a function, which takes 
 * a string in compressed form and recreates the original uncompressed string. (Note: The duplication 
 * factor is not restricted to one digit. Hence you can have a compressed string that reads as ‘3A12BC’ 
 * and that expands to ‘AAABBBBBBBBBBBBC’.)
 * @author wendi
 *
 */
public class Uncompress {
	
	/**
	 * brute force
	 * @param String src
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String uncompress(String src) {
		if (src == null || src.length() == 0) return "";
		if (src.length() == 1) return src;
		StringBuilder sb = new StringBuilder();
		char[] array = src.toCharArray();
		for (int start = 0, end = 0; start < array.length;) {
			int num = 0;
			while (end < array.length && Character.isDigit(array[end])) {
				num = num * 10 + array[end] - '0';
				end++;
			}
			if (end == array.length) break;
			if (num == 0)  sb.append(array[end]);
			else {
				while (num-- > 0) sb.append(array[end]);
			}
			start = end + 1;
			end = start;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Uncompress result = new Uncompress();
		System.out.println(result.uncompress("4AB5C4D"));
		System.out.println(result.uncompress("3A12BC"));
	}

}
