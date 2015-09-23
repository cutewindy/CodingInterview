//Given a string and an offset, rotate string by offset. (rotate from left to right)
//
//Have you met this question in a real interview? Yes
//Example
//Given "abcdefg".
//
//offset=0 => "abcdefg"
//offset=1 => "gabcdef"
//offset=2 => "fgabcde"
//offset=3 => "efgabcd"
//Challenge
//Rotate in-place with O(1) extra memory.


public class RotateString {
	
	public void rotateString(char[] str, int offset) {
		if (str == null || str.length == 0) {
			return;
		}
		int index = str.length - offset % str.length;
		reverse(str, 0 , index - 1);
		reverse(str, index, str.length - 1);
		reverse(str, 0, str.length - 1); 	
	}
	
	public void reverse(char[] str, int start, int end) {
		char temp;
		while (start < end) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start ++;
			end --;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateString result = new RotateString();
		char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		result.rotateString(str, 22);
		System.out.println(str);

	}

}
