package google_OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Email处理。 email地址分为local@domain。
 * （1）local里dots('.') between some characters 要去除。
 * （2）local里如果有'+'，'+'和后面的全去除。比如
 * 'a.b@example.com' -> 'ab@example.com', 
 * 'dupli......cate@example.com' -> 'duplicate@example.com',  
 * 'd.u.p.l.i.c.a.t.e@example.com' -> 'duplicate@example.com',  
 * 'ab+work@example.com' -> 'ab@example.com'。
 * 处理完后的邮件地址一样的放在一组，返回所有组，里面不止一个邮件地址的组的个数。
 * 
 * 请问楼主对于第一题...ab@example, ...ab..@example, ...ab..+cd@example应该是什么结果呢？ 前两个不变， ...
 * 不确定，我处理的是前两个不变hh，我觉得都可以吧
 * @author wendi
 *
 */
public class EmailProcess {
	
	/**
	 * 
	 * @param List<String> emails
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int emailProcess(List<String> emails) {
		if (emails == null || emails.size() == 0) return 0;
		Map<String, Integer> cnts = new HashMap<>();
		for (String email: emails) {
			String proEmail = process(email);
			if (!cnts.containsKey(proEmail)) cnts.put(proEmail, 0);
			cnts.put(proEmail, cnts.get(proEmail) + 1);
		}
		
		int res = 0;
		for (Integer cnt: cnts.values()) {
			if (cnt > 1) res++;
		}
		return res;
	}
	
	private String process(String email) {
		String[] parts = email.split("@");
		parts[0] = parts[0].replaceAll("\\.", "");
		for (int i = 0; i < parts[0].length(); i++) {
			if (parts[0].charAt(i) == '+') return parts[0].substring(0, i) + parts[1];
		}
		return parts[0] + parts[1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmailProcess result = new EmailProcess();
		System.out.println(result.emailProcess(new ArrayList<>(Arrays.asList(
				"a.b@example.com", "dupli......cate@example.com", "d.u.p.l.i.c.a.t.e@example.com", "ab+work@example.com"))));
		System.out.println(result.emailProcess(new ArrayList<>(Arrays.asList(
				"...ab@example", "...ab..@example","...ab..+cd@example"))));
	}

}
