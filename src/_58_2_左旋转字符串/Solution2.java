package _58_2_����ת�ַ���;

public class Solution2 {
	/**
	 * ��ָoffer˼·����0ms 100%��
	 * �ͷ�ת����˳��һ������
	 * 1.�Ȱ���Ҫ��ת��ȥ���ַ��������п�
	 * 2.�ٽ��������Ӵ���λ�ü���
	 * 
	 * ����涨������Ƭ���Ǿͱ�������
	 */
	public String reverseLeftWords(String s, int n) {
		return s.substring(n, s.length())+s.substring(0, n);
    }
}
