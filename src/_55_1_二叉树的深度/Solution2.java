package _55_1_二叉树的深度;

public class Solution2 {
	/**
	 * 剑指offer思路：
	 * （类比当时labuladong的二叉树刷题套路）
	 * 每个节点要做什么，然后递归即可
	 */
	public int maxDepth(TreeNode root) {
		return root==null?0:Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
