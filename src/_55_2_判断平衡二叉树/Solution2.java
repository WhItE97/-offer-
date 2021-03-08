package _55_2_判断平衡二叉树;

public class Solution2 {
	/**
	 * 剑指offer思路：【1ms 100%】
	 * LRD从下向上检查，这样每个节点只会被遍历一次！
	 */
	public boolean isBalanced(TreeNode root) {
		return balance(root)==-1?false:true;
	}
	
	public int balance(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int left = balance(node.left);
		if(left==-1) {
			return -1;
		}
		int right = balance(node.right);
		if(right==-1) {
			return -1;
		}
		return Math.abs(left-right)<2?Math.max(left,right)+1:-1;//如果已经失衡，则return -1，便于提前结束
	}
	
	public void postorderTraversal(TreeNode root) {
		//LRD遍历
		if(root.left!=null) {
			postorderTraversal(root.left);
		}
		if(root.right!=null) {
			postorderTraversal(root.right);
		}
		System.out.println(root.val);
	}
}
