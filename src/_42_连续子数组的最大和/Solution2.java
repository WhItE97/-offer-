package _42_连续子数组的最大和;

public class Solution2 {
	/**
	 * 剑指offer思路1：dp【时间O(N)2ms 14.28% ...空间O(N)92.27%】
	 * “最大和”->动态规划！
	 * dp三要素：1.重叠子问题2.最优子结构3.状态转移方程
	 * steps：
	 * （1.明确base case）self感觉想通了dp[i]的含义才能定义base case
	 * 2.明确【状态】（原问题和子问题中会变化的量）
	 * 3.明确【选择】（导致状态变化的行为）
	 * 4.[most imp&hd]【定义dp数组/函数的含义】
	 */
	/**
	 * 本题CORE：
	 * dp[i]:以nums[i]为结尾的所有子数组的和的最大值
	 * 转移方程
	 * dp[i] = max{dp[i-1]+nums[i],nums[i]}
	 */
	public int maxSubArray(int[] nums) {
		if(nums.length<1) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for(int i=1;i<nums.length;i++) {
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			max = dp[i]>max?dp[i]:max;
		}
		return max;
    }
}
