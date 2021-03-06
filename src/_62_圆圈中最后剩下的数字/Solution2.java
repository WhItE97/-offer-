package _62_圆圈中最后剩下的数字;

public class Solution2 {
	/**
	 * 力扣Krahets dp思路：【7ms 99%】
	 * 1.f(n,m):长度n的环每次删去第m个元素
	 * ——>新f(n-1,m)有元素排列如下：（删的是(m-1)%n,设t=m%n(即删除后的新首元素)）【HDP1.（易错点）这里删除的不能写成m%n-1！因为如果m==n==5——>t=-1了！】
	 * (为了方便观察前后关系，把删除后新的首个元素设为t，删除元素的(t-1)=(m-1)%n)
	 * [n-1,m]问题	[n,m]问题经第一轮删除后
	 * 0			t+0
	 * 1			t+1
	 * ...			...
	 * n-2			t-2
	 * 原[n,m]问题的解<=>新[n-1,m]问题的解（但是二者的下标不同！对应关系可以由上推导！）
	 * 2.二者对应关系
	 * [n-1,m]问题中某数x有：
	 * x—>(对应原[n,m]问题中的原数字)—>(t+x)%n
	 * 3.
	 * 所以要把[n-1,m]问题的解还原到[n,m]中，就需要把x做(x+t)%n的变化！即：
	 * f(n) = (f(n-1)+t)%n
	 * 其中 t = m%n
	 * 所以 f(n) = (f(n-1)+m%n)%n
	 *          = (f(n-1)+m)%n
	 * 4.得到状态转移方程
	 * dp[n] = (dp[n-1]+m)%n 【ATT.n每轮都在变化！】
	 * 5.初始状态
	 * 因为n代表数字个数，所以dp[1]为初始状态，无论m为多少，dp[1]必=0
	 */
	public int lastRemaining(int n, int m) {
//		int[] dp = new int[n+1];//因为dp从1开始，所以dp[0]是废1个空间
//		dp[1] = 0;
//		for(int i=2;i<=n;i++) {
//			dp[i] = (dp[i-1]+m)%i;
//		}
//		return dp[n];
		
		//不难看出，状态n只与上一个状态有关，所以上述写法浪费了很多空间！
		int x = 0;
		for(int i=2;i<=n;i++) {
			x = (x+m)%i;
		}
		return x;
    }
}
