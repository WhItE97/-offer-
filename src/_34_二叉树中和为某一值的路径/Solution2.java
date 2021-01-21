package _34_�������к�Ϊĳһֵ��·��;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	/**
	 * ����˼·�ܽ᣺
	 * 1.route��res����ֱ��д�ڳ�Ա�����﷽�㣡
	 * 2.Ҫ�ۼ�route�нڵ��valֵ������ͨ��ÿѡ��һ���ڵ㣬��-ȥ�ýڵ��val���ݹ鴫����һ��ѡ���������
	 * 3.�����ܣ�
	 * def dfs��
	 * 	��1��if ���� �ݹ��������[ATT �ݹ������������=·�����ҽ�����������]
	 * 		return;
	 * 	��2����ѡ��route.add;target-=node.val��
	 * 	��3��dfs�����ӣ�
	 * 		dfs�����ӣ�
	 * 	��5������ѡ��[������ѡ��Ҫ�ͱ�������ѡ���Ӧ�ϣ����Գ�������node����]
	 * 		route.removeLast
	 * 		target += node.val
	 */
	//res��route������д�ڳ�Ա�����
	List<List<Integer>> res;
	List<Integer> route;
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		res = new ArrayList<>();
		route = new ArrayList<>();
		dfs(root,sum);
		return res;
	}
	
	//��TRICK 1.������ʣ��Ŀ��ֵtargetȡ��һ����·������Ͳ�������ÿ������ѡ���-ȥ��val����
	public void dfs(TreeNode node,int target) {
		//1.����������HHHDP 1.��һֱ��ס�ĵ㣡������dfs�ĵݹ��������������·�������ļ�飡��->node==null->ֱ��return...
		if(node==null) {
			return ;
		}
		//2.����ѡ�񣩷���node����route
		route.add(node.val);
		target -= node.val;
		//3.��MOST IMP/HHHDP 2.�Լ�û�������KP��[ÿ�μ���]��һ���ǿսڵ��->[����·���������]������������
		//����Ƿ���Ҷ�ӣ�
		if(node.left==null&&node.right==null&&target==0) {//��Ҷ�ӣ���target==0->����·�����⣡����res��Ȼ����ݣ�
			res.add(new ArrayList<Integer>(route));
		}
		//4.dfs
		dfs(node.left,target);
		dfs(node.right,target);
		//5.�������ֵ�ѡ��HDP 3.��������[����]�ģ��������Ӻ����ӣ�������
		route.remove(route.size()-1);
		target += node.val;
	}
}
