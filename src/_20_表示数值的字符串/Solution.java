package _20_��ʾ��ֵ���ַ���;
//��������״̬��...��ʱ������
public class Solution {
	//��imp����ֵ�Ŀ���ģʽ��A[.[B]][e|EC] or .B[e|EC]
	//A��C���з���������������������B���޷��������������������ţ�
	/**
	 * self˼·��
	 * ��Stringһλһλ������ͨ��һ��matches����ÿ�δ���ȥ��ǰ״̬���Ӷ����ж�Ӧ���ж��Ƿ�Ϲ桾BAD��
	 * new˼·��
	 * һ��ʼ�Ⱦ�����ƥ��0~9�����֣�������+or-�������Ǻ������������֣�
	 * һ������.->����ƥ�� ���֣��޷��ţ� or e|E
	 * һ������e|E->����ƥ�䵽����(1or more[������һ��+-��])
	 */
	public boolean isNumber(String s) {
		int start = 0;
		boolean b = matchZF(s,0);//���ж���λ��û��+-
		if(b) {
			start = 1;//��1��ʼ�������ұ���Ϊ����
		}
		
	}
	//����������match
	public boolean matchZF(String s,int start) {
		if((int)(s.charAt(start))==43||(int)(s.charAt(start))==45){//��+or-
			return true;//��һλ����Ϊ���֣�start��Ҫ++
		}
		return false;//start����++
	}
	//����������match������һ������λ�ã����ʧ�ܣ��򷵻�-1
	public int matchNum(String s,int start) {
		while(start<s.length()) {
			int t = (int)(s.charAt(start));
			if(t>=48&&t<=57) {//����0~9
				start++;
				continue;
			}
			break;
		}
		return start;//���ط����ֵ�λ�õ��±�
	}
	
}
