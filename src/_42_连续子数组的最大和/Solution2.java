package _42_���������������;

public class Solution2 {
	/**
	 * ��ָoffer˼·1��dp��ʱ��O(N)2ms 14.28% ...�ռ�O(N)92.27%��
	 * �����͡�->��̬�滮��
	 * dp��Ҫ�أ�1.�ص�������2.�����ӽṹ3.״̬ת�Ʒ���
	 * steps��
	 * ��1.��ȷbase case��self�о���ͨ��dp[i]�ĺ�����ܶ���base case
	 * 2.��ȷ��״̬����ԭ������������л�仯������
	 * 3.��ȷ��ѡ�񡿣�����״̬�仯����Ϊ��
	 * 4.[most imp&hd]������dp����/�����ĺ��塿
	 */
	/**
	 * ����CORE��
	 * dp[i]:��nums[i]Ϊ��β������������ĺ͵����ֵ
	 * ת�Ʒ���
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
