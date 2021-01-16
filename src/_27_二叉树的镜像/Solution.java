package _27_二叉树的镜像;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Solution {
	/**
	 * self思路：
	 * DLR先序遍历每一个节点->交换其左右子
	 */
	public TreeNode mirrorTree(TreeNode root) {
		//base
		if(root==null) {
			return null;
		}
		Deque<TreeNode> st = new LinkedList<TreeNode>();
		TreeNode node = root;
		st.push(node);
		while(!st.isEmpty()) {
			node = st.pop();//D
			swap(node);
			if(node.right!=null) {
				st.push(node.right);//先L所以先压R
			}
			if(node.left!=null) {
				st.push(node.left);
			}
		}
		return root;
    }
	
	public void swap(TreeNode node) {
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
}
