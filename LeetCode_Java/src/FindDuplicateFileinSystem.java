import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of directory info including directory path, and all the files with contents in this 
 * directory, you need to find out all the groups of duplicate files in the file system in terms of 
 * their paths.
 * A group of duplicate files consists of at least two files that have exactly the same content.
 * A single directory info string in the input list has the following format:
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... 
 * fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, 
 * it means the directory is just the root directory.
 * The output is a list of group of duplicate file paths. For each group, it contains all the file 
 * paths of the files that have the same content. A file path is a string that has the following format:
 * "directory_path/file_name.txt"
 * Example 1:
 * Input:
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * Output:  
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * Note:
 * 1. No order is required for the final output.
 * 2. You may assume the directory name, file name and file content only has letters and digits, and 
 *    the length of file content is in the range of [1,50].
 * 3. The number of files given is in the range of [1,20000].
 * 4. You may assume no files or directories share the same name in the same directory.
 * 5. You may assume each given directory info represents a unique directory. Directory path and 
 *    file info are separated by a single blank space.
 * Follow-up beyond contest:
 * 1. Imagine you are given a real file system, how will you search files? DFS or BFS?
 * 2. If the file content is very large (GB level), how will you modify your solution?
 * 3. If you can only read the file by 1kb each time, how will you modify your solution?
 * 4. What is the time complexity of your modified solution? What is the most time-consuming part 
 *    and memory consuming part of it? How to optimize?
 * 5. How to make sure the duplicated files you find are not false positive?
 * @author wendi
 *
 */
public class FindDuplicateFileinSystem {
	
	
	/**
	 * HashMap
	 * 1. obtain the directory paths, the file names and their contents separately by 
	 *    splitting each string in the given paths. In order to find the files with duplicate contents, 
	 *    we make use of a HashMap map, which stores the data in the form {contents, [filePath1,filePath2..]}.
	 * 2. find out the contents corresponding to which at least two file paths exist, store it
	 *    in res list.
	 * @param String[] paths
	 * @return List<List<String>>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<String>> findDuplicateFileinSystem(String[] paths) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String path: paths) {
			String[] files = path.split(" ");
			for (int i = 1; i < files.length; i++) {
				String[] content = files[i].split("\\(|\\)");
				String filePath = files[0] + "/" + content[0];
				if (!map.containsKey(content[1])) map.put(content[1], new ArrayList<String>());
				map.get(content[1]).add(filePath);
			}
		}
		for (List<String> list: map.values()) {
			if (list.size() > 1) res.add(list);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindDuplicateFileinSystem result = new FindDuplicateFileinSystem();
		System.out.println(result.findDuplicateFileinSystem( new String[] 
			{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
	}

}
