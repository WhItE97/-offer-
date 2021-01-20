package _32_2_���ϵ��´�ӡ������2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	/**
	 * �ⷨ����DFSҲ������������BFS����
	 * ˼·��
	 * ͨ��һ��������level����¼��ǰdfs�ִ����ڲ㣬������������˳���level����������add��res list�Ķ�Ӧlevel�±����list��ȥ��
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(root,res,0);
		return res;
    }
	/**
	 * dfs��ܣ�
	 * res[]
	 * void dfs(ѡ���б�·��):
	 * 	if(�����������)��
	 * 		res.add(new (route))
	 * 		return
	 * 	for ѡ�� in ѡ���б�
	 * 		��ѡ��1.��ѡ�����·��2.��ѡ���ѡ���б����Ƴ���
	 * 		dfs()
	 * 		����ѡ��1.��ѡ���·����ɾ��2.��ѡ�����¼���ѡ���б�
	 */
	public void dfs(TreeNode node,List<List<Integer>> res,int level) {//��HDP������res����route����Ϊ���ǿ�����get(level)��ֱ�Ӳ��뵽��ȷ��resԪ��λ�á�
		//1.��������
		if(node==null) {
			return;//����ֱ��ֱ��ÿ��ѡ�񶼲�������ȷ��λ�ã����Բ���һ����·��һ�����res�ˣ�
		}
		//��HDP2.����ֱ��get(level)����Ϊ�գ�������Ҫ�� Ԥ���� �յ���������г�ʼ����->level��0��ʼ���õģ���������Ҫȡ�ȣ�
		if(level>=res.size()) {
			res.add(new ArrayList<Integer>());
		}
		//2.��ǰ�ڵ�ֵ ������ȷ��λ��
		res.get(level).add(node.val);
		//3.��˳�����������
		dfs(node.left, res, level+1);
		dfs(node.right, res, level+1);
	}
}
