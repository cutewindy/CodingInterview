import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * You are given a data structure of employee information, which includes the employee's unique id, 
 * his importance value and his direct subordinates' id.
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like 
 * [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although 
 * employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * Now given the employee information of a company, and an employee id, you need to return the total 
 * importance value of this employee and all his subordinates.
 * Example 1:
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. 
 * They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * Note:
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 * @author wendi
 *
 */

class Employee {
    public int id; // unique id of this employee
    public int importance; // the importance value of this employee
    public List<Integer> subordinates; // the id of direct subordinates	
    public Employee (int id, int importance, List<Integer> subordinates) {
    	this.id = id;
    	this.importance = importance;
    	this.subordinates = subordinates;
    }
}

public class EmployeeImportance {

	/**
	 * BFS: using map to store the (id, employee)
	 * @param List<Employee> employees, int id
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int employeeImportance(List<Employee> employees, int id) {
		if (employees == null || employees.size() == 0) return 0;
		int result = 0;
		Map<Integer, Employee> map = new HashMap<>();
		Queue<Employee> queue = new LinkedList<>();
		for (Employee e: employees) {
			if (e.id == id) {
				queue.offer(e);
			}
			map.put(e.id, e);
		}
		while (!queue.isEmpty()) {
			Employee e = queue.poll();
			result += e.importance;
			for (Integer sub: e.subordinates) {
				queue.offer(map.get(sub));
			}
		}
		return result;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeImportance result = new EmployeeImportance();
		Employee e1 = new Employee(1, 5, new ArrayList<Integer>(Arrays.asList(2, 3)));
		Employee e2 = new Employee(2, 3, new ArrayList<Integer>());
		Employee e3 = new Employee(3, 3, new ArrayList<Integer>());
		List<Employee> list = new ArrayList<>(Arrays.asList(e1, e2, e3));
		System.out.println(result.employeeImportance(list, 1));
	}

}
