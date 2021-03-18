package _68_2_二叉树的最近公共祖先;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 所有节点的值都是唯一的。p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Solution {
	/**
	 * self思路：【1376ms..5%】
	 * 从根节点开始，查询遍历的每个节点是否包含p和q！
	 * 1.如果包含，则保存在pre节点中
	 * 2.如果不包含，则上一个pre就是最近公共祖先
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pre = null;
        //BFS，如果该节点满足公共祖先，则把他的左右儿子都加入队列；否则就此打住，上一个pre就是最近的公共祖先
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
		//BFS查找pq
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
