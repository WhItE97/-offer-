package _58_2_����ת�ַ���;

/**
 * ��Ŀ��
 * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
 * �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
 * ���磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
 */
public class Solution {
	/**
	 * self˼·����WRONG���߲�ͨ��eg�������ĳ���n>=�ַ������ȵ�һ���ʱ�򣬵�һ��˫ָ����߲���ȫ�����Բ���ȡ����
	 * ˫ָ�룬����abcdefg-2>cdefg[ba]..�����λ���Ӵ�����Ҫ�ѵ�һλŲ�����ȥ(�����һλŲ������ȥֻ�ܰ���ǰŲ��)
	 */
	public String reverseLeftWords(String s, int n) {
		StringBuilder sb = new StringBuilder(s);
		for(int i=0;i<s.length()-n;i++) {
//			System.out.println("swap char:"+sb.charAt(i)+" and char:"+sb.substring(i+n,i+1+n));
			char tmp = sb.charAt(i);
			sb.replace(i, i+1, sb.substring(i+n, i+1+n));
			sb.replace(i+n, i+1+n, Character.toString(tmp));
		}
		//����Ҫ���Ӵ����в���Ϊ1�Ľ������԰ѵ�һ���������һ����WRONG POINT.ֻ�г���Ϊ�������ַ���������Ҫ����!��
		if(s.length()%2==0) {
			return sb.toString();
		}
		for(int i=s.length()-n;i<s.length()-1;i++) {
			char tmp = sb.charAt(i);
			System.out.println("i="+i);
//			System.out.println("swap char:"+sb.charAt(i)+" and char:"+sb.substring(i+1,i+1+1));
			sb.replace(i, i+1, sb.substring(i+1, i+1+1));
			sb.replace(i+1, i+1+1, Character.toString(tmp));
		}
		return sb.toString();
    }
}
