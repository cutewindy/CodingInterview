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

给一个文件和一个byte数组，判断这个byte数组是否在文件里出现过？本质是字符串匹配，然而不同的是文件可能很大，不能一次性读进内存。
我是假设了一个常量表示了内存分配给我（要解释为什么需要这个常量），创建一段buffer，一开始将它填满，然后匹配buffer和byte数组
（过程就和字符串匹配一样，我是用最蠢的办法），配不上的话，将最后的（byte数组长度-1）个byte移到buffer前端，然后继续读文件更
新buffer剩下的部分，再次匹配，重复这个过程知道文件到尾或者匹配成功。写完后出了两个bug，在面试官提示下修复了，不是自己找出来的= = 
然后是followup，提高时间效率，我说用KMP？他说我不期望你用KMP，那是有点research的方法。我又想了一下，他给我hint说你知道
rollinghash吗？我说不知道= =他就跟我简单解释了一下，就是一个byte数组有一个hash值，然后当删除一个前端的byte或者添加一个新
的byte在末尾的时候，可以通过运算在O(1)时间内算出新的hash值。然后就给我一个class rollinghash，三个方法addbyte,
removebyte,hash，叫我根据这个改代码。改完之后（这一次应该没有bug了= =），他问我有什么好方法可以实现这个hash函数吗
（要求当然就是rollinghash这个类里的三个方法都是常数复杂度），不要求unique，但尽量要求不同？我说XOR每个byte？每个byte相加？
他说可以，然后他说了一个他们在用的办法：设一个常数a，假设byte数组是bytes[0:n-1]，那么hash值为
a^(n-1)*byte[n-1]+a^(n-2)*byte[n-2]+...+a^0*byte[0]
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
		long HASH_SIZE = (long) Math.pow(31, n);
		for (long start = 0; start < fileSize; start = start + chunkSize - n) {  // overlapping
			byte[] content = read(filePath, start, chunkSize);
			long h = 0;
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
