package _10_2_������̨������;

public class Solution {
/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��̨�ס������������һ�� n ����̨���ܹ��ж�����������
 * ˼·��
 * (HDP!)��n�ף�������1or2������f(n)=f(n-1)+f(n-2)...
 * ��Ȼ�Ǹ�fibonacci��
 */
	public int numWays(int n) {
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 1;
		}
		int ppre = 1;
		int pre = 1;
		int res = 0;
		for(int i=2;i<=n;i++) {
			res = (pre+ppre)%1000000007;
			ppre = pre;
			pre = res;
		}
		return res;
	}
}
