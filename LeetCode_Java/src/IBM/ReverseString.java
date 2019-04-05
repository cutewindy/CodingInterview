package IBM;

public class ReverseString {
	
	
	/**
	 * Two pointers + two time reverse
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String reverseWordinString(String str) {
		char[] array = str.toCharArray();
		reverse(array, 0, array.length - 1);
		int i = 0;
		int j = 0;
		while (j < array.length) {
			while(j < array.length && array[j] != ' ') j++;
			reverse(array, i, j - 1);
			j++;
			i = j;
		}
		return cleanSpace(array);
	}
	
	public String cleanSpace(char[] array) {
		int i = 0;
		int j = 0;
		while (j < array.length) {
			if (array[j] == ' ') {
				array[i++] = ' ';
				while (j < array.length && array[j] == ' ') j++;
			}
			if (j < array.length) array[i++] = array[j++];
		}
		return String.valueOf(array).substring(0, i).trim();
	}
	
	private void reverse(char[] array, int i, int j) {
		while (i < j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
	}
	
	
	
	
	/**
	 * Two pointers
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String reverseString(String str) {
		char[] array = str.toCharArray();
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			swap(array, i, j);
			i++;
			j--;
		}
		return String.valueOf(array);
	}
	
	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString result = new ReverseString();
		System.out.println(result.reverseString("The sky is blue."));
		System.out.println(result.reverseWordinString("The    sky  is blue.      "));
	}

}
