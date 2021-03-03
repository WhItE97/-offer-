package _44_数字序列中某一位的数字;

/**
 * 题目：
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 */
public class Solution {
	/**
	 * self思路：
	 * 先求第n位对应的数字有几位数
	 * 0~9 10位
	 * 10~99 2*90=180位
	 * 100~999 3*900=2700位...【大体对..但是没总结规律和实现思路】
	 * 
	 * 力扣Krahets思路：【时间 0ms 100%】
	 * 一、原理
	 * 1.101112...中的每一位称为数位，记作n
	 * 2.10,11,12...称为数字，记作num
	 * 3.数字10是一个2位数，称此数字的位数为2，称为digit
	 * 4.每digit位数的起始数字（即1,10,100...），记作start
	 * 可以推导出不同位数的数字所对应的数位范围
	 * 有：
	 * 数字范围start~end（digit位数）的1.数字数量=9*start 2.数位数量=9*start*digit
	 * 二、steps
	 * 1.确定n所在数字的位数（digit）
	 * 2.确定n所在的数字（num）
	 * 3.确定n是num中的哪一数位，返回结果
	 */
	public int findNthDigit(int n) {
		int digit = 1;
		long start = 1;//【HDP 1.start和count可能越界！！】
		long count = 9;
		while(n>count) {
			n -= count;
			digit += 1;
			start *= 10;
			count = 9*digit*start;
		}
		long num = start + (n-1)/digit;//【HDP 2.下标从0开始！所以当前位数-1！】
		return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}
