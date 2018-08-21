package google_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 只输出一条最短路径，同时还被challenge用26个字符iteration太慢，想问问大家怎么回答这个follow up 的？
 * ref: http://www.1point3acres.com/bbs/thread-213577-2-1.html
 * 
 * 我的想法:
 * 只输出一条最短路径: 在BFS里用个getParent记录
 * 用26个char iteration太慢的话: 预处理, Map<String, List<String>>。需要k^2的时间, k = dict.size();
 * key是单词，value是和这个单词只相差一个char的string
 * @author wendi
 *
 */
public class WordLadder1_5 {
	
	/**
	 * BFS + HashMap
	 * BFS to build Graph, Use a HashMap to save the path.
	 * @param String beginWord, String endWord, List<String> wordList
	 * @return List<String>
	 * Time: O(V + E)
	 * Space: O(V)
	 */
	public List<String> wordLadder1_5(String beginWord, String endWord, List<String> wordList) {
		List<String> res = new ArrayList<>();
		if (wordList == null || wordList.size() == 0) return res;
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord)) return res;
		Map<String, String> childToParent = new HashMap<>();
		if (!findWords(beginWord, endWord, dict, childToParent)) return res;
		return getParents(beginWord, endWord, childToParent);
	}
	
	private boolean findWords(String beginWord, String endWord, Set<String> dict, Map<String, String> childToParent) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			String parent = queue.poll();
			char[] parentArray = parent.toCharArray();
			for (int i = 0; i < parentArray.length; i++) {
				char c = parentArray[i];
				for (char ch = 'a'; ch <= 'z'; ch++) {
					parentArray[i] = ch;
					String child = String.valueOf(parentArray);
					if (!dict.contains(child) || visited.contains(child)) continue;
					childToParent.put(child, parent);
					if (child.equals(endWord)) return true;
					queue.offer(child);
					visited.add(child);
				}
				parentArray[i] = c;
			}
		}
		return false;
	}
	
	private List<String> getParents(String beginWord, String endWord, Map<String, String> childToParent) {
		List<String> res = new ArrayList<>();
		if (childToParent.isEmpty()) return res;
		res.add(endWord);
		String nextWord = endWord;
		while (!nextWord.equals(beginWord)) {
			nextWord = childToParent.get(nextWord);
			res.add(0, nextWord);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder1_5 result = new WordLadder1_5();
		System.out.println(result.wordLadder1_5("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
	}

}
