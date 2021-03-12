package _63_股票的最大利润;

public class Solution2 {
	/**
	 * 力扣Krahets dp
	 * 1.dp[i]：以i结尾的子数组的最大利润
	 * 2.转移方程：
	 * dp[i] = max{dp[i-1],【第i天卖出的最大利润】（HDP）}
	 * 而【第i天卖出的最大利润】也需要记录第i天之前的min值
	 */
	public int maxProfit(int[] prices) {
		//base
		if(prices.length==0) {
			return 0;
		}
		int min = prices[0];
		int max = 0;
		int[] dp = new int[prices.length];
		dp[0] = 0;
		for(int i=1;i<prices.length;i++) {
			dp[i] = Math.max(dp[i-1], prices[i]-min);
			min = Math.min(min, prices[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
    }
	public static void main(String[] args) {
		
	}

}
