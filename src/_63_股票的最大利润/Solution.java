package _63_股票的最大利润;

/**
 * 题目：
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class Solution {
	/**
	 * self思路：
	 * 暴力法..O(N^2)
	 * 
	 * 剑指offer思路：
	 * res[i]表示第(i+1)天卖出的最大利润
	 * 【KEY POINT.】为此，我们需要知道前i天的最低买入价格！
	 * 所以用一个min记录前i天的最低买入价格
	 * 这样只需要O(N)就可以得到！
	 */
	public int maxProfit(int[] prices) {
		//base case
		if(prices.length==0) {
			return 0;
		}
		int[] res = new int[prices.length];
		res[0] = 0;
		int min = prices[0];
		int max = 0;
		for(int i=1;i<res.length;i++) {
			int tmp = prices[i]-min;
			res[i] = tmp>0?tmp:0;
			max = Math.max(max, res[i]);
			min = Math.min(min, prices[i]);
		}
		return max;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = {7,6,4,3,1};
		System.out.println(s.maxProfit(prices));
	}
}
