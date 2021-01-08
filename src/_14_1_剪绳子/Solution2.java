package _14_1_������;

import java.util.Arrays;

public class Solution2 {
/**
 * �Լ���˼·
 * wrong point��״̬ת�Ʒ��̣�
 * f(s) = f(i)*f(s-i)
 * ATT��֮ǰ�Լ��е�i*f(s-i)
 * wrong point��û�п��ǵ���������ĳ�ʼ״̬��Ϊ��������or�����һ���֣���max��ͬ��
 * ������Ϊ��dp[1]=1��������n=1��return 0
 * 		  dp[2]=2�����У���������n=2��return 1(��һ��)
 * 		  dp[3]=3�����У���������n=3��return 2(��һ��)
 * ��dp[4]��ʼ����dpֵ�ͺ�returnֵһ���ˣ���>=�������еĳ��ȣ���
 * ��
 */
	public int cuttingRope(int n) {
		if(n<2) {
			return 0;//û����
		}
		if(n==2) {
			return 1;
		}
		if(n==3) {
			return 2;
		}
		//��4��ʼ���и���ֵ��>=�����ˣ������Ե�����dp��max����
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i=4;i<=n;i++) {//�Ե�������i���ȶ�Ӧ�ĳ˻�max
			int max = Integer.MIN_VALUE;
			for(int j=1;j<=i/2;j++) {//�������п����и�ȣ�����ʵ����һ�뼴�ɣ�����һ����ǶԳƵģ�
				max = Math.max(max, dp[i-j]*dp[j]);
			}
			dp[i] = max;
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
