package _58_1_��ת����˳��;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	/**
	 * ����Krahets
	 * ˫ָ�롾4ms 42%��
	 * 1.���ƶ�lֱ��һ���ǿո��ַ�����r=l����ʼ�ƶ�r
	 * 2.rһֱ�ƶ���һ���ո񣨲�д��ո�
	 * 3.��l->r��Stringд��list
	 * 4.�����ַ���ĩβ�󣬰Ѹ�list�е�String����ƴ������
	 */
	public String reverseWords(String s) {
		int l = 0;
		int r = 0;
		List<String> res = new ArrayList<>();
		while(l<s.length()) {
			//1.l��Ϊ�ո�
			if(s.charAt(l)!=' ') {
				r=l;
				while(r<s.length()&&s.charAt(r)!=' ') {
					r++;
				}
				res.add(s.substring(l, r));//��ATT.String.substring(start,end)��StringBuilder.delete()һ������������ҿ�����
				l = r+1;
			}
			//2.lΪ�ո�
			else {
				l++;
			}
		}
		//��list�е��ʷ����м����ո�ƴ�ӳ��ַ���
		StringBuilder sb = new StringBuilder();
		for(int i=res.size()-1;i>=0;i--) {
			sb.append(res.get(i));
			sb.append(' ');
		}
		//������ɾ �ǿ��ַ��� ĩβ�Ŀո�
		if(sb.length()!=0) {
			sb.delete(sb.length()-1, sb.length());
		}
		return sb.toString();
	}
}
