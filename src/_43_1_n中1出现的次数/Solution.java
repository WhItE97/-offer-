package _43_1_n中1出现的次数;

/**
 * 题目：
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 */
public class Solution {
	/**
	 * 力扣Krahets思路：【时间0ms 100%】
	 * cur = ni 为当前位
	 * low = ni-1 ni-2 ... n2 n1 为低位
	 * high = nx nx-1 ... ni+1 为高位
	 * digit = 10^i 为 位因子
	 * 
	 * 根据当前cur值，分3situs：
	 * 1.cur=0：此位1的出现次数只由高位决定——>= high*digit
	 * 2.cur=1：此位1的出现次数——>= high*digit + low + 1
	 * 3.cur=others：此位1的出现次数——>= (high+1)*digit
	 */
	public int countDigitOne(int n) {
		//首先初始化该四个变量
		int high = n/10;
		int cur = n%10;
		int low = 0;
		int digit = 1;//cur从个位开始逐位向前计算
		int res = 0;
		while(high!=0||cur!=0) {//【HDP1.结束条件！】
			//开始就cur值分情况进行计算
			//1.cur==0
			if(cur==0) {
				res += high*digit;
			}
			//2.cur==1
			else if(cur==1) {
				res += high*digit + low + 1;
			}
			//3.cur==others
			else {
				res += (high+1)*digit;//必有cur屁股后面跟的所有都能与cur==1组合，所以前high*digit要加上1个完整的digit
			}
			//更新四个变量值，进入下一轮
			low += cur*digit;
			cur = high%10;
			high = high/10;
			digit *= 10;
		}
		return res;
    }
}
