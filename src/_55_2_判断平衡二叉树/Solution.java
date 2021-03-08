package _55_2_判断平衡二叉树;

public class Solution {
	/**
	 * self思路：【1ms 100%】
	 * for每个节点：判断自己的左右子树是否平衡（对自己的左右子分别求深度，然后判断左右子树的深度差是否超过1）——>递归每个节点检查
	 * 
	 * 这是从上到下的遍历解法，下面的节点都被多次遍历——>见Solution2，LRD实现每个节点仅被遍历一次
	 */
	public boolean isBalanced(TreeNode root) {
		if(root==null) {
			return true;
		}

		int ld = depth(root.left);
		int rd = depth(root.right);
		if((ld-rd)<=1&&(ld-rd)>=-1) {//说明当前节点平衡，继续下一个
			return isBalanced(root.left)&&isBalanced(root.right);
		}
		return false;
	}
	
	public int depth(TreeNode node) {
		if(node==null) {
			return 0;
		}
		return Math.max(depth(node.left), depth(node.right))+1;
	}
}
