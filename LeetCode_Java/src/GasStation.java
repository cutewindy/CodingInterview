/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise 
 * return -1.
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * Tags: Greedy
 * @author wendi
 *
 */
public class GasStation {
	
	/**
	 * Greedy: 
	 * 1. If tank < 0, the station before tank(include) cannot be begin.
	 * 2. If sum < 0, no matter where is begin, cannot traverse all stations, return -1.
	 * @param int[] gas, int[] cost
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int gasStation(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length) {
			return 0;
		}
		int index = 0;
		int tank = 0;
		int sum = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if (tank < 0) {
				index = i + 1;
				tank = 0;
			}
		}
		return sum < 0 ? -1 : index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation result = new GasStation();
		System.out.println(result.gasStation(new int[] {4, 2, 3, 6, 1},  new int[] {3, 3, 5, 1, 2}));
	}

}
