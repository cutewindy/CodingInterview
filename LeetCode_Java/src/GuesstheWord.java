import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This problem is an interactive problem new to the LeetCode platform.
 * We are given a word list of unique words, each word is 6 letters long, and one word in this list 
 * is chosen as secret.
 * You may call master.guess(word) to guess a word.  The guessed word should have type string and 
 * must be from the original list with 6 lowercase letters.
 * This function returns an integer type, representing the number of exact matches (value and 
 * position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it 
 * will return -1 instead.
 * For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if 
 * you have made 10 or less calls to master.guess and at least one of these guesses was the secret, 
 * you pass the testcase.
 * Besides the example test case below, there will be 5 additional test cases, each with 100 words 
 * in the word list.  The letters of each word in those testcases were chosen independently at 
 * random from 'a' to 'z', such that every word in the given word lists is unique.
 * Example 1:
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 * Explanation:
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 * Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 * @author wendi
 *
 */
public class GuesstheWord {
	
	/**
	 * min max:
	 * Generally, we will get 0 matches from the master.guess.
	 * As a result, the size of wordlist reduces slowly.
	 * Here we're going to assume that, we will always run into the worst case.
	 * We need to guess a word that can minimum our worst outcome.
	 * So we compare each two words and count their matches.
	 * For each word, we note how many word of 0 matches it gets.
	 * Then we guess the word with minimum words of 0 matches.
	 * In this solution, we apply a minimax idea.
	 * We minimize our worst case,
	 * where the worst case is max(the number of words with i matches)
	 * 
	 * 1. Get the match of words, take max match word from wordlist and guess it.
	 * 2. Update our wordlist and keep only the same matches to our guess.
	 * @param String[] wordlist, Master master
	 * @return
	 */
    public void guesstheWord(String[] wordlist, Master master) {
        int x = 0;
        for (int i = 0; i < 10; i++) {
            String candidate = findCandidate(wordlist);
            x = master.guess(candidate);
            if (x == 6) break;
            wordlist = shrinkWordList(wordlist, candidate, x);
        }
    }
    
    private String findCandidate(String[] wordlist) {
        Map<String, Integer> map = new HashMap<>();
        for (String w1: wordlist) {
            for (String w2: wordlist) {
                if (matches(w1, w2) == 0) map.put(w1, map.getOrDefault(w1, 0) + 1);
            }
        }
        String minMatchZeroWord = "";
        int minMatchZeroCount = Integer.MAX_VALUE;
        for (String word: wordlist) {
            if (map.getOrDefault(word, 0) < minMatchZeroCount) {
                minMatchZeroWord = word;
                minMatchZeroCount = map.getOrDefault(word, 0);
            }
        }
        return minMatchZeroWord;
    }
    
    private String[] shrinkWordList(String[] wordlist, String word, int x) {
        List<String> newWordList = new ArrayList<>();
        for (String w: wordlist) {
            if (matches(w, word) == x) newWordList.add(w);
        }
        return newWordList.toArray(new String[newWordList.size()]);
    }
    
    
    private int matches(String w1, String w2) {
        int x = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i)) x++;
        }
        return x;
    }	

    
    interface Master {
    	 public int guess(String word) {;
    	 }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
