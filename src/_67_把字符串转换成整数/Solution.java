package _67_���ַ���ת��������;

public class Solution {
	/**
	 * self˼·����1078/1079..�߽紦���̫��̫�����ˣ���Solution2��
	 * 1.���������п�ͷ�Ŀո�
	 * 2.�����һ���ַ�Ϊ+ or - or ���֣���ͨ��getNum�Ӻ�����ô�����һλ��ʼ������ִ�
	 * ��HD��getNum��ʱ�򣬸����ֿ��ܻ�Խ�磡��������int�Ľ磬�������ܳ���long�ı߽磡��
	 * �������������ֻ��ͨ��1078/1079�İ���..��
	 * 3.���������return 0
	 */
	public int strToInt(String str) {
		if(str==null||str.length()==0) {
			return 0;
		}
		int index = 0;
		while(index<str.length()&&str.charAt(index)==' ') {
			index++;
		}
		if(index>str.length()-1) {
			return 0;
		}
		//'+'=43;'-'=45;'0'=48
		int first = (int)str.charAt(index);
		//1.�׸��ַ���+
		if(first==43) {
			long tmp = getNum(str.substring(index+1),true);
			return (tmp>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)tmp;
		}
		//2.�׸��ַ���-
		if(first==45) {
			long tmp = getNum(str.substring(index+1),false);
			System.out.println("tmp="+tmp);
			System.out.println("-1*tmp="+(-1)*tmp);
			return (tmp*(-1)<Integer.MIN_VALUE)?Integer.MIN_VALUE:(int)((-1)*tmp);
		}
		//3.�׸��ַ�������
		if(first>47&&first<58) {
			long tmp = getNum(str.substring(index),true);
			return (tmp>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)tmp;
		}
		//4.else
		else {
			return 0;
		}
    }
	
	public long getNum(String str,boolean positive) {
		System.out.println("substring="+str);
		if(str.length()==0) {
			return 0;
		}
		int len = 0;//��¼���ֳ���
		StringBuilder sb = new StringBuilder();
		while(str.charAt(len)>47&&str.charAt(len)<58) {
//			System.out.println("char="+str.charAt(len));
			sb.append(str.charAt(len));
			len++;
			if(len==str.length()) {
				break;
			}
		}
		//now sb��װ������ִ�
		long res = 0;
		long i = 1;
		for(int index=0;index<sb.length();index++) {
			res += (sb.charAt(sb.length()-1-index)-48)*i;
			System.out.println("res="+res+",tag="+positive);
			if(positive&&res>Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if(!positive&&(-1)*res<Integer.MIN_VALUE) {
				System.out.println("res="+res+",Math.abs min="+Math.abs(Integer.MIN_VALUE));
				return Math.abs(Integer.MIN_VALUE);
			}
			i*=10;
		}
		return res;
	}
}
