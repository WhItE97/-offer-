package _05_替换空格;

public class Solution {
/**
 * 题目：
 * 把一个字符串空格全换成%20
 * 思路：
 * 变StringBuilder
 * 通过charAt遍历每个字符
 * 空格字符调用replace(int start,int end,String s=20%)
 */
	public static void main(String[] args) {
		String s = "We are happy.";
		System.out.println(replaceSpace(s));
	}
	public static String replaceSpace(String s) {
		StringBuilder sb = new StringBuilder(s);
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)==' ') {
				sb.replace(i,i+1,"%20");
			}
		}
		return sb.toString();
	}
}
