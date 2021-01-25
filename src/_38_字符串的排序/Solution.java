package _38_�ַ���������;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * ��Ŀ��
 * ����һ���ַ�������ӡ�����ַ������ַ����������С�
 * �����������˳�򷵻�����ַ������飬�����治�����ظ�Ԫ�ء�
 */
public class Solution {
	/**
	 * self˼·��
	 * �Ȱ�ԭ�ַ�����ɵ����ַ�����Ϊѡ���б�
	 * Ȼ��dfs��ȫ����
	 * ����һ�ε�������Ŀ���壡�������String=aab->aҲֻ����1�Σ���
	 */
	public String[] permutation(String s) {
		if(s.length()==0) {
			return (new String[] {});
		}
		//1.���sΪ�����ַ�������
		char[] c = s.toCharArray();
		List<Character> choices = new ArrayList<>();
		for(int i=0;i<c.length;i++) {
			choices.add(c[i]);
		}
		int size = c.length;
		//2.dfs
		dfs(choices,sb,size);
		//3.��List<String>��resתΪString[]������
		String[] ret = new String[res.size()];
		Iterator<String> it = res.iterator();
		int i = 0;
		while(it.hasNext()) {
			ret[i] = it.next();
			i++;
		}
		return ret;
    }
	StringBuilder sb = new StringBuilder();//route
	Set<String> res = new HashSet<>();//res�������ٸ���list.size����String�������ڷ��أ���WRONG POINT.��Ϊ��ĿҪ�������������ظ��ģ����Խ����Ҫ��hashset����
	//size:����ȫ���е��ַ�������
	public void dfs(List<Character> choices, StringBuilder sb,int size) {
		//1.��������
		if(sb.length()==size) {
			res.add(sb.toString());
			return;
		}
		//2.dfs
		for(int i=0;i<choices.size();i++) {//for ѡ�� in ѡ���б�
			//��ѡ��(2steps)
			char c = choices.remove(i);//��ѡ���б���ɾ��ѡ��
			sb.append(c);//��·���м���ѡ��
			//dfs
			dfs(choices,sb,size);
			//��������ѡ��(2steps)
			sb.deleteCharAt(sb.length()-1);//��·����ɾ��ѡ��
			choices.add(i, c);//��ѡ�����¼���ѡ���б�
		}
	}
}
