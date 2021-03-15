package _65_不用加减乘除做加法;

/**
 * 题目：
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Solution {
	/**
	 * 力扣Krahets思路：
	 * 不能用加减乘除——>回到本质！位运算！
	 * 举例分析：
	 * 数字	二进制
	 * 4	0100
	 * 6	0110
	 * ---------
	 * 相加后各位情况(不算进位的情况)
	 * 		0010
	 * 进位情况
	 * 		1000
	 * ---------
	 * 相或	1010=10
	 * 【con】
	 * 1.相加后（不算进位）：每位的结果<=>按位异或^
	 * 2.进位：			每位的进位<=>按位与&
	 * 3.再把上面两步的结果相加即可
	 * 【HDP.计算机中使用补码！补码的加减法处理方式一样！即减法也同样适用！(因为CPU只有加法器！)】
	 */
	public int add(int a,int b) {
//		int sum1 = a^b;//不包含进位的各位信息
//		int carry = a&b;//进位信息
//		carry <<= 1;
//		while(carry!=0) {
//			//【WRONG POINT.这里注意在计算carry的时候，sum1已经更新了..所以会出错！所以要预先保存一个tmp！】
//			int tmps = sum1;
//			sum1 = sum1^carry;
//			carry = tmps&carry;
//			carry <<= 1;
//		}
//		return sum1;
		
//		//别人的更简洁写法1.
//		while(b!=0) {//把b用作记录进位
//			int s = a^b;//不含进位的各位
//			b = (a&b)<<1;//b更新为进位
//			a = s;//必须用s做temp，不然无论先更新a还是b，都会影响另一个的计算！
//		}
//		return a;
		
		//简介写法把进位存进tmp
		while(b!=0) {
			int c = (a&b)<<1;
			a = a^b;
			b = c;
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().add(-1, 2));
	}
}
