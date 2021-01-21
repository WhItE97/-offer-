package _16_��ֵ�������η�;

//�����Լ��ĵݹ�д��..�ܻ��ǲ����õݹ顪��>��Solution2
/**
 * ��Ŀ��
 * ��x��n�η��������ÿ⺯��������Ҫ���Ǵ�������
 */
/**
 * self˼·��
 * 1.����Ҫ���Ǳ߽�ֵ����0��0�η������壡
 * 2.ָ������Ϊ��Ϊ������intΪ��Ҫ��������>����MIN_VALUEԽ�����⣡��
 * 3.�Ż���
 * 	(1)x^n=x^(n/2)*x^(n/2),n=ż�� //java��^�ǰ�λ���
 * 	(2)x^n=x^(n-1/2)*x^(n-1/2)*x,n=����
 * 4.��WRONG POINT���ڰ�ָ��תΪ��������ʱ��û���ǵ�n=Integer.MIN_VALUE!!
 * ��������漰��int�为��һ���ǵ�ת��Ϊlong�ٱ�����
 */
/**
 * HDP:Java��float��double����ֱ�ӽ������㣡(��leetcode�Ϻ���ûcare...)
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.myPow(2, 10));
	}
	
	public double myPow(double x,int n) {
		long n1 = n;
		boolean flag = false;//flagΪtrue����ָ��Ϊ���������Ҫȡ����
		if(n1==0) {
			if(x==0) {
				System.out.println("û������");
				return 0.0;
			}
			return 0.0;
		}
		if(x==1) {
			return 1;
		}
		//���ָ��Ϊ����������Ҫȡ����ֵ�����дη����㣬�����ȡ��return
		if(n1<0) {
			n1 = -n1;//���ǵ�Integer.MIN_VALUE����>��long��װ
			flag = true;
		}
		
		double res = unsignedMyPow(x,n1);
		if(flag) {
			res = 1/res;
		}
		return res;
	}

	public double unsignedMyPow(double x,long n) {//�����nһ��Ϊ>0�������Ե�������η�������Fibonacci
		//base
		if(n==1) {
			return x;
		}
		if(n%2==0) {//ż�η�
			double res = unsignedMyPow(x,n>>1);
			res *= res;//imp trick������һ���������
			return res;
		}
		else {//��η�
			double res = unsignedMyPow(x,n>>1);
			res = res*res*x;
			return res;
		}
	}
}
