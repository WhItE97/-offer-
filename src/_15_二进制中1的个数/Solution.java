package _15_二进制中1的个数;

public class Solution {
/**
 * 题目：
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中1的个数。例如，把9表示成二进制是1001，有2位是 1。因此，如果输入9，则该函数输出2。
 */
/**
 * self思路：
 * 转二进制遍历count..
 */
	public int hanmingWeight(int n) {
		//you need to treat n as an unsigned value
		//先把n变成二进制字符串
		String res = Integer.toBinaryString(n);
		int count = 0;
		for(int i=0;i<res.length();i++) {
			if(res.charAt(i)=='1') {
				count++;
			}
		}
		return count;
	}
}
