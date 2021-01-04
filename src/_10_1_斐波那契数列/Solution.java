package _10_1_斐波那契数列;

public class Solution {
/**
 * 输入n，求fibonacci的第n项
 * f(0)=0;f(1)=1;f(n)=f(n-1)+f(n-2)
 * 剑指offer trick：
 * 因为自顶向下递归会有很多重复计算的节点（可以通过画二叉树的形式理解）
 * 所以自底向上计算，能省下很多无效计算！
 */
	public int fib(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int ppre = 0;
		int pre = 1;
		int res = 0;
		for(int i=2;i<=n;i++) {
			//从底层开始向上计算，可以省下来很多重复节点!
			res = (ppre + pre)%1000000007;//看清题目要求，要取模
			ppre = pre;
			pre = res;
		}
		return res;
	}
}
