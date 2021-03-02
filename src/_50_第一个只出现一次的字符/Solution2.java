package _50_第一个只出现一次的字符;

import java.util.HashMap;

public class Solution2 {
	/**
	 * 剑指offer解法：【时间 35ms 21%  空间75%】
	 * 遍历两轮字符串，1.出现次数计入hashmap2.遍历每个字符查出现次数
	 * [ATT.第二轮不能遍历hashmap！因为map无序!出来的不一定是第一个只出现一次的字符！]
	 */
	public char firstUniqChar(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i))==1) {
				return s.charAt(i);
			}
		}
		return ' ';
	}
}
