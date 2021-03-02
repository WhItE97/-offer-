package _43_1_n��1���ֵĴ���;

/**
 * ��Ŀ��
 * ����һ������ n ����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 */
public class Solution {
	/**
	 * ����Krahets˼·����ʱ��0ms 100%��
	 * cur = ni Ϊ��ǰλ
	 * low = ni-1 ni-2 ... n2 n1 Ϊ��λ
	 * high = nx nx-1 ... ni+1 Ϊ��λ
	 * digit = 10^i Ϊ λ����
	 * 
	 * ���ݵ�ǰcurֵ����3situs��
	 * 1.cur=0����λ1�ĳ��ִ���ֻ�ɸ�λ��������>= high*digit
	 * 2.cur=1����λ1�ĳ��ִ�������>= high*digit + low + 1
	 * 3.cur=others����λ1�ĳ��ִ�������>= (high+1)*digit
	 */
	public int countDigitOne(int n) {
		//���ȳ�ʼ�����ĸ�����
		int high = n/10;
		int cur = n%10;
		int low = 0;
		int digit = 1;//cur�Ӹ�λ��ʼ��λ��ǰ����
		int res = 0;
		while(high!=0||cur!=0) {//��HDP1.������������
			//��ʼ��curֵ��������м���
			//1.cur==0
			if(cur==0) {
				res += high*digit;
			}
			//2.cur==1
			else if(cur==1) {
				res += high*digit + low + 1;
			}
			//3.cur==others
			else {
				res += (high+1)*digit;//����curƨ�ɺ���������ж�����cur==1��ϣ�����ǰhigh*digitҪ����1��������digit
			}
			//�����ĸ�����ֵ��������һ��
			low += cur*digit;
			cur = high%10;
			high = high/10;
			digit *= 10;
		}
		return res;
    }
}
