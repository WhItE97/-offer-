package _17_��ӡ��1������nλ��;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.printNumbers(1)));
	}
/**
 * ��Ŀ��
 * ˳���ӡ��1������nλʮ������
 * 
 * leetcode������int[]���أ�����Ĭ��������int��Χ����..
 * ʵ���Ͽ������ڡ���������
 * �㲢��֪�����Թٻ����һ������n�����nλ���������ܳ�����long�ķ�Χ����int 32λ��long 64λ��18 446 744 073 709 551 615=20λ��
 * �ⷨ��Solution2
 */
	public int[] printNumbers(int n) {
		int[] arr = new int[(int)Math.pow(10, n)-1];
		for(int i=0;i<Math.pow(10, n)-1;i++) {
			arr[i] = i+1;
		}
		return arr;
	}
}
