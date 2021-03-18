package _68_1_二叉搜索树的最近公共祖先;

/**
 * 题目：
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 一个节点也可以是它自己的祖先。
 * 所有节点的值都是唯一的。p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Solution {
	/**
	 * self思路：【6ms 100%】
	 * BST：左<父<右
	 * 所以从根开始，找到一个大于小的，且小于大的的节点
	 * （一个节点可以是自己的祖先，所以一旦找到p or q，则立马return 其为最近公共祖先）
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
		if(root==null) {
			return null;
		}
		TreeNode node = root;
		//1.找到其中一个节点，直接return
		if(node==p||node==q) {
			return (node==p)?p:q;
		}
		//2.非其中一个，又分3situs
		//2.1.当前节点比两个节点都大，则递归找左子
		if(node.val>p.val&&node.val>q.val) {
			return lowestCommonAncestor(node.left,p,q);
		}
		//2.2.当前节点比两个节点都小，递归找右子
		else if(node.val<p.val&&node.val<q.val) {
			return lowestCommonAncestor(node.right,p,q);
		}
		//2.3.当前节点恰好比其中一个大，比另一个小
		else {
			return node;
		}
    }
}
