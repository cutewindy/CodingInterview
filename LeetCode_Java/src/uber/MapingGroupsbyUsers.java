package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * // example input:
    private static HashMap<String, String[]> MEMBERS_BY_GROUPS = new HashMap<String, String[]>() {{
        put("Group0", new String[]{"Group3", "User0", "User1"});
        put("Group1", new String[]{"Group3", "User2", "User3"});
        put("Group2", new String[]{"Group3", "Group5", "User4", "User5"});
        put("Group3", new String[]{"Group4", "User6", "User7"});
        put("Group4", new String[]{"User8", "User9"});
        put("Group5", new String[]{"User10", "User11"});
    }};

    // example output
    private static HashMap<String, String[]> GROUPS_BY_USERS = new HashMap<String, String[]>() {{
        put("User6", new String[]{"Group1", "Group0", "Group3", "Group2"});
        put("User7", new String[]{"Group1", "Group0", "Group3", "Group2"});
        put("User4", new String[]{"Group2"});
        put("User5", new String[]{"Group2"});
        put("User2", new String[]{"Group1"});
        put("User3", new String[]{"Group1"});
        put("User0", new String[]{"Group0"});
        put("User1", new String[]{"Group0"});
        put("User8", new String[]{"Group4", "Group1", "Group0", "Group3", "Group2"});
        put("User9", new String[]{"Group4", "Group1", "Group0", "Group3", "Group2"});
        put("User10", new String[]{"Group5", "Group2"});
        put("User11", new String[]{"Group5", "Group2"});
    }};
 * @author wendi
 *
 */
public class MapingGroupsbyUsers {
	
	/**
	 * BFS
	 * @param Map<String, String[]> MEMBERS_BY_GROUPS
	 * @return Map<String, String[]>
	 * Time: O()
	 * Space: O()
	 */
	public Map<String, String[]> mapingGroupsbyUsers(Map<String, String[]> MEMBERS_BY_GROUPS) {
		Map<String, Set<String>> res = new HashMap<>();
		for (String group: MEMBERS_BY_GROUPS.keySet()) {
			Set<String> numbers = getNumbers(group, MEMBERS_BY_GROUPS);
			for (String user: numbers) {
				if (!res.containsKey(user)) res.put(user, new HashSet<String>());
				res.get(user).add(group);
			}
			
		}
		Map<String, String[]> Res = new HashMap<>();
		for (String user: res.keySet()) {
			String[] groups = new String[res.get(user).size()];
			int i = 0;
			for (String group: res.get(user)) {
				groups[i++] = group;
			}
			Res.put(user, groups);
		}
		return Res;
	}
	
	private Set<String> getNumbers(String group, Map<String, String[]> MEMBERS_BY_GROUPS) {
		Set<String> res = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(group);
		Set<String> visited = new HashSet<>();
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			for (String user: MEMBERS_BY_GROUPS.get(curr)) {
				if (visited.contains(user)) continue;
				visited.add(user);
				if (MEMBERS_BY_GROUPS.containsKey(user)) queue.offer(user);
				else res.add(user);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapingGroupsbyUsers result = new MapingGroupsbyUsers();
		Map<String, String[]> MEMBERS_BY_GROUPS = new HashMap<String, String[]>() {{
	        put("Group0", new String[]{"Group3", "User0", "User1"});
	        put("Group1", new String[]{"Group3", "User2", "User3"});
	        put("Group2", new String[]{"Group3", "Group5", "User4", "User5"});
	        put("Group3", new String[]{"Group4", "User6", "User7"});
	        put("Group4", new String[]{"User8", "User9"});
	        put("Group5", new String[]{"User10", "User11"});
	    }};
	    Map<String, String[]> GROUPS_BY_USERS = new HashMap<>();
	    GROUPS_BY_USERS = result.mapingGroupsbyUsers(MEMBERS_BY_GROUPS);
	    for (String user: GROUPS_BY_USERS.keySet()) {
	    	System.out.println(user + ": " + Arrays.toString(GROUPS_BY_USERS.get(user)));
	    }
	}

}
