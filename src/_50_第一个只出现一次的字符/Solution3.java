package _50_��һ��ֻ����һ�ε��ַ�;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Solution3 {
	/**
	 * ��ָoffer�ⷨ��������ʱ�� 34ms 22%(����ͨ��hashmap��಻��...)  �ռ�83%��
	 * ����hashmap��->LinkedHashMap����HashMap�����࣬ʵ���˲���˳�������HashMap��
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
