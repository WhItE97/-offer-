package _49_丑数;

/**
 * 题目：
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * self补充：
 * 质因子的定义是：包含质因子2，3，5则该数可以被2，3，5作除数的若干次除法
 */
public class Solution {
	/**
	 * self思路：
	 * 枚举..【计算了很多不必要的非丑数】
	 * 
	 * 力扣Krahets思路：【3ms 70%】
	 * 【dp！】
	 * dp[i]:第i+1个丑数
	 * 【HDP.分析：】
	 * 1.就dp[i+1]，有:dp[i+1]=min{dp[a]*2,dp[b]*3,dp[c]*5};其中0≤a,b,c≤i
	 * 2.为了保证dp[i+1]是第一个大于dp[i]的丑数，还需要保证:
	 * (1)2*dp[a-1]<=dp[i]<2*dp[a]
	 * (2)3*dp[b-1]<=dp[i]<3*dp[b]
	 * (3)5*dp[c-1]<=dp[i]<5*dp[c]
	 * 所以状态转移方程
	 */
	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int a=0;
		int b=0;
		int c=0;
		for(int i=1;i<n;i++) {
			int aa = 2*dp[a];
			int bb = 3*dp[b];
			int cc = 5*dp[c];
			//【HDP.每轮dp a,b,c的变化——>因为用了该位置，所以依次往后挪一位即可！（可以从转移方程中的不等式两端看出）】
			dp[i] = Math.min(Math.min(aa, bb), cc);
			if(dp[i]==aa) {
				a++;
			}
			if(dp[i]==bb) {
				b++;
			}
			if(dp[i]==cc) {
				c++;
			}
		}
		return dp[n-1];
    }
}
