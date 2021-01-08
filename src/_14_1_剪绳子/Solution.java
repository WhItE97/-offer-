package _14_1_剪绳子;

public class Solution {
/**
 * 题目：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * (没有指定剪的次数！)
 */
/**
 * self思路：
 * “最大”——>dp问题
 * 状态：绳子的剩余长度
 * 选择：剪掉的长度
 * (长度默认n>1了)
 */
	public int cuttingRope(int n) {
		return dp(n,new int[n+1]);
	}
	
	/**
	 * @param n：总长度
	 * @param res[i]：总长度为n的绳子的最大乘积
	 * 状态转移方程：【WRONG,见Solution2】
	 * f(s) = f(s-len)*len【从状态转移方程这里开始错了..】
	 * len=[1,2,...,n-1]
	 * f(s) = max(len=[1,2,...,n-1]){len*f(s-len)}
	 */
	public int dp(int n,int[] res) {
		if(n<2) {
			return 1;
		}
		if(n==2) {
			//2只能剪一次，且最大=1x1
			res[2] = 1;//类似dp[0]
			return res[2];
		}
		if(res[n]!=0) {//先查表，没有再计算
			return res[n];
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n-1;i++) {//遍历绳子可以剪的所有长度选择，用res记录，每次先查表
			if(n-i<1) {//如果剩余绳子长度-i的长度已经比1还小了，那就裁剪不了了！
				break;
			}
			max = Math.max(max, i*dp(n-i,res));
		}
		return max;
	}
}
