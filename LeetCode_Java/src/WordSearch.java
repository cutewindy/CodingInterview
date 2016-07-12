/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
		[
		  ['A','B','C','E'],
		  ['S','F','C','S'],
		  ['A','D','E','E']
		]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * Tags: Array, Backtracking
 * @author wendi
 *
 */
public class WordSearch {

	/**
	 * Backtracking: First, find the beginning. Then do the recursion.
	 * Basecase1: if the whole string word has been check, return true.
	 * Basecase2: if row, col out of range, or the char has been visited, or char doesn't equals to board[row][col], return false.
	 * Condition: means the char equals to word[pos], need to check its up, right, down, left char,
	 * to check whether they equal to word[pos+1].
	 * @param char[][] board, String word
	 * @return boolean
	 * Time: O()
	 * Space: O()
	 */
	public boolean wordSearch(char[][] board, String word) {
		if ((board == null && word != null) || board.length == 0 || board[0].length == 0) {
			return false;
		}
		if ((board == null && word == null) || word.length() == 0) {
			return true;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && helper(word, board, visited, i, j, 0)) {
					return true;
				}
			}
		}		
		return false;
	}
	
	private boolean helper(String word, char[][] board, boolean[][] visited, int row, int col, int pos) {
		if (pos == word.length()) {
			return true;
		}
		if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length -1 ||
				visited[row][col] || board[row][col] != word.charAt(pos)) {
			return false;
		}
		visited[row][col] = true;
		if (helper(word, board, visited, row - 1, col, pos + 1) || 
			helper(word, board, visited, row, col + 1, pos + 1) ||
			helper(word, board, visited, row + 1, col, pos + 1) ||
			helper(word, board, visited, row, col - 1, pos + 1)) {
			return true;
		}
		visited[row][col] = false;		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch result = new WordSearch();
		System.out.println(result.wordSearch(new char[][] 
				{{'A','B','C','E'}, 
				 {'S','F','C','S'},
				 {'A','D','E','E'}}, "SEEDE"));
	}

}
