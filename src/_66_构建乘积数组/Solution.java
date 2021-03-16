package _66_�����˻�����;

/**
 * ��Ŀ��
 * ����һ������ A[0,1,��,n-1]���빹��һ������ B[0,1,��,n-1]��
 * ����B[i]��ֵ������A�г����±�i�����Ԫ�صĻ�, ��B[i]=A[0]��A[1]������A[i-1]��A[i+1]������A[n-1]��
 * ����ʹ�ó�����
 */
public class Solution {
	/**
	 * ����Krahets
	 * ����B[i]�ı��ʽ->���ֹ���
	 * B0 =  1*A1*A2*...*AN
	 * B1 = A0* 1*A2*...*AN
	 * ...
	 * BN = A0*A1*A2*...*1
	 * ������ʵ����������������ͬ�еĳ˻���
	 * 
	 * �ο���˼·��self��
	 * 1.�ֱ�����������װ�������Ƕ�Ӧ�еĳ˻�
	 * 2.�ٰ������������Ӧλ����ˣ��õ��ö�Ӧλ�õ�Bi
	 */
	public int[] constructArr(int[] a) {
		//base
		if(a.length==0) {
			return new int[] {};
		}
		int[] top = new int[a.length];
		int[] down = new int[a.length];
		top[a.length-1] = 1;
		down[0] = 1;
		for(int i=1;i<a.length;i++) {
			//�ֱ���top��down
			//1.��down
			down[i] = down[i-1]*a[i-1];
			//2.��top
			top[a.length-1-i] = top[a.length-i]*a[a.length-i];
		}
		//�����������Ӧ��˵õ����
		int[] res = new int[a.length];
		for(int i=0;i<a.length;i++) {
			res[i] = top[i]*down[i];
		}
		return res;
    }
}
