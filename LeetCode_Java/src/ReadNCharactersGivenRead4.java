import java.util.Arrays;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is 
 * only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters 
 * from the file.
 * Note:
 * The read function will only be called once for each test case.
 * 
 * Tags: String
 * @author wendi
 *
 */
public class ReadNCharactersGivenRead4 {

	/* The read4 API is defined in the parent class Reader4.
    int read4(char[] buf); */
	
//	private char file[] = {'1', '2', '3'};
	private char file[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private int fileIndex = 0;
    public int read4(char[] buf) {
    	int index = 0;
    	while (index < 4 && fileIndex < file.length) {
    		buf[index++] = file[fileIndex++];
    	}
//    	System.out.println(index);
//    	System.out.println(Arrays.toString(buf));
    	return index;
    }

    public int ReadNHelper(char[] buf, int n) {
    	fileIndex = 0;
    	return readN(buf, n);
    }
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int readN(char[] buf, int n) {
    	int index = 0;
    	char[] temp = new char[4];
	    int tempIndex = 0;
	    int size = 0;
	    while (index < n) {
	        size = read4(temp);
	        tempIndex = 0;
	        if (size == 0) {   // case: no char in file
	            break;
	        }
	        while (index < n && tempIndex < size) {  
	        	buf[index++] = temp[tempIndex++];
            }
	    }
	    return index;
    }
	  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadNCharactersGivenRead4 result = new ReadNCharactersGivenRead4();
		char[] buf = new char[7];
		System.out.println(result.ReadNHelper(buf, 7));
		System.out.println(Arrays.toString(buf));
		char[] newBuf = new char[7];
		System.out.println(result.ReadNHelper(newBuf, 7));
		System.out.println(Arrays.toString(newBuf));
	}

}
