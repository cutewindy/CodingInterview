import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Design a Snake game that is played on a device with screen size = width x height. Play the game 
 * online if you are not familiar with the game.
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * You are given a list of food's positions in row-column order. When a snake eats the food, its 
 * length and the game's score both increase by 1.
 * Each food appears one by one on the screen. For example, the second food will not appear until 
 * the first food was eaten by the snake.
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block 
 * occupied by the snake.
 * Example:
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * Snake snake = new Snake(width, height, food);
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * |S| | |
 * | | |F|
 * snake.move("R"); -> Returns 0
 * | |S| |
 * | | |F|
 * snake.move("D"); -> Returns 0
 * | | | |
 * | |S|F|
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food 
 * appears at (0,1) )
 * | |F| |
 * | |S|S|
 * snake.move("U"); -> Returns 1
 * | |F|S|
 * | | |S|
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * | |S|S|
 * | | |S|
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 * 
 * Tags: Design, Queue
 * @author wendi
 *
 */
public class DesignSnakeGame {
	
	private int width;
	private int height;
	private int[][] food;
	private Deque<Integer> body;  // use for updating tail
	private Set<Integer> set;  // use for fast loop-up for eating body case
	private int foodIndex;
	private boolean gameOver = false;

    /** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	public DesignSnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;;
		this.food = food;
		this.body = new LinkedList<>();
		this.set = new HashSet<>();  
		this.body.offer(0);  
		this.set.add(0);
		this.foodIndex = 0;
	}
	
    /** Moves the snake.
    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
    @return The game's score after the move. Return -1 if game over. 
    Game over when snake crosses the screen boundary or bites its body. */	
	public int move(String direction) {
		if (gameOver) return -1;  // don't forget to check whether game already over: do nothing
		int i = body.peek() / width;
		int j = body.peek() % width;
		if (direction.equals("U")) i--;
		else if (direction.equals("L")) j--;
		else if (direction.equals("R")) j++;
		else if (direction.equals("D")) i++;
	
		// 1. remove tail
		int tail = body.pollLast();
		set.remove(tail);
		int newHead = i * width + j;
		
		// 2. check whether out of boundary or eating body
		if (i < 0 || i >= height || j < 0 || j >= width || set.contains(newHead)) {
			gameOver = true;   // don't forget if game is over, over never.
			return -1;
		}
		
		// 3. check whether eating food, add tail
		if (foodIndex < food.length && i == food[foodIndex][0] && j == food[foodIndex][1]) {  // don't forget to check foodIndex
			body.offer(tail);
			set.add(tail);
			foodIndex++;
		}
		
		// 4. add new head
		body.offerFirst(newHead);
		set.add(newHead);
		return body.size() - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignSnakeGame dsg = new DesignSnakeGame(3, 2, new int[][] {{1, 2}, {0, 1}});
		System.out.println(dsg.move("R"));
		System.out.println(dsg.move("D"));
		System.out.println(dsg.move("R"));
		System.out.println(dsg.move("U"));
		System.out.println(dsg.move("L"));
		System.out.println(dsg.move("U"));
//		DesignSnakeGame dsg = new DesignSnakeGame(2, 2, new int[][] {{1, 1}, {0, 0}});
//		System.out.println(dsg.move("R"));
//		System.out.println(dsg.move("D"));
//		System.out.println(dsg.move("L"));
//		System.out.println(dsg.move("U"));
//		System.out.println(dsg.move("R"));
	}

}
