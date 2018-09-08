import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one 
 * word and end with a special character '#'). For each character they type except '#', you need to 
 * return the top 3 historical hot sentences that have prefix the same as the part of sentence 
 * already typed. Here are the specific rules:
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same 
 * sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). 
 * If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one 
 * appears first).
 * If less than 3 hot sentences exist, then just return as many as you can.
 * When the input is a special character, it means the sentence ends, and in this case, you need to 
 * return an empty list.
 * Your job is to implement the following functions:
 * The constructor function:
 * AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is 
 * historical data. Sentences is a string array consists of previously typed sentences. Times is the 
 * corresponding times a sentence has been typed. Your system should record these historical data.
 * Now, the user wants to input a new sentence. The following function will provide the next 
 * character the user types:
 * List<String> input(char c): The input c is the next character typed by the user. The character 
 * will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). 
 * Also, the previously typed sentence should be recorded in your system. The output will be the top 
 * 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 * Example:
 * Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
 * The system have already tracked down the following sentences and their corresponding times: 
 * "i love you" : 5 times 
 * "island" : 3 times 
 * "ironman" : 2 times 
 * "i love leetcode" : 2 times 
 * Now, the user begins another search: 
 * Operation: input('i') 
 * Output: ["i love you", "island","i love leetcode"] 
 * Explanation: 
 * There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have 
 * same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should 
 * be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be 
 * ignored. 
 * Operation: input(' ') 
 * Output: ["i love you","i love leetcode"] 
 * Explanation: 
 * There are only two sentences that have prefix "i ". 
 * Operation: input('a') 
 * Output: [] 
 * Explanation: 
 * There are no sentences that have prefix "i a". 
 * Operation: input('#') 
 * Output: [] 
 * Explanation: 
 * The user finished the input, the sentence "i a" should be saved as a historical sentence in 
 * system. And the following input will be counted as a new search. 
 * Note:
 * 1. The input sentence will always start with a letter and end with '#', and only one blank space 
 * will exist between two words.
 * 2. The number of complete sentences that to be searched won't exceed 100. The length of each 
 * sentence including those in the historical data won't exceed 100.
 * 3. Please use double-quote instead of single-quote when you write test cases even for a character 
 * input.
 * 4. Please remember to RESET your class variables declared in class AutocompleteSystem, as 
 * static/class variables are persisted across multiple test cases. Please see here for more details.
 * @author wendi
 *
 */
public class DesignSearchAutocompleteSystem {

	/**
	 * Trie + MaxHeap
	 */
	
	Trie trie;
	String prefix;
    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
        	trie.insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
        	trie.insert(prefix, 1);
        	prefix = "";
        	return res;
        }
        prefix += c;
        TrieNode curr = trie.getPrefixNode(prefix);
        if (curr == null) return res;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
        	@Override
        	public int compare(Pair p1, Pair p2) {
        		if (p1.freq != p2.freq) return p2.freq - p1.freq;
        		return p1.sentense.compareTo(p2.sentense);
        	}
        });
        addToPQ(curr, prefix, maxHeap);
        for (int i = 0; i < 3 && !maxHeap.isEmpty(); i++) {
        	res.add(maxHeap.poll().sentense);
        }
        return res;
    }
    
    private void addToPQ(TrieNode curr, String sentence, PriorityQueue<Pair> maxHeap) {
    	if (curr == null) return;
    	if (curr.freq != 0) maxHeap.offer(new Pair(sentence, curr.freq));
    	for (int i = 0; i <= 26; i++) {
    		if (curr.children[i] == null) continue;
    		char c = (i == 26 ? ' ' : (char) ('a' + i));
    		addToPQ(curr.children[i], sentence + c, maxHeap);
    	}
    }
    
    class Pair {
    	String sentense;
    	int freq;
    	public Pair(String sentense, int freq) {
    		this.sentense = sentense;
    		this.freq = freq;
    	}
    }
    
    class TrieNode {
    	int freq;
    	TrieNode children[];
    	public TrieNode() {
    		this.freq = 0;
    		this.children = new TrieNode[27];  // include ' '
    	}
    }
    
    class Trie {
    	public TrieNode root;
    	public Trie() {
    		root = new TrieNode();
    	}
    	
    	public void insert(String s, int freq) {
    		TrieNode curr = root;
    		for (char c: s.toCharArray()) {
    			int id = c == ' ' ? 26 : c - 'a';
    			if (curr.children[id] == null) curr.children[id] = new TrieNode();
    			curr = curr.children[id];
    		}
    		curr.freq += freq;
    	}
    	
    	public TrieNode getPrefixNode(String s) {
    		if (s == null || s.length() == 0) return null;
    		TrieNode curr = root;
    		for (char c: s.toCharArray()) {
    			int id = c == ' ' ? 26 : c - 'a';
    			if (curr.children[id] == null) return null;
    			curr = curr.children[id];
    		}
    		return curr;
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignSearchAutocompleteSystem result = new DesignSearchAutocompleteSystem(
				new String[] {"i love you", "island","ironman", "i love leetcode"}, 
				new int[] {5,3,2,2});
		System.out.println(result.input('i'));
		System.out.println(result.input(' '));
		System.out.println(result.input('a'));
		System.out.println(result.input('#'));
	}

}
