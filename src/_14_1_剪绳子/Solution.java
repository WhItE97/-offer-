package _14_1_������;

public class Solution {
/**
 * ��Ŀ��
 * ����һ������Ϊ n �����ӣ�������Ӽ����������ȵ� m �Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊ k[0],k[1]...k[m-1] ��
 * ���� k[0]*k[1]*...*k[m-1] ���ܵ����˻��Ƕ��٣�
 * ���磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 * (û��ָ�����Ĵ�����)
 */
/**
 * self˼·��
 * ����󡱡���>dp����
 * ״̬�����ӵ�ʣ�೤��
 * ѡ�񣺼����ĳ���
 * (����Ĭ��n>1��)
 */
	public int cuttingRope(int n) {
		return dp(n,new int[n+1]);
	}
	
	/**
	 * @param n���ܳ���
	 * @param res[i]���ܳ���Ϊn�����ӵ����˻�
	 * ״̬ת�Ʒ��̣���WRONG,��Solution2��
	 * f(s) = f(s-len)*len����״̬ת�Ʒ������￪ʼ����..��
	 * len=[1,2,...,n-1]
	 * f(s) = max(len=[1,2,...,n-1]){len*f(s-len)}
	 */
	public int dp(int n,int[] res) {
		if(n<2) {
			return 1;
		}
		if(n==2) {
			//2ֻ�ܼ�һ�Σ������=1x1
			res[2] = 1;//����dp[0]
			return res[2];
		}
		if(res[n]!=0) {//�Ȳ��û���ټ���
			return res[n];
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n-1;i++) {//�������ӿ��Լ������г���ѡ����res��¼��ÿ���Ȳ��
			if(n-i<1) {//���ʣ�����ӳ���-i�ĳ����Ѿ���1��С�ˣ��ǾͲü������ˣ�
				break;
			}
			max = Math.max(max, i*dp(n-i,res));
		}
		return max;
	}
}
