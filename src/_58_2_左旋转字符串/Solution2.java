package _58_2_左旋转字符串;

public class Solution2 {
	/**
	 * 剑指offer思路：【0ms 100%】
	 * 和反转单词顺序一个道理！
	 * 1.先按照要旋转过去的字符串长度切块
	 * 2.再交换两个子串的位置即可
	 * 
	 * 如果规定不能切片，那就遍历插入
	 */
	public String reverseLeftWords(String s, int n) {
		return s.substring(n, s.length())+s.substring(0, n);
    }
}
