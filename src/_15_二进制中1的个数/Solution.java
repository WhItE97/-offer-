package _15_��������1�ĸ���;

public class Solution {
/**
 * ��Ŀ��
 * ��ʵ��һ������������һ���������Զ����ƴ���ʽ����������������Ʊ�ʾ��1�ĸ��������磬��9��ʾ�ɶ�������1001����2λ�� 1����ˣ��������9����ú������2��
 */
/**
 * self˼·��
 * ת�����Ʊ���count..
 */
	public int hanmingWeight(int n) {
		//you need to treat n as an unsigned value
		//�Ȱ�n��ɶ������ַ���
		String res = Integer.toBinaryString(n);
		int count = 0;
		for(int i=0;i<res.length();i++) {
			if(res.charAt(i)=='1') {
				count++;
			}
		}
		return count;
	}
}
