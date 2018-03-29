import java.util.HashMap;
import java.util.Map;

/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as 
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such as 
 * http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your 
 * encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny 
 and the tiny URL can be decoded to the original URL.
 * @author wendi
 *
 */
public class EncodeandDecodeTinyURL {
	
	Map<Integer, String> map = new HashMap<>(); 
	String host = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrl == null) return null;
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return host + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl == null) return null;
        int key = Integer.valueOf(shortUrl.replace(host, ""));
        return map.get(key);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncodeandDecodeTinyURL result = new EncodeandDecodeTinyURL();
		System.out.println(result.encode("https://leetcode.com/problems/design-tinyurl"));
		System.out.println(result.decode("http://tinyurl.com/-1163677885"));
	}

}
