package _60_n�����ӵĵ���;


/**
 * ��Ŀ��
 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 * ����Ҫ��һ�����������鷵�ش𰸣����е� i ��Ԫ�ش����� n ���������������ĵ��������е� i С���Ǹ��ĸ��ʡ�
 */
public class Solution {
	/**
	 * self˼·����1790ms 5%��
	 * 1.n�����ӣ�����n~6n����һ����6^n�����У���
	 * 2.newһ��6n-n+1���ȵ�res����
	 * 3.����ÿ�����еĸ��ʣ��Ը����еĺ����±꣬count��res����
	 * ��Ϊn��ȷ���������޷�ȷ��for�Ĳ�������>�ݹ飡(ÿ�㶼����1.��ǰ������2.��������3.��ǰǰ��λ��sum4.res����)
	 */
	public double[] dicesProbability(int n) {
		double ratio = 1/(Math.pow(6, n));
		double[] res = new double[5*n+1];
		recur(1,n,0,ratio,res);
		return res;
    }
	/**
	 * ��һ��recur��������ݹ�
	 * num:��ǰ�ǵ�num������
	 * n:����n������
	 * sum:ǰ�������ӵĺ�
	 * ration:ÿ�����еĿ�����1/��6^n��
	 */
	public void recur(int num,int n,int sum,double ratio,double[] res) {
		for(int i=1;i<=6;i++) {
			//ֻ��n==num��(n�������Ѿ�������)����res��д
			if(n!=num) {
				recur(num+1,n,sum+i,ratio,res);
			}
			else {
				int index = sum+i-n;
				res[index] += ratio;
			}
		}
	}
}
