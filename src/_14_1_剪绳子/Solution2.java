package _14_1_剪绳子;

import java.util.Arrays;

public class Solution2 {
/**
 * 自己的思路
 * wrong point①状态转移方程：
 * f(s) = f(i)*f(s-i)
 * ATT：之前自己列的i*f(s-i)
 * wrong point②没有考虑到几个特殊的初始状态作为主体输入or主体的一部分，其max不同！
 * （体现为：dp[1]=1，但输入n=1，return 0
 * 		  dp[2]=2（不切），但输入n=2，return 1(切一刀)
 * 		  dp[3]=3（不切），但输入n=3，return 2(切一刀)
 * 从dp[4]开始，其dp值就和return值一样了（都>=他本身不切的长度）！
 * ）
 */
	public int cuttingRope(int n) {
		if(n<2) {
			return 0;//没法切
		}
		if(n==2) {
			return 1;
		}
		if(n==3) {
			return 2;
		}
		//从4开始，切割后的值就>=本身了，所以自底向上dp求max即可
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i=4;i<=n;i++) {//自底向上求i长度对应的乘积max
			int max = Integer.MIN_VALUE;
			for(int j=1;j<=i/2;j++) {//遍历所有可能切割长度（但其实遍历一半即可，超过一半后都是对称的）
				max = Math.max(max, dp[i-j]*dp[j]);
			}
			dp[i] = max;
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
