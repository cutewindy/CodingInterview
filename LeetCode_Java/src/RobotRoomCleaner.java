import java.util.HashSet;
import java.util.Set;

/**
 * Given a robot cleaner in a room modeled as a grid.
 * Each cell in the grid can be empty or blocked.
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made 
 * is 90 degrees.
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on 
 * the current cell.
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *   // Clean the current cell.
 *   void clean();
 * }
 * Example:
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 * Notes:
 * 1. The input is only given to initialize the room and the robot's position internally. You must 
 * solve this problem "blindfolded". In other words, you must control the robot using only the 
 * mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 * 2. The robot's initial position will always be in an accessible cell.
 * 3. The initial direction of the robot will be facing up.
 * 4. All accessible cells are connected, which means the all cells marked as 1 will be accessible 
 * by the robot.
 * 5. Assume all four edges of the grid are all surrounded by wall.
 * @author wendi
 *
 */
public class RobotRoomCleaner {
	
	/**
	 * // This is the robot's control interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface Robot {
	 *     // Returns true if the cell in front is open and robot moves into the cell.
	 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
	 *     public boolean move();
	 *
	 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
	 *     // Each turn will be 90 degrees.
	 *     public void turnLeft();
	 *     public void turnRight();
	 *
	 *     // Clean the current cell.
	 *     public void clean();
	 * }
	 */
	
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        visited.add(0 + "-" + 0);
        robot.clean();
        dfs(robot, 0, 0, 0, visited);
    }
    
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left
    private void dfs(Robot robot, int row, int col, int currDir, Set<String> visited) {
    	// Clean current cell.
        for (int k = 0; k < 4; k++) {
            int nextDir = (currDir + k) % 4;
            int i = dir[nextDir][0] + row; // [i, j] is the relative position from the initial point
            int j = dir[nextDir][1] + col;
            if (!visited.contains(i + "-" + j) && robot.move()) {
                visited.add(i + "-" + j);
                robot.clean();
                dfs(robot, i, j, nextDir, visited);
            }
            robot.turnRight();
        }
        // Move backward one step while maintaining the orientation.
        backtrack(robot);
    }
    
    private void backtrack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    class Robot{
    	public void clean() {}
    	
    	public boolean move() {return true;}
    	
    	public void turnRight() {}
    	public void turnLeft() {}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
