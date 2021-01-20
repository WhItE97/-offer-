package _32_3_���ϵ��´�ӡ������3;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ��
 * ��ʵ��һ����������֮����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��ҵ����˳���ӡ���������ٰ��մ����ҵ�˳���ӡ���������Դ����ơ�
 */
public class Solution {
	/**
	 * self˼·1����ӦSolution������WRONG��
	 * dfs��levelΪ���ż�����𻯴���ż����dfs����LR�ĵݹ飬������dfs����RL�ĵݹ飩��WRONG ֻ�޸ĵݹ�˳��Ļ���ֻ�Ǹı���ÿ���ڵ�����Ҷ���˳�򣡶�û�иı���Щ�ڵ���˳�򣡡�
	 * self˼·2����ӦSolution2��������Solution2��
	 * ����bfs����ż�����𻯴�����Ϊ���Ǵ������ҷ�����У����Զ���������Ҫ�õ�����ջ������
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root,res,0);
		return res;
    }
	
	public void dfs(TreeNode node,List<List<Integer>> res,int level) {
		//1.��������
		if(node==null) {
			return;
		}
		if(level>=res.size()) {
			res.add(new ArrayList<>());//�Խ�������²����level����Ӧ��Ԫ��list ���г�ʼ������ֹres.get(level)Խ��
		}
		//2.����add�õ����Ӧlevel�±��res�����
		res.get(level).add(node.val);
		//3.��level��ż�Ľ���������
		if((level&1)==0) {//ż���㣬��0,2,4...->��������add����
			dfs(node.right,res,level+1);
			dfs(node.left,res,level+1);
		}
		else {//������->��������add����
			dfs(node.left,res,level+1);
			dfs(node.right,res,level+1);
		}
	}
}
