package _05_�滻�ո�;

public class Solution {
/**
 * ��Ŀ��
 * ��һ���ַ����ո�ȫ����%20
 * ˼·��
 * ��StringBuilder
 * ͨ��charAt����ÿ���ַ�
 * �ո��ַ�����replace(int start,int end,String s=20%)
 */
	public static void main(String[] args) {
		String s = "We are happy.";
		System.out.println(replaceSpace(s));
	}
	public static String replaceSpace(String s) {
		StringBuilder sb = new StringBuilder(s);
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)==' ') {
				sb.replace(i,i+1,"%20");
			}
		}
		return sb.toString();
	}
}
