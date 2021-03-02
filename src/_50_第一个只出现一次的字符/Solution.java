package _50_第一个只出现一次的字符;

/**
 * 题目：
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Solution {
	/**
	 * self思路：【时间 164ms 5.43% ...空间70%】
	 * 用StringBuilder，从第一个字符开始遍历，如果其出现了不止1次，则遍历完该轮，删除所有该字符
	 * 直到找到一个遍历中只出现过一次的字符
	 */
	public char firstUniqChar(String s) {
		StringBuilder sb = new StringBuilder(s);
		int count = 0;
		while(sb.length()>1) {//循环结束条件：sb的length<=1了
			count = 0;
			char c = sb.charAt(0);
			for(int i=1;i<sb.length();i++) {//对本轮的sb的首字符进行match
				if(sb.charAt(i)==c) {
					sb.deleteCharAt(i);
					count++;
					i--;
				}
			}
			//注意，如果重复，遍历完后需要把首字符删掉
			if(count>0) {
				sb.deleteCharAt(0);
			}
			//检查该轮的字符是否有重复，如果没有，则找到
			else{
				return c;
			}
		}
		if(sb.length()==0) {//都删完了还没找到or输入空字符串
			return ' ';
		}
		return sb.charAt(0);
    }
}
