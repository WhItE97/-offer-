package _50_��һ��ֻ����һ�ε��ַ�;

import java.util.HashMap;

public class Solution2 {
	/**
	 * ��ָoffer�ⷨ����ʱ�� 35ms 21%  �ռ�75%��
	 * ���������ַ�����1.���ִ�������hashmap2.����ÿ���ַ�����ִ���
	 * [ATT.�ڶ��ֲ��ܱ���hashmap����Ϊmap����!�����Ĳ�һ���ǵ�һ��ֻ����һ�ε��ַ���]
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
