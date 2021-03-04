package _48_最长不含重复字符的子字符串;

import java.util.Map;
import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(s.lengthOfLongestSubstring("aaabbc"));
		
//		Map<Integer,Integer> map = new HashMap<>();
//		map.put(1, 3);
//		int n = map.getOrDefault(2, 2);//如果没有该key，不会存入key和default value，只会返回default value！
//		System.out.println("n="+n);
//		System.out.println("map.size="+map.size());
//		System.out.println(map.get(2));//如果没有该key，get会直接返回null！
	}

}
