package _63_��Ʊ���������;

public class Solution2 {
	/**
	 * ����Krahets dp
	 * 1.dp[i]����i��β����������������
	 * 2.ת�Ʒ��̣�
	 * dp[i] = max{dp[i-1],����i��������������󡿣�HDP��}
	 * ������i���������������Ҳ��Ҫ��¼��i��֮ǰ��minֵ
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
