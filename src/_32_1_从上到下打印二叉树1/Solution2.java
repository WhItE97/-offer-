package _32_1_从上到下打印二叉树1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
	//和solution一样的思路，队列实现层次遍历！->只是这里不用那么多辅助空间，而是直接用list.toArray实现
	public int[] levelOrder(TreeNode root) {
		if(root==null) {
			return new int[] {};
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> ls = new ArrayList<Integer>();
		q.add(root);//add->remove(失败抛出异常);;;offer->poll(失败返回null)
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
		//【HDP list转int数组只能遍历赋值..】
		int[] res = new int[ls.size()];
		for(int i=0;i<ls.size();i++) {
			res[i] = ls.get(i);
		}
		return res;
	}
}
