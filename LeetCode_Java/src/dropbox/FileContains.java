package dropbox;
/**
 * 问：实现一个function，boolean fileContains(String filePath, byte[] pattern)，判断能否在该文件中找到match这个pattern的。
答：hash pattern，遍历file content，每次取和pattern相同长的byte array，也hash，比较hash是否相同。（code实现）
问：hash相同可能会是collision
答：那就byte by byte比较 （code 实现）
问：如果文件太大怎么办？
答：文件分片，每次读入一个chunk，再查找。因为分片是non-overlapping的，所以要考虑边界情况。code实现时改成了overlapping的版本，给每个chunk先加上和pattern一样长的prefix和suffix。
问：如果pattern很小怎么办？
答：那就无需hash了
问：时间复杂度？
答：O(mn), m是file content长，n是pattern （后来觉得hash的复杂度没有考虑）
问：hash还能怎么优化？
答：。。。
问：提示，RollingHash，介绍了一下add，remove操作，然后说不熟悉没关系，能否自己设计一个RollingHash？（不用在意会不会collide）
答：确实不知道，乱写了一个hash(bytes[n,n+k]) = hash(bytes[n-1, n+k-1]) - hash(bytes[n-1]) + hash(bytes[n+k])
以上
 * @author wendi
 *
 */
public class FileContains {
	
	/**
	 * Approach2: large file read by chunk(overlapping) + rolling hash
	 * Time: O((m+n) * n^2)
	 * Space: O(chunkSize)
	 */
	public boolean fileContainsI(String filePath, byte[] pattern) {
		int n = pattern.length;
		long patternH = 0;
		for (int i = 0; i < n; i++) {
			patternH = patternH * 31 + pattern[i];
		}
		long fileSize = getFileSize(filePath);
		int chunkSize = 1 << 30;   // assume 1GB memory can be used
		for (long start = 0; start < fileSize; start = start + chunkSize - n) {  // overlapping
			byte[] content = read(filePath, start, chunkSize);
			long h = 0;
			long HASH_SIZE = (long) Math.pow(31, n);
			for (int i = 0; i < n - 1; i++) {
				h = h * 31 + content[i];
			}
			for (int i = n - 1; i < content.length; i++) {
				h = (h * 31) % HASH_SIZE + content[i];                    // rolling hash
				if (h == patternH) {
					boolean found = true;
					for (int k = 0; k < n; k++) {
						if (content[i - n + 1 + k] == pattern[k]) continue;
						found = false;
						break;
					}
					if (found) return true;
				}
			}
		}
		return false;
	}
	
	private byte[] read(String filePath, long start, int chunkSize) {
		byte[] content = new byte[chunkSize];
		return content;
	}
	
	private long getFileSize(String filePath) {
		long fileSize = 0;
		// TODO
		return fileSize;
	}
	
	
	
	
	/**
	 * Approach1: Brute force
	 * Get all the content according to the filePath, save them to memory
	 * Time: O(m * n) m = fileSize
	 * Space: O(m + n)
	 */
	public boolean fileContains(String filePath, byte[] pattern) {
		int patternH = pattern.hashCode();
		int n = pattern.length;
		byte[] content = read(filePath);
		for (int i = 0; i <= content.length - n; i++) {
			byte[] contentArray = new byte[n];
			for (int j = 0; j < n; j++) {
				contentArray[j] = content[i + j];
			}
			int h = contentArray.hashCode();
			if (h == patternH) {  // hashCode may have collision, compare byte by byte
				boolean found = true;
				for (int k = 0; k < n; k++) {
					if (contentArray[k] == pattern[k]) continue;
					found = false;
					break;
				}
				if (found) return true;
			}
		}
		return false;
	}

	private long hashCode(byte[] pattern) {
		long sum = 0;
		for (byte p: pattern) {
			sum = 31 * sum + p;
		}
		return sum;
	}
	
	private byte[] read(String filePath) {
		byte[] content = new byte[Integer.MAX_VALUE];
		return content;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
