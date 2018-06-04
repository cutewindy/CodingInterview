/**
 * Design and implement a data structure for a compressed string iterator. It should support the 
 * following operations: next and hasNext.
 * The given compressed string will be in the form of each letter followed by a positive integer 
 * representing the number of this letter existing in the original uncompressed string.
 * next() - if the original string still has uncompressed characters, return the next letter; 
 * Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 * Note:
 * Please remember to RESET your class variables declared in StringIterator, as static/class 
 * variables are persisted across multiple test cases. Please see here for more details.
 * Example:
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * iterator.next(); // return 'L'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 't'
 * iterator.next(); // return 'C'
 * iterator.next(); // return 'o'
 * iterator.next(); // return 'd'
 * iterator.hasNext(); // return true
 * iterator.next(); // return 'e'
 * iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 * @author wendi
 *
 */
public class DesignCompressedStringIterator {
	
	String str;
	char c;
	int count;
	int index;
	
	/**
	 * Brute force
	 * @param compressedString
	 */
	public DesignCompressedStringIterator(String compressedString) {
		this.str = compressedString;
		this.c = ' ';
		this.count = 0;
		this.index = 0;
	}
	
	/**
	 * @return char
	 * Time: O()
	 * Space: O(1)
	 */
	public char next() {
		if (count == 0 && index >= str.length()) return ' ';
		if (count == 0) {
			c = str.charAt(index++);
			while (index < str.length() && Character.isDigit(str.charAt(index))) {
				count = count * 10 + str.charAt(index++) - '0';
			}
		}
		count--;
		return c;
	}
	
	
	/**
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean hasNext() {
		return index < str.length() || count != 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignCompressedStringIterator iterator = new DesignCompressedStringIterator("L1e2t1C1o1d1e1");
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
	}

}
