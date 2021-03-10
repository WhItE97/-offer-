package _60_n个骰子的点数;

import java.util.Arrays;

public class Solution2 {
	/**
	 * 力扣Krahets思路：【0ms 100%】
	 * 【dp】...!【太难想了..】
	 * 【分析】：
	 * f(n):n个骰子对应的概率列表
	 * f(n,x):前n个骰子，点数和为x的概率
	 * 有状态转移方程：
	 * f(n,x) = Σf(n-1,x-i)*(1/6) i=[1,6]
	 * 
	 * 【ATT HDP.这样的dp x-i可能会越界！】
	 * 考虑每个f(n-1,i)对所有f(n,x)的贡献！（x=i+1,i+2,...,i+6）
	 * 【自己还是没写出来..】
	 */
	public double[] dicesProbability(int n) {
		double[] dp1 = new double[6];
		//【TRICK.其实f(n)由f(n-1)即可推出，所以设置两个一维数组交替前进！（省空间）】
		Arrays.fill(dp1, 1.0/6.0);
		//1.总共n轮
		for(int i=2;i<=n;i++) {
			//i个骰子的可能点数和的长度——>设置为数组长
			double[] dp2 = new double[5*i+1];
			//遍历上一轮的所有点数，基于该点数从1加到6六种可能！
			for(int j=0;j<dp1.length;j++) {//【HHHDDDPPP.自己没想到第二个循环的参数怎么设置！】
				for(int k=0;k<6;k++) {
					dp2[j+k] += dp1[j]/6.0;
				}
			}
			dp1 = dp2;
		}
		return dp1;
	}
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(Arrays.toString(s.dicesProbability(1)));
	}
}
