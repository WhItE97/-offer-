package _15_��������1�ĸ���;

public class Solution2 {
/**
 * ��ָoffer˼·��
 * �޷��š���>���Ƶ���λ���ǲ�0������ÿ������1λ��ͬ1�� ������������=0����ǰ���ұߵ�һλΪ1
 */
	public int hanmingWeight(int n) {
		int count = 0;
		while(n!=0) {
			count += n&1;
			n = n>>>1;//you need to treat n as unsigned value!����Ҫ���޷�����λ��
		}
		return count;
	}
}
