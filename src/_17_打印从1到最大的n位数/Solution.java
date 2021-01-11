package _17_打印从1到最大的n位数;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.printNumbers(1)));
	}
/**
 * 题目：
 * 顺序打印从1到最大的n位十进制数
 * 
 * leetcode这里用int[]返回，所以默认限制在int范围内了..
 * 实际上考点在于【大数】！
 * 你并不知道面试官会给你一个多大的n！这个n位数甚至可能超过了long的范围！【int 32位，long 64位：18 446 744 073 709 551 615=20位】
 * 解法见Solution2
 */
	public int[] printNumbers(int n) {
		int[] arr = new int[(int)Math.pow(10, n)-1];
		for(int i=0;i<Math.pow(10, n)-1;i++) {
			arr[i] = i+1;
		}
		return arr;
	}
}
