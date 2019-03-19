package dropbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 最高频题duplicate file，只不过和leetcode里不同的是只给一个root directory的string，需要自己在traverse过程中记录result。
 * boolean isDir(String path)
List<String> listDir(String path). check 1point3acres for more.
String joinPath(String path, String subPath)

-先用的file的content来作为HASHMAP 作为KEY
-之后面试官问会有什么样的问题 答曰文件可能会很大 不好放 
-提出用 文件大小 作为filter 之后再在相同大小的file之间比较

-写完之后面试官又表示这样比较的话还是会很占内存而且很慢 该怎么办
-装作沉思 面试官给暗示用Hash
-最后全部写完还剩十分钟 用的文件size为第一层filter 文件hashcode第二层filter 
-过了一遍code 问了些intern的问题就结束了

 * 刚开始定义了一个api拿到类似leetcode中的input然后再找duplicate，要求优化，然后就直接把api删了在做traverse过程中直接往hashmap中放files。

第一遍写的dfs，在面试官提醒了disk read是most expensive operation之后换成了bfs utilize spatial locality。
然后再让优化的时候就提到了可以用disjointset 做union find，然后override hash function，在file size及format相等时
候比较hash code来决定是否union。

  套路的size -> partial_hash -> full_hash -> content compare.

 * @author wendi
 *
 */
public class FindDuplicateFiles {

	/**
	 * Approach2: If the file content is huge
	 * size -> partial_hash -> full_hash -> content compare
	 */
	public List<List<String>> findDuplicateFilesI(String path) {
		List<List<String>> res = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		Map<Integer, Map<Integer, List<String>>> map = new HashMap<>(); // [size : [part hash : [file path]]]
		queue.offer(path);
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			if (isDir(curr)) {
				List<String> list = listDir(curr);
				for (String next: list) queue.offer(joinPath(curr, next));
			}
			else {
				int size = getContentSize(curr);
				map.putIfAbsent(size, new HashMap<Integer, List<String>>());
				int partHashCode = getPartHashCode(curr);
				map.get(size).putIfAbsent(partHashCode, new ArrayList<String>());
				map.get(size).get(partHashCode).add(curr);
			}
		}
		
		// TODO: int the same list, find the same content check byte by byte
		
		return res;
	}
	
	private int getPartHashCode(String curr) {
		return 10;
	}
	
	private int getContentSize(String path) {
		return 10;
	}
	
	/**
	 * Approach1: BFS
	 */
	public List<List<String>> findDuplicateFiles(String path) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(path);
		Map<Integer, List<String>> map = new HashMap<>();
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			if (isDir(curr)) {
				List<String> list = listDir(curr);
				for (String next: list) queue.offer(joinPath(curr, next));
			}
			else {
				int h = read(curr).hashCode();
				map.putIfAbsent(h, new ArrayList<String>());
				map.get(h).add(curr);
			} 
		}
		
		List<List<String>> res = new ArrayList<>();
		for (List<String> value: map.values()) {
			if (value.size() > 1) res.add(value);
		}
		
		return res;
	}
	
	private String read(String path) {
		return "";
	}
	
	 private boolean isDir(String path) {
		 return true;
	 }
	 
	 private List<String> listDir(String path) {
		 List<String> res = new ArrayList<>();
		 return res;
	 }
	 
	 private String joinPath(String path, String subPath) {
		 return "";
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
