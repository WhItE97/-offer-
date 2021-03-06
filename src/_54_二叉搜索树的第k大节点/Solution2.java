package _54_二叉搜索树的第k大节点;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * self思路2.【1ms 40% 空间 50%】
	 * 减少空间复杂度，把LDR写成RDL，用一个k记录这是第几个节点，就是第几大
	 */
	public int kthLargest(TreeNode root, int k) {
		int i = 0;//用于记录当前访问到了第i大节点
		Deque<TreeNode> st = new LinkedList<>();
		TreeNode node = root;
		while(!st.isEmpty()||node!=null) {
			while(node!=null) {
				st.push(node);
				node = node.right;//R
			}
			node = st.pop();//D
			i++;//记录这是第几大
			if(i==k) {
				break;
			}
			node = node.left;//L
		}
		return node.val;
    }
}
