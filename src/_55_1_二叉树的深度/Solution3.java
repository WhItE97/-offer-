package _55_1_二叉树的深度;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	/**
	 * self BFS——>队列实现【1ms 22%】
	 * 每BFS一层，count+1
	 */
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.add(root);
		int count = 0;
		while(!q1.isEmpty()||!q2.isEmpty()) {
			if(!q1.isEmpty()) {
				count++;
			}
			while(!q1.isEmpty()) {
				TreeNode tmp = q1.poll();
				if(tmp.left!=null) {
					q2.offer(tmp.left);
				}
				if(tmp.right!=null) {
					q2.offer(tmp.right);
				}
			}
			
			if(!q2.isEmpty()) {
				count++;
			}
			while(!q2.isEmpty()) {
				TreeNode tmp = q2.poll();
				if(tmp.left!=null) {
					q1.offer(tmp.left);
				}
				if(tmp.right!=null) {
					q1.offer(tmp.right);
				}
			}
		}
		return count;
	}
}
