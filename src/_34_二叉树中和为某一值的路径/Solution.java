package _34_�������к�Ϊĳһֵ��·��;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ��Ŀ��
 * ����һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·����������[���ڵ�]��ʼ����[һֱ��Ҷ�ڵ�]�������Ľڵ��γ�һ��·����
 */
public class Solution {
	/**
	 * self˼·����δʵ���Ż�Ҳ��AC����ʱ�临�Ӷ�ֻ�����28%��д���е���->ͬ����˼·����������д������Solution2��
	 * dfs��������·�����->���Ż�������ӵ�ֵ�Ѿ�����Ŀ��ֵ�ˣ�����������ѡ��δʵ�֡�
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		//base
		if(root==null) {
			return (new ArrayList<>());
		}
		Deque<TreeNode> st = new LinkedList<TreeNode>();
		List<Integer> route = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<>();
		dfs(root,st,route,res,sum);
		return res;
    }
	/**
	 * dfs��ܣ�
	 * def dfs(ѡ���б�·��)����HDP���ѵ����ڸ����ǽڵ㣡ѡ���б���ôʵ�֣�->ջ!����HDP2��������ʽ��>DLR���ǴӸ���ʼ����
	 * 	if(�����������)
	 * 		res.add
	 * 		return;
	 * 	��ѡ��1.��ѡ�����·��2.��ѡ���ѡ���б���ɾ��
	 * 	dfs()
	 * 	����ѡ��
	 */
	//node�����ִ���ڵ� st����ѡ���б������ route����¼·���ڵ�ֵ res�������
	public void dfs(TreeNode node,Deque<TreeNode> st,List<Integer> route,List<List<Integer>> res,int sum) {
		//1.��������:����route��Ӧ�ڵ��Ѿ���Ҷ�ӽڵ㡾WRONG POINT 1.���ﱾ���Ѿ���Ҷ�ӽڵ㣬�������Ҷ�ӻ�û���ü�ѹջ��
		if(node.left==null&&node.right==null) {
			//�жϱ���·���ĺ��Ƿ�����sum
			int ssum = 0;
			for(int i=0;i<route.size();i++) {
				ssum += route.get(i);
			}
			ssum += node.val;
			route.add(node.val);
			st.push(node);
			//1.1.����Ļ�����res
			if(ssum==sum) {
				res.add(new ArrayList<Integer>(route));
			}
			//1.2.����·�������㣬clear route��ֱ��return
			//��WRONG POINT 2.route��ô����clear��..Ӧ���ǳ������һ��Ԫ�أ��������Ѿ�д��dfs�������ˣ���������ֱ�ӷ��أ���
			return;
		}
		
		//2.DLR�������������ѡ��
		st.push(node);//D
		route.add(node.val);
		//2.1.1.ѡ��left
		if(node.left!=null) {
			dfs(node.left,st,route,res,sum);//L
			//2.1.2.����leftѡ�� ��WRONG POINT 3.����ѡ��ý������������ѡ���ǰ���°�..���Գ���ѡ���pop��remove����Ҳ����if�������
			st.pop();
			route.remove(route.size()-1);
		}
		//2.2.1.ѡ��right
		if(node.right!=null) {
			dfs(node.right,st,route,res,sum);//R
			//2.2.2.����rightѡ��
			st.pop();
			route.remove(route.size()-1);
		}
	}
}
