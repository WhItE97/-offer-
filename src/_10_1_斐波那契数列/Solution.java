package _10_1_쳲���������;

public class Solution {
/**
 * ����n����fibonacci�ĵ�n��
 * f(0)=0;f(1)=1;f(n)=f(n-1)+f(n-2)
 * ��ָoffer trick��
 * ��Ϊ�Զ����µݹ���кܶ��ظ�����Ľڵ㣨����ͨ��������������ʽ��⣩
 * �����Ե����ϼ��㣬��ʡ�ºܶ���Ч���㣡
 */
	public int fib(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int ppre = 0;
		int pre = 1;
		int res = 0;
		for(int i=2;i<=n;i++) {
			//�ӵײ㿪ʼ���ϼ��㣬����ʡ�����ܶ��ظ��ڵ�!
			res = (ppre + pre)%1000000007;//������ĿҪ��Ҫȡģ
			ppre = pre;
			pre = res;
		}
		return res;
	}
}
