package _32_1_���ϵ��´�ӡ������1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
	//��solutionһ����˼·������ʵ�ֲ�α�����->ֻ�����ﲻ����ô�ศ���ռ䣬����ֱ����list.toArrayʵ��
	public int[] levelOrder(TreeNode root) {
		if(root==null) {
			return new int[] {};
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> ls = new ArrayList<Integer>();
		q.add(root);//add->remove(ʧ���׳��쳣);;;offer->poll(ʧ�ܷ���null)
		while(!q.isEmpty()) {
			TreeNode tmp = q.remove();
			ls.add(tmp.val);
			if(tmp.left!=null) {
				q.add(tmp.left);
			}
			if(tmp.right!=null) {
				q.add(tmp.right);
			}
		}
		//��HDP listתint����ֻ�ܱ�����ֵ..��
		int[] res = new int[ls.size()];
		for(int i=0;i<ls.size();i++) {
			res[i] = ls.get(i);
		}
		return res;
	}
}
