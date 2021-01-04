package _10_2_青蛙跳台阶问题;

public class Solution {
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 思路：
 * (HDP!)对n阶，可以跳1or2，所以f(n)=f(n-1)+f(n-2)...
 * 显然是个fibonacci！
 */
	public int numWays(int n) {
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 1;
		}
		int ppre = 1;
		int pre = 1;
		int res = 0;
		for(int i=2;i<=n;i++) {
			res = (pre+ppre)%1000000007;
			ppre = pre;
			pre = res;
		}
		return res;
	}
}
