import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given several logs that each log contains a unique id and timestamp. Timestamp is a 
 * string that has the following format: Year:Month:Day:Hour:Minute:Second, for example, 
 * 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.
 * Design a log storage system to implement the following functions:
 * void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your 
 * storage system.
 * int[] Retrieve(String start, String end, String granularity): Return the id of logs whose 
 * timestamps are within the range from start to end. Start and end all have the same format as 
 * timestamp. However, granularity means the time level for consideration. For example, start = 
 * "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to 
 * find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.
 * Example 1:
 * put(1, "2017:01:01:23:59:59");
 * put(2, "2017:01:01:22:59:59");
 * put(3, "2016:01:01:00:00:00");
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need 
 * to return all logs within 2016 and 2017.
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need 
 * to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
 * Note:
 * 1. There will be at most 300 operations of Put or Retrieve.
 * 2. Year ranges from [2000,2017]. Hour ranges from [00,23].
 * 3. Output for Retrieve has no order required.
 * @author wendi
 *
 */
public class DesignLogStorageSystem {
	
    Map<Integer, String> timestamps; // [id, timestamp]
    Map<String, Integer> endIndexes; // [granularity, end index in timestamp]
    public DesignLogStorageSystem() {
        this.timestamps = new HashMap<>();
        this.endIndexes = new HashMap<>();
        endIndexes.put("Year", 4);
        endIndexes.put("Month", 7);
        endIndexes.put("Day", 10);
        endIndexes.put("Hour", 13);
        endIndexes.put("Minute", 16);
        endIndexes.put("Second", 19);
    }
    
    /**
     * @param id, String timestamp
     * Time: O(1)
     */
    public void put(int id, String timestamp) {
        timestamps.put(id, timestamp);
    }
    
    /**
     * HashMap
     * @param String s, String e, String gra
     * @return List<Integer>
     * Time: O(n)
     */
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        int endIndex = endIndexes.get(gra);
        s = s.substring(0, endIndex);
        e = e.substring(0, endIndex);
        for (Integer id: timestamps.keySet()) {
            String timestamp = timestamps.get(id).substring(0, endIndex);
            if (timestamp.compareTo(s) >= 0 && timestamp.compareTo(e) <= 0) res.add(id);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignLogStorageSystem result = new DesignLogStorageSystem();
		result.put(1, "2017:01:01:23:59:59");
		result.put(2, "2017:01:01:22:59:59");
		result.put(3, "2016:01:01:00:00:00");
		System.out.println(result.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"));
		System.out.println(result.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"));
	}

}
