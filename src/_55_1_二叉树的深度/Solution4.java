package _55_1_二叉树的深度;

import java.util.Queue;
import java.util.LinkedList;

public class Solution4 {
	/**
	 * 只用1个栈的bfs【依旧是1ms 22%】
	 */
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while(!queue.isEmpty()) {
			count++;
			int size = queue.size();//【CORE.IMP】记录本层的节点数
			for(int i=0;i<size;i++) {
				TreeNode tmp = queue.poll();
				if(tmp.left!=null) {
					queue.offer(tmp.left);
				}
				if(tmp.right!=null) {
					queue.offer(tmp.right);
				}
			}
		}
		return count;
	}
}
