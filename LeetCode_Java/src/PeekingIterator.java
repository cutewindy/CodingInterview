import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a 
 * PeekingIterator that support the peek() operation -- it essentially peek() at the element that 
 * will be returned by the next call to next().
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that 
 * should return false.
 * Hint:
 * 1. Think of "looking ahead". You want to cache the next element.
 * 2. Is one variable sufficient? Why or why not?
 * 3. Test your design with call order of peek() before next() vs next() before peek().
 * 4. For a clean implementation, check out Google's guava library source code.
 * 5. Follow up: How would you extend your design to be generic and work with all types, not just 
 * integer?
 * 
 * Tags: Design
 * @author wendi
 *
 */
public class PeekingIterator implements Iterator<Integer>{
    private Iterator<Integer> it;
    private Integer peek;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    this.peek = it.hasNext() ? it.next() : null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer curr = peek;
	    peek = it.hasNext() ? it.next() : null;
	    return curr;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
	
	@Override
	public void remove() {
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> it = list.iterator();
		PeekingIterator pit = new PeekingIterator(it);
		System.out.println(pit.peek());
		if (pit.hasNext()) {
			pit.next();
		}
		System.out.println(pit.peek);
		pit.next();
		System.out.println(pit.next());
		System.out.println(pit.hasNext());
	}

}