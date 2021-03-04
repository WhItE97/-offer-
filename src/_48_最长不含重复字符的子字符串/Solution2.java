package _48_������ظ��ַ������ַ���;

public class Solution2 {
	/**
	 * self˼·2.��ʱ�� 850ms 5%...̫���ˡ�
	 * ��start1��end1�����Ӵ����±�
	 * ��end1+1����ǰ����ִ����ַ��ظ��ˡ���>�Ӹ�λ��Ϊstart2���µ���ִ�������ҵ�һ���µ�end2-start2>end1-start1����ȡ��֮������start2++
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {//base case
			return 0;
		}
		char[] str = s.toCharArray();
		int start1 = 0;
		int start2 = 0;
		int end1 = 0;//��Ӵ�[start1,end1]����>���Լ��㳤��=end1-start1+1��
		int end2 = 1;
		StringBuilder sb = new StringBuilder();//��ŵ�ǰ����Ӵ�
		sb.append(str[start1]);
		while(end2<s.length()) {
			System.out.println("start1="+start1+",end1="+end1+",start2="+start2+",end2="+end2+",sb="+sb.toString());
			//break����2.s.length-start2<end1-start1 [����һ����֦���������п��ޣ�����Ч��]
			if((s.length()-start2)<(end1-start1+1)) {
				break;
			}
			
			if(check_contains(sb,str[end2])) {//1.����ظ��ˣ���break������Ѱ�ҡ���>start2��Ųһλ,���sb����
				sb.delete(0, sb.length());
				start2++;
				sb.append(str[start2]);
				end2 = start2+1;
				continue;
			}
			//2.���û�ظ���������Ѹ��ַ���ӽ��Ӵ�2
			sb.append(str[end2]);
			if(sb.length()>(end1-start1+1)) {//3.check����Ӵ����ȴ��ڵ�ǰ��¼����Ӵ����ˣ��Ǿ��滻��start1��end1
				start1 = start2;
				end1 = end2;
			}
			end2++;
		}
		return (end1-start1+1);
    }
	
	public boolean check_contains(StringBuilder sb,char ch) {
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)==ch) {
				return true;//��ʾch�ظ��ˣ�contain
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.lengthOfLongestSubstring("aaabbccdef"));
	}

}
