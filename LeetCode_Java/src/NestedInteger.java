import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
	
	private List<NestedInteger> list;
	private Integer integer;
	
	// Constructor initializes an empty nested list.
	public NestedInteger() {
		this.list = new ArrayList<>();
	}
	 
	// Constructor initializes a single integer.
	public NestedInteger(int value) {
		this.integer = value;
	}
	
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger() {
		return this.integer != null;
	}
	
	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return isInteger() ? this.integer : null; 
	}
	
	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
		this.integer = value;
	}

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni) {
		if (this.list == null) {
			this.list = new ArrayList<>();
		}
		this.list.add(ni);
	}
	 
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		if (isInteger()) {
			return null;
		}
		else {
			return this.list;
		}
	}	
	
	
	public static String printNL(List<NestedInteger> nestedInteger) {
		StringBuilder sb = new StringBuilder();
		for (NestedInteger n: nestedInteger) {
			sb.append("[");
			if (n.isInteger()) {
				sb.append(n.getInteger()).append(",");
			}
			else printNL(n.getList());
			sb.append("]");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedInteger list1 = new NestedInteger();
		list1.add(new NestedInteger(1));
		list1.add(new NestedInteger(1));
		NestedInteger list2 = new NestedInteger();
		list2.add(new NestedInteger(1));
		list2.add(new NestedInteger(1));
		List<NestedInteger> nestedInteger = new ArrayList<>();
		nestedInteger.add(list1);
		nestedInteger.add(new NestedInteger(2));
		nestedInteger.add(list2);
		System.out.println(NestedInteger.printNL(nestedInteger));
	}

}
