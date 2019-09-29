import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of n distinct non-empty strings, you need to generate minimal possible 
 * abbreviations for every word following rules below.
 * Begin with the first character and then the number of characters abbreviated, which followed by 
 * the last character.
 * If there are any conflict, that is more than one words share the same abbreviation, a longer 
 * prefix is used instead of only the first character until making the map from word to abbreviation 
 * become unique. In other words, a final abbreviation cannot map to more than one original words.
 * If the abbreviation doesn't make the word shorter, then keep it as original.
 * Example:
 * Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 * Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 * Note:
 * 1. Both n and the length of each word will not exceed 400.
 * 2. The length of each word is greater than 1.
 * 3. The words consist of lowercase English letters only.
 * 4. The return answers should be in the same order as the original array.
 * @author wendi
 *
 */
public class WordAbbreviation {
	
	
	/**
	 * Brute force
	 * 由于每个单词的缩写形式中数字前面的字母个数不一定相同，所以我们用一个pre数组来记录每个单词缩写形式开头字母的长度，初始
	 * 化都为1，然后先求出所有单词pre为1的缩写形式，再来进行冲突处理。我们遍历每一个缩写字符串，进行while循环，新建一个
	 * 集合set，然后遍历其他所有字符串，所有发现冲突字符串，就把冲突字符串的坐标存入集合中，如果没有冲突，那么集合为空，直接
	 * break掉，如果由冲突，那么还要把当前遍历的位置i加入结合中，然后遍历集合中所有的位置，对其调用缩写函数，此时pre对应的
	 * 值自增1，直到没有冲突存在为止
	 * @param List<String> dict
	 * @return List<String>
	 * Time: O(n^2 * l^2) l = ave length of word
	 * Space: O(n)
	 */
    public List<String> wordsAbbreviation(List<String> dict) {
        if (dict == null || dict.size() == 0) return new ArrayList<String>();
        int n = dict.size();
        int[] prefix = new int[n];
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = 1;
            res[i] = (getAbbreviation(dict.get(i), 1)); // make abbreviation for each string
        }
        for (int i = 0; i < n; i++) {
            while (true) {
                Set<Integer> set = new HashSet<>();
                for (int j = i + 1; j < n; j++) { // check all strings with the same abbreviation
                    if (res[i].equals(res[j])) set.add(j);
                }
                if (set.isEmpty()) break;
                set.add(i);
                for (Integer index: set) {
                    res[index] = getAbbreviation(dict.get(index), ++prefix[index]); // increase the prefix
                }
            }
        }
        return Arrays.asList(res);
    }
    
    private String getAbbreviation(String word, int prefixLen) {
        if (word.length() <= 3 || word.length() <= prefixLen + 2) return word;
        int n = word.length();
        int num = n - prefixLen - 1;
        return word.substring(0, prefixLen) + num + word.charAt(n - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordAbbreviation result = new WordAbbreviation();
		System.out.println(result.wordsAbbreviation(Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion")));
	}

}
