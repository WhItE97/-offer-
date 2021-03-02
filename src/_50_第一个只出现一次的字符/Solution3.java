package _50_第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Solution3 {
	/**
	 * 剑指offer解法衍生：【时间 34ms 22%(和普通的hashmap差距不大...)  空间83%】
	 * 有序！hashmap！->LinkedHashMap！（HashMap的子类，实现了插入顺序遍历的HashMap）
	 */
	public char firstUniqChar(String s) {
		HashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		Iterator<Character> it = map.keySet().iterator();
		while(it.hasNext()) {
			char c = it.next();
			if(map.get(c)==1) {
				return c;
			}
		}
		return ' ';
	}
}
