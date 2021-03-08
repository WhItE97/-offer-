package _55_1_�����������;

import java.util.Queue;
import java.util.LinkedList;

public class Solution4 {
	/**
	 * ֻ��1��ջ��bfs��������1ms 22%��
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
			int size = queue.size();//��CORE.IMP����¼����Ľڵ���
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
