package dropbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * p="abba", s="red blue blue red", true
p="aaaa", s="red red red red", true
p="abab", s="red blue blue red", false
p="abba", s="red red red red", false
follow up: 假设单词之间没有空格怎么办？例如 pattern: “a a a a” input : “asd asd asd asd” （dp和递归应该都行，
最好递归-partition s，前一半跟p的前n-1个字母match，后一半跟第一问一样的检查是否可行）
 * @author wendi
 *
 */
public class WordPattern {
	
	
	/**
	 * dfs
	 * @param String p, String s
	 * @return boolean
	 * Time: O(n) n=p.length()
	 * Space: O(n)
	 */
	public boolean wordPatternFollowUp(String p, String s) {
		return dfs(p, s, 0, 0, new HashMap<Character, String>(), new HashSet<String>());
	}
	
	private boolean dfs(String p, String s, int index, int pos, Map<Character, String> map, Set<String> set) {
//		System.out.println(p + " : " + s);
		if (index == p.length() && pos == s.length()) return true;
		if (index == p.length() || pos == s.length()) return false;
		if (map.containsKey(p.charAt(index))) {
			String word = map.get(p.charAt(index));
			if (pos + word.length() > s.length() || !word.equals(s.substring(pos, pos + word.length()))) return false;
			return dfs(p, s, index + 1, pos + word.length(), map, set);
		}
		for (int i = pos; i < s.length(); i++) {
			String word = s.substring(pos, i + 1);
//			System.out.println("word: " + word);
			if (set.contains(word)) continue;
			map.put(p.charAt(index), word);
			set.add(word);
			if (dfs(p, s, index + 1, i + 1, map, set)) return true;
			map.remove(p.charAt(index));
			set.remove(word);
		}
		return false;
	}
	
	/**
	 * hashmap
	 * @param String p, String s
	 * @return boolean
	 * Time: O(n) n=p.length()
	 * Space: O(n)
	 */
	public boolean wordPattern(String p, String s) {
		String[] words = s.split("\\s");
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		if (p.length() != words.length) return false;
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(words[i])) return false;
			}
			else if (set.contains(words[i])) return false;
			else {
				map.put(c, words[i]);
				set.add(words[i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPattern result = new WordPattern();
		System.out.println(result.wordPattern("abba", "red blue blue red"));
		System.out.println(result.wordPatternFollowUp("abba", "redbluebluered"));
	}

}
