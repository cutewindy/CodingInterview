package IBM;
/**
 * 给一个unsigned int i，判断这个数是否是power of 2
    followup： i 是a的b次方吗， ab都是正整数
 * @author wendi
 *
 */
public class IsPowerof2 {
	
	
	public boolean isPowerof2(int x) {
		for (int i = 1; i * i <= x; i++) {
			if (i * i == x) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unsigned in
	}

}
return numOnes(x) == 1

int numOnes = 0;
while (x != 0) {
	x &= (x - 1);
	numOnes++;
}
return numOnes;


0b1000
  0111
  0000
  3210