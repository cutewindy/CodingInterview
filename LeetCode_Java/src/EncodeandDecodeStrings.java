import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over 
 * the network and is decoded back to the original list of strings.
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * Implement the encode and decode methods.
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters. Your algorithm 
 * should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode 
 * algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your 
 * own encode/decode algorithm.
 * @author wendi
 *
 */
public class EncodeandDecodeStrings {
	
	/**
	 * Encode method: len + "|" + string
	 * @param strs
	 * @return
	 */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append("|").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int mid = s.indexOf("|", i);
            int size = Integer.parseInt(s.substring(i, mid));
            int start = mid + 1;
            int end = start + size;
            res.add(s.substring(start, end));
            i = end;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncodeandDecodeStrings result = new EncodeandDecodeStrings();
		List<String> input = new ArrayList<>(Arrays.asList("aa", "a|b", "||abc"));
		String encode = result.encode(input);
		List<String> decode = result.decode(encode);
		System.out.println("input: " + input);
		System.out.println("encode: " + encode);
		System.out.println("decode: " + decode);
	}

}
