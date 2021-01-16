package _28_�ԳƵĶ�����;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô���ǶԳƵġ�
 */
public class Solution {
	/**
	 * self˼·���������С�
	 * 1.��ʵ�־��񣨱������нڵ㣬�����нڵ�������������Ľ�����
	 * 2.�þ���������ԭ���Ƚ�
	 * ���������ˣ�root��mirrorRoot��������(ָ��Ķ���ͬһ����..)����->��ʱû�뵽��ô���Ƴ�һ���µľ�����..��
	 * change˼·�������С�
	 * 1.�����л�ԭ����������������ֵ��null����Ĵ���
	 * 2.�ٶԾ����������л����Ƚ��������Ƿ����
	 * change˼·��HDP�������л���ʵ�֣���nullָ��Ĵ�����
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return false;
		}
//		TreeNode.preorderTraversal(root);
//		System.out.println();
		StringBuilder sb1 = new StringBuilder();
		Serialization(root,sb1);
		mirrorTree(root);
//		TreeNode.preorderTraversal(root);
//		System.out.println();
		StringBuilder sb2 = new StringBuilder();
		Serialization(root,sb2);
		System.out.println("before:"+sb1.toString());
		System.out.println("after:"+sb2.toString());
		return sb1.toString().contentEquals(sb2.toString());
    }
	//1.������ڵ㣬���ؾ����ĸ��ڵ�
	public TreeNode mirrorTree(TreeNode root) {
		//��Ҫ����base...��
		if(root == null) {
			return null;
		}
		//����˼·���������нڵ㣬�����нڵ���������ӽ���
		Deque<TreeNode> st = new LinkedList<TreeNode>();
		//����DLR�������
		//�ȴ�һ�����ڵ㷽�㷵��
		TreeNode node = root;
		st.push(node);
		while(!st.isEmpty()) {
			node = st.pop();
			swap(node);//D
			if(node.right!=null) {
				st.push(node.right);//��L������ѹR
			}
			if(node.left!=null) {
				st.push(node.left);//��ѹL
			}
		}
		return root;
	}
	//swapʵ�������ӽ���
	public void swap(TreeNode node) {
		TreeNode tmp = node.right;
		node.right = node.left;
		node.left = tmp;
	}
	
	//2.DLR�����л�->���л�Ҫ��nullָ��Ҳ���룬�Ų���������壡->��HDP�������ȷ�Ĳ���null
	public void Serialization(TreeNode root,StringBuilder sb) {
		//ֻҪ�ڵ㣡=null->��Ҫ������DLRȫд�����л���
		sb.append(root.val);
		if(root.left==null) {
			sb.append('#');
		}
		else {
			Serialization(root.left,sb);
		}
		if(root.right==null) {
			sb.append('#');
		}
		else {
			Serialization(root.right,sb);
		}
	}
}
