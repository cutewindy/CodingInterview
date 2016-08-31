import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list 
 * primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of 
 * the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * 
 * Tags: Math, Heap
 * @author wendi
 *
 */
public class SuperUglyNumber {

	/**
	 * Method2: Heap: Using heap instead of Math.min to improve speed
	 * @param int n, int[] primes
	 * @return int
	 * Time: O(log(k) * n) k is length of primes
	 * Space: O(k + n)
	 */
	class Num {
		int value;
		int index;
		int prime;
		
		public Num(int value, int index, int prime) {
			this.value = value;
			this.index = index;
			this.prime = prime;
		}
		
//		@Override
//		public int compareTo(Num that) {
//			return this.value - that.value;
//		}
	}
	
	public int superUglyNumberI(int n, int[] primes) {
		if (n <= 0 || primes == null || primes.length == 0) {
			return -1;
		}
		int[] superUgly = new int[n];
		superUgly[0] = 1;
		PriorityQueue<Num> heap = new PriorityQueue<>(primes.length, new Comparator<Num>(){
			@Override
			public int compare(Num a, Num b) {
				return a.value - b.value;
			}
		});		
		for (int prime: primes) {
			heap.offer(new Num(prime, 0, prime));
		}
		for (int i = 1; i < n; i++) {
			superUgly[i] = heap.peek().value;
			while (heap.peek().value == superUgly[i]) {
				Num pop = heap.poll();
				heap.offer(new Num(pop.prime * superUgly[pop.index + 1], pop.index + 1, pop.prime));
			}
		}	
		return superUgly[n - 1];
	}
	
	
	
	
	/**
	 * Method1: DP: like "Ugly Number II", using array index to instead pointers i2, i3 and i5.
	 * @param int n, int[] primes
	 * @return int
	 * Time: O(kn) k is length of primes
	 * Space: O(n)
	 */
	public int superUglyNumber(int n, int[] primes) {
		if (n <= 0 || primes == null || primes.length == 0) {
			return -1;
		}
		int[] superUgly = new int[n];
		superUgly[0] = 1;
		int[] index = new int[primes.length];
		for (int i = 1; i < n; i++) {
			int curr = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				while (primes[j] * superUgly[index[j]] <= superUgly[i - 1]) {
					index[j]++;
				}
				curr = Math.min(primes[j] * superUgly[index[j]], curr);
			}
			superUgly[i] = curr;
		}
		return superUgly[n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperUglyNumber result = new SuperUglyNumber();
		System.out.println(result.superUglyNumber(7, new int[] {2, 7, 13, 19}));
		System.out.println(result.superUglyNumberI(7, new int[] {2, 7, 13, 19}));
	}

}
