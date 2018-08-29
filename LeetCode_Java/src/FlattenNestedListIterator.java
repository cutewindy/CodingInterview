import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next 
 * should be: [1,1,2,1,1].
 * Example 2:
 * Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next 
 * should be: [1,4,6].
 * 
 * Tags: Stack, Design
 * @author wendi
 *
 */
public class FlattenNestedListIterator {

	// Approach2: Stack
	Stack<NestedInteger> stack = null;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
    	stack = new Stack<>();
        if (nestedList == null || nestedList.size() == 0) return;
        for (int i = nestedList.size() - 1; i >= 0; i--) {
        	stack.push(nestedList.get(i));
        } 
    }

//    @Override
    public Integer next() {
        if (hasNext()) {
        	return stack.pop().getInteger();
        }
        return null;
    }

//    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
        	if (stack.peek().isInteger()) return true;
        	List<NestedInteger> currList = stack.pop().getList();
            for (int i = currList.size() - 1; i >= 0; i--) {
            	stack.push(currList.get(i));
            } 
        }
        return false;
    }
    
    // Approach1: DFS + list + (Iterator)
//    List<Integer> list;
//    int index;  // Iterator<Integer> it;
//    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
//        list = new ArrayList<>();
//        index = 0;  
//        dfs(nestedList); // it = list.iterator();
//    }
//    
//    private void dfs(List<NestedInteger> nestedList) {
//        if (nestedList == null || nestedList.size() == 0) return;
//        for (NestedInteger value: nestedList) {
//            if (value.isInteger()) {
//                list.add(value.getInteger());
//            }
//            else {
//                dfs(value.getList());
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        if (!hasNext()) return null;
//        return list.get(index++);
//    }
//
//    @Override
//    public boolean hasNext() {
//        return index != list.size();
//    }    

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedInteger list1 = new NestedInteger();
		list1.add(new NestedInteger(1));
		list1.add(new NestedInteger(1));
		NestedInteger list2 = new NestedInteger();
		list2.add(new NestedInteger(1));
		list2.add(new NestedInteger(1));
		List<NestedInteger> nestedList = new ArrayList<>();
		nestedList.add(list1);
		nestedList.add(new NestedInteger(2));
		nestedList.add(list2);		
		NestedInteger.printNL(nestedList);
		FlattenNestedListIterator result = new FlattenNestedListIterator(nestedList);
	}

}
