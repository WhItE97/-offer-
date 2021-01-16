package _27_�������ľ���;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ�������һ������������һ�����������ú���������ľ���
 */
public class Solution {
	/**
	 * self˼·��
	 * DLR�������ÿһ���ڵ�->������������
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
				st.push(node.right);//��L������ѹR
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
