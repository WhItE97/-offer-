package _68_2_�������������������;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 * ���нڵ��ֵ����Ψһ�ġ�p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ������С�
 */
public class Solution {
	/**
	 * self˼·����1376ms..5%��
	 * �Ӹ��ڵ㿪ʼ����ѯ������ÿ���ڵ��Ƿ����p��q��
	 * 1.����������򱣴���pre�ڵ���
	 * 2.���������������һ��pre���������������
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pre = null;
        //BFS������ýڵ����㹫�����ȣ�����������Ҷ��Ӷ�������У�����ʹ˴�ס����һ��pre��������Ĺ�������
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	if(havePQ(node,p,q)) {
        		pre = node;
        		if(node.left!=null) {
        			queue.offer(node.left);
        		}
        		if(node.right!=null) {
        			queue.offer(node.right);
        		}
        	}
        }
        return pre;
    }
	
	public boolean havePQ(TreeNode node,TreeNode p,TreeNode q) {
		boolean ptag = false;
		boolean qtag = false;
		//BFS����pq
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();
			if(n==p) {
				ptag = true;
			}
			if(n==q) {
				qtag = true;
			}
			if(n.left!=null) {
				queue.offer(n.left);
			}
			if(n.right!=null) {
				queue.offer(n.right);
			}
		}
		if(ptag&&qtag) {
			return true;
		}
		else {
			return false;
		}
	}
}
