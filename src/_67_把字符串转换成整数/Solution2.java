package _67_���ַ���ת��������;

public class Solution2 {
	/**��2ms 99%��
	 * ����Krahets�������߽紦��
	 * 1.���ո񡿣����Ա�����Ҳ����ͨ��char[] c = str.trim().toCharArray()ֱ��ȥ���ո񡪡�>���������˸����ڴ棡��
	 * 2.������λ��3situs��+��-���޷��š���>��Ϊ����Խ��ʱҪ���������أ�[������Ҫһ������λtag��]
	 * 3.���������ַ��������������ַ�ֱ�ӷ��أ�
	 * 4.�������ַ�����1���ַ�ת���֡���>��ȥ0��ASCII��48��2������ƴ�ӡ���>res*10+������
	 * 5.��MOST IMP.CORE����*****Integer�߽紦�����ǵ�һ�������ˣ�RECITE��*****��
	 * ��
	 * �Լ�û��ͨ͸������int�ı߽�[-2^31=-2147483648,2^31-1=2147483647]
	 * ��ô�ڼ����һλ���ﵽ�߽����ֵ�λ����֮ǰ������Ҫ�ж�ǰ�������214748364�Ĺ�ϵ����
	 * ��ǰ������Ѿ�>214748364:������һλ�Ӷ��٣�����Խ�硾������������������
	 * ��ǰ�����==214748364:����һλ�ӵ���:
	 * ��*****MOST HD.*****����ֻҪ>7��1.����>7Խ����,return Integer.MAX_VALUE����2.����>7��������8���Ǹ��󣬷�����return Integer.MIN_VALUE��������
	 * ��
	 */
	public int strToInt(String str) {
		//base
		if(str==null||str.length()==0) {
			return 0;
		}
		int index = 0;//ָʾ��ǰ������һλ
		boolean tag = true;//trueΪ����falseΪ��
		int res = 0;//��¼��ǰ��ֵ
		//1.�޳��ո�
		while(index<str.length()&&str.charAt(index)==' ') {
			index++;
		}
		if(index>=str.length()) {//��IMP ATT.�ڶ��λ����ˣ���
			return 0;
		}
		//2.�ж��׸��ַ�
		if(str.charAt(index)=='+'||(str.charAt(index)>47&&str.charAt(index)<58)) {
			tag = true;
			if(str.charAt(index)=='+') {//����Ƿ���λ������Ҫ����
				index++;
			}
		}
		else if(str.charAt(index)=='-') {
			tag = false;
			index++;
		}
		//3.�������ַ�
		else {
			return 0;
		}
		//4.�����ַ�
		while(index<str.length()&&(str.charAt(index)>47&&str.charAt(index)<58)) {
			int num = (int)(str.charAt(index)-48);//����Ҫ�ӵ�����
			//��HDP.�߽紦��
			//�߽�1.ǰ����Ѿ������ˣ������۱�����λ�Ӽ������
			if(res>214748364) {
				return tag?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			//�߽�2.ǰ���ǡ�õȣ�ȡ���ڱ���Ҫ�ӵ���һλ
			else if(res==214748364) {
				System.out.println("im in");
				if(num>7) {//��Խ���˲Ż�ֹͣ��ûԽ������������һ�֣���
					return tag?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
			}
			//�����ÿ���res<214743864�ı߽�3.����ΪֻҪûԽ�磡�ͻ�һֱ������ȥ��
			res = 10*res + num;
			index++;//now indexָ����һ���ַ�
		}
		//final�����ֽ�ֹ�ˣ���û��Խ�磡
		return tag?res:(-1)*res;
    }
}
