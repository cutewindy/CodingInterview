/**
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  
 * The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of 
 * bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of 
 * them instead, and won't eat any more bananas during this hour.
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come 
 * back.
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * Example 1:
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * Note:
 * 1. 1 <= piles.length <= 10^4
 * 2. piles.length <= H <= 10^9
 * 3. 1 <= piles[i] <= 10^9
 * @author wendi
 *
 */
public class KokoEatingBananas {
		
	
	/**
	 * Binary Search
	 * 1. 想一下K的可能的取值范围，当H无穷大的时候，科科有充足的时间去吃，那么就可以每小时只吃一根，也可以吃完，所以K的最小
	 * 取值是1。那么当H最小，等于N时，那么一个小时内必须吃完任意一堆，那么K值就应该是香蕉最多的那一堆的个数.
	 * 2. 当求出了 mid 之后，需要统计用该速度吃完所有的香蕉堆所需要的时间，统计的方法就是遍历每堆的香蕉个数，然后算吃完该堆
	 * 要的时间.
	 * 3. 算出需要的总时间后去跟H比较，若大于H，说明吃的速度慢了，需要加快速度，所以 left 更新为 mid ，否则 right 更新为 mid
	 * @param int[] piles, int H
	 * @return int
	 * Time: O(nlog(m)) m = max num of banana in piles
	 * Space: O(1)
	 */
    public int kokoEatingBananas(int[] piles, int H) {
        int max = 0;
        for (int p: piles) max = Math.max(p, max);
        int s = 1;
        int e = max;
        while (s + 1 < e) {
            int mid = s + (e - s) / 2;
            int h = getH(piles, mid);
            if (h > H) s = mid;
            else e = mid; // include h == H, find left most
        }
        if (getH(piles, s) <= H) return s;
        return e;
    }
    
    private int getH(int[] piles, int k) {
        int h = 0;
        for (int p: piles) {
            h += p / k + (p % k == 0 ? 0 : 1);
        }
        return h;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KokoEatingBananas result = new KokoEatingBananas();
		System.out.println(result.kokoEatingBananas(new int[] {30,11,23,4,20}, 6));
	}

}
