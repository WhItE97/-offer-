package _26_�����ӽṹ;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	/**
	 * self˼·����WRONG��
	 * �������ӽṹ���ظ������ǲ�һ����..��
	 * ->1.�ظ���������Ҫ��һ���ڵ��������Ϊ����������[���нڵ�]�������л��������Ľṹ�洢�Խ��к����ıȽϡ�����ֻҪ�����˸ýڵ㣬�ͱ����������ڵ��µ����нڵ㣡��
	 * 2.�ӽṹ������Ҫmatchһ��������������������ֻ��һ�������е�һС���֣����ӽṹ������һ���ڵ㣬����ֻȡ������or��������even����ȡ����
	 * ��[1,2,3,4,5]��[2,4]�����к�����ǰ�ߵ��ӽṹ��������ǰ�ߵ�������
	 * ��
	 * 1.��->�ݹ飬˼��ÿһ���ڵ�Ӧ����ʲô��->ÿһ���ڵ��¼�Լ�Ϊ���ڵ��������ģ��
	 * 2.��μ�¼ģ��->���л�
	 * 3.�����г����˵��������л��������HashSet��ͨ��contains�鿴�Ƿ����ӽṹB��Ӧ�����л����
	 * 
	 * new ��ָoffer˼·��
	 * 1.�Ѿ������ӽṹ�ˣ�Ҫmatch�Ļ������ȵ���A���ҵ�match B�ĸ��ڵ�Ľڵ�ɣ�
	 * 2.�ҵ�match B���ڵ�ģ��ٶԶ��ߵ����������ֱ�ݹ�Ƚϣ�
	 * 3.�����������ݹ�ֱ���ӽṹB��Ҷ�ӽڵ㣡
	 */
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		//base
		if(A==null||B==null) {
			return false;
		}
		boolean flag = false;
		//д�����������ֱ�����1.��A��Ѱ��match B�ĸ��ڵ�Ľڵ� 2.���ҵ��Ľڵ㿪ʼ�ݹ�match��ֱ���ӽṹB��Ҷ�ӽڵ�
		//step1.LDR����A��Ѱ��match B���ڵ�Ľڵ�
		TreeNode node = A;
		Deque<TreeNode> st = new LinkedList<TreeNode>();

		while(!st.isEmpty()||node!=null) {//LDR
			if(flag) {//������ֻ���Ż�ʱ�临�Ӷ����ã����������û�������ҵ��ˣ��Ǿͽ���Ѱ�ң���
				return true;
			}
			while(node!=null) {
				st.push(node);
				node = node.left;//Lһ·ѹ�������½ǵĽڵ�
			}
			node = st.pop();//D
			flag = hasStructB(node,B);
			node = node.right;//R
		}
		return flag;//��HDP ��һ����������ˣ���Ϊ����Ǳ��������һ���ڵ㣬�Ͳ�����뵽��Ȧ��while���Ӷ��߲�������trick·������
    }
	
	public boolean hasStructB(TreeNode node,TreeNode B) {
		//Ϊ�ݹ���ӽ�������
		//1.B==null,˵������B��Ҷ���ˣ�������
		if(B==null) {
			return true;
		}
		//2.B��=null,Aȴ==null�ˣ�˵����match;����������val���ȣ�Ҳmatchʧ�ܣ�
		if(node==null || node.val != B.val) {
			return false;
		}
		//�����ȣ��ݹ�Ƚ������ӣ�DLR��
		return hasStructB(node.left,B.left)&&hasStructB(node.right,B.right);
	}
}
