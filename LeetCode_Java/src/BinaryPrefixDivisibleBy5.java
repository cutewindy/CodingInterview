import java.util.ArrayList;
import java.util.List;


public class BinaryPrefixDivisibleBy5 {
	
	/**
	 * Use the fact that (ab + c)%d is same as ((a%d)(b%d) + c%d)%d.
	 * We now have the relation new_number%5 = ((old_number%5)*2 + d)%5;
	 * @param int[] A
	 * @return List<Boolean>
	 * Time: O(n)
	 * Space: O(1)
	 */
    public List<Boolean> binaryPrefixDivisibleBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int curr = 0;
        for (int a: A) {
            curr = (curr * 2 + a) % 5;
            if (curr % 5 == 0) res.add(true);
            else res.add(false);
        }
        return res;       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryPrefixDivisibleBy5 result = new BinaryPrefixDivisibleBy5();
		System.out.println(result.binaryPrefixDivisibleBy5(new int[] {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
	}

}
