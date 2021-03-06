package _54_�����������ĵ�k��ڵ�;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * ����һ�ö��������������ҳ����е�k��Ľڵ㡣
 */
public class Solution {
	/**
	 * self˼·����5ms 6% �ռ�O(N) 8%..��
	 * [REVIEW.binary search/sort tree:�Զ�����������ڵ㣬�����������Ľڵ�ֵ<��ǰ�ڵ�<�������Ľڵ�ֵ]
	 * ��LDR�����������������飬��return arr[k-1]����>O(N)
	 */
	List<Integer> tree = new ArrayList<>();
	public int kthLargest(TreeNode root, int k) {
		NonrecursionInorderTraversal(root);
		return tree.get(tree.size()-k);
    }
	
	//�ǵݹ�LDR�������ʵ��
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
