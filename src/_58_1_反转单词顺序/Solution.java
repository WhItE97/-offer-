package _58_1_��ת����˳��;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣
 * Ϊ������������ź���ͨ��ĸһ������
 * ���������ַ���"I am a student. "�������"student. a am I"��
 */
public class Solution {
	/**
	 * self˼·����8ms 20% ˫ָ���ջ��1������
	 * һ�������ո񣬾ͽ���ǰStringBuilderд��ջ�������
	 * ��ջ��ʱ����ÿ�����ʺ���ӿո񼴿�
	 */
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();//����ÿ�������ʡ��Ķ�д
		Deque<String> st = new LinkedList<>();
		int index = 0;//����ָʾ��ȡ��s����һλ��
		while(index<s.length()) {
			//1.�����ո񣬿�ʼ����
			if(s.charAt(index)==' ') {
//				System.out.println("�����ո��ˣ���ʱsb="+sb.toString());
				//1.1.��ʱsb�Ѿ��д�д��ջ����
				if(sb.length()!=0) {
					st.push(sb.toString());
					sb.delete(0, sb.length());//��ATT.StringBuilder��delete��ɾ��[start,end)��
				}
				//1.2.��ʱsbΪ��,ɶҲ����,��������ո�
				index++;
			}
			//2.�����ǿո���ַ�
			else {
				sb.append(s.charAt(index));
				index++;
			}
		}
		//�п��ܶ���ĩβû�пո�sb�ﻹ�е��ʵȴ�д��
		if(sb.length()!=0) {
			st.push(sb.toString());
		}
		//����stack���Ѿ������еĵ����ˣ�������ջ��ÿ�����ʼӲ���ո�return���ַ�������
		StringBuilder res = new StringBuilder();
		int size = st.size();//��WRONG POINT 1.ע�Ⱑ��ջ�����С�������Щ��size���Ƕ�̬�仯�ģ�����Ҫȫ���������isEmpty() or �Ȱ�size���������!��
		for(int i=0;i<size;i++) {
			res.append(st.pop());
			res.append(' ');
		}
		//ɾ��ĩβ�Ŀո�
		//��WRONG POINT 2.û����ȫ�ǿո���ַ�����
		if(res.length()!=0) {
			res.delete(res.length()-1, res.length());
		}
		return res.toString();
    }
}
