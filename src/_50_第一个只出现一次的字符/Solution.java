package _50_��һ��ֻ����һ�ε��ַ�;

/**
 * ��Ŀ��
 * ���ַ��� s ���ҳ���һ��ֻ����һ�ε��ַ������û�У�����һ�����ո� s ֻ����Сд��ĸ��
 */
public class Solution {
	/**
	 * self˼·����ʱ�� 164ms 5.43% ...�ռ�70%��
	 * ��StringBuilder���ӵ�һ���ַ���ʼ���������������˲�ֹ1�Σ����������֣�ɾ�����и��ַ�
	 * ֱ���ҵ�һ��������ֻ���ֹ�һ�ε��ַ�
	 */
	public char firstUniqChar(String s) {
		StringBuilder sb = new StringBuilder(s);
		int count = 0;
		while(sb.length()>1) {//ѭ������������sb��length<=1��
			count = 0;
			char c = sb.charAt(0);
			for(int i=1;i<sb.length();i++) {//�Ա��ֵ�sb�����ַ�����match
				if(sb.charAt(i)==c) {
					sb.deleteCharAt(i);
					count++;
					i--;
				}
			}
			//ע�⣬����ظ������������Ҫ�����ַ�ɾ��
			if(count>0) {
				sb.deleteCharAt(0);
			}
			//�����ֵ��ַ��Ƿ����ظ������û�У����ҵ�
			else{
				return c;
			}
		}
		if(sb.length()==0) {//��ɾ���˻�û�ҵ�or������ַ���
			return ' ';
		}
		return sb.charAt(0);
    }
}
