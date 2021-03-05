package _49_����;

/**
 * ��Ŀ��
 * ���ǰ�ֻ���������� 2��3 �� 5 ��������������Ugly Number�����󰴴�С�����˳��ĵ� n ��������
 * self���䣺
 * �����ӵĶ����ǣ�����������2��3��5��������Ա�2��3��5�����������ɴγ���
 */
public class Solution {
	/**
	 * self˼·��
	 * ö��..�������˺ܶ಻��Ҫ�ķǳ�����
	 * 
	 * ����Krahets˼·����3ms 70%��
	 * ��dp����
	 * dp[i]:��i+1������
	 * ��HDP.��������
	 * 1.��dp[i+1]����:dp[i+1]=min{dp[a]*2,dp[b]*3,dp[c]*5};����0��a,b,c��i
	 * 2.Ϊ�˱�֤dp[i+1]�ǵ�һ������dp[i]�ĳ���������Ҫ��֤:
	 * (1)2*dp[a-1]<=dp[i]<2*dp[a]
	 * (2)3*dp[b-1]<=dp[i]<3*dp[b]
	 * (3)5*dp[c-1]<=dp[i]<5*dp[c]
	 * ����״̬ת�Ʒ���
	 */
	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int a=0;
		int b=0;
		int c=0;
		for(int i=1;i<n;i++) {
			int aa = 2*dp[a];
			int bb = 3*dp[b];
			int cc = 5*dp[c];
			//��HDP.ÿ��dp a,b,c�ı仯����>��Ϊ���˸�λ�ã�������������Ųһλ���ɣ������Դ�ת�Ʒ����еĲ���ʽ���˿�������
			dp[i] = Math.min(Math.min(aa, bb), cc);
			if(dp[i]==aa) {
				a++;
			}
			if(dp[i]==bb) {
				b++;
			}
			if(dp[i]==cc) {
				c++;
			}
		}
		return dp[n-1];
    }
}
