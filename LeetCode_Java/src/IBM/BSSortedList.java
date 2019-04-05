package IBM;
/**
 * 你得到了一个药名的超长清单（sorted list），先把它存起来，然后之后会按照这个清单多次查询想要的药名。查询方式是，给prefix，
 * 比如要找“ab”开头的药，和期待得到的药的数量，比如要找所有符合条件的前十个药。返回一个符合要求的药的list
解法：存起来其实就是给class写一个构造函数，把这个传入的list付给一个instance就行。查的时候binary search搜就成。我还补了
一句，如果是无序的药单，可以在存的时候建一个trie，看起来老爷爷比较满意。
 * @author wendi
 *
 */
public class BSSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
bc

range
lowerbound~upperbound
2-8
4-6

unordered input:
sort: time: O(nlogn) space: O(n)
trie: time: O(n) space: O(n)

--
aba
abb
bcc
fcc
zdd
*/

