package _14_2_剪绳子2;

public class Solution {
/**
 * 绳子长度从[2,58]——>[2,1000]
 * 并且答案需要取模1e9+7
 * ——>已经无法再用结果来取max了(所以之前的dp已经不行了，好像可以用什么大数运算..没看)
 * ——>分析数学规律——>发现可以用贪心算法！
 */
/**
 * 剑指offer思路：贪心算法
 * n>=5时：
 * 	尽可能剪成长度=3的段
 * n==4时：
 * 	剪成2*2的段
 * 
 * 数学证明：
 * 1.首先是两个特殊点（即不剪比剪了的最大乘积还要大的点）
 * ①n==2 max=1
 * ②n==3 max=2
 * 再往下的点，剪了后的最大乘积一定>=不剪的长度
 * 所以以2和3做剪裁的基本单位来数学分析
 * 2.f(s) = len*f(s-len)
 * len=2有：
 * 		2*(n-2)要想>n
 * 		n>4
 * len=3有:
 * 		3*(n-3)要想>不剪的n
 * 		n>4.5
 * 取n>=5时：
 * 		尝试以2和3做剪裁单位来剪裁
 * 		3(n-3)>=2(n-2) when n>=5
 * 3.结论：所以在n>=5的时候尽量全以3为单位裁剪！
 * 		  n==4的时候以2为单位裁剪
 */
	public int cuttingRope(int n) {
		if(n<2) {
			return 0;
		}
		if(n==2) {
			return 1;
		}
		if(n==3) {
			return 2;
		}
		int timesof3=n/3;
		if(n-3*timesof3==1) {
			//如果余1，回退一个3，构成2x2>1x3
			timesof3--;
		}
		int timesof2 = (n-3*timesof3)/2;
		//会越界，所以再写一个函数变long计算余数
		return result(timesof3,timesof2);
	}
	
	public int result(int a,int b) {
		long res = 1;
		while(a>0) {
			res *= 3;
			res %= 1000000007;
			a--;
		}
		while(b>0) {
			res *= 2;
			res %= 1000000007;
			b--;
		}
		return (int)res;
	}
}
