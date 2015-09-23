import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Merge two given sorted integer array A and B into a new sorted integer array.
//
//Have you met this question in a real interview? Yes
//Example
//A=[1,2,3,4]
//
//B=[2,4,5,6]
//
//return [1,2,2,3,4,4,5,6]
//
//Challenge
//How can you optimize your algorithm 
//if one array is very large and the other is very small?


public class MergeSortedArrayII {
	
	public ArrayList<Integer> mergeSortedArrayII(ArrayList<Integer> A, ArrayList<Integer> B) {
		for (int i = 0; i < B.size(); i ++) {
			A.add(B.get(i));
		}
		Collections.sort(A);
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArrayII result = new MergeSortedArrayII();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 4, 5, 6));
		System.out.println(result.mergeSortedArrayII(A, B));
 
	}

}
