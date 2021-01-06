package _13_机器人的运动范围;

public class Solution {
/**
 * 题目：m行n列(0~m-1,0~n-1)的矩阵，输入k，机器人只能到坐标每位数之和<=k的位置
 * 机器人从[0,0]开始，每次【只能上下左右移动一格！】
 * 求机器人能达到多少个格子
 */
/**
 * self思路：【WRONG】
 * 遍历所有位置..——>错！如16，8，4——>[10,0]满足1+0+0<4——>但机器人每次只能移动一步！所以其实到不了这个点！
 * 换思路！：dfs记录route！（见Solution2）
 */
	public int movingCount(int m,int n,int k) {
		int res = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if((sumEach(i)+sumEach(j))<=k) {
					res++;
				}
			}
		}
		return res;
	}
	
	public static int sumEach(int x) {
		int res = 0;
		while(x/10!=0) {
			res += x%10;
			x /= 10;
		}
		return res+x;
	}
}
