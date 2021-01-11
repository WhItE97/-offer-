package _17_��ӡ��1������nλ��;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//LASTЧ����n=5�ͳ�ʱ��...��Solution3
public class Solution2 {
	public static void main(String[] args) {
		int[] ret = new Solution2().printNumbers(2);
		System.out.println(Arrays.toString(ret));
	}
/**
 * ���Ǵ��������ַ�����װ��
 * dfs��ɾȥǰ�������ɸ�0�����е�0Ԫ��
 */
	public int[] printNumbers(int n){
		char[] choices = new char[] {'0','1','2','3','4','5','6','7','8','9'};
		//ʵ���Ͼ��Ǹ���λ��n����choices��ѡ��n�Ρ���>ȫ�������⣡����>dfs��
		dfs(choices,sb,5);
//		clear(res);
		int[] re = fitToAC(res);
		return re;
	}
	
	/**
	 * dfs��ܣ�
	 * def dfs:
	 * 	if(�����������)��
	 * 		return;
	 * 	for ѡ�� in ѡ���б�
	 * 		��ѡ��
	 * 		route.add(ѡ��)
	 * 		dfs
	 * 		����ѡ��
	 */
	List<StringBuilder> res = new LinkedList<StringBuilder>();//װ���
	StringBuilder sb = new StringBuilder();//װÿ�ֵ�route
	public void dfs(char[] choices,StringBuilder sb,int n) {
		//��������������length������ȫ�����п�ͷΪ0������������0����Ԫ�ص�������0ȫ��ȥ�����ɣ�
		if(sb.length()==n) {
			res.add(new StringBuilder(sb));
			return;
		}
		for(char ch:choices) {
			//��ѡ��
			sb.append(ch);
			//dfs
			dfs(choices,sb,n);
			//����ѡ��
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	int allZERO = 0;
	//�������У�ɾ�����������ɸ�0��ͷ������0Ԫ��
	public void clear(List<StringBuilder> res) {
		for(int i=0;i<res.size();i++) {//���������
			int count = 0;//��¼���ֵ�Ԫ�صĿ�ͷ0Ԫ�ظ���
			for(int j=0;j<res.get(i).length();j++) {
				if(res.get(i).charAt(j)=='0') {//ȷʵ��0Ԫ��
					if(count==j) {//����count������=j����>�������ܱ�֤�Ǵӿ�ͷ������0Ԫ�أ�
						count++;
					}
				}
			}
			//����countװ�˱���String��0��ͷ��'0'����
			res.get(i).delete(0,count);
			if(res.get(i).length()==0) {//ȫ0��Ԫ��Ҫ��List��ɾ��������������ɾ����ı�����Ԫ��λ�ã����Լ�¼����index���ɣ�
				allZERO=i;
			}
		}
		res.remove(allZERO);
	}
	
	public int[] fitToAC(List<StringBuilder> res) {
		int[] arr = new int[res.size()];
		for(int i=0;i<res.size();i++) {
			//����תΪ���֣��Ž�int����
			arr[i] = Integer.parseInt(res.get(i).toString());
		}
		return arr;
	}
}
