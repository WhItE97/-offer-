package _48_最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
	/**
	 * 力扣Krahets思路：【7ms 81%】
	 * 自己的dp实现每轮都要手动往前遍历搜索该字符上一次出现的位置（记为pre）
	 * 但这个O(N)的搜索行为可以通过hashmap简化！【更甚者：因为ASCII码只有128个——>用arr[128]比hashmap更快！】
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {//base case
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;//1个字符的时候
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put(s.charAt(0), 0);
		int max = dp[0];
		for(int i=1;i<dp.length;i++) {
			//首先查本轮的元素上一次最近出现的位置
			int pre = map.getOrDefault(s.charAt(i), -1);//【如果没有该key，不会存入key和default value的键值对，只会返回default value！】【get()如果没有该key，会直接返回null！】
			//1.如果没有出现过
			if(pre==-1) {
				//首先要把这次出现的位置更新进去
				map.put(s.charAt(i), i);
				//计算dp
				dp[i] = dp[i-1]+1;
			}
			//2.如果出现过
			else {
				//2.1.如果最近一次出现在dp[i-1]子串内
				if((i-pre)<=dp[i-1]) {
					dp[i] = i-pre;
				}
				//2.2.如果最近一次出现在dp[i-1]子串外
				else {
					dp[i] = dp[i-1]+1;
				}
				//【ATT.不要忘了更新新出现的位置】
				map.replace(s.charAt(i), i);
			}
			//更新max值
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		return max;
    }
}
