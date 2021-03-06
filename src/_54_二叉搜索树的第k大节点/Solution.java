package _54_二叉搜索树的第k大节点;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Solution {
	/**
	 * self思路：【5ms 6% 空间O(N) 8%..】
	 * [REVIEW.binary search/sort tree:对二叉树的任意节点，都有左子数的节点值<当前节点<右子树的节点值]
	 * 先LDR遍历二叉树存入数组，再return arr[k-1]——>O(N)
	 */
	List<Integer> tree = new ArrayList<>();
	public int kthLargest(TreeNode root, int k) {
		NonrecursionInorderTraversal(root);
		return tree.get(tree.size()-k);
    }
	
	//非递归LDR中序遍历实现
	public void NonrecursionInorderTraversal(TreeNode node) {
		Deque<TreeNode> st = new LinkedList<>();
		while(!st.isEmpty()||node!=null) {
			while(node!=null) {
				st.push(node);
				node = node.left;//L
			}
			node = st.pop();//D
			tree.add(node.val);
			System.out.println(node.val);
			node = node.right;//R
		}
	}
}
