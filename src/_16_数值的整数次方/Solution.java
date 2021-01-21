package _16_数值的整数次方;

//这是自己的递归写法..总还是不想用递归——>见Solution2
/**
 * 题目：
 * 求x的n次方，不能用库函数，不需要考虑大数问题
 */
/**
 * self思路：
 * 1.首先要考虑边界值，如0的0次方无意义！
 * 2.指数可能为正为负！（int为负要变正——>考虑MIN_VALUE越界问题！）
 * 3.优化：
 * 	(1)x^n=x^(n/2)*x^(n/2),n=偶数 //java中^是按位异或！
 * 	(2)x^n=x^(n-1/2)*x^(n-1/2)*x,n=奇数
 * 4.【WRONG POINT】在把指数转为正数计算时，没考虑到n=Integer.MIN_VALUE!!
 * 会溢出！涉及到int变负的一定记得转换为long再变正！
 */
/**
 * HDP:Java中float和double不能直接进行运算！(但leetcode上好像没care...)
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.myPow(2, 10));
	}
	
	public double myPow(double x,int n) {
		long n1 = n;
		boolean flag = false;//flag为true代表指数为负数，最后要取倒数
		if(n1==0) {
			if(x==0) {
				System.out.println("没有意义");
				return 0.0;
			}
			return 0.0;
		}
		if(x==1) {
			return 1;
		}
		//如果指数为负数，则先要取绝对值，进行次方计算，最后再取倒return
		if(n1<0) {
			n1 = -n1;//考虑到Integer.MIN_VALUE——>用long来装
			flag = true;
		}
		
		double res = unsignedMyPow(x,n1);
		if(flag) {
			res = 1/res;
		}
		return res;
	}

	public double unsignedMyPow(double x,long n) {//输入的n一定为>0的数，自底向上求次方，类似Fibonacci
		//base
		if(n==1) {
			return x;
		}
		if(n%2==0) {//偶次方
			double res = unsignedMyPow(x,n>>1);
			res *= res;//imp trick！减少一半计算量！
			return res;
		}
		else {//奇次方
			double res = unsignedMyPow(x,n>>1);
			res = res*res*x;
			return res;
		}
	}
}
