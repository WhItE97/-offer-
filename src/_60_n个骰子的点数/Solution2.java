package _60_n�����ӵĵ���;

import java.util.Arrays;

public class Solution2 {
	/**
	 * ����Krahets˼·����0ms 100%��
	 * ��dp��...!��̫������..��
	 * ����������
	 * f(n):n�����Ӷ�Ӧ�ĸ����б�
	 * f(n,x):ǰn�����ӣ�������Ϊx�ĸ���
	 * ��״̬ת�Ʒ��̣�
	 * f(n,x) = ��f(n-1,x-i)*(1/6) i=[1,6]
	 * 
	 * ��ATT HDP.������dp x-i���ܻ�Խ�磡��
	 * ����ÿ��f(n-1,i)������f(n,x)�Ĺ��ף���x=i+1,i+2,...,i+6��
	 * ���Լ�����ûд����..��
	 */
	public double[] dicesProbability(int n) {
		double[] dp1 = new double[6];
		//��TRICK.��ʵf(n)��f(n-1)�����Ƴ���������������һά���齻��ǰ������ʡ�ռ䣩��
		Arrays.fill(dp1, 1.0/6.0);
		//1.�ܹ�n��
		for(int i=2;i<=n;i++) {
			//i�����ӵĿ��ܵ����͵ĳ��ȡ���>����Ϊ���鳤
			double[] dp2 = new double[5*i+1];
			//������һ�ֵ����е��������ڸõ�����1�ӵ�6���ֿ��ܣ�
			for(int j=0;j<dp1.length;j++) {//��HHHDDDPPP.�Լ�û�뵽�ڶ���ѭ���Ĳ�����ô���ã���
				for(int k=0;k<6;k++) {
					dp2[j+k] += dp1[j]/6.0;
				}
			}
			dp1 = dp2;
		}
		return dp1;
	}
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(Arrays.toString(s.dicesProbability(1)));
	}
}
