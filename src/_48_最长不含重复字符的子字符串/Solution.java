package _48_最长不含重复字符的子字符串;

/**
 * 题目：
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Solution {
	/**
	 * self思路：【dp是对了，但是dp[i]如果取这个含义，就没法写出状态转移方程...——>剑指offer思路如第16行起】
	 * “最长”——>dp！
	 * dp[i]:截至第i个字符的最长子字符串长
	 * dp[0] = 0;dp[1] = 1
	 * 状态转移方程
	 * dp[i] = str[i]...【似乎走不下去了】
	 * 
	 * 剑指offer思路：【19ms 10%...】
	 * dp[i]:【以第i个字符结尾】的字符串的不含重复字符的最长子串长【ATT.必须是以第i个字符收尾！而不能是第i个字符之前的子串】
	 * dp[0]=1
	 * 【HDP.状态转移方程】
	 * 1.如果第i个字符前面没出现过：dp[i]=dp[i-1]+1（以str[i]结尾，所以直接+1即可）
	 * 2.如果前面出现过——>【MOST HHHHDP.出现的位置在dp[i-1]子串内or外！】
	 * （1）如果上一次出现的位置在dp[i-1]子串内：找到该位置pre——>dp[i]=i-pre
	 * （2）如果上一次出现的位置在dp[i-1]子串外：（以str[i]结尾，所以太远的影响不了这里）——>dp[i]=dp[i-1]+1
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {//base case
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;//dp[0]——>首个字符的dp
		int max = dp[0];
		for(int i=1;i<dp.length;i++) {
			//首先从当前位置向前检索本轮的字符，求出其上一次出现的最近的位置pre（没出现则=-1）
			int pre = -1;
			for(int j=i-1;j>=0;j--) {
				if(s.charAt(j)==s.charAt(i)) {
					pre = j;//找到了，修改pre
					break;//【ATT.第一次写的错误点！找到了最近的记得break啊！不然又要继续找下去了..】
				}
			}
			//开始写状态转移方程
			//1.本轮的字符s[i]没出现过
			if(pre==-1) {
				dp[i] = dp[i-1]+1;
			}
			//2.本轮的字符出现过
			//2.1.上一次出现的位置在dp[i-1]子串内
			else if((i-pre)<=dp[i-1]) {
				dp[i] = i-pre;
			}
			//2.2.上一次出现的位置在dp[i-1]子串外
			else {
				dp[i] = dp[i-1]+1;
			}
			//【HDP.和一半的dp不同来了，这里的dp数组，只是以第i个字符为字符的长度；所以我们还需要求一个max！】
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		return max;
    }
}
